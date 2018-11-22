package triangle;

import org.junit.Test;
import static org.junit.Assert.*;

public class TriangleTest extends BaseTest {

    @Test
    public void isTriangle(){
        assertTrue(Triangle.isTriangle(2,3,4));
    }

    @Test
    public void oneSideMoreThanOther(){
        assertTrue(Triangle.isTriangle(9,10,8));
    }

    @Test
    public void oneSideMoreThanSumOfOther(){
        assertFalse(Triangle.isTriangle(1,10,3));
    }

    @Test
    public void oneSideIsNegative(){
        assertFalse(Triangle.isTriangle(-5,3,6));
    }

    @Test
    public void oneSideIsIrrational(){
        assertTrue(Triangle.isTriangle(Math.sqrt(2), 3,4));
    }

    @Test
    public void oneSideIsZero(){
        assertFalse(Triangle.isTriangle(0, 1, 3));
    }

    @Test
    public void twoSidesAreZero(){
        assertFalse(Triangle.isTriangle(1,0,0));
    }

    @Test
    public void triangleIsIsosceles(){
        assertTrue(Triangle.isTriangle(3,8,8));
    }

    @Test
    public void triangleIsEquilateral(){
        assertTrue(Triangle.isTriangle(6,6,6));
    }

    @Test
    public void sumOfTwoSideAreEqualThird(){
        assertFalse(Triangle.isTriangle(6,3,3));
    }

    @Test
    public void triangleIsRight(){
        assertTrue(Triangle.isTriangle(3,4,5));
    }


}
