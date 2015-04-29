import org.junit.*;
import java.io.*;

public class WhileTest {
	@Test
	public void testWhile() {
		final ByteArrayOutputStream out = new ByteArrayOutputStream();
	        System.setOut(new PrintStream(out));
		Main.main(null);
		Assert.assertEquals("0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n", out.toString());
	}
}
