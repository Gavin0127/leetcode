import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author : Ge Xiantao
 * @date : 2019/4/4 15:34
 */
public class FindDeadLock {

    public static void main(String[] args) {
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        ScheduledExecutorService schedule =
                Executors.newScheduledThreadPool(1);
        schedule.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                long[] threads = threadMXBean.findDeadlockedThreads();
                if (threads != null) {
                    ThreadInfo[] threadInfos =
                            threadMXBean.getThreadInfo(threads);
                    System.out.println("Detected deadlock threads: ");
                    for (ThreadInfo threadInfo : threadInfos) {
                        System.out.println(threadInfo.getThreadName());
                    }
                }
            }
        }, 5, 10, TimeUnit.SECONDS);
    }

}
