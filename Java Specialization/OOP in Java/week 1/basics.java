import java.awt.*;
import java.util.Scanner;

public class basics {
    public static void main(String[] args){
        Point point1 = new Point(1,1); //The point1 object stores the address of the Point object 
        //rather than the value itself

        // point 1 and point2 refer to the same address thus updating any one of them will affect the other
        Point point2 = point1;
        //updating the values
        point2.x = 2;
        point1.y = 4;
        
        System.out.println("The point addr is : x = " + point2.x + " and y = " + point2.y);

        String input ="";
        Scanner in = new Scanner(System.in);
        //An string object contains the address of the string so we use the equals method to check similar strings
        while(!input.equals("quit")){
            System.out.print("Input : ");
            input = in.next().toLowerCase();
            System.out.println(input);
        }

        //For-Each loop
        String [] fruits = {"Apple", "Mango", "Orange"};
        for (String string : fruits) {
            System.out.println(string);
        }

        in.close();
        
    }
}