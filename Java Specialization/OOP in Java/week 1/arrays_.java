import java.util.*;

public class arrays_ {
    public static void main(String[] args){
        //undefined array
        int[] numbers = new int[5];
        numbers[0] = 1;
        numbers[1] = 2;
        //Convert numbers array to string to print the entire array of numbers 
        System.out.println(Arrays.toString(numbers));

        //defined array
        int[] numbers1 = {1,3,20,7,5};
        System.out.println(numbers1.length);
        Arrays.sort(numbers1);
        System.out.println(Arrays.toString(numbers1));

        //Multidimensional array
        int[][] numbers2 = {{1,3,20,7,5},{1,3,4,2,1}};
        int[][] numbers3 = new int[2][3];
        numbers3[0][0] = 1;
        numbers3[0][1] = 3;

        //Multidimensional array output
        System.out.println(numbers2.length);
        System.out.println(Arrays.deepToString(numbers2));
        System.out.println(Arrays.deepToString(numbers3));

    }

}