import java.lang.Math;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int canary = 0;

        try {
            Scanner in = new Scanner(System.in);

            System.out.println("Triangle Maker:\nPlease enter the first point with a space in between the coordinates \nlike this:  \"x y\" :");
            double numX = in.nextDouble();
            double numY = in.nextDouble();
            Point p1 = new Point(numX, numY);

            System.out.println("You entered ");
            p1.print();

            System.out.println("Please enter the second point with a space in between the coordinates\nlike this:  \"x y\" :");
            numX = in.nextDouble();
            numY = in.nextDouble();
            Point p2 = new Point(numX, numY);

            System.out.println("You entered ");
            p2.print();

            System.out.println("Please enter the last point with a space in between the coordinates\nlike this:  \"x y\" :");
            numX = in.nextDouble();
            numY = in.nextDouble();
            Point p3 = new Point(numX, numY);

            System.out.println("You entered ");
            p3.print();

            System.out.println("\n\nThe given side lengths will make a/an:");
            Triangle test2 = new Triangle(p1, p2, p3);
            test2.displayType();
            test2.getArea();

            in.close();
        } catch (Exception e) {
            // Inform the user that the input was invalid.
            canary = -1;
            System.out.println("Inavlid Triangle!\nException thrown:\n" + e);}

    }

}
