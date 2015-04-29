import org.junit.*;
import java.io.*;

public class IfElseTest {
        @Test
        public void testIfElse() {
                final ByteArrayOutputStream out = new ByteArrayOutputStream();
                System.setOut(new PrintStream(out));
                Main.main(null);
                Assert.assertEquals("If-else test failed, improper output", "i = 0\ni = 1\n", out.toString());
        }   
}
