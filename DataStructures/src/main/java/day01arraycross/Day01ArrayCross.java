package day01arraycross;

/**
 *
 * @author xiaoxingpan
 */
public class Day01ArrayCross {

    static int getIfExists(int[][] data, int row, int col) {
//        // Check if the row index is within bounds
//        if (row >= 0 && row < data.length) {
//            // Check if the column index is within bounds for the specified row
//            if (col >= 0 && col < data[row].length) {
//                // Return the element at the specified row and col
//                return data[row][col];
//            }
//        }
//        // Return 0 if the element doesn't exist or indices are out of bounds
//        return 0;
        
        try{  
            return data[row][col];
        } catch (IndexOutOfBoundsException e) {
            return 0;       
        }
    }

    static int sumOfCross(int[][] data, int row, int col) {
        return getIfExists(data, row, col) + getIfExists(data, row + 1, col)
                + getIfExists(data, row, col + 1) + getIfExists(data, row - 1, col)
                + getIfExists(data, row, col - 1);
    }

    static int findMinSum(int[][] array2d) {
        int minSum = Integer.MAX_VALUE; // sumOfCross(array2d, 0, 0);
        for (int row = 0; row < array2d.length; row++) {
            for (int col = 0; col < array2d[row].length; col++) {
                minSum = Math.min(minSum, sumOfCross(array2d, row, col));
            }
        }
        System.out.println("The smallest sum is " + minSum);

        for (int row = 0; row < array2d.length; row++) {
            for (int col = 0; col < array2d[row].length; col++) {
                if (sumOfCross(array2d, row, col) == minSum) {
                    System.out.printf("Element at row %d col %d has the smallest sum. The value is %d%n", row, col, array2d[row][col]);
                    if (getIfExists(array2d, row - 1, col) != 0) {
                        System.out.printf("The value of element above is %d%n", array2d[row - 1][col]);
                    } else {
                        System.out.println("There is no element above.");
                    }
                    if (getIfExists(array2d, row, col - 1) != 0) {
                        System.out.printf("The value of element below is %d%n", array2d[row + 1][col]);
                    } else {
                        System.out.println("There is no element below.");
                    }
                    if (getIfExists(array2d, row, col - 1) != 0) {
                        System.out.printf("The value of element to the left is %d%n", array2d[row][col - 1]);
                    } else {
                        System.out.println("There is no element to the left.");
                    }
                    if (getIfExists(array2d, row, col + 1) != 0) {
                        System.out.printf("The value of element to the right is %d%n", array2d[row][col + 1]);
                    } else {
                        System.out.println("There is no element to the right.");
                    }
                }
            }
        }
        return minSum;
    }
    
     static int[][] duplicateEmptyArray2D(int[][] orig2d) {
        int[][] newArray = new int[orig2d.length][];
        for (int row = 0; row < orig2d.length; row++) {
            newArray[row] = new int[orig2d[row].length];
        }
        return newArray;
    }
    
    // Create an integer array data2Dsums of identical size to data2D where each element of it is the cross-sum of the element in the original array.
    static int[][] duplicateArray2D(int[][] orig2d) {
        int[][] newArray = new int[orig2d.length][];
        for (int row = 0; row < orig2d.length; row++) {
            newArray[row] = new int[orig2d[row].length];
            for (int col = 0; col < newArray[row].length; col++) {
                newArray[row][col] = sumOfCross(orig2d, row, col);
            }
        }
        return newArray;
    }

    static void print2D(int[][] data2d) {
        for (int row = 0; row < data2d.length; row++) {
            for (int col = 0; col < data2d[row].length; col++) {
                System.out.printf("%s%d", (col == 0 ? "" : ", "), data2d[row][col]);
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[][] data2Djagged = {
            {1, 3, 6, 8, 9, 1},
            {7, 1, 2, 3},
            {8, 3, 2},
            {1, 7, 1, 9},};

        print2D(duplicateArray2D(data2Djagged));
    }

}
