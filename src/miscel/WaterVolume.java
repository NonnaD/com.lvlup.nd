package miscel;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class WaterVolume {
    public static void main(String[] args) {
        int[] arr = {99,6,8,6,2,5,4,8,3,7};
        int i = 0, j = arr.length-1;


        while(i < j && arr[++i] > arr[j]){
             System.out.println(i + " " + j);
        }


        //System.out.println(i);
    }

    public int maxArea(int[] height) {
        if(height.length == 0) return 0;
        //How to find V of water - lowest bar length Math.min(height[a], height[b]) * (b - a)
        //brute force: find all posiible combination of V O(n^2) - bad idea
        //using 2 pointers sliding window where i = 0; j = 1. Find max value if only j increases or both i and j increases
        int max[] = new int[2];
        int maxV = 0;

        for(int i = 0, j = 1; j < height.length; j++){
            if(height[j] == 0) continue;
            int volume = Math.min(height[i], height[j]) * (j - i);

            int volumeI = 0;

            while(i < j && (volumeI = Math.min(height[++i], height[j]) * (j - i)) > volume){
                i++;
                System.out.println(i + " +  " + volumeI);
            };

            System.out.println(i + " " + j);

            volume = Math.max(volume, volumeI);

            if(volume > maxV){
                maxV = volume;

                max[0] = i; max[1] = j;
            }

        }


        return maxV;
    }
}
