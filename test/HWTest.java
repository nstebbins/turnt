import org.junit.*;
import java.io.*;

public class HWTest {
    @Test
    public void testHW() {
        final ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        Main.main(null);
        Assert.assertEquals("Hello World\n", out.toString());
    }
}
