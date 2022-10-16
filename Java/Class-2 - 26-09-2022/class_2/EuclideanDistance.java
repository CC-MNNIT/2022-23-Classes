package class_2;

public class EuclideanDistance {
    int x1;
    int x2;
    int y1;
    int y2;

    public EuclideanDistance(int x1, int x2, int y1, int y2) {
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
    }
    private double getxSq(){
        return (x2-x1)*(x2-x1);
    }
    private double getySq(){
        return (y2-y1)*(y2-y1);
    }
    public void getDistance(){
        double xsq= getxSq();
        double ysq= getySq();
        double dist= Math.sqrt(xsq+ysq);
        System.out.println("Distance between two points is "+ dist);
    }
}
