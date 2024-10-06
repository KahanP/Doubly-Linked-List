Project 2:

=> Group Members:
   - Kahan Patel - @uga.edu
   - Naveen Seedani - ns75004@uga.edu

=> Contribution:
   - Kahan:
   - Naveen:

=> Pseudocode and Time Complexity:

   => deleteSubsection ---- O(n)
    1) Check if the list is empty:
     - if 'head' is null, print a message and return

    2) Initialize a pointer 'current' to the head of the list

    3) Loop through the list until 'current' is null: ------------------ O(n)
     - For each node, check if the node's value falls within the range:
      - If it does, mark the node as 'toDelete' and move 'current' to the next node before performing the deletion

      - Deletion process:
       a. If the node to delete is the head: ------------------- O(1)
        - Set the head to the next node.
        - If the new head is not null, update its 'back' pointer to null.
        - If the new head is null, set 'tail' to null as well.

       b. If the node to delete is the tail: ------------------- O(1)
        - Set the tail to the previous node.
        - If the new tail is not null, update its 'next' pointer to null.

       c. If the node to delete is in the middle: ------------------- O(1)
        - Update the 'next' pointer of the previous node to skip the current node.
        - Update the 'back' pointer of the next node to skip the current node.

     -  If the node's value does not fall within the range, move 'current' to the next node.

    4) Repeat steps 3a-3c until all nodes within the range are deleted or the end of the list is reached.

   => reverseList --- O(n)
    1) Check if the list is empty:
     - If 'head' is null, print a message.

    2) Initialize a pointer 'current' to the tall of the list.

    3) Traverse the list from the tail to head: -------------- O(n)
     - For each node:
      a. Store the 'next' pointer in a temporary variable 'temp'.
      b. Swap the 'next' and 'back' pointers of the current node/
      c. Move 'current' to the original 'back' node, now store in 'current.next'.

    4) After reversing all the nodes, swap the head and the tail: -------------- O(1)
     - Store the current 'head' in a temporary variable 'tempHead'.
     - Set 'head' to 'tail'.
     - Set 'tail' to 'tempHead'.

    5) Update the 'back' pointer of the new head:
     - If the list is not empty, set the 'back' pointer of the new head to 'null'.

    6) Update the 'next' pointer of the new tail:
     - If the list is not empty, set the 'next' pointer of the new tail to 'null'.

   => swapAlt --- O(n)
    1) Check if the list is empty:
     - If 'head' is null or 'head.next' is null, return.

    2) Initialize a pointer 'current' to point to the head of the list.

    3) Loop through the list: ----------------- O(n)
     - While 'current' is not null and 'current.next' is not null:
      a. Store the value of the current node ('current.info') in a te,porary variable 'temp'.
      b. Set the value of 'current' to the value of 'current.next'.
      c. Set the value of 'current.next' to 'temp'.
      d. Move 'current' to the node after 'current.next' (i.e., 'current = current.next.next').

    4) Repeat the process until you have traversed the list and swapped all adjacent nodes.
