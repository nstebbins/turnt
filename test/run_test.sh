ANTLR_LOCATION="antlr-4.0-complete.jar"
JUNIT_LOCATION="junit-4.12.jar:hamcrest-all-1.3.jar"
TRANS_LOCATION="../turnt src"

if [ -z $1 ]
then
    for D in `find . -type d`
    do
        echo $D
    done

    # Build the turnt program
    cat test.tt | java -cp "$ANTLR_LOCATION:$TRANS_LOCATION:." Translate

    # Compile Test
    javac -cp "$JUNIT_LOCATION:." HWTest.java

    #Run Test
    java -cp "$JUNIT_LOCATION:." org.junit.runner.JUnitCore HWTest

    # Clean up
    ./clean_test.sh
else
    echo $1   
fi
