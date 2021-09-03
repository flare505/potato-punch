package algo;

class NumMatrix {
    int[][] prefixSum = new int[200][200];

    public NumMatrix(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        prefixSum[0][0] = matrix[0][0];
        for (int i = 1; i < n; i++) {
            prefixSum[i][0] = prefixSum[i-1][0] + matrix[i][0];
        }
        for (int j = 1; j < m; j++) {
            prefixSum[0][j] = prefixSum[0][j-1] + matrix[0][j];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                prefixSum[i][j] = prefixSum[i-1][j] + prefixSum[i][j-1] - prefixSum[i-1][j-1] + matrix[i][j];
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(prefixSum[i][j] + " ");
            }
            System.out.println();
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if (row1 == 0  && col1 == 0) {
            return prefixSum[row2][col2];
        } else if (row1 == 0) {
            return prefixSum[row2][col2] - prefixSum[row2][col1 - 1];
        } else if (col1 == 0) {
            return prefixSum[row2][col2] - prefixSum[row1-1][col2];
        }
        return prefixSum[row2][col2] - prefixSum[row2][col1-1] - prefixSum[row1-1][col2] + prefixSum[row1-1][col1-1];
    }
}

public class PrefixSum2D {
    public static void main(String[] args) {
        int[][] matrix = new int[][] {{3,0,1,4,2},{5,6,3,2,1},{1,2,0,1,5},{4,1,0,1,7},{1,0,3,0,5}};
        NumMatrix numMatrix = new NumMatrix(matrix);
        System.out.println(numMatrix.sumRegion(0, 1, 1, 1));
    }
}
