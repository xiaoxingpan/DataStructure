package day01universalarrays;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * jagged array: member arrays can be of different sizes
 *
 */
public class Day01UniversalArrays {

    public static Scanner input = new Scanner(System.in);

    // get a integer input
    static int inputInt() {
        // loop stop when return statement execute sucessfully
        while (true) {
            try {
                return input.nextInt();
            } catch (InputMismatchException ex) {
                System.out.println("Not an integer, try again.");
                input.nextLine();
            }
        }
    }

    // ask user to enter each element for a int[] with certain length
    static void inputArray(int[] data1d) {
        for (int i = 0; i < data1d.length; i++) {
//            System.out.printf("Enter value %d: ", i + 1);
            System.out.println("Enter value for " + (i + 1));
            data1d[i] = inputInt();
        }
    }

    // print a array1d as format: 7, 5, 3, 3, 0
    static void outputArray(int[] data1d) {
        for (int i = 0; i < data1d.length; i++) {
            System.out.print(data1d[i]);
            if (i != data1d.length - 1) {
                System.out.print(", ");
            }
        }
//        for (int row = 0; row < data2d.length; row++) {
//            for (int col = 0; col < data2d[row].length; col++) {
//                System.out.printf("%s%d", (col == 0 ? "" : ", "), data2d[row][col]);
//            }
//            System.out.println();
//        }
//        System.out.println();                
    }

    static void inputArray(int[][] data2d) {
        for (int row = 0; row < data2d.length; row++) {
            for (int col = 0; col < data2d[row].length; col++) {
                System.out.printf("Enter value for row %d column %d: ", row + 1, col + 1);
                data2d[row][col] = inputInt();
            }
        }
    }

    /**
     * Print out values comma separated, in such a way that commas align and
     * values are right-adjusted Example output: -234234, 9, 4, 22 3, 128, -2
     * 123, -7, 0, 1, 7
     */
    static void outputArray(int[][] data2d) {
        // find the longest length of array in data2d
        int maxLength = 0;
        for (int[] row : data2d) {
            maxLength = Math.max(maxLength, row.length);
            // maxLength = maxLength > row.length ? maxLength : row.length;
        }
        System.out.println("the longest length of array in data2d is " + maxLength);

        // find the max width for each column
        int[] colsWidth = new int[maxLength];
        for (int row = 0; row < data2d.length; row++) {
            for (int col = 0; col < data2d[row].length; col++) {
                int length = String.valueOf(data2d[row][col]).length();
                colsWidth[col] = Math.max(length, colsWidth[col]);
            }
        }
//        outputArray(colsWidth);

        // print the array
        for (int row = 0; row < data2d.length; row++) {
            for (int col = 0; col < data2d[row].length; col++) {
                System.out.printf("%s%" + colsWidth[col] + "d", (col == 0 ? "" : ", "), data2d[row][col]);
                //%s represent "" : ", ",
            }
            System.out.println();
        }
    }

    static int[] findDuplicates(int[] a1, int[] a2) {
        int[] dups = new int[Math.min(a1.length, a2.length)];
        int dupsFound = 0;
        for (int i = 0; i < a1.length; i++) {
            for (int j = 0; j < a2.length; j++) {
                if (a1[i] == a2[j]) {
                    // duplicate found but is it unique? (did we see it before?)
                    boolean isUnique = true;
                    for (int k = 0; k < dupsFound; k++) {
                        if (dups[k] == a1[i]) {
                            isUnique = false; // already in dups
                            break;
                        }
                    }
                    if (isUnique) {
                        dups[dupsFound++] = a1[i];
                    }
                }
            }
        }
        // allocate a new array and copy the final result to return it
        int[] finalDups = new int[dupsFound];
        for (int i = 0; i < dupsFound; i++) {
            finalDups[i] = dups[i];
        }
        return finalDups;
    }

    static int elementNum(int[][] arr) {
        int num = 0;
        for (int[] arr1 : arr) {
            num += arr1.length;
        }
        return num;
    }

//    static int[] findDuplicates(int[][] a1, int[][] a2) {
//
//        int[] dups = new int[Math.min(elementNum(a1), elementNum(a2))];
//        int dupsFound = 0;
//
//        for (int i = 0; i < a1.length; i++) {
//            for (int j = 0; j < a2.length; j++) {
//                if (a1[i] == a2[j]) {
//                    // Duplicate row found, check if it's unique
//                    boolean isUnique = true;
//                    for (int k = 0; k < dupsFound; k++) {
//                        if (dups[k] == a1[i]) {
//                            isUnique = false; // Already in the result array
//                            break;
//                        }
//                    }
//                    if (isUnique) {
//                        dups[dupsFound++] = a1[i]; // Clone the row to avoid reference issues
//                    }
//                }
//            }
//        }
//        
//        int[] finalDups = new int[dupsFound];
//        for (int i = 0; i < dupsFound; i++) {
//            finalDups[i] = dups[i];
//        }
//
//        return finalDups;
//    }

    public static void main(String[] args) {
//        int[] array1d = new int[5];
//        inputArray(array1d);
//        outputArray(array1d);

//        int[][] array2d = new int[3][4];
//        inputArray(array2d);
//
//        // instantiate a 2d jaggedArray
//        int[][] jaggedArray = new int[3][];
//        jaggedArray[0] = new int[4];
//        jaggedArray[1] = new int[2];
//        jaggedArray[2] = new int[5];
//        inputArray(jaggedArray);
//        int[][] jaggedArray1 = {
//            {-234234, 9, 4, 22},
//            {3, 128, -2},
//            {123, -7, 0, 1, 7}
//        };
//        outputArray(jaggedArray1);
        int[] arr1 = {5, 2, 1, 0, 3, 0};
        int[] arr2 = {3, 2, 0, 4};
        outputArray(findDuplicates(arr1, arr2));
    }
}
