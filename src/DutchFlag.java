import java.util.Arrays;

public class DutchFlag {

    public static void main(String[] args) {
        char[] balls = new char[]{'B', 'G', 'R'};
        System.out.println(Arrays.toString(balls));
        dutch_flag_sort(balls);
        System.out.println(Arrays.toString(balls));
//        int[] ballsInt = new int[balls.length];
//        for(int i = 0; i <= balls.length - 1; i++){
//            ballsInt[i] = balls[i];
//        }
//
//        System.out.println(Arrays.toString(ballsInt));
    }

    public static void dutch_flag_sort(char[] balls) {
        int pivotFirstGreen = 0;
        int pivotFirstRed = 0;
        int i = 0;
        int m = 0;
        int j = balls.length;

        for(int b = 0; b <= balls.length-1; b++){
            if (balls[b] == 'G'){
                pivotFirstGreen = balls[b];
                break;
            }
        }

        char ir = balls[i];
        while (i < j){
            while (i < j && balls[--j] < pivotFirstGreen);
            balls[i] = balls[j];

            while (i<j && balls[i++] >= pivotFirstGreen);
            balls[j] = balls[i];
        }
        balls[j] = ir;

//        for(int r = 0; r < balls.length-1; r++){
//            if (balls[r] == 'G'){
//                pivotFirstRed = balls[r];
//                break;
//            }
//        }
//
//        int ballM = pivotFirstRed;
//        while (m < j){
//            while (m < j && balls[--j] <= pivotFirstRed);
//            balls[m] = balls[j];
//
//            while (m < j && balls[++m] > pivotFirstRed);
//            balls[j] = balls[m];
//        }
//        balls[j] = (char) ballM;

    }


}
