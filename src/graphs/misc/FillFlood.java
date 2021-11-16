package graphs.misc;

import java.util.ArrayList;
import java.util.Arrays;

public class FillFlood {

    //Example One

    //    { "pixel_row": 0, "pixel_column": 1, "new_color": 2,
//     "image": [[0, 1, 3],
//               [1, 1, 1],
//               [1, 5, 4]]}
//
//    // I.e. the pixel at row 0 and column 1 changes to color 2.
//    //Output:
//
//            [[0, 2, 3],
//            [2, 2, 2],
//            [2, 5, 4]]
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> image = new ArrayList<>();
        ArrayList<Integer> oneRow = new ArrayList<>();
        ArrayList<Integer> secondRow = new ArrayList<>();
        ArrayList<Integer> thrdRow = new ArrayList<>();

        oneRow.add(0); oneRow.add(1); oneRow.add(3);
        secondRow.add(1); secondRow.add(1); secondRow.add(1);
        thrdRow.add(1); thrdRow.add(5); thrdRow.add(4);

        image.add(oneRow);
        image.add(secondRow);
        image.add(thrdRow);

        image.forEach(row -> System.out.println(row.toString()));

        flood_fill(0, 1, 2, image);

        System.out.println();

        image.forEach(row -> System.out.println(row.toString()));
    }

    static ArrayList<ArrayList<Integer>> flood_fill(Integer pixel_row, Integer pixel_column, Integer new_color, ArrayList<ArrayList<Integer>> image) {
        int oldVal = image.get(pixel_row).get(pixel_column);
        fill(pixel_row, pixel_column, oldVal, new_color, image);
        return image;

    }

    public static void fill(Integer pixel_row, Integer pixel_column, Integer originValue, Integer new_color, ArrayList<ArrayList<Integer>> image) {
       if (image.get(pixel_row).get(pixel_column).equals(originValue)){
           image.get(pixel_row).set(pixel_column, new_color);
           if (pixel_row > 0) fill(pixel_row - 1, pixel_column, originValue, new_color, image);
           if (pixel_row < image.size() - 1) fill(pixel_row + 1, pixel_column, originValue, new_color, image);
           if (pixel_column > 0) fill(pixel_row, pixel_column - 1, originValue, new_color, image);
           if (pixel_column < image.get(pixel_row).size() - 1) fill(pixel_row, pixel_column + 1, originValue, new_color, image);
       }
    }
}
