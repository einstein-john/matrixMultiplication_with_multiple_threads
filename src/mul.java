
import java.util.Random;

public class matrixMultiplication {
    static int[][] result;
    static final int rows = 3;
    static final int col = 2;
    public synchronized static void setResult(int[][] result) {
        matrixMultiplication.result = result;
    }


    public static int[][] createMatrix() {
        Random r = new Random();
        int[][] mat = new int[col][rows];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                mat[i][j] = r.nextInt(10);
            }
        }
        return mat;
    }
    public static void displayMatrix(int[][] mat) {


        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                System.out.print(mat[i][j] + " ");

            }
            System.out.println();
        }

    }
    public static void main(String[] args) {
        int[][] one = createMatrix();
        int[][] two = createMatrix();

        displayMatrix(one);
        System.out.println("\n\n");
        displayMatrix(two);

        try {
            Thread t1 = new Thread(new threadMultiply(0,one, two));
            Thread t2 = new Thread(new threadMultiply(1,one, two));
            Thread t3 = new Thread(new threadMultiply(3,one, two));

            t1.start();
            t2.start();
            t3.start();

            t1.join();
            t2.join();
            t3.join();

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("\n\n");

        displayMatrix(result);


    }


}
 class threadMultiply implements Runnable{

     int [][] mat1;
     int [][] mat2;
     int rows;

    public threadMultiply(  int end, int [][]one, int [][]two){

        mat1 = one;
        mat2 = two;

        this.rows = end;
    }


    @Override
    public void run() {

        int sum = 0;
        int[][] result = new int[mat1.length][mat2.length];
        for (int i = 0; i < matrixMultiplication.col; i++) {
            for (int j = 0; j < rows; j++) {
                for (int k = 0; k < rows; k++) {
                    sum += mat1[i][k] * mat2[k][j];
                }
                result[i][j] = sum;
                sum = 0;
            }
        }
matrixMultiplication.setResult(result);
    }
}
