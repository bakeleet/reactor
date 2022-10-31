package org.example;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        var controller = new Controller();

//        controller
//            .getSingleRecord()
//            .subscribe(value -> System.out.println("MAIN(single): " + value));

//        controller
//            .getSomeFiction()
//            .subscribe(value -> System.out.println("MAIN(random): metadata = " + value));


        controller
            .getScienceFiction()
            .subscribe(value -> System.out.println("MAIN(sci-fi): metadata = " + value));

        Thread.sleep(1000);

        controller
            .getFantasy()
            .subscribe(value -> System.out.println("MAIN(fantasy): metadata = " + value));

        Thread.sleep(1000);

        controller
            .getHistorical()
            .subscribe(value -> System.out.println("MAIN(history): metadata = " + value));

        Thread.sleep(1000);
    }

}