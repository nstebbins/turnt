#!/bin/bash
pushd `dirname $0` > /dev/null
TEST_DIR=`pwd`
LIB_DIR=$TEST_DIR
ANTLR_LOCATION="$LIB_DIR/antlr-4.5-complete.jar"
JUNIT_LOCATION="$LIB_DIR/junit-4.12.jar:$LIB_DIR/hamcrest-all-1.3.jar"
TRANS_LOCATION="$TEST_DIR/../src"

if [ -z $1 ]
then
    for D in `find . -type d`
    do
        if [ $D != "." -a $D != ".." ]
        then
            TEST_NAME=`basename $D`
            echo Running Test $TEST_NAME
            TT=$TEST_NAME.tt
            TEST=$TEST_NAME.java
            pushd $D > /dev/null
            cat $TT | java -cp "$ANTLR_LOCATION:$TRANS_LOCATION:." Translate
            javac -cp "$JUNIT_LOCATION:." $TEST
            java -cp "$JUNIT_LOCATION:." org.junit.runner.JUnitCore $TEST_NAME
            ../clean_test.sh
            popd > /dev/null
        fi
    done
else
    D=./$1
    TEST_NAME=`basename $D`
    echo Running Test $TEST_NAME
    TT=$TEST_NAME.tt
    TEST=$TEST_NAME.java
    pushd $D > /dev/null
    cat $TT | java -cp "$ANTLR_LOCATION:$TRANS_LOCATION:." Translate
    javac -cp "$JUNIT_LOCATION:." $TEST
    java -cp "$JUNIT_LOCATION:." org.junit.runner.JUnitCore $TEST_NAME
    ../clean_test.sh
    popd > /dev/null
fi
popd > /dev/null
