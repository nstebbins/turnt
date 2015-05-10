import org.antlr.v4.runtime.*;
import java.util.*;
import java.io.*;

/** Convert turnt to Java */

public class turntToJava extends turntTestBaseListener {

	private boolean hasMain = false;
	private HashMap<String, ArrayList<DirectiveTuple>> events;
	private ArrayList<String> directiveList;
	private HashMap<String, String> symbolTable;
	private File currentFile;

	private String curr_array_name;
	private int curr_list_pos, curr_list_size;

	/** Constructor */
	public turntToJava(){
		super();
		events = new HashMap<String, ArrayList<DirectiveTuple>>();
		directiveList = new ArrayList<String>();
		symbolTable = new HashMap<String, String>();

		curr_array_name = "";
		curr_list_pos = 0; 
		curr_list_size = 0;
	}


	/** Create essential java files */
	@Override
	public void enterPrgm(turntTestParser.PrgmContext ctx) {
		/* Create State.java */
		String state = /*package turnt;*/ 
			"\n\nimport java.util.HashMap;\n\n"
			+ "public class State {\n"
			+ "\tprivate static HashMap<String, "
			+ "Object> state = new HashMap<String, Object>();\n\n"
			+ "\tpublic static Object changeState(String "
			+ "name, Object toAdd) {\n"
			+ "\t\tstate.put(name, toAdd);\n"
			+ "\t\treturn toAdd;\n"
			+ "\t}\n\n"
			+ "\tpublic static void removeState(String name) {\n"
			+ "\t\tstate.remove(name);\n"
			+ "\t}\n\n"
			+ "\tpublic static Object getState(String name) {\n"
			+ "\t\treturn state.get(name);\n"
			+ "\t}\n"
			+ "}\n";

		File state_file = new File("State.java");
		writeToFile(state, state_file, false);

		/* Create Directive.java */
		String dir = /*package turnt;*/ 
			"\n\npublic abstract class Directive implements Comparable<Directive> {\n"
			+ "\tprivate int priority = 0;\n\n"
			+ "\tpublic Directive() {\n"
			+ "\t\tthis(0);\n"
			+ "\t}\n\n"
			+ "\tpublic Directive(int prio) {\n"
			+ "\t\tpriority = prio;\n"
			+ "\t}\n\n"
			+ "\tpublic int getPriority() {\n"
			+ "\t\treturn priority;\n"
			+ "\t}\n\n"
			+ "\tpublic void setPriority(int prio) {\n"
			+ "\t\tpriority = prio;\n"
			+ "\t}\n\n"
			+ "\tpublic void dir(){}\n\n"
			+ "\t@Override\n"
			+ "\tpublic int compareTo(Directive o) {\n"
			+ "\t\treturn priority - o.getPriority();\n"
			+ "\t}\n"
			+ "}\n";

		File dir_file = new File("Directive.java");
		writeToFile(dir, dir_file, false);

		/* Create Actions.java */
		String actions = /*package turnt;*/ "\n\npublic class "
			+ "Actions{}\n";

		File actions_file = new File("Actions.java");
		writeToFile(actions, actions_file, false);

		/* Create Event.java */ 
		String event = /*package turnt;*/"\n\nimport java.util."
			+ "*;\n\npublic abstract class Event {\n"
			+ "\tpublic String name;"
			+ "\n\tprivate ArrayList<Directive> "
			+ "registeredDirectives;\n\n"
			+ "\tpublic Event() {\n"
			+ "\t\tregisteredDirectives = new ArrayList<Directive>();\n"
			+ "\t}\n\n"
			+ "\tpublic ArrayList<Directive> evt() {\n"
			+ "\t\treturn registeredDirectives;\n"
			+ "\t}\n\n"
			+ "\tpublic void register(Directive directive) {\n"
			+ "\t\tregisteredDirectives.add(directive);\n"
			+ "\t}\n\n"
			+ "\tpublic boolean checkCondition() {\n"
			+ "\t\treturn false;\n"
			+ "\t}\n\n"
			+ "\tpublic String getName() {return \"\";}\n"
			+ "}\n";

		File event_file = new File("Event.java");
		writeToFile(event, event_file, false);

		/* Creates Actions.java */
		File action_file = new File("Actions.java");
		writeToFile("import java.util.*;\n\npublic class Actions {\n", 
			action_file, false);
	}


