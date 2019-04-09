import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author : Ge Xiantao
 * @date : 2019/4/4 16:09
 */
public class CyclicBarrierSample {

    public static void main(String[] args) {
        CyclicBarrier barrier = new CyclicBarrier(5,
                                                  () -> System.out.println(
                                                          "Action...GO again"));
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(new CyclicWorker(barrier));
            thread.start();
        }
    }

    public static class CyclicWorker implements Runnable {

        private CyclicBarrier barrier;

        public CyclicWorker(CyclicBarrier barrier) {
            this.barrier = barrier;
        }

        @Override
        public void run() {
            try {
                for (int i = 0; i < 2; i++) {
                    System.out.println("Executed!");
                    barrier.await();
                }
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }

}
