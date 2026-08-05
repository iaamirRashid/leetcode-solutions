class Solution {
    public int[][] matrixGenerate(int n) {
        int[][] res = new int[n][n];

        int startRow = 0;
        int endRow = n - 1;
        int startCol = 0;
        int endCol = n - 1;

     int num = 1;

        while (startRow <= endRow && startCol <= endCol) {

            // Top Row
            for (int j = startCol; j <= endCol; j++) {
                res[startRow][j] = num++;
            }

            // Right Column
            for (int i = startRow + 1; i <= endRow; i++) {
                res[i][endCol] = num++;
            }

            // Bottom Row
            if (startRow < endRow) {
                for (int j = endCol - 1; j >= startCol; j--) {
                    res[endRow][j] = num++;
                }
            }

            // Left Column
            if (startCol < endCol) {
                for (int i = endRow - 1; i > startRow; i--) {
                    res[i][startCol] = num++;
                }
            }

            startRow++;
            endRow--;
            startCol++;
            endCol--;
        }

        return res;
    }
    public int[][] generateMatrix(int n) {
        return  matrixGenerate(n);
    }
}