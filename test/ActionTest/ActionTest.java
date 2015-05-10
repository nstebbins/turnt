import org.junit.*;
import java.io.*;

public class ActionTest {
    @Test
    public void testAction() {
        final ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        Main.main(null);
        Assert.assertEquals("hello\n", out.toString());
    }
}
