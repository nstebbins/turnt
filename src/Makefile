ANTLR4 = java -Xmx500M -cp "/usr/local/lib/antlr-4.5-complete.jar:$CLASSPATH" org.antlr.v4.Tool

run:
	$(ANTLR4) turntTest.g4
	javac turntTest*.java
	javac Translate.java
	cat ../testfile/action.tt | java Translate
	javac Main.java

clean: 
	$(RM) *.class *~ *.tokens turntTest2*java Actions.java Directive.java Engine.java Event.java Main.java State.java startDirective.java mainEvent.java
