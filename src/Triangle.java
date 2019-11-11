import java.lang.Math;
import java.util.Arrays;

public class Triangle {
    private double adj=0, opp=0, hyp=0, area=0;
    private String type = "";

    public Triangle(double a, double b, double c) {

        // Accept 3 arguments in any order and sort them
        double []vec = { a, b, c };
        Arrays.sort(vec);

        // Assign the smallest value to the adjacent side,
        // the middle value as the opposite, and the largest value as the hypotenuse.
        adj = vec[0];
        opp = vec[1];
        hyp = vec[2];

        // Exception Handling: Negative Arguments
        if (hyp <= 0){
            type = "Invalid Triangle!" + "\n" + "All three sides are negative (or zero).";
        } else if (opp <= 0){
            type = "Invalid Triangle!" + "\n" + "Two sides are negative (or zero).";
        } else if (adj <= 0){
            type = "Invalid Triangle!" + "\n" + "One side is negative (or zero).";
        }

        // Exception Handling: The three sides can't make a valid triangle.
        else if ((adj + opp) <= hyp) {
            type = "Invalid Triangle!" + "\n" + "The hypotenuse is larger than (or equal to) the opposite and adjacent sides combined." + "\n" + "Refer to the Triangle Inequality Theorem for more information.";
        } else  {
            // Check if the triangle has a 90 degree angle.
            // A^2 + B^2 - C^2 = 0 for a right triangle
            final double pythagoreanId = ((adj*adj) + (opp*opp) - (hyp*hyp));
            if ( pythagoreanId == 0) {
                type = "Right ";
            }
            // Certain irrational numbers will not equal zero despite being valid right triangles.
            // Set the precision to 10^-11 to allow for a tolerance
            // If the two sides are equal check the pythagoreanID
            else if ( (adj == opp) && ( Math.abs((hyp/adj) - Math.sqrt(2)) < 0.00000000001) ) {
                type = "Right ";
            }

            // Initialize the type of triangle:
            if ((adj == opp) && (adj == hyp)) {
                type = "Equilateral Triangle";
            } else if ((adj == opp) || (adj == hyp) || (opp == hyp)) {
                type = type + "Isosceles Triangle";
            } else {
                type = type + "Scalene Triangle";}
        }

    }

    public String displayType() {
        System.out.println(type);
    return type;
    }

    public String getType() { return type; }

    public double getArea() {
        double s = (adj + opp + hyp)/2;
        area = Math.sqrt(s*(s-adj)*(s-opp)*(s-hyp));
        if (area <=0) {
            System.out.println("Error! Invalid Triangles have no area.");
            return 0;
        }else {
            System.out.println("The triangle has an area of: " + area);
            return area;
        }

    }

    public Triangle(Point i, Point j, Point k) {
        this(i.euclidean(j), j.euclidean(k), k.euclidean(i));
        if (i.equal(j) || j.equal(k) || k.equal(i)) {
            System.out.println("Two or more points are the same\nYou will have a side length of zero.\n");
        }
    }
}