	@Override
	public void exitPrgm(turntTestParser.PrgmContext ctx) {
		/* Create Main.java */
		String main = /*package turnt;*/ "\n\nimport java.util.*;"
			+ "\n\npublic class Main "
			+"{\n\tpublic static void main(String[] args) "
			+ "{\n\t\tEngine engine = new Engine();\n\t\t";

		if (hasMain) { 
			main = main + "engine.emitEvent(\"MainEvent\");\n\t"
				+ "\twhile(engine.hasNext()) {\n"
				+ "\t\t\tengine.pop().dir();\n"
				+ "\t\t\tengine.autoEmit();\n"
				+ "\t\t}\n"
				+ "\t}\n"
				+ "}\n";
		}
		else{
			main = main + "\n\t\twhile(engine.hasNext()) {"
				+ "\n\t\t\tengine.pop()."
				+ "dir();\n\t\t}\n\t}\n}\n";

		}

		File main_file = new File("Main.java");
		writeToFile(main, main_file, false);

		/* Create Engine.java */
		String engine = /*package turnt;*/ 
			"\n\nimport java.util.HashMap;\n"
			+ "import java.util.PriorityQueue;\n\n"
			+ "public class Engine {\n"
			+ "\tprivate static PriorityQueue<Directive> directiveQueue;\n"
			+ "\tprivate static HashMap<String, Event> eventMap;\n"
			+ "\tprivate static HashMap<String, Directive> directiveMap;\n\n\t";

		//Constructor
		if (hasMain) {
			engine = engine + "public Engine() {\n\t\t"
				+ "directiveQueue = new PriorityQueue<Directive>();\n\t\t"
				+ "eventMap = new HashMap<String, Event>();\n\t\t"
				+ "directiveMap = new HashMap<String, Directive>();\n\t\t"
				+ "eventMap.put(\"MainEvent\", new mainEvent"
				+ "());";
			for (String evt : events.keySet()) {
				engine += "\n\t\teventMap.put(\"" + evt + "\", new " + evt + "());";
			}
			for (String dir : directiveList) {
				engine += "\n\t\tdirectiveMap.put(\"" + dir + "\", new " + dir + "());";
			}
			engine += "\n\t}\n\n";
		}
		else {
			engine = engine + "public Engine() { \n\t\t"
				+ "directiveQueue = new PriorityQueue(); "
				+ "eventMap = new HashMap<>(); \n\t"
				+ "}\n}\n\n";   
		}

		engine = engine + "\tpublic static void push(Directive directive) {"
			+ "\n\t\tdirectiveQueue.add(directive);"
			+ "\n\t}"
			+ "\n\n\tpublic static Directive pop() {"
			+ "\n\t\treturn directiveQueue.poll();"
			+ "\n\t}"
			+ "\n\n\tpublic static boolean hasNext() {"
			+ "\n\t\treturn !directiveQueue.isEmpty();"
			+ "\n\t}"
			+ "\n\tpublic static void emitEvent(String event) {"
			+ "\n\t\tfor(Directive directive : eventMap."
			+ "get(event).evt()) {"
			+ "\n\t\t\tpush(directive);"
			+ "\n\t\t}"
			+ "\n\t}"
			+ "\n\n\tpublic static void "
			+ "registerDynamic(String dir, String evt, int priority) {"
			+ "\n\t\tDirective target = directiveMap.get(dir);"
			+ "\n\t\ttarget.setPriority(priority);"
			+ "\n\t\teventMap.get(evt).register(target);"
			+ "\n\t}"
			+ "\n\n\tpublic static void createDirective("
			+ "String name, Directive dir) {"
			+ "\n\t\tdirectiveMap.put(name, dir);"
			+ "\n\t}\n\n"
			+ "\tpublic static void autoEmit() {\n"
			+ "\t\tSystem.out.printf(\"\");\n"
			+ "\t\tfor (Event evt : eventMap.values()) {\n"
			+ "\t\t\tif (evt.checkCondition()) {\n"
			+ "\t\t\t\temitEvent(evt.getName());\n"
			+ "\t\t\t}\n"
			+ "\t\t}\n"
			+ "\t}\n"
			+ "}\n";

		File engine_file = new File("Engine.java");
		writeToFile(engine, engine_file, false);

		/* Create all event classes */
		Set<String> eventSet = events.keySet();
		Iterator eventIter = eventSet.iterator();
		//Create each event.
		while(eventIter.hasNext()) {
			String eventID = eventIter.next().toString();
			ArrayList<DirectiveTuple> dirs = events.get(eventID);   
			String event = "\tpublic " + eventID + "() {\n"
					+ "\t\tname = \"" + eventID + "\";";
			if (eventID.equals("mainEvent")) {
				event = "public class mainEvent extends Event {\n"
					+ "\tpublic boolean checkCondition() {return false;}\n"
				    + "\tpublic String name;\n"
			   	    + event;
			}
			//Add directives registered to event on top level.
			Iterator<DirectiveTuple> dirIter = dirs.iterator();
			while(dirIter.hasNext()){
				DirectiveTuple tup = dirIter.next();
				String directive = tup.name;
				event +=  "\n\t\tsuper.register(new "
					+ directive + "(" + String.valueOf(tup.priority) + "));";
			}

			event = event + "\n\t}\n\n"
					+ "\tpublic String getName() {return name;}\n"
					+ "}";

			File event_file = new File(eventID+".java");
			boolean isMainEvent = eventID.equals("mainEvent");
			writeToFile(event, event_file, !isMainEvent);
		}

		/* add closing brace */
		File action_file = new File("Actions.java");
		writeToFile("}\n", action_file, true);
	}

