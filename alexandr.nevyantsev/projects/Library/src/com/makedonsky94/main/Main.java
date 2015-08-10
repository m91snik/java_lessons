package com.makedonsky94.main;


public class Main {

    public static void main(String[] args) {
        System.out.println("Library v1.0\nactive commands:\n-showlib");
        final LibraryCallback callback = element -> System.out.format("Добавлен элемент «%s»\n", element);
        Library lib = new Library();
        LibraryReader libraryReader = new LibraryReader(System.in);
        while(libraryReader.hasData()) {
            String[] data = libraryReader.readData();
            for(String localData : data) {
                lib.addWord(localData, callback);
            }
        }
    }
}
