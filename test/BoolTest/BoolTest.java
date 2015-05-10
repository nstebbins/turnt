import org.junit.*;
import java.io.*;

public class BoolTest {
	@Test
	public void testBool() {
		final ByteArrayOutputStream out = new ByteArrayOutputStream();
	        System.setOut(new PrintStream(out));
		Main.main(null);
		Assert.assertEquals("i\ni\ni\ni\n", out.toString());
	}
}