	//Private class for String Int tuples.
	private class DirectiveTuple {
		public String name;
		public int priority;

		public DirectiveTuple(String n, int p) {
			name = n;
			priority = p;
		}
	}

	@Override
	public void enterRegisterMain(turntTestParser.RegisterMainContext ctx) {
		hasMain = true;
		String event = ctx.getChild(2).getText() + "Event";
		String directive = ctx.ID().getText() + "Directive";
		int priority = Integer.parseInt(ctx.getChild(3).getText());

		if(!events.containsKey(event)){
			ArrayList<DirectiveTuple> s = new ArrayList<DirectiveTuple>();
			s.add(new DirectiveTuple(directive, priority));
			events.put(event, s);
		}
		else{
			ArrayList<DirectiveTuple> s = events.get(event);
			s.add(new DirectiveTuple(directive, priority));
			events.put(event, s);
		}
	}

	@Override
	public void enterRegister(turntTestParser.RegisterContext ctx) {
		if (currentFile == null) {
			//Not in a block.
			String event = ctx.getChild(2).getText() + "Event";
			String directive = ctx.getChild(1).getText() + "Directive";
			int priority = Integer.parseInt(ctx.getChild(3).getText());

			if(!events.containsKey(event)){
				ArrayList<DirectiveTuple> s = new ArrayList<DirectiveTuple>();
				s.add(new DirectiveTuple(directive, priority));
				events.put(event, s);
			}
			else{
				ArrayList<DirectiveTuple> s = events.get(event);
				s.add(new DirectiveTuple(directive, priority));
				events.put(event, s);
			}
		} else {
			//In a block.
			writeToFile("Engine.registerDynamic(\"" + ctx.getChild(1)
					+ "Directive\", \"" + ctx.getChild(2) + "Event\", "
					+ ctx.getChild(3) + ");\n",
					currentFile, true);
		}
	}

	/** Create java files associated with Directives */
	@Override
	public void enterDir(turntTestParser.DirContext ctx) {
		String ID = ctx.ID().getText();
		directiveList.add(ID + "Directive");
		String dir = /*package turnt;*/ 
			"\nimport java.util.*;"
			+ "\n\npublic class " + ID + "Directive extends Directive {\n"
			+ "\tpublic " + ID + "Directive() {\n"
			+ "\t\tsuper();\n"
			+ "\t}\n\n"
			+ "\tpublic " + ID + "Directive(int prio) {\n"
			+ "\t\tsuper(prio);\n"
			+ "\t}\n\n"
			+ "\tpublic void dir() {\n";

		File dir_file = new File(ID + "Directive.java");
		currentFile = dir_file;
		writeToFile(dir, dir_file, false);
	}

	@Override
	public void exitDir(turntTestParser.DirContext ctx) {
		writeToFile("\t}\n}\n", currentFile, true);
		currentFile = null;
	}

