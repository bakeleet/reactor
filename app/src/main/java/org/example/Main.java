package org.example;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        var controller = new Controller();

//        controller
//            .getSingleRecord()
//            .subscribe(value -> System.out.println("SINGLE: " + value));

        controller
            .getAllFiction()
            .subscribe(value -> System.out.println("MULTIPLE: " + value));

//        controller
//            .getFibonacci(100)
//            .subscribe(value -> System.out.println("FIBONACCI: " + value));

        Thread.sleep(5000);
    }

}