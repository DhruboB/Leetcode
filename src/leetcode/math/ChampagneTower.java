package leetcode.math;

public class ChampagneTower {
    public static void main(String[] args) {
//        int poured  = 25;
//        int query_row = 6;
//        int query_glass = 1; // 0.1875

//        int poured  = 2;
//        int query_row = 1;
//        int query_glass = 1; // 0.5


        int poured  = 100000009;
        int query_row = 33;
        int query_glass = 17; // 1.00000

        System.out.println(champagneTower(poured,query_row,query_glass));
    }

    public static double champagneTower(int poured, int query_row, int query_glass) {

        double[] tower = new double[101];
        tower[0] = poured;

        for (int row = 1; row <= query_row; row++) {
            for (int col = row; col >= 0; col--) {
                double remainingChampagne = (tower[col] - 1) / 2.0;
                if (remainingChampagne > 0) {
                    tower[col + 1] += remainingChampagne;
                    tower[col] = remainingChampagne;
                } else {
                    tower[col] = 0;
                }
            }
        }
        return Math.min(1.0, tower[query_glass]);
    }
}