	/* modify files properly for actions */
	@Override
	public void enterAction(turntTestParser.ActionContext ctx) {
		// declared action?
		String ID = ctx.ID().getText();
		String action = "\n\npublic static void " + ID + "()" + "{\n";

		// add action to Actions class
		File action_file = new File("Actions.java");
		currentFile = action_file;
		writeToFile(action, action_file, true);
	}

	@Override
	public void exitAction(turntTestParser.ActionContext ctx) {
		File action_file = new File("Actions.java");
		writeToFile("}\n\n", action_file, true);
		currentFile = null;
	}

	/* triggering actions */
	@Override
	public void enterAction_stmt(turntTestParser.Action_stmtContext ctx) {
		String ID = ctx.ID().getText();
		String currtext = "\nActions." + ID + "();";

		writeToFile(currtext, currentFile, true);
	}

	@Override
	public void exitAction_stmt(turntTestParser.Action_stmtContext ctx) {

	}

	//TODO: error if no event for register event.
	@Override
	public void enterAE_EVENT(turntTestParser.AE_EVENTContext ctx) {
		String ID = ctx.ID().getText();
		currentFile = new File(ID + "Event.java");
		writeToFile("\n\npublic class " + ID + "Event extends Event {\n"
				+ "\tprivate String name;\n"
				+ "\tpublic boolean checkCondition() {\n",
				currentFile, false);
		//Add to events storage.
		if (!events.containsKey(ID + "Event")) {
			ArrayList<DirectiveTuple> eventList = new ArrayList<DirectiveTuple>();
			events.put(ID + "Event", eventList);
		}
	}

	@Override
	public void exitAE_EVENT(turntTestParser.AE_EVENTContext ctx) {
		writeToFile("\n\t}\n\n", currentFile, true);
		currentFile = null;
	}
	@Override
	public void enterNAE_EVENT(turntTestParser.NAE_EVENTContext ctx) {
		String ID = ctx.ID().getText();
		currentFile = new File(ID + "Event.java");
		// No auto-emit condition
		writeToFile("\n\npublic class " + ID + "Event extends Event {\n"
				+ "\tprivate String name;\n"
				+ "\tpublic boolean checkCondition() { return false; }\n\n",
				currentFile, false);
		//Add to events storage.
		if (!events.containsKey(ID + "Event")) {
			ArrayList<DirectiveTuple> eventList = new ArrayList<DirectiveTuple>();
			events.put(ID + "Event", eventList);
		}
	}

	@Override
	public void exitNAE_EVENT(turntTestParser.NAE_EVENTContext ctx) {
		currentFile = null;
	}

	@Override
	public void enterEmitOn(turntTestParser.EmitOnContext ctx) {
		writeToFile("return ", currentFile, true);
	}

	@Override
	public void exitEmitOn(turntTestParser.EmitOnContext ctx) {
		writeToFile(";", currentFile, true);
	}

    /*
	@Override
	public void enterPrint(turntTestParser.PrintContext ctx) {
		int childNum = ctx.getChild(1).getChildCount();
		String gChild = null;
		if(childNum > 0){
			gChild = ctx.getChild(1).getChild(0).getText();  

			if(childNum == 1){
				writeToFile("System.out.println(" + gChild 
						+ ".toString());\n", currentFile, true);
			}

			 //else if(childNum > 0 && !gChild.equals("state")){
			 //  writeToFile("System.out.println(" + ctx.getChild(1)
			 //  + ");\n", currentFile, true);
			  // }
		}
		else{
			writeToFile("System.out.println(" + ctx.getChild(1)
					+ ");\n", currentFile, true);
		}    
	}
    */
    @Override
    public void enterSTRING_PRINT(turntTestParser.STRING_PRINTContext ctx) {
        String toPrint = ctx.getChild(1).getText();
        writeToFile("System.out.println(" + toPrint + ");\n", currentFile, true);
    }

    @Override
    public void enterEXPR_PRINT(turntTestParser.EXPR_PRINTContext ctx) {
        writeToFile("System.out.println(", currentFile, true);
    }

    @Override
    public void exitEXPR_PRINT(turntTestParser.EXPR_PRINTContext ctx) {
        writeToFile(");\n", currentFile, true);
    }

