package org.example;

public class Main {
    public static void main(String[] args) {
        Thread fiveSecondsCounter = new Thread(() ->
        {
            for (;;) {
                try {
                    Thread.sleep(5000);
                    System.out.println("Минуло 5 секунд");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        Thread timecounter = new Thread(() ->
        {
            fiveSecondsCounter.start();
            for (int i = 0; ; i++) {
                System.out.println(i + " seconds");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        timecounter.start();
    }
}