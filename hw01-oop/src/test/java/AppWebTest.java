import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AppWebTest {
    private int a = 3;
    private int b = 4;
    private int c = 5;

    @Test
    public void checkTriangleCountPerimeter() {
        Triangle triangle = new Triangle(a, b, c);
        assertEquals(triangle.getPerimeter(), (double) a + b + c, 0);
    }

    @Test
    public void checkTriangleCountSquare() {
        Triangle triangle = new Triangle(a, b, c);
        double p = (triangle.getPerimeter() + .0) / 2;
        double s = Math.sqrt(p * (p - a) * (p - b) * (p - c));
        assertEquals(triangle.getSquare(), s, 0);
    }

    @Test
    public void checkSquareCountSquare() {
        Square square = new Square(a);
        assertEquals(square.getSquare(), a * a, 0);
    }

    @Test
    public void checkSquareCountPerimeter() {
        Square square = new Square(a);
        assertEquals(square.getPerimeter(), a * 4, 0);
    }
}
