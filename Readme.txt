Kahan Patel - kpp18676@uga.edu
    - insert
    - delete
    - print
    - print revesre
    - length
    - reverse
    - Driver

Naveen Seedani - ns75004@uga.edu
    - github setup
    - delete subsection
    - swap alternate
    - Readme.txt

Compile command:
    -  ./compile.sh
OR
    - javac -Xlint:unchecked -d bin -cp bin src/cs2720/assignment2/*.java

Run command:
    - ./testInt tests the int-input.txt file
    - ./testDouble tests the double-input.txt file
    - ./testString tests the string-input.txt file
OR
    java -cp bin cs2720.assignment2.LinkedListDriver


DeleteSubsection:
    function deleteSubsection(lowerBound, upperBound):
    if the list is empty:
        return

    set current to head of the list

    while current is not null:
        if current node's value is between lowerBound and upperBound:
            set toDelete to current node
            move current to the next node

            if toDelete is the head:
                update head to the next node
                if head is not null:
                    set head's back to null
                else:
                    set tail to null (list is now empty)

            else if toDelete is the tail:
                update tail to the previous node
                if tail is not null:
                    set tail's next pointer to null

            else:
                connect toDelete's previous node's next pointer to toDelete's next node
                connect toDelete's next node's back pointer to toDelete's previous node

        else:
            move current to the next node


    Big O complexity - O(n) the method iterates through the list only once therfore the comlexity is O(n)

ReverseList:
    function reverseList():
        if the list is empty:
            return

        set current to tail of the list

        while current is not null:
            store current's next node in temp
            swap current's next and back
            move current to temp (the stored next node)

        swap head and tail:
            store head in tempHead
            set head to tail
            set tail to tempHead

        if head is not null:
            set head's back to null

        if tail is not null:
            set tail's next to null

    Big O complexity - O(n) the method traverses the list only once


SwapAlternate:
    function swapAlternate():
        if the list is empty or only has one element:
            return

        set current to head of the list

        while current is not null and current.next is not null:
            store current node's value in temp
            set current node's value to current.next's value
            set current.next's value to temp (swap current and next node's values)
            move current to the node after next (current.next.next)

    Big O complexity - O(n) only traverses the list once
