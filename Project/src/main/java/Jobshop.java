import org.chocosolver.solver.Model;
import org.chocosolver.solver.Solution;
import org.chocosolver.solver.variables.BoolVar;
import org.chocosolver.solver.variables.IntVar;

public class Jobshop {
    public static void run() {
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

        Model model = new Model("ITS JOBSHOP TIME!");

        IntVar[] date_debut = new IntVar[n*m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++) {
                int position = Tab[i][j];
                date_debut[position] = model.intVar("ES_"+i+"_"+j, 0, Dmax);
            }
        }

        IntVar[] durees = new IntVar[n*m];
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                durees[i*m+j] = model.intVar("p_"+i+"_"+j, P[i][j], P[i][j]);
            }
        }

        IntVar[] date_fin = new IntVar[n*m];
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                date_fin[i*m+j] = model.intVar("EF_"+i+"_"+j, 0, Dmax);
            }
        }

        BoolVar[][] b = new BoolVar[n*m][n*m];
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                for(int u=0; u<n; u++) {
                    for(int v=0; v<m; v++) {
                        b[i*m+j][u*m+v] = model.boolVar("b_"+i+"_"+j+"_"+u+"_"+"v");
                    }
                }
            }
        }

        IntVar OBJ = model.intVar("Cmax", 0, 999);

        System.out.println(model);
        Solution solution = model.getSolver().findSolution();
        if (solution != null)
            System.out.println(solution);
    }
}
