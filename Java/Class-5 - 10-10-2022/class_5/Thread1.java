package class_5;

public class Thread1 extends Thread {
    @Override
    public void run() {
        while (true){
            System.out.println("I am thread 1");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
