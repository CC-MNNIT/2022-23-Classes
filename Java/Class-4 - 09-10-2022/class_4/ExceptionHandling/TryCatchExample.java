package ExceptionHandling;

public class TryCatchExample {
    public static void main(String[] args) {
        int numerator = 10;
        int denominator = 0;

        int fraction = 0;

        try {
            fraction = numerator / denominator;
        } catch (ArithmeticException e) {
            System.out.println("Cannot divide by 0.");
        }

        System.out.println(fraction);
    }
}
