public class casting {
    public static void main(String[] args){
        //Implicit casting 
        // byte < short < int < long < float < double
        short x =1;
        int y = x + 2;
        System.out.println(y);

        //Explicit casting
        double x1 =1.1;
        int y1 = (int) (x1 + 2);
        System.out.println(y1);

        //casting to an integer from string
        String x3 ="12";
        int y3 = Integer.parseInt(x3) + 2;
        //Float.parseFloat(x3);
        //Short.parseShort(x3);
        System.out.println(y3);
    }
}