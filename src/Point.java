import java.lang.Math;

public class Point {
    private double x;
    private double y;

    public Point(double a, double b) {
        x=a;
        y=b;
    }
    public double getX() {return x;}
    public double getY() {return y;}

    public double euclidean(Point z) {
        double c = Math.abs(x- z.x);
        double d = Math.abs(y- z.y);
        return Math.sqrt((c*c)+(d*d));
    }

    public String print() {
        System.out.println("(" + x + ", " + y +")");
        return new String("(" + x + ", " + y +")");
    }

    public boolean equal(Point z) {
        return (x == z.x)&& ((y == z.y));
    }

}