#!/bin/sh

echo "Installing ANTLR"
export CLASSPATH=".:./antlr-4.0-complete.jar:$CLASSPATH"
alias antlr4='java -jar ./antlr-4.0-complete.jar'
alias grun='java org.antlr.v4.runtime.misc.TestRig'