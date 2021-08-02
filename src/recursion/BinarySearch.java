package recursion;

public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5,6,7,8,9};
        System.out.println(bsearch(arr, 0, arr.length, 9));
    }

    public static int bsearch(int[] arr, int start, int end, int a){
        if (start >= end) return -1;
        int midpoint = (start + end)/2;
        if (a == arr[midpoint]) return midpoint;

        if(a > arr[midpoint]) return bsearch(arr, midpoint + 1, end, a);
        else return bsearch(arr, start, midpoint, a);
    }
}
