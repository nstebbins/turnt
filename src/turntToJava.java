import org.antlr.v4.runtime.*;
import java.util.*;
import java.io.*;

/** Convert turnt to Java */

public class turntToJava extends turntTestBaseListener {
	
	private boolean hasMain = false;
	private HashMap<String, ArrayList<String>> eventMap;
	private ArrayList<String> directiveList;
	private File currentFile;
   
   
	/** Constructor */
	public turntToJava(){
		super();
		eventMap = new HashMap<String, ArrayList<String>>();
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
					+ "directiveQueue = new PriorityQueue<Directive>(); \n\t\t"
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

        @Override
        public void enterFor_blk(turntTestParser.For_blkContext ctx){
             String for_blk = ctx.getText();
             int index = for_blk.indexOf('(');
             String s = for_blk.substring(0, index+1);
             writeToFile(s, currentFile, true);
             //System.out.println(s);
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

        @Override
        public void enterFor_expr(turntTestParser.For_exprContext ctx){     
            String for_expr = ctx.getText();
            /*int index = for_expr.indexOf('{');
            String for_stmt = for_blk.substring(0,index+1) + "\n";
            */
            int childNum = ctx.assign().get(0).getChildCount(); 
            /*RuleContext init = (RuleContext)ctx.getChild(2).getChild(0); 
            int childNum = init.getChild(0).getChildCount();
            String init_stmt = init.getText();*/
            /*System.out.println(childNum);
            System.out.println(init_stmt.getText());
            //String s = block.substring(0,index2+1) + "\n";
            */
            //System.out.println(childNum);
            if(childNum == 0){
                String init_stmt = ctx.getChild(0).getText();
                writeToFile(init_stmt, currentFile, true);
           //     System.out.println(init_stmt);
            }
             /*   int i = for_stmt.indexOf('(');
                String s = for_stmt.substring(0, i+1);
                writeToFile(s, currentFile, true);
                
                enterAssign(ctx.for_expr().assign().get(0));
                
                int j = for_stmt.indexOf(';');
                String end_stmt = for_stmt.substring(j, index+1);
                writeToFile(end_stmt, currentFile, true);     
            }
            else{
            //String s = block.substring(0,index+1) + "\n";
                writeToFile(for_stmt, currentFile, true);
            }*/
        }

        @Override
        public void exitFor_expr(turntTestParser.For_exprContext ctx){
            String for_expr = ctx.getText();
            
            int index = for_expr.indexOf(';');
            int index2 = for_expr.indexOf(';', index+1);
            //String mid_stmt = for_expr.substring(index, index2);
            //writeToFile(mid_stmt, currentFile, true);
            //System.out.println(mid_stmt);
            int childNum = ctx.assign().get(1).getChildCount(); 
            /*RuleContext init = (RuleContext)ctx.getChild(2).getChild(0); 
            int childNum = init.getChild(0).getChildCount();
            String init_stmt = init.getText();*/
            /*System.out.println(childNum);
            System.out.println(init_stmt.getText());
            //String s = block.substring(0,index2+1) + "\n";
            */
            //System.out.println(childNum);
            if(childNum == 0){
                String end_stmt = ctx.getChild(4).getText() + "){\n";
                writeToFile(end_stmt, currentFile, true);
                //System.out.println(end_stmt);
            }
            else{
                writeToFile("){\n", currentFile, true);
            } 
            
        }

        @Override
        public void enterWhile_blk(turntTestParser.While_blkContext ctx){
            String block = ctx.getText();
            int index = block.indexOf('{');
            String s = block.substring(0,index+1) + "\n";
            writeToFile(s, currentFile, true);
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
            writeToFile(s, currentFile, true);
        }

        @Override
        public void exitIf_blk(turntTestParser.If_blkContext ctx){
            writeToFile("\n}\n", currentFile, true);
        }

        @Override
        public void enterBexpr(turntTestParser.BexprContext ctx){
            String s = ctx.getText();
            String c = ctx.getParent().getParent().getChild(0).getText(); 
            if(!c.equals("for")){
                s = s + ";\n";
            }
            else{
                s = s + ";";
            }
            
            writeToFile(s, currentFile, true); 
        }

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

        @Override
        public void enterType(turntTestParser.TypeContext ctx){
            String s = ctx.getChild(0).getText() + " "; 
            writeToFile(s, currentFile, true);
        }



}
