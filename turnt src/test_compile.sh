#!/bin/sh
grammar=$1

echo "Building Grammar"
antlr4 $grammar.g4
javac $grammar*.java
javac Translate.java
