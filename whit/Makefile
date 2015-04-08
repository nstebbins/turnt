ANTLR4 = java -Xmx500M -cp "/usr/local/lib/antlr-4.5-complete.jar:$CLASSPATH" org.antlr.v4.Tool
GRUN   = java org.antlr.v4.runtime.misc.TestRig

hello:
	$(ANTLR4) turntTest.g4
	javac turntTest*.java
	cat test | $(GRUN) turntTest prgm -gui

clean: 
	$(RM) *.class *~
