package org.example.search;

public class SearchWord {

    public static void main(String[] args) {

        String name = "sa";

        Thread searchThread1 = new Thread(new SearchWordInFile("assinaturas1.txt", name));
        Thread searchThread2 = new Thread(new SearchWordInFile("assinaturas1.txt", name));
        Thread searchAuthorThread = new Thread(new SearchWordInFile("autores.txt", name));

        searchThread1.start();
        searchThread2.start();
        searchAuthorThread.start();
    }
}
