package triangle;

import org.junit.After;
import org.junit.Before;

public class BaseTest {

    @Before
    public void start(){
        System.out.println("Start test");
    }

    @After
    public void end(){
        System.out.println("Test has been completed");
    }


}
