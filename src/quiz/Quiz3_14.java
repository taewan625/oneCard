package quiz;

import java.util.Arrays;

public class Quiz3_14 {
    public static void main(String[] args) {
        // 배열 1,2번
        int[] arr = {1,2,3,4,5,6}; //10

        int[] counter = new int[arr.length+1];  // [0, 2, 2, 2, 2, 1, 1, 1, 0, 0, 0]

        // 나열 array 만들기
        for (int i = 0; i < arr.length; i++) {
            counter[arr[i]]++; //arr[] 범위가 -> counter = 1~7 counter[8]부터는 접근자체를 안함
        }
        System.out.println(Arrays.toString(counter));


        // Q1. 중복 제거 결과
        for (int i = 0; i < counter.length; i++) {
            if (counter[i]>0){
                System.out.print(i+",");
            }
        }
        System.out.println();

        // Q2. 정렬해서 나열
        for (int i = 0; i < counter.length; i++) {
            if (counter[i] > 0) {
                for (int j = 0; j < counter[i]; j++) {
                    System.out.print(i +",");
                }
            }
        }

    } // main 끝
}// Quiz3_14 끝
