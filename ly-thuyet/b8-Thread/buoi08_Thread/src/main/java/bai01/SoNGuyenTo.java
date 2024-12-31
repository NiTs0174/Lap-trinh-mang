/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package bai01;

/**
 *
 * @author TN
 */
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class SoNGuyenTo{
    private static final int NUM_THREADS = 2;
    public static void main(String[] args) {
        int limit = 1000000;

        Thread[] threads = new Thread[NUM_THREADS]; 
        PrimeSumTask[] tasks = new PrimeSumTask[NUM_THREADS];

        int segmentSize = limit;
        int start = 1000;
        int end = segmentSize;
        long startTime = System.currentTimeMillis();

        for (int i = 0; i < NUM_THREADS; i++) {
            if (i == NUM_THREADS - 1) {
                // Last thread takes care of remaining numbers 
                end = limit;
            }
            tasks[i] = new PrimeSumTask (start, end); 
            threads[i] = new Thread(tasks[i]);
            threads[i].start();

            start = end + 1;
            end += segmentSize;
        }
        
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Future<List<Integer>> primeNumbersFuture = executorService.submit(new PrimeFinder(1000, 1000000));
        
        long sum = 0;
        for (int i = 0; i < NUM_THREADS; i++) {
            try {
                threads[i].join();
                sum += tasks[i].getSum();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }  
        
        try{
            List<Integer> primeNumbers = primeNumbersFuture.get();
            long endTime = System.currentTimeMillis();
            System.out.println("So luong = "+NUM_THREADS);
            System.out.println("Mang cac so nguyen : " + primeNumbers);
            System.out.println("Tong cac so nguyen to den " + limit + ": " + sum);
            System.out.println("Thoi gian thuc hien: " + (endTime - startTime) + "miliseconds");
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            executorService.shutdown();
        }
    }
    
    static class PrimeSumTask implements Runnable {
        private int start = 1000;
        private int end;
        private long sum;

        public PrimeSumTask (int start, int end) {
            this.start = start;
            this.end = end;
            this.sum = 0;
        }

        public long getSum() {
            return sum;
        }

        private boolean isPrime (int number) {
            if (number < 2) {
                return false;
            }    
            for (int i= 2; i <= Math.sqrt(number); i++) {
                if (number % i == 0) {
                    return false;
                }
            }
            return true;
        }

        @Override
        public void run(){
            for(int i = start; i<= end; i++){
                if(isPrime(i)){
                    sum += i;
                }
            }
        }
        
        public List<Integer> call() {
        List<Integer> primeNumbers = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            if (isPrime(i)) {
                primeNumbers.add(i);
            }
        }
        return primeNumbers;
        }
    }
}