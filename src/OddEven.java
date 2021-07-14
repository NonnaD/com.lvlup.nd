import java.util.Arrays;

public class OddEven {

    public static void main(String[] args) {
        int[] arr = {2, 3, 5};

        int[] oddEven = solve(arr);
        System.out.println(Arrays.toString(oddEven));

//        int[] arr = {1,2,3,4,5,6,7,8,9};
//       int end = arr.length -1;
//       int stop =  arr.length;
//       int start = 0;
//       int startS = arr.length;
//       while (stop > 0){
//           System.out.print(arr[end--] + " ");
//           stop--;
//       }
//        System.out.println();
//        while (startS > 0){
//            System.out.print(arr[start++] + " ");
//            startS--;
//        }
    }

    static int[] solve1(int[] arr) {
        if(arr == null || arr.length < 1) return arr;
        int start = 0;
        int end = arr.length -1;
        int temp;

        while (end > start){

            while (end > start && arr[end]%2!=0){
                end--;
            };

            while (end > start && arr[start]%2==0){
                start++;
            };

            temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
        }
        return arr;
    }

    static int[] solve2(int[] arr) {
        int start = -1;
        int end = arr.length -1;
        int temp;

        while(end > start){
            System.out.println("end before " + end);
            while(end > start && arr[--end]%2!=0);
            System.out.println("end after " + end);
            while(end > start && arr[++start]%2==0);
            temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
        }
        return arr;
    }
    static int[] solve(int[] arr) {
        //start equls -1 so I can first increment the value and then use it
        // if start equals 0  while(end > start && arr[--start]%2==0);
        //after while completed it will update start before line 26
        int start = -1;
        int end = arr.length -1;
        int temp;

        while(end > start){
            while(end > start && arr[--end]%2!=0);
            while(end > start && arr[++start]%2==0);
            temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
        }

        return arr;
    }
}

//
