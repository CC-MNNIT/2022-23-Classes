package class_5;

public class Thread2 extends Thread {
    @Override
    public void run() {
        while (true){
            System.out.println("I am thread 2");
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