	/*
		PROMPT: write user input to identifer
	*/
	@Override
	public void enterPrompt(turntTestParser.PromptContext ctx) {
		String ID = ctx.ID().getText();

		// write to current file
		String scanner = "\nScanner in = new Scanner(System.in);";
		String prompt = "\nif(" + ID + " instanceof Integer) {" + 
						"\n" + ID + " = in.nextInt(); }" + 
						"\nelse if(" + ID + " instanceof Double) {" + 
						"\n" + ID + " = in.nextDouble(); }" + 
						"\nelse {" + 
						"\n" + ID + " = in.nextLine(); }";

		writeToFile(scanner, currentFile, true);
		writeToFile(prompt, currentFile, true);
	}

	//TODO: Must make state into an expr.
	@Override
	public void enterStateNew(turntTestParser.StateNewContext ctx) {
		String id = ctx.getChild(2).getText();
		String type = ctx.getChild(1).getText();
		symbolTable.put(id, type);
		writeToFile(mapVars(type) + " " + id + " =  (" + mapVars(type) + ") State.changeState(\"" + id
				+ "\", (Object) new ",
				currentFile, true);
	}

	@Override
	public void exitStateNew(turntTestParser.StateNewContext ctx) {
		writeToFile("(\"" + ctx.getChild(3) + "\"));\n",
				currentFile, true);
	}

	@Override
	public void enterStateGet(turntTestParser.StateGetContext ctx) {
		String id = ctx.getChild(1).getText();
		String type = symbolTable.get(id);
		writeToFile(mapVars(type) + " " + id + " = (" + mapVars(type)
				+ ") State.getState(\"" + id + "\");\n",
				currentFile, true);
	}
	@Override
	public void enterStateSet(turntTestParser.StateSetContext ctx) {
		String id = ctx.getChild(1).getText();
		String type = symbolTable.get(id);
		writeToFile("State.changeState(\"" + ctx.getChild(1)
				+ "\", (Object) " + ctx.getChild(2) + ");\n", currentFile, true);
	}

	//Emit
	@Override
	public void enterEmit(turntTestParser.EmitContext ctx) {
		writeToFile("Engine.emitEvent(\"" + ctx.getChild(1) + "Event\");\n",
				currentFile, true);
	}

	//TODO: Try with resources.
	//NOTE: If writing to file contained in currentFile, append must be true.
	//Otherwise, append should be false.
	private void writeToFile(String toWrite, File file, boolean append) {
		FileWriter writer = null;
		try {
			writer = new FileWriter(file, append);
			writer.write(toWrite);
		} catch (IOException e) {
			System.out.println("IO Exception");
		} finally {
			try {
				writer.close();
			} catch (IOException e) {
			}
		}
	}

	private String mapVars(String input) {
		if (input.equals("int")) {
			return "Integer";
		} else if (input.equals("float")) {
			return "Double";
		} else if (input.equals("bool")) {
			return "Boolean";
		} else if (input.equals("String")) {
			return "String";
		}
		return "String";
	}

	@Override
	public void enterFor_blk(turntTestParser.For_blkContext ctx){
		String for_blk = ctx.getText();
		int index = for_blk.indexOf('(');
		String s = for_blk.substring(0, index+1);
		//writeToFile(s, currentFile, true);
		//System.out.println(s);
        writeToFile("for ", currentFile, true);
	}

	@Override
	public void exitFor_blk(turntTestParser.For_blkContext ctx){
		/*String stmt = ctx.getText();
		  int index = stmt.indexOf('{');
		  String s = stmt.substring(0,index+1);

		  RuleContext init = (RuleContext)ctx.getChild(2).getChild(0); 
		  int childNum = init.getChild(0).getChildCount();
		  String first_stmt = init.getText();
		//System.out.println(childNum);
		//System.out.println(first_stmt.getText());
		//String s = block.substring(0,index+1) + "\n";
		System.out.println(first_stmt);         
		if(childNum > 0){
		int i = stmt.indexOf(';');
		s = s.substring(i,index+1);    
		//System.out.println(s);
		}
		System.out.println(s);
		s = s + "\n";
		writeToFile(s, currentFile, true);
		*/
		writeToFile("\n}\n", currentFile, true);
	}

