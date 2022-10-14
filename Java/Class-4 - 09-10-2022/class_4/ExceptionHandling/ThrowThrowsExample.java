package class_4.ExceptionHandling;

public class ThrowThrowsExample {
    public static void main(String[] args) {
        divide1(10, 0);
        try {
            divide2(10, 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static int divide1(int a, int b) {
        try {
            return a/b;
        } catch (ArithmeticException e) {
            return -1;
        }
    }

    public static int divide2(int a, int b) throws Exception {
        if(b == 0) throw new ArithmeticException();
        return a/b;
    }
}
