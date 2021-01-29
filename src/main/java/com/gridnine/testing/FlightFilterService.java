package com.gridnine.testing;

import java.util.List;

public interface FlightFilterService {

    void printDepartureUntilCurrentTime(List<Flight> flights);
    void printArrivalEarlierDeparture(List<Flight> flights);
    void printTimeOnEarth(List<Flight> flights);

}
