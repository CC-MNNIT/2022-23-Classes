package class_5.stopwatch;

public class Timer implements Runnable{
    Stopwatch stopwatch;
    private volatile boolean suspended=false;
    public volatile boolean status = true;
    public Timer(Stopwatch stopwatch){
       this.stopwatch=stopwatch;
    }

    @Override
    public void run() {
        int hr=0;
        int min=0;
        int sec=0;

        try{
            while(status){
                Thread.sleep(1000);
                sec++;
                if(sec==60){
                    min++;
                    sec=0;
                }
                if(min==60){
                    hr++;
                    min=0;
                }
                // UI display code.
                stopwatch.setTimer(hr, min, sec);
                while (suspended){}
            }
            stopwatch.setTimer(0,0,0);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }

    }

    public void stop(){
        status=false;
    }
    public void suspend(){
        suspended=true;
    }
    public void resume(){
        suspended=false;
        System.out.println("Resumed");
    }
}
