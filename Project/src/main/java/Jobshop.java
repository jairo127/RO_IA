public class Jobshop {
    public static void run() {
        // System.out.println("J'ai trouvé la solution mais je le dirai pas car je suis pas une balance");
        int n = 3, m = 3;
        int Dmax = 68;

        int[][] M = new int[n][m];
        int[][] P = new int[n][m];
        int[][] Tab = new int[n][m];

        M[0][0] = 1; M[0][1] = 2; M[0][2] = 3;
        M[1][0] = 2; M[1][1] = 3; M[1][2] = 1;
        M[2][0] = 3; M[2][1] = 1; M[2][2] = 2;

        P[0][0] = 10; P[0][1] = 20; P[0][2] = 30;
        P[1][0] = 5; P[1][1] = 4; P[1][2] = 10;
        P[2][0] = 12; P[2][1] = 7; P[2][2] = 4;

        Tab[0][0] = 0; Tab[0][1] = 1; Tab[0][2] = 2;
        Tab[1][0] = 3; Tab[1][1] = 4; Tab[1][2] = 5;
        Tab[2][0] = 6; Tab[2][1] = 7; Tab[2][2] = 8;
    }
}
