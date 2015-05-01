#!/bin/sh
grammar=$1
dir="$2Test/$2Test.tt" # Jeff's test directory
test=../test/$dir

echo "building grammar & translator"
antlr4 $grammar.g4
javac $grammar*.java
cat $test | grun $grammar prgm -gui
