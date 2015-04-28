import org.junit.*;
import java.io.*;

public class ForTest {
	@Test
	public void testFor() {
		final ByteArrayOutputStream out = new ByteArrayOutputStream();
	        System.setOut(new PrintStream(out));
		Main.main(null);
		Assert.assertEquals("0\n0\n0\n0\n0\n0\n0\n0\n0\n0\n", out.toString());
	}
}
