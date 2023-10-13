package Matrix;


/**
 * 867. Transpose Matrix: in this problem we are asked to transpose the matrix.
 * Meaning flip the matrix over its main diagonal, switching the matrix’s row and column indices.
 *
 * { [ 1 ,2 ]}
 * { [1],
 *   [2]}
 *
 *
 *
 */



public class TransposeMatrix {

    public static void main(String[] args) {

        int [][] matrix = {{1,2,3},{4,5,6},{7,8,9}};

        for (int i=0;i<matrix[0].length;i++){
            System.out.print("linha-->");
            for (int j=0;j<matrix.length;j++) {
                System.out.print(matrix[i][j]);
                System.out.print(" , ");
            }
            System.out.println("");
        }

        int[][] result = transposeMatrix(matrix);
        System.out.println("matriz transpoded");
        for (int i=0;i<result[0].length;i++){
            System.out.print("linha-->");
            for (int j=0;j<result.length;j++) {
                System.out.print(result[i][j]);
                System.out.print(" , ");
            }
            System.out.println("");
        }


    }

    public static int[][] transposeMatrix(int[][] matrix) {

        int[][] newMatrix = new int[matrix[0].length][matrix.length];
        for(int i=0;i<matrix.length;i++){
            for (int j=0;j< matrix[0].length;j++){
               newMatrix[j][i] = matrix[i][j];
            }
        }

        // Write your code here.
        return newMatrix;
    }


}
