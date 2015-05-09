import org.junit.*;
import java.io.*;

public class PrintTest {
    @Test
    public void printTest() {
        final ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        Main.main(null);
        Assert.assertEquals("Hello World\n", out.toString());
    }
}
