
import org.junit.Test;
import static org.junit.Assert.*;

public class Testing {
    @Test
    public void shouldAnalyzePointConstructor() throws Exception {
        Point actual = new Point(3.4 , 2.1);
        assertEquals(3.4, actual.getX(), 0.00001);
        assertEquals(2.1, actual.getY(), 0.00001);
    }

    @Test
    public void checkEuclidean() throws Exception {
        Point a = new Point(0,3);
        Point b = new Point(4,0);
        assertEquals(5, b.euclidean(a), 0.00001);
    }

    @Test
    public void checkEquals() throws Exception {
        Point a = new Point(0,3);
        Point b = new Point(0,3);
        Point c = new Point(3,3);
        assertTrue(a.equal(b));
        assertFalse(a.equal(c));
    }

    @Test
    public void checkPrint() throws Exception {
        Point a = new Point(0,3);
        assertEquals("(0.0, 3.0)", a.print());
    }

    @Test
    public void checkConstructor() throws Exception {
        // Invalid because the Hyp > (Adj + Opp)
        Triangle invalHyp = new Triangle(1, 1, 7);
        String invalExpect = "Invalid Triangle!" + "\n" + "The hypotenuse is larger than (or equal to) the opposite and adjacent sides combined." + "\n" + "Refer to the Triangle Inequality Theorem for more information.";
        assertEquals(invalExpect, invalHyp.getType());

        //Invalid Because two points are coterminal
        // Which returns a side length of zero
        Triangle invalZero = new Triangle(0, 2, 3);
        assertEquals("Invalid Triangle!\nOne side is negative (or zero).", invalZero.getType());
        //assertEquals(0, invalZero.getArea(), 0.001);

        //Invalid Because two points are zero or negative
        // Which returns a side length of zero
        Triangle invalTwo = new Triangle(0, -1, 3);
        assertEquals("Invalid Triangle!\nTwo sides are negative (or zero).", invalTwo.getType());

        //Invalid Because two points are zero or negative
        // Which returns a side length of zero
        Triangle invalAll = new Triangle(-4, -1, -2);
        assertEquals("Invalid Triangle!\nAll three sides are negative (or zero).", invalAll.getType());

        Triangle sca = new Triangle(3, 2, 4);
        assertEquals("Scalene Triangle", sca.getType());

        Point a = new Point(0,3);
        Point b = new Point(4,0);
        Point c = new Point(0,0);
        Triangle rightSca = new Triangle(a, b, c);
        assertEquals("Right Scalene Triangle", rightSca.getType());

        Triangle iso = new Triangle(2, 2, 3);
        assertEquals("Isosceles Triangle", iso.getType());

        Point d = new Point(0,1);
        Point e = new Point(1,0);
        Point f = new Point(0,0);
        Triangle rightIso = new Triangle(d, e, f);
        assertEquals("Right Isosceles Triangle", rightIso.getType());

        Triangle coterminal = new Triangle(d, d, f);
        assertEquals(0, coterminal.getArea(), 0.00001);

        // Equilateral Triangle
        Triangle equil = new Triangle(3,3,3);
        assertEquals("Equilateral Triangle", equil.getType());
        assertEquals("Equilateral Triangle", equil.displayType());
        assertEquals(3.897114317029974, equil.getArea(), 0.00001);

    }

    @Test
    public void checkGetType() throws Exception {

        Point d = new Point(0,1);
        Point e = new Point(1,0);
        Point f = new Point(0,0);
        Triangle rightIso = new Triangle(d, e, f);
        assertEquals("Right Isosceles Triangle", rightIso.getType());

        // Equilateral Triangle
        Triangle equil = new Triangle(3,3,3);
        assertEquals("Equilateral Triangle", equil.getType());

    }


}