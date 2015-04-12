import org.antlr.v4.runtime.*;
import java.util.*;
import java.io.*;

/** Convert turnt to Java */

public class turntToJava extends turntTestBaseListener {
 
        private boolean hasMain = false;
        private HashMap<String, ArrayList> eventMap;
        
       
        /** Constructor */
        public turntToJava(){
            super();
            eventMap = new HashMap<String, ArrayList>();
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
            try{
                FileWriter state_writer = new FileWriter(state_file);
                try{
                    state_writer.write(state);
                }
                finally{
                    state_writer.close();
                }
            }
            catch(Exception e){
                System.out.println("io exception");
            }
       
      
            /* Create Directive.java */
            String dir = /*package turnt;*/ "\n\npublic class "
                        + "Directive { \n\tpublic void dir(){}"
                        + "\n}\n";

            File dir_file = new File("Directive.java");
            try{
                FileWriter dir_writer = new FileWriter(dir_file);
                try{
                    dir_writer.write(dir);
                }
                finally{
                    dir_writer.close();
                }
            }
            catch(Exception e){
                System.out.println("io exception");
            }
       

            /* Create Actions.java */
            String actions = /*package turnt;*/ "\n\npublic class "
                        + "Actions{}\n";
            
            File actions_file = new File("Actions.java");
            try{
                FileWriter actions_writer = new FileWriter(actions_file);
                try{
                    actions_writer.write(actions);
                }
                finally{
                    actions_writer.close();
                }
            }
            catch(Exception e){
                System.out.println("io exception");
            }
       

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
            try{
                FileWriter event_writer = new FileWriter(event_file);
                try{
                    event_writer.write(event);
                }
                finally{
                    event_writer.close();
                }
            }
            catch(Exception e){
                System.out.println("io exception");
            }
       
        }


	@Override
	public void exitPrgm(turntTestParser.PrgmContext ctx) {
	    /* Create Main.java */
            String main = /*package turnt;*/ "\n\npublic class Main "
                        +"{\n\tpublic static void main(String[] args) "
                        + "{\n\t\tEngine engine = new Engine();\n\t\t";

            if(hasMain){ 
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
            try{
                FileWriter main_writer = new FileWriter(main_file);
                try{
                    main_writer.write(main);
                }
                finally{
                    main_writer.close();
                }
            }
            catch(Exception e){
                System.out.println("io exception");
            }
       

            /* Create Engine.java */
            String engine = /*package turnt;*/ "\n\nimport java.util."
                        + "HashMap; \nimport java.util.PriorityQueue;"
                        + " \n\npublic class Engine { \n\tprivate "
                        + "PriorityQueue<Directive> directiveQueue; "
                        + "\n\tprivate HashMap<String, Event> "
                        + "eventMap; \n\n\t";
                    
            if(hasMain){
                engine = engine + "public Engine() { \n\t\t"
                        + "directiveQueue = new PriorityQueue(); \n\t\t"
                        + "eventMap = new HashMap<String, Event>(); \n\t\t"
                        + "eventMap.put(\"MainEvent\", new mainEvent"
                        + "());\n\t}\n\n";
            }
            else{
                engine = engine + "public Engine() { \n\t\t"
                        + "directiveQueue = new PriorityQueue(); "
                        + "eventMap = new HashMap<>(); \n\t"
                        + "}\n}\n\n";
                       
            }

            engine = engine + "\tpublic void push(Directive directive) {"
                        + "\n\t\tdirectiveQueue.add(directive);\n\t}"
                        + "\n\n\tpublic Directive pop() {\n\t\t"
                        + "return directiveQueue.poll();\n\t}"
                        + "\n\n\tpublic boolean hasNext() { \n\t\t"
                        + "return !directiveQueue.isEmpty();\n\t}\n\t"
                        + "public void emitEvent(String event) {"
                        + "\n\t\tfor(Directive directive : eventMap."
                        + "get(event).evt()) {\n\t\t\tpush(directive);"
                        + "\n\t\t}\n\t}\n}\n";

            File engine_file = new File("Engine.java");
            try{
                FileWriter engine_writer = new FileWriter(engine_file);
                try{
                    engine_writer.write(engine);
                }
                finally{
                    engine_writer.close();
                }
            }
            catch(Exception e){
                System.out.println("io exception");
            }
       

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
                try{
                    FileWriter event_writer = new FileWriter(event_file);
                    try{
                        event_writer.write(event);
                    }
                    finally{
                        event_writer.close();
                    }
                }
                catch(Exception e){
                    System.out.println("io exception");
                }
       

            }	

        }

        @Override
        public void enterStart(turntTestParser.StartContext ctx){
            hasMain = true;
            String event = ctx.getChild(2).getText() + "Event";
            String directive = ctx.ID().getText() + "Directive";
             
            if(!eventMap.containsKey(event)){
                ArrayList<String> s = new ArrayList<String>();
                s.add(directive);
                eventMap.put(event, s);
               //System.out.println("startT: " + ctx.getChild(2).getText());
            }
            else{
                ArrayList<String> s = eventMap.get(event);
                s.add(directive);
                eventMap.put(event, s);
            }

           //  startIDs.add(ctx.ID().getText);
        } 

        /** Create java files associated with Directives */
	@Override
	public void enterDir(turntTestParser.DirContext ctx) {
            String ID = ctx.ID().getText();

          //  directiveQueue.add(ID);

            String dir = /*package turnt;*/ "\n\npublic class " 
                    + ID + "Directive extends Directive {\n\tpublic void" 
                    + " dir() {\n";
	
            String line = ctx.block().getText().split(";")[0];
            String start = ctx.block().getStart().getText();
            String end = line.replace(start, "");
            
            int s = 0;
            if(start.equals("print")){
                s=1;
            }
            switch(s){
                case 1: 
                    dir = dir + print(ID, end);
            }
            
            dir = dir + "\n}\n\t}\n";
  
            String dirID = ID + "Directive";
            File dir_file = new File(dirID+".java");
            try{
                FileWriter dir_writer = new FileWriter(dir_file);
                try{
                    dir_writer.write(dir);
                }
                finally{
                    dir_writer.close();
                }
            }
            catch(Exception e){
                System.out.println("io exception");
            }
       

           /* String event = "package turnt; \n\npublic class " 
                    + ID + "Event extends Event {"
                    + "\n\tpublic " + ID + "() {"
                    + "\n\t\tsuper.register(new " + ID 
                    + "Directive());\n\t} \n}";*/

        }

        public String print(String ID, String end){
	    String s = end;	
            return ("System.out.println(" + end + ");");
	}

        public void enterLine(turntTestParser.LineContext ctx){
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
        
        }

}
