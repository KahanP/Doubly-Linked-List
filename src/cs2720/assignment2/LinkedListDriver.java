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

        System.out.print("Enter list type (i - int, d - double, s - string):");
        Scanner textScanner = new Scanner(System.in);
        String type = textScanner.nextLine();
        if (type == "i") {
            DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        } else if (type == "d") {
            DoublyLinkedList<Double> list = new DoublyLinkedList<>();
        } else if (type == "s") {
            DoublyLinkedList<String> list = new DoublyLinkedList<>();
        } else {
            System.out.println("Invalid list type, system exiting...");
            System.exit(0);
        }



        try {
            File file = new File(fileName);
            Scanner fileScanner = new Scanner(file);

            // turn file into a SortedLinked List
            while (fileScanner.hasNext()) {


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

    } // main
} // LinkedListDriver
