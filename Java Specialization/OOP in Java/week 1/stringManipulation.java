import java.util.Scanner;

public class stringManipulation {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.print("Name : ");
        String name = in.nextLine().trim();
        System.out.println("Your name is : " + name);
        in.close();
    }
}