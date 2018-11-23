package triangle;

import org.junit.Test;
import static org.junit.Assert.*;

public class TriangleTest extends BaseTest {

    @Test
    public void isTriangle(){
        assertTrue(triangle.isTriangle(2,3,4));
    }

    @Test
    public void oneSideMoreThanOther(){
        assertTrue(triangle.isTriangle(9,10,8));
    }

    @Test
    public void oneSideMoreThanSumOfOther(){
        assertFalse(triangle.isTriangle(1,10,3));
    }

    @Test
    public void oneSideIsNegative(){
        assertFalse(triangle.isTriangle(-5,3,6));
    }

    @Test
    public void oneSideIsIrrational(){
        assertTrue(triangle.isTriangle(Math.sqrt(2), 3,4));
    }

    @Test
    public void oneSideIsZero(){
        assertFalse(triangle.isTriangle(0, 1, 3));
    }

    @Test
    public void twoSidesAreZero(){
        assertFalse(triangle.isTriangle(1,0,0));
    }

    @Test
    public void triangleIsIsosceles(){
        assertTrue(triangle.isTriangle(3,8,8));
    }

    @Test
    public void triangleIsEquilateral(){
        assertTrue(triangle.isTriangle(6,6,6));
    }

    @Test
    public void sumOfTwoSideAreEqualThird(){
        assertFalse(triangle.isTriangle(6,3,3));
    }

    @Test
    public void triangleIsRight(){
        assertTrue(triangle.isTriangle(3,4,5));
    }


}
