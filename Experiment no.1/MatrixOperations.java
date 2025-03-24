import java.util.Scanner;

public class MatrixOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input matrices
        System.out.println("Enter elements of the first 2x2 matrix:");
        int[][] matrix1 = new int[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                matrix1[i][j] = scanner.nextInt();
            }
        }

        System.out.println("Enter elements of the second 2x2 matrix:");
        int[][] matrix2 = new int[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                matrix2[i][j] = scanner.nextInt();
            }
        }

        // Menu for operations
        System.out.println("\nChoose operation:");
        System.out.println("1. Matrix Addition");
        System.out.println("2. Matrix Multiplication");
        System.out.println("3. Matrix Transpose");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                int[][] additionResult = matrixAddition(matrix1, matrix2);
                System.out.println("Matrix Addition Result:");
                printMatrix(additionResult);
                break;
            case 2:
                int[][] multiplicationResult = matrixMultiplication(matrix1, matrix2);
                System.out.println("Matrix Multiplication Result:");
                printMatrix(multiplicationResult);
                break;
            case 3:
                System.out.println("Transpose of the first matrix:");
                int[][] transposeMatrix1 = matrixTranspose(matrix1);
                printMatrix(transposeMatrix1);
                System.out.println("Transpose of the second matrix:");
                int[][] transposeMatrix2 = matrixTranspose(matrix2);
                printMatrix(transposeMatrix2);
                break;
            default:
                System.out.println("Invalid choice");
                break;
        }

        scanner.close();
    }

    // Matrix addition
    public static int[][] matrixAddition(int[][] m1, int[][] m2) {
        int[][] result = new int[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                result[i][j] = m1[i][j] + m2[i][j];
            }
        }
        return result;
    }

    // Matrix multiplication
    public static int[][] matrixMultiplication(int[][] m1, int[][] m2) {
        int[][] result = new int[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                result[i][j] = 0;
                for (int k = 0; k < 2; k++) {
                    result[i][j] += m1[i][k] * m2[k][j];
                }
            }
        }
        return result;
    }

    // Matrix transpose
    public static int[][] matrixTranspose(int[][] matrix) {
        int[][] result = new int[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                result[j][i] = matrix[i][j];
            }
        }
        return result;
    }

    // Function to print a matrix
    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
