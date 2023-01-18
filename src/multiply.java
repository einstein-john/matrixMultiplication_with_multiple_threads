import java.util.Random;

public class multiply {
    int i;
    int j;
    int chance;

    public multiply(int i, int j) {
        this.i = i;
        this.j = j;
        chance = 0;
    }

    public synchronized int[][] multiplyMatrix(int[][] m1, int[][] m2) {
        int sum = 0;
        int[][] result = new int[m1.length][m2[0].length];
        for (int i = 0; i < m1.length; i++) {
            for (int j = 0; j < m2[0].length; j++) {
                for (int k = 0; k < m1[0].length; k++) {
                    sum += m1[i][k] * m2[k][j];
                }
                result[i][j] += sum;
                sum = 0;
            }
        }
        return result;
    }



    public static void displayMatrix(int[][] mat) {
        Random r = new Random();

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                System.out.print(mat[i][j] + " ");

            }
            System.out.println();
        }

    }
}
