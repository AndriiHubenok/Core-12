package org.example;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {
    private static List<String> result;
    private static List<Integer> listOfNumbers;
    static int num;
    public static void main(String[] args) {
        listOfNumbers = new ArrayList<>();
        int amount = 15;
        result = new ArrayList<>();
        for (int i = 1; i <= amount; i++) {
            listOfNumbers.add(i);
            result.add(Integer.toString(i));
        }
        Thread D = new Thread(() -> {
            try {
                number();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        D.start();
    }

    private static void fizz(int num) {
        for(int i = 1; i <= listOfNumbers.size(); i++) {
            if(i % 3 == 0 && !(i % 5 == 0)) {
                result.set(i - 1, "fizz");
            }
        }
    }

    private static void buzz(int num) {
        for(int i = 1; i <= listOfNumbers.size(); i++) {
            if(i % 5 == 0 && !(i % 3 == 0)) {
                result.set(i - 1, "buzz");
            }
        }
    }

    private static void fizzbuzz(int num) {
        for(int i = 1; i <= listOfNumbers.size(); i++) {
            if(i % 5 == 0 && i % 3 == 0) {
                result.set(i - 1, "fizzbuzz");
            }
        }
    }

    private static void number() throws InterruptedException {
        Thread A = new Thread(() -> fizz(num));
        Thread B = new Thread(() -> buzz(num));
        Thread C = new Thread(() -> fizzbuzz(num));
        A.start();
        B.start();
        C.start();
        for (int i = 0; i < listOfNumbers.size(); i++) {
            if(i == listOfNumbers.size() - 1) {
                System.out.println(result.get(i));
                break;
            }
            System.out.print(result.get(i) + ", ");
        }
    }
}
