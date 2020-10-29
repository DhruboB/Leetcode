package leetcode.array;

public class MaximizeDistanceToClosestPerson {

    public static void main(String[] args) {
//        int[] seats = {1,0,0,0,1,0,1}; // 2
//        int[] seats = {1,0,0,0}; // 3

//        int[] seats = {0,0,1}; // 2

        int[] seats = {0,1,1,1,0,0,1,0,0}; // 2

//        int[] seats = {0,0,0,0,0,0,0,0,1,1,0,0}; // 8

//        int[] seats = {0, 0, 0, 1, 1, 0, 1, 1, 0, 0, 0, 1, 0, 0, 1, 0, 0}; // 3

        System.out.println(maxDistToClosest(seats));
    }

    public static int maxDistToClosest(int[] seats) {
        int maxDistance = 0;
        int count = 0;
        boolean withinOthers = false;
        boolean startWithPerson = false;
        boolean endWithPerson = false;
        for (int i = 0; i < seats.length; i++) {
            int j = i;
            while (j < seats.length) {
                if (seats[j] != 1) {
                    count++;
                } else {
                    endWithPerson = true;
                    withinOthers = startWithPerson && endWithPerson ? true : false;
                    count = withinOthers ? (int) Math.ceil(count / 2.0) : count ;
                    if (count >= maxDistance) {
                        maxDistance = count;
                    }
                    count = 0;
                    startWithPerson = true;
                    endWithPerson = false;
                    break;
                }
                if (j == seats.length - 1) {
                    withinOthers = startWithPerson && endWithPerson ? true : false;
                    count = withinOthers ? (int) Math.ceil(count / 2.0) : count ;
                    if (count >= maxDistance) {
                        maxDistance = count;
                        endWithPerson = false;
                    }
                }
                j++;
            }
            i = j;
        }
        return maxDistance;
    }
}
