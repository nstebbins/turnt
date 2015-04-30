import org.junit.*;
import java.io.*;

public class PriorityTest {
    @Test
    public void testHW() {
        final ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        Main.main(null);
        Assert.assertEquals("2\n1\n3\n4\n", out.toString());
    }
}
