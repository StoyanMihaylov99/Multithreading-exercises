package BasicThreadSynchronization_02;

import java.util.Scanner;

class Processor extends Thread {

    private volatile boolean running = true;

    @Override
    public void run() {
        while (running) {
            System.out.println("Hello");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }
    public void shutDown() {
        running = false;
    }
}

public class App {
    public static void main(String[] args) {
        Processor processor1 = new Processor();
        processor1.start();

        System.out.println("Press return to stop ...");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();

        processor1.shutDown();
    }
}
