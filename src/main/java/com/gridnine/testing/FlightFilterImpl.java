package com.gridnine.testing;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FlightFilterImpl implements FlightFilterService {

    @Override
    public void printDepartureUntilCurrentTime(List<Flight> flights) {
        List<Flight> filterFlights = new ArrayList<>();
        List<Segment> segments = flights.stream()
                .flatMap((flight -> flight.getSegments()
                        .stream()))
                .filter(segment -> segment.getDepartureDate().compareTo(LocalDateTime.now()) < 0)
                .collect(Collectors.toList());
        Flight flight = new Flight(segments);
        filterFlights.add(flight);
        System.out.println(filterFlights);
    }

    @Override
    public void printArrivalEarlierDeparture(List<Flight> flights) {
        List<Flight> filterFlights = flights.stream().filter((flight -> flight.getSegments().size() > 1))
                .filter((f) -> {
                    boolean bool = false;
                    for (int i = 0; i < f.getSegments().size() - 1; i++) {
                        bool = f.getSegments().get(i).getArrivalDate().compareTo(f.getSegments().get(i + 1).getDepartureDate()) < 0;
                    }
                    return bool;
                })
                .collect(Collectors.toList());
        System.out.println(filterFlights);
    }

    @Override
    public void printTimeOnEarth(List<Flight> flights) {
        List<Flight> filterFlights = flights.stream().filter((flight -> flight.getSegments().size() > 1))
                .filter((flight -> {
                    long time = 0;
                    for (int i = 0; i < flight.getSegments().size() - 1; i++) {
                        Duration temp = Duration.between(flight.getSegments().get(i).getArrivalDate(), flight.getSegments().get(i + 1).getDepartureDate());
                        time += temp.toMinutes();

                    }
                    return time > 120;
                })).collect(Collectors.toList());
        System.out.println(filterFlights);
    }
}
