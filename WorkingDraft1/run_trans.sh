#!/bin/sh
grammar=$1
test=$2

echo "Building Grammar and Running Translater"
antlr4 $grammar.g4
javac $grammar*.java
javac Translate.java
cat $test | java Translate
