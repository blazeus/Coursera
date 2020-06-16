import java.text.NumberFormat;

public class numberFormatting {
    public static void main(String[] args) {
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        // Factory methods are those methods which create a new instance
        String result = currency.format(123212133.213);
        System.out.println(result);

        String result1 = NumberFormat.getPercentInstance().format(0.12);
        System.out.println(result1);
    }
}