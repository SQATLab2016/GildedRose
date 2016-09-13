#!/bin/bash

EXERCISE_DIR="$HOME/development/codes/for_courses/software_testing/assignment2/GildedRose"
SRC_DIR="$EXERCISE_DIR/src/fi/oulu/tol/sqat"
OUT_DIR="$EXERCISE_DIR/bin"
JUNIT_DIR="$HOME/development/codes/for_courses/software_testing/junit"

javac -cp $JUNIT_DIR/junit-4.12.jar -d $OUT_DIR -sourcepath $EXERCISE_DIR/src $SRC_DIR/tests/GildedRoseTest.java
