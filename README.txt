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

   => reverseList --- O()
