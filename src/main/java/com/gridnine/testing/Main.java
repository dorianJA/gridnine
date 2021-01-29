package com.gridnine.testing;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Flight> flights = FlightBuilder.createFlights();
        System.out.println("----------------All Flights-------------------");
        flights.stream().forEach(System.out::println);
        FlightFilterService flightFilterService = new FlightFilterImpl();


        System.out.println("-----------------Filter flights--------------------");
        System.out.println("вылет до текущего момента времени");
        flightFilterService.printDepartureUntilCurrentTime(flights);
        System.out.println("-----------------Filter flights--------------------");
        System.out.println("имеются сегменты с датой прилёта раньше даты вылета");
        flightFilterService.printArrivalEarlierDeparture(flights);
        System.out.println("-----------------Filter flights--------------------");
        System.out.println("общее время, проведённое на земле превышает два часа ");
        flightFilterService.printTimeOnEarth(flights);


    }


}
