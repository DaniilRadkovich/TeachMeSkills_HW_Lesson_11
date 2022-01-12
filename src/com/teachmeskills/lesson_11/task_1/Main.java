package com.teachmeskills.lesson_11.task_1;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter way to your document: ");
        String wayToDoc = sc.nextLine();
        sc.close();

        BufferedReader fileToRead = new BufferedReader(new FileReader(wayToDoc));
        BufferedWriter validNumbers = new BufferedWriter(new FileWriter("Valid.txt"));
        BufferedWriter noValidNumbers = new BufferedWriter(new FileWriter("NoValid.txt"));
        String line;
        StringBuilder stringBuilder = new StringBuilder();
        while ((line = fileToRead.readLine()) != null) {
            stringBuilder.append(line).append("\n");
        }
        fileToRead.close();
        String[] docsArray = stringBuilder.toString().split("\n");
        System.out.println(Arrays.toString(docsArray));
        System.out.println("Number of documents in the file: " + docsArray.length);

        for (int i = 0; i < docsArray.length; i++) {
            if (docsArray[i].length() == 15 && (docsArray[i].startsWith("docnum") || docsArray[i].startsWith("contract"))) {
                validNumbers.write(i + ". " + docsArray[i] + "\n");
            } else if (docsArray[i].length() != 15 && (docsArray[i].startsWith("docnum") || docsArray[i].startsWith("contract"))) {
                noValidNumbers.write(i + ". " + docsArray[i] + " --> Wrong document length" + "(" + docsArray[i].length() + ")!" + "\n");
            } else if (!(docsArray[i].startsWith("docnum") || docsArray[i].startsWith("contract"))) {
                noValidNumbers.write(i + ". " + docsArray[i] + " --> Document don't starts with 'docnum' or 'contract'!" + "\n");
            }
        }
        validNumbers.close();
        noValidNumbers.close();
    }
}
