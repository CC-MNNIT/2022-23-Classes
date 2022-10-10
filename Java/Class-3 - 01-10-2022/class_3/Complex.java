package class_3;


public class Complex {
    private double re, im;

    public Complex(double re, double im) {
        this.re = re;
        this.im = im;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj==this)return true;
        if(!(obj instanceof Complex))return false;
        Complex complex=(Complex)obj;
        return Double.compare(this.im,complex.im)==0&&Double.compare(this.re,complex.re)==0;
    }
}
