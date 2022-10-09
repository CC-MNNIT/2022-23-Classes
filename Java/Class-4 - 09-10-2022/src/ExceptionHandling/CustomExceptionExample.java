package ExceptionHandling;

public class CustomExceptionExample {
    public static void main(String[] args) throws CustomException {
        if(5 == 5) throw new CustomException();
        try {
            throw new CustomException();
        } catch (CustomException e) {
            System.out.println("Custom exception thrown.");
        }
    }
}

class CustomException extends Exception {
}