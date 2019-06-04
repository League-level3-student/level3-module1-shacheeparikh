package _04_HangMan;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.junit.runners.JUnit4;

public class MultiplyTest {
    @Test
    public void basicTests() {
        assertEquals(30, Multiply.points(new String[]
                         {"1:0","2:0","3:0","4:0","2:1","3:1","4:1","3:2","4:2","4:3"}));
                     
        assertEquals(10, Multiply.points(new String[]
                         {"1:1","2:2","3:3","4:4","2:2","3:3","4:4","3:3","4:4","4:4"}));
                     
        assertEquals(0, Multiply.points(new String[]
                         {"0:1","0:2","0:3","0:4","1:2","1:3","1:4","2:3","2:4","3:4"}));
        
        assertEquals(15, Multiply.points(new String[]
                         {"1:0","2:0","3:0","4:0","2:1","1:3","1:4","2:3","2:4","3:4"}));
                     
        assertEquals(12, Multiply.points(new String[]
                         {"1:0","2:0","3:0","4:4","2:2","3:3","1:4","2:3","2:4","3:4"}));
    }
}