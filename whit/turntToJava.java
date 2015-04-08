/** Convert short array inits like {1,2,3} to "\u0001\u0002\u0003" */
public class turntToJava extends turntTestBaseListener {

	/** Translate { to " */
	@Override
	public void enterPrgm(turntTestParser.PrgmContext ctx) {
		System.out.print("public class Main {\n\tpublic static void main(String[] args) {\n\t\tEngine engine = new Engine();\n\t\tengine.emitEvent(\"MainEvent\");\n\t\twhile(engine.hasNext()) {\n\t\t\tengine.pop().dir();\n\t\t}\n\t}\n}");
	}

	/*@Override
	public void enterStart(turntTestParser.ValueContext ctx) {

		// Assumes no nested array initializers
		int value = Integer.valueOf(ctx.INT().getText());
		System.out.printf("\\u%04x", value);

	} */

	/** Translate } to " */

	/*@Override
	public void exitStart(turntTestParser.InitContext ctx) {
		System.out.print('"');
	}*/

	@Override
	public void enterDir(turntTestParser.DirContext ctx) {
		System.out.print("public class " + ctx.ID() + "Directive {\n\tpublic void dir() {\n\t\t");
	}

	@Override
	public void exitDir(turntTestParser.DirContext ctx) {
		System.out.print("}\n");
	}


}