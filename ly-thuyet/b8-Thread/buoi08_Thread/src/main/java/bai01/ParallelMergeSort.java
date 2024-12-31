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
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

class MergeSortTask implements Callable<int[]> {
    private int[] array;
    private int start;
    private int end;

    public MergeSortTask(int[] array, int start, int end) {
        this.array = array;
        this.start = start;
        this.end = end;
    }

    @Override
    public int[] call() {
        if (start < end) {
            int mid = (start + end) / 2;
            // Tạo và khởi chạy hai công việc con để sắp xếp hai nửa của mảng
            MergeSortTask leftTask = new MergeSortTask(array, start, mid);
            MergeSortTask rightTask = new MergeSortTask(array, mid + 1, end);

            ExecutorService executorService = Executors.newFixedThreadPool(2);
            List<Future<int[]>> futures = new ArrayList<>();

            futures.add(executorService.submit(leftTask));
            futures.add(executorService.submit(rightTask));

            for (Future<int[]> future : futures) {
                try {
                    future.get();
                } catch (InterruptedException | ExecutionException e) {
                    e.printStackTrace();
                }
            }
            executorService.shutdown();
            // Ghép hai nửa đã sắp xếp
            merge(start, mid, end);
        }
        return array;
    }

    private void merge(int start, int mid, int end) {
        int[] tempArray = Arrays.copyOfRange(array, start, end + 1);
        int i = start, j = mid + 1, k = 0;

        while (i <= mid && j <= end) {
            if (tempArray[i - start] < tempArray[j - start]) {
                array[i++] = tempArray[k++];
            } else {
                array[i++] = tempArray[j++ - start];
            }
        }

        while (i <= mid) {
            array[i++] = tempArray[k++];
        }
    }
}

public class ParallelMergeSort {
    public static void main(String[] args) {
        int[] array = new int[1000000];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 1000000);
        }

        long startTime = System.currentTimeMillis();

        // Sắp xếp mảng bằng cách sử dụng luồng
        MergeSortTask mergeSortTask = new MergeSortTask(array, 0, array.length - 1);
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<int[]> result = executorService.submit(mergeSortTask);

        try {
            result.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        executorService.shutdown();

        long endTime = System.currentTimeMillis();
        System.out.println("Time taken for parallel sort: " + (endTime - startTime) + " ms");
    }
}


