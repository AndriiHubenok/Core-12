package org.example;

public class FizzBuzz {
    private volatile int cursor = 1;
    private int amount = 15;
    public static void main(String[] args) {
        FizzBuzz test = new FizzBuzz();
        Thread A = new Thread(() -> test.fizz());
        Thread B = new Thread(() -> test.buzz());
        Thread C = new Thread(() -> test.fizzbuzz());
        Thread D = new Thread(() -> test.number());
        A.start();
        B.start();
        C.start();
        D.start();
    }

    private void fizz() {
        for(; cursor <= amount;) {
            synchronized (this) {
                if (cursor % 3 == 0 && !(cursor % 5 == 0) && cursor <= amount) {
                    System.out.print("fizz, ");
                    cursor++;
                }
            }
        }
    }

    private void buzz() {
        for(; cursor <= amount;) {
            synchronized (this) {
                if (cursor % 5 == 0 && !(cursor % 3 == 0) && cursor <= amount) {
                    System.out.print("buzz, ");
                    cursor++;
                }
            }
        }
    }

    private void fizzbuzz() {
        for(; cursor <= amount;) {
            synchronized (this) {
                if (cursor % 3 == 0 && cursor % 5 == 0 && cursor <= amount) {
                    System.out.print("fizzbuzz, ");
                    cursor++;
                }
            }
        }
    }

    private void number() {
        for(; cursor <= amount;) {
            synchronized (this) {
                if (!(cursor % 3 == 0) && !(cursor % 5 == 0) && cursor <= amount) {
                    System.out.print(cursor + ", ");
                    cursor++;
                }
            }
        }
    }
}
