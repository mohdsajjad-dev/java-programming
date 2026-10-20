public class MultipleThreadsNumbers {
    static class NumberThread extends Thread {
        private final int start;
        private final int end;
 
        NumberThread(String name, int start, int end) {
            super(name);
            this.start = start;
            this.end = end;
        }
 
        @Override
        public void run() {
            for (int number = start; number <= end; number++) {
                System.out.println(getName() + " prints: " + number);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }
            }
        }
    }
 
    public static void main(String[] args) throws InterruptedException {
        Thread first = new NumberThread("Thread-1", 1, 5);
        Thread second = new NumberThread("Thread-2", 6, 10);
 
        System.out.println("Thread-1 before start: " + first.getState());
        first.start();
        second.start();
        first.join();
        second.join();
        System.out.println("Thread-1 after completion: " + first.getState());
    }
}
