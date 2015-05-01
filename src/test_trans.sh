#!/bin/sh
grammar=$1
dir="$2Test/$2Test.tt" # Jeff's test directory
test=../test/$dir

echo "Building Grammar and Running Translater"
antlr4 $grammar.g4
javac $grammar*.java
javac Translate.java
cat $test | java Translate
javac Main.java 
