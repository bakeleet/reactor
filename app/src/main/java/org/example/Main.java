package org.example;

public class Main {

    public static void main(String[] args) {
        new FictionController()
                .endpoint()
                .subscribe(value -> System.out.println("MAIN: " + value));
    }

}