#!/bin/sh
grammar=$1
test=$2

echo "Building Grammar and Running Parser"
antlr4 $grammar.g4
javac $grammar*.java
cat $test | grun $grammar prgm -gui
