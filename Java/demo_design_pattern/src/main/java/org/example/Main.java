package org.example;

import org.example.demo_visiteur.Monitor;
import org.example.demo_visiteur.UpdateVisitor;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
//        Demo Builder
        /*Voiture voiture = new Voiture.Builder()
                .marque("tesla")
                .modele("3")
                .build();

        voiture = new Voiture.Builder()
                .marque("m1")
                .build();*/

//        Demo Abstract Factory
//        Application Mac
//        Application applicationMac = new Application(new MacFactory());

//        Application Windows
//        Application applicationWindows = new Application(new WinFactory());

//        Demo Singleton
        /*List<Person> liste = Storage.getInstance().getPersonList();
        liste = Storage.getInstance().getPersonList();*/

//        Demo Observable
        /*WeatherStation weatherStation = new WeatherStation();
        Phone phone = new Phone();
        Tablet tablet = new Tablet();
        weatherStation.registerObserver(phone);
        weatherStation.registerObserver(tablet);

        weatherStation.randomTemperature();

        weatherStation.randomTemperature();
        weatherStation.removeObserver(tablet);
        weatherStation.randomTemperature();*/

//        Demo Strategy
        /*Order order = new Order(1000);
        String choice;

        do {
            System.out.println("1 -- Card");
            System.out.println("2 -- Paypal");
            System.out.println("0 -- Quit");
            choice = scanner.nextLine();
            switch (choice){
                case "1" -> order.pay(new CardPaymentStrategy());
                case "2" -> order.pay(new PaypalStrategy());
                case "0" -> {}
                default -> System.out.println("Invalid choice");
            }
        }while (!choice.equals("0"));*/

//        Demo Proxy
        /*ProxyMedia mediaImage = new ProxyMedia(new Image());
        System.out.println(mediaImage.getContent());

        ProxyMedia mediaVideo = new ProxyMedia(new Video());
        System.out.println(mediaVideo.getContent());

        ProxyMedia mediaAudio = new ProxyMedia(new Audio());
        System.out.println(mediaAudio.getContent());*/

//        Demo Visiteur
        Monitor monitor = new Monitor();
        monitor.accept(new UpdateVisitor());
    }
}
