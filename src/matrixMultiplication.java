import java.util.Random;

public class matrixMultiplication {

    static int [][] result;
    public static int[][] createMatrix() {
        Random r = new Random();
        int[][] mat = new int[100][100];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                mat[i][j] = r.nextInt(10);
            }
        }
        return mat;
    }

    public static void main(String[] args) {
        int[][] one = createMatrix();
        int[][] two = createMatrix();

multiply.displayMatrix(one);
System.out.println("\n\n");
multiply.displayMatrix(two);

        try {
            Thread t1 = new Thread(new threadMultiply(new multiply(0,33),one,two));
            Thread t2 = new Thread(new threadMultiply(new multiply(34,64),one,two));
            Thread t3 = new Thread(new threadMultiply(new multiply(65,100),one,two));

            t1.start();
            t2.start();
            t3.start();

            t1.join();
            t2.join();
            t3.join();

        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("\n\n");

        multiply.displayMatrix(result);
    }


}

class threadMultiply implements Runnable{
    multiply m ;
     int [][] mat1;
     int [][] mat2;

    public threadMultiply(multiply mul, int [][]one,int [][]two){
        m = mul;
        mat1 = one;
        mat2 = two;
    }


    @Override
    public void run() {
        matrixMultiplication.result = m.multiplyMatrix(mat1,mat2);

    }
}
