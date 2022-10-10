package ExceptionHandling;

public class MultipleCatchBlockExample {
    public static void main(String[] args) {
        try {
            int c = 1;
            switch (c) {
                case 1: throw new Exception1();
                case 2 : throw new Exception2();
                case 3 : throw new Exception3();
            }
        } catch (Exception1 e1) {
            System.out.println("Exception 1 is thrown");
        } catch (Exception2 e2) {
            System.out.println("Exception 2 is thrown");
        } catch (Exception3 e3) {
            System.out.println("Exception 3 is thrown");
        }
    }
}

class Exception1 extends Exception {}
class Exception2 extends Exception {}
class Exception3 extends Exception {}