    /*
	@Override
	public void enterFor_expr(turntTestParser.For_exprContext ctx){     
		String for_expr = ctx.getText();
		//int index = for_expr.indexOf('{');
		//  String for_stmt = for_blk.substring(0,index+1) + "\n";
		//
		int childNum = ctx.assign().get(0).getChildCount(); 
		//RuleContext init = (RuleContext)ctx.getChild(2).getChild(0); 
		//  int childNum = init.getChild(0).getChildCount();
		//  String init_stmt = init.getText();
		//System.out.println(childNum);
		//  System.out.println(init_stmt.getText());
		////String s = block.substring(0,index2+1) + "\n";
		//
		//System.out.println(childNum);
		if(childNum == 0){
			String init_stmt = ctx.getChild(0).getText();
			writeToFile(init_stmt, currentFile, true);
			//System.out.println(init_stmt);
		}
		//   int i = for_stmt.indexOf('(');
		//	 String s = for_stmt.substring(0, i+1);
		//	 writeToFile(s, currentFile, true);

		//	 enterAssign(ctx.for_expr().assign().get(0));

		//	 int j = for_stmt.indexOf(';');
		//	 String end_stmt = for_stmt.substring(j, index+1);
		//	 writeToFile(end_stmt, currentFile, true);     
		//}
		//else{
		//	//String s = block.substring(0,index+1) + "\n";
		//	writeToFile(for_stmt, currentFile, true);
		//	}
	}
    */

    /*
	@Override
	public void exitFor_expr(turntTestParser.For_exprContext ctx){
		String for_expr = ctx.getText();

		int index = for_expr.indexOf(';');
		int index2 = for_expr.indexOf(';', index+1);
		//String mid_stmt = for_expr.substring(index, index2);
		//writeToFile(mid_stmt, currentFile, true);
		//System.out.println(mid_stmt);
		//int childNum = ctx.assign().get(1).getChildCount(); 
		//RuleContext init = (RuleContext)ctx.getChild(2).getChild(0); 
		//  int childNum = init.getChild(0).getChildCount();
		//  String init_stmt = init.getText();
		//System.out.println(childNum);
		//  System.out.println(init_stmt.getText());
		//String s = block.substring(0,index2+1) + "\n";
		
		//System.out.println(childNum);
		//if(childNum == 0){
		//	String end_stmt = ctx.getChild(4).getText() + "){\n";
		//	writeToFile(end_stmt, currentFile, true);
			//System.out.println(end_stmt);
		//}
		//else{
		//	writeToFile("){\n", currentFile, true);
		//} 

	}
    */

    @Override
    public void enterFor_expr(turntTestParser.For_exprContext ctx) {
        writeToFile("(", currentFile, true);
    }

    @Override
    public void exitFor_expr(turntTestParser.For_exprContext ctx) {
        writeToFile(") {\n", currentFile, true);
    }

    @Override
    public void exitFor_init(turntTestParser.For_initContext ctx) {
        writeToFile("; ", currentFile, true);
    }

    @Override
    public void exitFor_condition(turntTestParser.For_conditionContext ctx) {
        writeToFile("; ", currentFile, true);
    }

	@Override
	public void enterWhile_blk(turntTestParser.While_blkContext ctx){
		String block = ctx.getText();
		int index = block.indexOf('{');
		String s = block.substring(0,index+1) + "\n";
		// writeToFile(s, currentFile, true);
		writeToFile("while ", currentFile, true);
	}

    public void enterConditional(turntTestParser.ConditionalContext ctx) {
        writeToFile("(", currentFile, true);
    }

    public void exitConditional( turntTestParser.ConditionalContext ctx) {
        writeToFile(") {", currentFile, true);
    }

	@Override
	public void exitWhile_blk(turntTestParser.While_blkContext ctx){
		writeToFile("\n}\n", currentFile, true);
	}

	@Override
	public void enterIf_blk(turntTestParser.If_blkContext ctx){
		String block = ctx.getText();
		int index = block.indexOf('{');
		String s = block.substring(0,index+1) + "\n";
		//writeToFile(s, currentFile, true);
		writeToFile("if ", currentFile, true);
	}

	@Override
	public void exitIf_blk(turntTestParser.If_blkContext ctx){
		writeToFile("\n}\n", currentFile, true);
	}

