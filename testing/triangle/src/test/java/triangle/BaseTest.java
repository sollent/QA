package triangle;

import org.junit.After;
import org.junit.Before;

public class BaseTest {

    protected Triangle triangle;

    @Before
    public void start(){
        triangle = new Triangle();
        System.out.println("Start test");
    }

    @After
    public void end(){
        System.out.println("Test has been completed");
    }


}
