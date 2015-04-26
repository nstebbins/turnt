import org.antlr.v4.runtime.*;
import java.util.*;
import java.io.*;

/** Convert turnt to Java */

public class turntToJava extends turntTestBaseListener {
	
	private boolean hasMain = false;
	private HashMap<String, ArrayList> eventMap;
	private ArrayList<String> directiveList;
	private File currentFile;
   
   
	/** Constructor */
	public turntToJava(){
		super();
		eventMap = new HashMap<String, ArrayList>();
		directiveList = new ArrayList<String>();
	}
	

	/** Create essential java files */
	@Override
	public void enterPrgm(turntTestParser.PrgmContext ctx) {
		/* Create State.java */
		String state = /*package turnt;*/ "\n\nimport"
				+ " java.util.HashMap; \n\npublic class "
				+ "State {\n\tprivate static HashMap<String, "
				+ "Object> state = new HashMap<String, Object>(); "
				+ "\n\n\tpublic static void changeState(String "
				+ "name, Object toAdd) {\n\t\tstate.put(name,"
				+ "toAdd); \n\t} \n\n\tpublic static void " 
				+ "removeState(String name) { \n\t\tstate.remove"
				+ "(name); \n\t} \n\n\tpublic static Object "
				+ "getState(String name) { \n\t\treturn state."
				+ "get(name);\n\t}\n}\n";

		File state_file = new File("State.java");
		writeToFile(state, state_file, false);

		/* Create Directive.java */
		String dir = /*package turnt;*/ "\n\npublic class "
					+ "Directive { \n\tpublic void dir(){}"
					+ "\n}\n";

		File dir_file = new File("Directive.java");
		writeToFile(dir, dir_file, false);
		
		/* Create Actions.java */
		String actions = /*package turnt;*/ "\n\npublic class "
					+ "Actions{}\n";
		
		File actions_file = new File("Actions.java");
		writeToFile(actions, actions_file, false);

		/* Create Event.java */ 
		String event = /*package turnt;*/"\n\nimport java.util."
				+ "ArrayList;\n\npublic class Event {"
				+ "\n\tprivate ArrayList<Directive> "
				+ "registeredDirectives;\n\n\tpublic Event() "
				+ " {\n\t\tregisteredDirectives = new "
				+ "ArrayList<Directive>();\n\t}\n\n\tpublic"
				+ " ArrayList<Directive> evt() {\n\t\treturn"
				+ " registered"
				+ "Directives; \n\t} \n\n\tpublic void "
				+ "register(Directive directive) { "
				+ "\n\t\tregisteredDirectives.add(directive);"
				+ "\n\t}\n}\n";

		File event_file = new File("Event.java");
		writeToFile(event, event_file, false);

		/* Creates Actions.java */
		File action_file = new File("Actions.java");
		writeToFile("public class Actions {\n", action_file, false);
    }

	
	@Override
	public void exitPrgm(turntTestParser.PrgmContext ctx) {
	    /* Create Main.java */
		String main = /*package turnt;*/ "\n\npublic class Main "
					+"{\n\tpublic static void main(String[] args) "
					+ "{\n\t\tEngine engine = new Engine();\n\t\t";

		if (hasMain) { 
		   main = main + "engine.emitEvent(\"MainEvent\");\n\t"
					+ "\twhile(engine.hasNext()) {\n\t\t\tengine.pop()."
					+ "dir();\n\t\t}\n\t}\n}\n";
		}
		else{
		   main = main + "\n\t\twhile(engine.hasNext()) {"
					+ "\n\t\t\tengine.pop()."
					+ "dir();\n\t\t}\n\t}\n}\n";

		}

		File main_file = new File("Main.java");
		writeToFile(main, main_file, false);

		/* Create Engine.java */
		String engine = /*package turnt;*/ "\n\nimport java.util."
					+ "HashMap; \nimport java.util.PriorityQueue;"
					+ " \n\npublic class Engine { \n\tprivate "
					+ "static PriorityQueue<Directive> directiveQueue; "
					+ "\n\tprivate static HashMap<String, Event> "
					+ "eventMap;\n\tprivate static HashMap<String, "
					+ "Directive> directiveMap;\n\n\t";

		if (hasMain) {
			engine = engine + "public Engine() { \n\t\t"
					+ "directiveQueue = new PriorityQueue(); \n\t\t"
					+ "eventMap = new HashMap<String, Event>(); \n\t\t"
					+ "directiveMap = new HashMap<String, Directive>();\n\t\t"
					+ "eventMap.put(\"MainEvent\", new mainEvent"
					+ "());";
			for (String evt : eventMap.keySet()) {
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
				+ "registerDynamic(String dir, String evt) {"
				+ "\n\t\tDirective target = directiveMap.get(dir);"
				+ "\n\t\teventMap.get(evt).register(target);"
				+ "\n\t}"
				+ "\n\n\tpublic static void createDirective("
				+ "String name, Directive dir) {"
				+ "\n\t\tdirectiveMap.put(name, dir);"
				+ "\n\t}"
				+ "\n}\n";

		File engine_file = new File("Engine.java");
		writeToFile(engine, engine_file, false);

		/* Create all event classes */
		Set<String> events = eventMap.keySet();
		Iterator eventIter = events.iterator();
		while(eventIter.hasNext()){
			String eventID = eventIter.next().toString(); //test this
			ArrayList<String> dirs = eventMap.get(eventID);   
			String event = /*package turnt;*/ "\n\npublic class " 
				+ eventID + " extends Event {"
				+ "\n\tpublic " + eventID + "() {";

			Iterator<String> dirIter = dirs.iterator();
			while(dirIter.hasNext()){
				String directive = dirIter.next();
				event = event +  "\n\t\tsuper.register(new " 
						+ directive + "());"; 
			}
				   
			event = event + "\n\t} \n}";

			File event_file = new File(eventID+".java");
			writeToFile(event, event_file, false);
		}

		/* add closing brace */
		File action_file = new File("Actions.java");
		writeToFile("}\n", action_file, true);
	}

	@Override
	public void enterRegisterMain(turntTestParser.RegisterMainContext ctx) {
		hasMain = true;
		String event = ctx.getChild(2).getText() + "Event";
		String directive = ctx.ID().getText() + "Directive";
		 
		if(!eventMap.containsKey(event)){
			ArrayList<String> s = new ArrayList<String>();
			s.add(directive);
			eventMap.put(event, s);
		}
		else{
			ArrayList<String> s = eventMap.get(event);
			s.add(directive);
			eventMap.put(event, s);
		}
	}

	//TODO: Priorities for directives.
	public void enterRegister(turntTestParser.RegisterContext ctx) {
		if (currentFile == null) {
			//Not in a block.
			String event = ctx.getChild(2).getText() + "Event";
			String directive = ctx.getChild(1).getText() + "Directive";

			if (!eventMap.containsKey(event)) {
				ArrayList<String> eventList = new ArrayList<String>();
				eventList.add(directive);
				eventMap.put(event, eventList);
			} else {
				ArrayList<String> eventList = eventMap.get(event);
				eventList.add(directive);
				eventMap.put(event, eventList);
			}
		} else {
			//In a block.
			writeToFile("Engine.registerDynamic(\"" + ctx.getChild(1)
					+ "Directive\", \"" + ctx.getChild(2) + "Event\");\n",
					currentFile, true);	
		}
	}

	/** Create java files associated with Directives */
	@Override
	public void enterDir(turntTestParser.DirContext ctx) {
		String ID = ctx.ID().getText();
		directiveList.add(ID + "Directive");
		String dir = /*package turnt;*/ "\n\npublic class "
					+ ID + "Directive extends Directive {"
					+ "\n\tpublic void dir() {\n";

		File dir_file = new File(ID + "Directive.java");
		currentFile = dir_file;
		writeToFile(dir, dir_file, false);
	}

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

	public void exitAction_stmt(turntTestParser.Action_stmtContext ctx) {
		
	}

	//TODO: error if no event for register event.
	public void enterEvent(turntTestParser.EventContext ctx) {
		String ID = ctx.ID().getText();
		if (!eventMap.containsKey(ID + "Event")) {
			ArrayList<String> eventList = new ArrayList<String>();
			eventMap.put(ID + "Event", eventList);
		}
	}

	public void enterPrint(turntTestParser.PrintContext ctx) {
		writeToFile("System.out.println(" + ctx.getChild(1)
				+ ");\n", currentFile, true);
	}

	/*public void enterLine(turntTestParser.LineContext ctx){
		String s = ctx.getChild(0).getText();
		if(s.equals("register")){
			String event = ctx.getStop().getText();
			String directive = ctx.getChild(1).getText();
			ArrayList arr = eventMap.get(event);
			arr.add(directive);
			eventMap.put(event, arr);
		}        

		if(s.equals("event")){
			String event = ctx.getStop().getText();
			eventMap.put(event, null);
		}	
	}*/

	//TODO: Must make state into an expr.
	public void enterStateNew(turntTestParser.StateNewContext ctx) {
		writeToFile("State.changeState(" + ctx.getChild(2)
				+ ", " + ctx.getChild(3) + ");\n", currentFile, true);
	}

	public void enterStateGet(turntTestParser.StateGetContext ctx) {
		writeToFile("State.getState(" + ctx.getChild(1) + ");\n",
				currentFile, true);
	}

	public void enterStateSet(turntTestParser.StateSetContext ctx) {
		writeToFile("State.changeState(" + ctx.getChild(1)
				+ ", " + ctx.getChild(2) + ");\n", currentFile, true);
	}

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
}
