package cs2720.assignment2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LinkedListDriver {

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("add input text file, exiting...");
            return;
        } // if

        String fileName = args[0];
        DoublyLinkedList<?> list = new DoublyLinkedList<>();

        System.out.print("Enter list type (i - int, d - double, s - string): ");
        Scanner textScanner = new Scanner(System.in);
        String type = textScanner.nextLine();
        String dataType = null;
        if (type.equals("i")) {
            list = new DoublyLinkedList<Integer>();
            dataType = "integer";
        } else if (type.equals("d")) {
            list = new DoublyLinkedList<Double>();
            dataType = "double";
        } else if (type.equals("s")) {
            list = new DoublyLinkedList<String>();
            dataType = "string";
        } else {
            System.out.println("Invalid list type, system exiting...");
            System.exit(0);
        }

        try {
            File file = new File(fileName);
            Scanner fileScanner = new Scanner(file);

            // turn file into a SortedLinked List
            while (fileScanner.hasNext()) {

                if (type.equals("i") && fileScanner.hasNextInt()) {
                    int item = fileScanner.nextInt();
                    ((DoublyLinkedList<Integer>) list).insertItem(item);
                } else if (type.equals("d") && fileScanner.hasNextDouble()) {
                    double item = fileScanner.nextDouble();
                    ((DoublyLinkedList<Double>) list).insertItem(item);
                } else if (type.equals("s")) {
                    String item = fileScanner.next();
                    ((DoublyLinkedList<String>) list).insertItem(item);
                } else {
                    System.out.println("Invalid data type in file or mismatching item type.");
                    break;                }

            } // while
            fileScanner.close();
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        } // catch

        System.out.print(
            "Commands:\n" +
            "(i) - Insert value\n" +
            "(d) - Delete value\n" +
            "(p) - Print List\n" +
            "(l) - Length\n" +
            "(t) - Print reverse\n" +
            "(r) - Reverse List\n" +
            "(b) - Delete Subsection\n" +
            "(s) - Swap Alternate\n" +
            "(q) - Quit program\n\n");

        boolean quit = false;
        while (!quit) {

            System.out.print("Enter a command: ");
            String command = textScanner.nextLine();

            switch(command) {
            case "i": // insert
                System.out.print("The list is: ");
                list.print();
                System.out.print("Enter a " + dataType + " to insert: ");
                String insertInput = textScanner.nextLine();
                try {
                    if (dataType.equals("integer")) {
                        Integer itemToInsert = Integer.parseInt(insertInput);
                        ((DoublyLinkedList<Integer>) list).insertItem(itemToInsert);
                    } else if (dataType.equals("double")) {
                        Double itemToInsert = Double.parseDouble(insertInput);
                        ((DoublyLinkedList<Double>) list).insertItem(itemToInsert);
                    } else if (dataType.equals("string")) {
                        ((DoublyLinkedList<String>) list).insertItem(insertInput);
                    } else {
                        throw new IllegalArgumentException("Invalid data type");
                    }
                } catch (IllegalArgumentException e) {
                    System.out.println("Invalid input please enter a valid " + dataType);
                } // convert input to generic
                System.out.print("The list is: ");
                list.print();
                System.out.print("The reverse list: ");
                list.printReverse();

                break;
            case "d": // delete value
                if (list.length() > 0) {
                    System.out.print("The list is : ");
                    list.print();
                } // check if list is empty for print statement
                System.out.print("Enter a " + dataType + " to delete: ");
                String deleteInput = textScanner.nextLine();
                try {
                    if (dataType.equals("integer")) {
                        Integer itemToDelete = Integer.parseInt(deleteInput);
                        ((DoublyLinkedList<Integer>) list).deleteItem(itemToDelete);
                    } else if (dataType.equals("double")) {
                        Double itemToDelete = Double.parseDouble(deleteInput);
                        ((DoublyLinkedList<Double>) list).deleteItem(itemToDelete);
                    } else if (dataType.equals("string")) {
                        ((DoublyLinkedList<String>) list).deleteItem(deleteInput);
                    } else {
                        throw new IllegalArgumentException("Invalid data type");
                    }
                } catch (IllegalArgumentException e) {
                    System.out.println("Invalid input please enter a valid " + dataType);
                } // convert input to generic
                if (list.length() != 0) {
                    System.out.print("The list is: ");
                    list.print();
                    System.out.print("The reverse list: ");
                    list.printReverse();
                } // check if list is empty
                break;
            case "p": // print list
                System.out.print("The list is : ");
                list.print();
                break;
            case "l": // length
                System.out.print("The length of the list is ");
                int length = list.length();
                System.out.print(length);
                System.out.println("");
                break;
            case "t": // print reverse
                System.out.print("The reverse list: ");
                list.printReverse();
                break;
            case "r": // reverse list
                System.out.print("The original list: ");
                list.print();
                System.out.print("The reversed list: ");
                list.reverseList();
                list.print();
                break;
            case "b": // delete subsection
                try {
                    System.out.print("Enter the lower bound: ");
                    String lowerBoundInput = textScanner.nextLine();
                    System.out.print("Enter the upper bound: ");
                    String upperBoundInput = textScanner.nextLine();

                    System.out.print("The original list: ");
                    list.print(); // before the list is modified

                    if (dataType.equals("integer")) {
                        Integer lowerBound = Integer.parseInt(lowerBoundInput);
                        Integer upperBound = Integer.parseInt(upperBoundInput);
                        ((DoublyLinkedList<Integer>) list).deleteSubsection(lowerBound, upperBound);
                    } else if (dataType.equals("double")) {
                        Double lowerBound = Double.parseDouble(lowerBoundInput);
                        Double  upperBound = Double.parseDouble(upperBoundInput);
                        ((DoublyLinkedList<Double>) list).deleteSubsection(lowerBound, upperBound);
                    } else if (dataType.equals("string")) {
                        ((DoublyLinkedList<String>) list).deleteSubsection(lowerBoundInput, upperBoundInput);
                    } else {
                         throw new IllegalArgumentException("Invalid data type");
                    }

                    System.out.print("The modified list: ");
                    if (list.length() != 0) {
                        list.print(); // print after list is modified
                    } else {
                        System.out.println();
                    } // check if list is null
                    if (list.length() != 0) {
                        System.out.print("The reverse list: ");
                        list.printReverse(); // print reversed modified
                    }

                } catch (IllegalArgumentException e) {
                     System.out.println("Invalid input please enter a valid " + dataType);
                } // convert input to generic
                break;
            case "s": // swap alt
                System.out.print("The original list: ");
                if (list.length() != 0) {
                    list.print();
                } else {
                    System.out.println();
                } // check if list is null

                // swapAlternate based on the type of the list
                if (dataType.equals("integer")) {
                    ((DoublyLinkedList<Integer>) list).swapAlternate();
                } else if (dataType.equals("double")) {
                    ((DoublyLinkedList<Double>) list).swapAlternate();
                } else if (dataType.equals("string")) {
                    ((DoublyLinkedList<String>) list).swapAlternate();
                }

                // print modified list
                System.out.print("The modified list: ");
                list.print();
                if (list.length() == 0) {
                    System.out.println();
                }
                // print the reverse list if the list contains more than 2 elements
                if (list.length() != 2 && list.length() != 0) {
                    System.out.print("The reverse list: ");
                    list.printReverse();
                }
                break;
            case "q": // quit
                System.out.println("Exiting the program");
                quit = true;
                System.exit(0);
                break;
            default:
                System.out.println("Invalid command try again");
                break;
            } // switch case

        } // main functioning loop

    } // main

} // LinkedListDriver
