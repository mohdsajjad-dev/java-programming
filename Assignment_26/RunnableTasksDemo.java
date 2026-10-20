public class RunnableTasksDemo {
    static class NumberTask implements Runnable {
        @Override
        public void run() {
            for (int number = 1; number <= 5; number++) {
                System.out.println(Thread.currentThread().getName() + " prints: " + number);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }
            }
        }
    }
 
    static class LetterTask implements Runnable {
        @Override
        public void run() {
            for (char letter = 'A'; letter <= 'E'; letter++) {
                System.out.println(Thread.currentThread().getName() + " prints: " + letter);
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
        Thread numbers = new Thread(new NumberTask(), "Number-Task");
        Thread letters = new Thread(new LetterTask(), "Letter-Task");
 
        numbers.start();
        letters.start();
        numbers.join();
        letters.join();
        System.out.println("Both Runnable tasks completed.");
    }
}
