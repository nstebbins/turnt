import org.junit.*;
import java.io.*;

public class StateTest {
	@Test
	public void testWhile() {
		final ByteArrayOutputStream out = new ByteArrayOutputStream();
	        System.setOut(new PrintStream(out));
		Main.main(null);
		Assert.assertEquals("5\n22\n", out.toString());
	}
}
