
public class P2_Q1andQ2 {

    public static void main(String[] args) {

        stair(4, 2);
        // int[][] st =new int[5][5];
        //  printX(st,0,st.length-1,7);
    }

    public static void printX(int[][] st, int i, int j, int num) {
        if (i < st.length) {
            st[i][i] = num;
            st[i][j] = num;
            for (int k = 0; k < st.length; k++) {
                System.out.print(st[i][k]);
            }
            System.out.println("");
            printX(st, ++i, --j, num);
        }
    }

    public static void stair(int step, int space) {
        if (step > 0) {
            System.out.println("|_");
            for (int i = 0; i < space; ++i) {
                System.out.print(" ");
            }

            stair(--step, space + 2);

        }
    }
}
