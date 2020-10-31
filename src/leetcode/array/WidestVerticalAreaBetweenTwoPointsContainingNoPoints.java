package leetcode.array;

import java.util.Arrays;
import java.util.Comparator;

public class WidestVerticalAreaBetweenTwoPointsContainingNoPoints {

    public static void main(String[] args) {
        int[][] points = {{8,7},{9,9},{7,4},{9,7}};
        System.out.println(maxWidthOfVerticalArea(points));
    }

    public static int maxWidthOfVerticalArea(int[][] points) {
        int max = 0;
        int width = 0;
        Arrays.sort(points, Comparator.comparingLong(o -> o[0]));
        for(int i=1; i < points.length; i++){
            width = points[i][0] - points[i-1][0];
            max = Math.max(max, width);
        }
        return max;
    }
}