    /*
	@Override
	public void exitBexpr(turntTestParser.BexprContext ctx){
		String s = ctx.getText();
		String uncle = ctx.getParent().getParent().getChild(0).getText(); 
		String uncle2 = ctx.getParent().getChild(0).getText(); 
		if(!uncle.equals("for") && !uncle2.equals("while") 
				&& !uncle2.equals("if")){
			s = s + ";\n";
				}
		else if(uncle.equals("for")){
			s = s + ";";
		}
		else if(uncle2.equals("while") || uncle2.equals("if")) {
			s = s + ") {\n";
		}
		else{
			s = "";
		}

		writeToFile(s, currentFile, true); 
	}
    */

    @Override
    public void enterRbexpr(turntTestParser.RbexprContext ctx) {
        String op = ctx.getParent().getChild(1).getText();
        writeToFile(" " + op + " ", currentFile, true);
    }

	@Override
	public void enterEQ_BEXPR(turntTestParser.EQ_BEXPRContext ctx) {
		writeToFile("(new Float(", currentFile, true);
	}

	@Override
	public void enterNE_BEXPR(turntTestParser.NE_BEXPRContext ctx) {
		writeToFile("!(new Float(", currentFile, true);
	}

    @Override
	public void enterBEQ_BEXPR(turntTestParser.BEQ_BEXPRContext ctx) {
		writeToFile("(new Boolean(", currentFile, true);
	}

	@Override
	public void enterBNE_BEXPR(turntTestParser.BNE_BEXPRContext ctx) {
		writeToFile("!(new Boolean(", currentFile, true);
	}

	@Override
	public void enterEqlsexpr(turntTestParser.EqlsexprContext ctx) {
		writeToFile(")).equals(new Float(", currentFile, true);
	}

	@Override
	public void exitEqlsexpr(turntTestParser.EqlsexprContext ctx) {
		writeToFile("))", currentFile, true);
	}

    @Override
	public void enterEqlsbexpr(turntTestParser.EqlsbexprContext ctx) {
		writeToFile(")).equals(new Boolean(", currentFile, true);
	}

	@Override
	public void exitEqlsbexpr(turntTestParser.EqlsbexprContext ctx) {
		writeToFile("))", currentFile, true);
	}

    @Override
    public void enterP_BEXPR(turntTestParser.P_BEXPRContext ctx) {
        writeToFile("(", currentFile, true);
    }

    @Override
    public void exitP_BEXPR(turntTestParser.P_BEXPRContext ctx) {
        writeToFile(")", currentFile, true);
    }

    @Override
	public void enterBOOL(turntTestParser.BOOLContext ctx){
	    String bool = ctx.getText();
		writeToFile(bool, currentFile, true);
	}

    @Override
	public void enterID_BEXPR(turntTestParser.ID_BEXPRContext ctx){
	    String id = ctx.getText();
		writeToFile(id, currentFile, true);
	}

    /*
	@Override
	public void exitAssign(turntTestParser.AssignContext ctx){  
		int childNum = ctx.getChild(0).getChildCount();
		String s = null; 
		if(childNum > 0){
			String child = ctx.getChild(0).getText();
			s = ctx.getText().replace(child, ""); 
			//writeToFile(s, currentFile, true); 
		}
		else{
			s = ctx.getText();
			//writeToFile(s, currentFile, true);
		}

		String sib = ctx.getParent().getParent().getChild(0).getText(); 
		if(!sib.equals("for")){
			s = s + ";\n";
		}
		else{
			String sib2 = ctx.getParent().getParent().getChild(2).getChild(0).getText();
			if(sib2.equals(ctx.getText())){
				s = s + ";";
			} 
		} 

		writeToFile(s, currentFile, true); 
	}
    */

    @Override
    public void exitDeclare(turntTestParser.DeclareContext ctx) {
        String id = ctx.getChild(1).getText();
        id = !curr_array_name.isEmpty() ? "" : id;
        writeToFile(id, currentFile, true);
    }

    @Override
    public void exitDeclare_line(turntTestParser.Declare_lineContext ctx) {
        writeToFile(";\n", currentFile, true);
    }

    @Override
    public void exitAssign_line(turntTestParser.Assign_lineContext ctx) {
        String toPrint = !curr_array_name.isEmpty() ? "\n" : ";\n";
        writeToFile(toPrint, currentFile, true);
        curr_array_name = ""; curr_list_pos = 0; curr_list_size = 0; // reset
    }

