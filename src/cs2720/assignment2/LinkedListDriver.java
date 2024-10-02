package cs2720.assignment2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LinkedListDriver {

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
        System.out.print("TYPE: " + type);
        if (type.equals("i")) {
            list = new DoublyLinkedList<Integer>();
        } else if (type.equals("d")) {
            list = new DoublyLinkedList<Double>();
        } else if (type.equals("s")) {
            list = new DoublyLinkedList<String>();
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
                    break;
                }

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

                break;
            case "d": // delete value

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

                break;
            case "r": // reverse list

                break;
            case "b": // delete subsection

                break;
            case "s": // swap alt

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
