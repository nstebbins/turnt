import org.junit.*;
import java.io.*;

public class AutoEmitTest {
	@Test
	public void testWhile() {
		final ByteArrayOutputStream out = new ByteArrayOutputStream();
	        System.setOut(new PrintStream(out));
		Main.main(null);
		Assert.assertEquals("Setup'd\n5\n10\n10\nChanged\nDone\nChanged2\nDone\nChanged3\nDone\nChanged4\nDone\nChanged5\nDone\n2\n", out.toString());
	}
}
