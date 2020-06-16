public class Mathematical_operations {
    public static void main(String[] args){
        int result = (int)Math.ceil(1.1F); // Gives the mathematical cieling of the number 
        int result1 = (int)Math.floor(1.1F); // Gives the mathematical cieling of the number 
        System.out.println("Ceil is: " + result + " Floor is : " + result1);

        int result2 = (int)Math.round(1.1F); // Gives the rounded figure of the number 
        System.out.println("Rounded figure is : " + result2);
        
        int result3 = (int)(Math.random() * 100); // Gives the random figure between range (0,100) 
        System.out.println("Random number generation : " + result3);
    }
}