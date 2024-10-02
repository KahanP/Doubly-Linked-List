#!/usr/bin/bash -ex

./compile.sh
java -cp bin cs2720.assignment2.LinkedListDriver ./input/double-input.txt
