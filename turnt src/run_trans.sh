#!/bin/sh
grammar=$1
test=$2
alias antlr4='java -jar ./antlr-4.0-complete.jar'

echo "Building Grammar and Running Translater"
antlr4 $grammar.g4
javac $grammar*.java
javac Translate.java
cat $test | java Translate
javac Main.java
