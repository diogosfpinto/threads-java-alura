package org.example.search;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SearchWordInFile implements Runnable {

    private Scanner scanner;
    private String file;
    private String name;

    public SearchWordInFile(String file, String name) {
        this.file = file;
        this.name = name;
    }

    @Override
    public void run() {

        try {
            scanner = new Scanner(new File(file));

            int i = 1;
            while(scanner.hasNextLine()){

                String linha = scanner.nextLine();
                if (linha.toLowerCase().contains(name.toLowerCase())){
                    System.out.println(file + " - "+i+ " - "+ linha);
                }
                i++;
            }

            scanner.close();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
