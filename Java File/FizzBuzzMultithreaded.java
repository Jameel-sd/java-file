public class FizzBuzzMultithreaded {
    private int n;
    private int current = 1;
    private Semaphore semNum = new Semaphore(1);
    private Semaphore semFizz = new Semaphore(0);
    private Semaphore semBuzz = new Semaphore(0);
    private Semaphore semFizzBuzz = new Semaphore(0);

    public FizzBuzz(int n) {
        this.n = n;
    }

    private void unlockNext() {
        current++;
        if (current > n) {
            semFizz.release(); semBuzz.release();
            semFizzBuzz.release(); semNum.release();
            return;
        }
        if (current % 15 == 0) semFizzBuzz.release();
        else if (current % 3 == 0) semFizz.release();
        else if (current % 5 == 0) semBuzz.release();
        else semNum.release();
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        while (current <= n) {
            semFizz.acquire();
            if (current > n) break;
            printFizz.run();
            unlockNext();
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        while (current <= n) {
            semBuzz.acquire();
            if (current > n) break;
            printBuzz.run();
            unlockNext();
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        while (current <= n) {
            semFizzBuzz.acquire();
            if (current > n) break;
            printFizzBuzz.run();
            unlockNext();
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        while (current <= n) {
            semNum.acquire();
            if (current > n) break;
            printNumber.accept(current);
            unlockNext();
        }
    }
}