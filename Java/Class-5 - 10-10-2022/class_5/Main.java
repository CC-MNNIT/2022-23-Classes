package class_5;

public class Main implements Runnable {
    public static void main(String[] args) {
        Thread1 thread1=new Thread1();
        thread1.start();
        Thread2 thread2=new Thread2();
        thread2.start();
        Thread thread=new Thread(new Main());
        thread.start();
        while (true){
            System.out.println("I am main thread");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void run() {
        while (true){
            System.out.println("I am thread 3 created using runnable interface");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