    @Override
    public void enterID_ASSIGN(turntTestParser.ID_ASSIGNContext ctx) {
    	String id = ctx.getChild(0).getText();
        writeToFile(id, currentFile, true);
    }

    @Override
    public void enterBID_ASSIGN(turntTestParser.BID_ASSIGNContext ctx) {
    	String id = ctx.getChild(0).getText();
        writeToFile(id, currentFile, true);
    }

    @Override
    public void enterELEM_EXPR(turntTestParser.ELEM_EXPRContext ctx) {
        String [] stuff = ctx.getText().split("\\[|\\]");
        String elem_access = stuff[0] + ".get(" + stuff[1] + ");"; 
        writeToFile(elem_access, currentFile, true);
    }

    @Override
    public void exitELEM_EXPR(turntTestParser.ELEM_EXPRContext ctx) {
    	// ...
    }

    @Override
    public void enterP_ASSIGN(turntTestParser.P_ASSIGNContext ctx) {
        writeToFile("(", currentFile, true);
    }

    @Override
    public void exitP_ASSIGN(turntTestParser.P_ASSIGNContext ctx) {
        writeToFile(")", currentFile, true);
    }

	@Override
	public void enterType(turntTestParser.TypeContext ctx){
		String s = null;

		int childNum = ctx.getParent().getChildCount();
		String sample = "intfloatboolcharString" + "list int" + "list float";

		int index;
		for(index=0; index<childNum; index++){
			String sib = ctx.getParent().getChild(index).getText();
			if(sample.contains(sib)){
				break;
			} 
		}

		String type = ctx.getText();

		String ID = ctx.getParent().getChild(index+1).getText();
		if(type.equals("int")){
			s = "Integer ";
		}
		else if(type.equals("float")){
			s = "Double ";
		}
		else if(type.equals("bool")){
			s = "Boolean ";
		}
		else if(type.equals("char")){
			s = "Character ";
		}
		else if(type.equals("String")){
			s = "String ";
		}
		else if(type.contains("list")) {
			curr_array_name = ID; curr_list_pos = 0;
			if(type.equals("list int")) {
				s = "ArrayList<Integer> " + ID + " = new ArrayList<Integer>();\n";
			}
			else if(type.equals("list float")) {
				s = "ArrayList<Double> " + ID + " = new ArrayList<Double>();\n";
			}
		}

		//String s = ctx.getChild(0).getText() + " "; 
		writeToFile(s, currentFile, true);
	}
    
	@Override
    public void enterP_EXPR(turntTestParser.P_EXPRContext ctx) {
        writeToFile("(", currentFile, true);
    }

    public void exitP_EXPR(turntTestParser.P_EXPRContext ctx) {
        writeToFile(")", currentFile, true);
    }

    @Override
    public void enterARRAY_EXPR(turntTestParser.ARRAY_EXPRContext ctx) {
        curr_list_size = ctx.getText().split(",").length;
        // writeToFile("{", currentFile, true);
    }

    public void exitARRAY_EXPR(turntTestParser.ARRAY_EXPRContext ctx) {
        // writeToFile("}", currentFile, true);
    }

	@Override
    public void enterNEG_EXPR(turntTestParser.NEG_EXPRContext ctx) {
        writeToFile("-(", currentFile, true);
    }

	@Override
    public void exitNEG_EXPR(turntTestParser.NEG_EXPRContext ctx) {
        writeToFile(")", currentFile, true);
    }

	@Override
    public void enterTERM_EXPR(turntTestParser.TERM_EXPRContext ctx) {
        
    	if(!curr_array_name.isEmpty() && curr_list_pos <= curr_list_size - 1) {
    		writeToFile(curr_array_name + ".add(" + ctx.getText() + ");\n", currentFile, true);
    		curr_list_pos++;
    	}
    	else {
    		// last array element or something else
    		writeToFile(ctx.getText(), currentFile, true);
    	}
        
    }

	@Override
    public void enterRexpr(turntTestParser.RexprContext ctx) {
        String op = ctx.getParent().getChild(1).getText();
        op = !curr_array_name.isEmpty() ? "" : op;
        writeToFile(" " + op + " ", currentFile, true);
    }

      
}
