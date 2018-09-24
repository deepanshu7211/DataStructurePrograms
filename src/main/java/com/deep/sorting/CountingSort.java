/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deep.sorting;

import java.util.Arrays;

/**
 * @author deepanshu.saxena
 */
public class CountingSort {

    public static void main(String[] args) {
        //int a[]={0, 3, 1, 0, 5, 2, 4, 5, 2};
        int a[] = {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1};
//     int a[]={5,2,6,1,3,4};
        CountSort countsort = new CountSort();
        countsort.countingSort(a);
    }


    public static void dutchFlagAlgo()
    {
        int arr[] = {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1};
        int lo = 0;
        int hi = arr.length - 1;
        int mid = 0,temp=0;
        while (mid <= hi)
        {
            switch (arr[mid])
            {
                case 0:
                {
                    temp   =  arr[lo];
                    arr[lo]  = arr[mid];
                    arr[mid] = temp;
                    lo++;
                    mid++;
                    break;
                }
                case 1:
                    mid++;
                    break;
                case 2:
                {
                    temp = arr[mid];
                    arr[mid] = arr[hi];
                    arr[hi] = temp;
                    hi--;
                    break;
                }
            }
        }

        System.out.println(Arrays.toString(arr));
    }
}

class CountSort {
    private int arr[], c[], b[];
    private int max;
    private int length;

    public void countingSort(int a[]) {
        this.length = a.length;
        this.arr = a;
        max = getMax();

        c = new int[max + 1];
        b = new int[length];
        System.out.println("max :: " + c.length + " " + max);
        for (int i = 0; i < length; i++) {
//            System.out.println("c[i] " + c[arr[i]]);
            c[arr[i]]++;
            System.out.println("i " + i + " after c[i] " + c[arr[i]]);
        }
        System.out.println("c init " + Arrays.toString(c));
        for (int i = 1; i < max + 1; i++)
            c[i] = c[i] + c[i - 1];   // genrate c' array

        System.out.println(" c " + Arrays.toString(c));

        for (int i = 0; i < arr.length; i++) {
//            System.out.println("c[a[i]]--" + (c[a[i]]));
            b[c[a[i]] - 1] = a[i];
            c[a[i]] = c[a[i]] - 1;
        }

        System.out.println("final array :: " + Arrays.toString(b));

    }

    public int getMax() {
        max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max)
                max = arr[i];
        }
        return max;
    }
}