import org.junit.*;
import java.io.*;

public class ArrayTest {
    @Test
    public void testArray() {
        final ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        Main.main(null);
        Assert.assertEquals("3\n", out.toString());
    }
}
