package com.flighttracker.flighttracker.Business;

import com.flighttracker.flighttracker.DataObjects.*;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FlightDataGenerator {


    public static List<FlightData> generateRandomFlightDataList() {
        List<FlightData> flightDataList = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            FlightData flightData = new FlightData();
            flightData.setFlight_date(generateRandomDate());
            flightData.setFlight_status(generateRandomFlightStatus());
            flightData.setNumber("FL" + (i + 1));
            flightData.setAirline(generateRandomAirline());
            flightData.setDeparture(generateRandomDeparture());
            flightData.setArrival(generateRandomArrival());
            flightData.setAirportData(generateRandomAirport());
            flightData.setLiveData(generateRandomLiveData());
            flightData.setAircraftData(generateRandomAircraft());

            flightDataList.add(flightData);
        }

        return flightDataList;
    }

    private static String generateRandomDate() {
        return "2023-12-13";
    }

    private static String generateRandomFlightStatus() {
        String[] statuses = {"On Time", "Delayed", "Cancelled"};
        Random random = new Random();
        int index = random.nextInt(statuses.length);
        return statuses[index];
    }

    private static AirlineData generateRandomAirline() {
        AirlineData airlineData = new AirlineData();
        airlineData.setName("Airline" + new Random().nextInt(100));
        airlineData.setIata("IATA" + new Random().nextInt(100));
        airlineData.setIcao("ICAO" + new Random().nextInt(100));
        return airlineData;
    }

    private static DepartureData generateRandomDeparture() {
        DepartureData departureData = new DepartureData();
        departureData.setAirport("DepartureAirport" + new Random().nextInt(100));
        departureData.setScheduled(OffsetDateTime.now());
        departureData.setActual(OffsetDateTime.now());
        departureData.setEstimated(OffsetDateTime.now());
        return departureData;
    }

    private static ArrivalData generateRandomArrival() {
        ArrivalData arrivalData = new ArrivalData();
        arrivalData.setAirport("ArrivalAirport" + new Random().nextInt(100));
        arrivalData.setScheduled(OffsetDateTime.now());
        arrivalData.setActual(OffsetDateTime.now());
        arrivalData.setEstimated(OffsetDateTime.now());
        arrivalData.setEstimatedRunway(OffsetDateTime.now());
        arrivalData.setActualRunway(OffsetDateTime.now());
        return arrivalData;
    }

    private static AirportData generateRandomAirport() {
        AirportData airportData = new AirportData();
        airportData.setAirportName("Airport" + new Random().nextInt(100));
        airportData.setIata("IATA" + new Random().nextInt(100));
        airportData.setIcao("ICAO" + new Random().nextInt(100));
        airportData.setTimezone("Timezone" + new Random().nextInt(100));
        return airportData;
    }

    private static LiveData generateRandomLiveData() {
        LiveData liveData = new LiveData();
        liveData.setLatitude(new Random().nextInt(90));
        liveData.setLongitude(new Random().nextInt(180));
        liveData.setAltitude(new Random().nextInt());
        liveData.setDirection(new Random().nextInt(360));
        return liveData;
    }

    private static AircraftData generateRandomAircraft() {
        AircraftData aircraftData = new AircraftData();
        aircraftData.setRegistration("Registration" + new Random().nextInt(100));
        aircraftData.setIata("IATA" + new Random().nextInt(100));
        aircraftData.setIcao("ICAO" + new Random().nextInt(100));
        return aircraftData;
    }
}
