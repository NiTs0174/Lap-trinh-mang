/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bai01;

/**
 *
 * @author TN
 */
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

class PrimeFinder implements Callable<List<Integer>> {
    private int startRange;
    private int endRange;

    public PrimeFinder(int startRange, int endRange) {
        this.startRange = startRange;
        this.endRange = endRange;
    }

    private boolean isPrime(int num) {
        if (num < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    @Override
    public List<Integer> call() {
        List<Integer> primeNumbers = new ArrayList<>();
        for (int i = startRange; i <= endRange; i++) {
            if (isPrime(i)) {
                primeNumbers.add(i);
            }
        }
        return primeNumbers;
    }
}

public class PrimeSumCalculator {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        Future<List<Integer>> primeNumbersFuture = executorService.submit(new PrimeFinder(1000, 1000000));
        Future<Integer> sumFuture = executorService.submit(() -> {
            List<Integer> primeNumbers = primeNumbersFuture.get();
            int sum = 0;
            for (int prime : primeNumbers) {
                sum += prime;
            }
            return sum;
        });

        try {
            List<Integer> primeNumbers = primeNumbersFuture.get();
            int sum = sumFuture.get();

            System.out.println("Prime numbers: " + primeNumbers);
            System.out.println("Sum of prime numbers: " + sum);

        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            executorService.shutdown();
        }
    }
}

