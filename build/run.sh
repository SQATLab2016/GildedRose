#!/bin/bash

#OUT_DIR="$HOME/development/codes/for_courses/software_testing/assignment2/GildedRose/bin/fi/oulu/tol/sqat"
OUT_DIR="$HOME/development/codes/for_courses/software_testing/assignment2/GildedRose/bin"
JUNIT_DIR="$HOME/development/codes/for_courses/software_testing/junit"

#echo "listing tests content"
#ls $OUT_DIR/tests
#echo "printing out gildedrosetest src"
#ls $OUT_DIR/tests/GildedRoseTest.class

java -cp $JUNIT_DIR/junit-4.12.jar:$JUNIT_DIR/hamcrest-core-1.3.jar:$OUT_DIR:$OUT_DIR/tests:. org.junit.runner.JUnitCore fi.oulu.tol.sqat.tests.GildedRoseTest
