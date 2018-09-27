package model;

import java.util.ArrayList;
import java.util.UUID;

/**
 * Created by Admin on 2/13/17.
 */

public class event {

    String eventID;//: Unique identifier for this event
    String personID;//: Person to which this event belongs
    String descendant;
    double latitude;//: Latitude of event’s location
    double longitude;//: Longitude of event’s location
    String country;//: Country in which event occurred
    String city;//: City in which event occurred
    String eventType;//: Type of event (birth, baptism, christening, marriage, death, etc.)
    String year;//: Year in which event occurred


    public event(String personID, String descendant, double latitude, double longitude, String country, String city, String eventType, String year) {
        eventID = UUID.randomUUID().toString();
        this.personID = personID;
        this.descendant = descendant;
        this.latitude = latitude;
        this.longitude = longitude;
        this.country = country;
        this.city = city;
        this.eventType = eventType;
        this.year = year;
    }

    public event(String eventID, String personID, String descendant, double latitude, double longitude, String country, String city, String eventType, String year) {
        this.eventID = eventID;
        this.personID = personID;
        this.descendant = descendant;
        this.latitude = latitude;
        this.longitude = longitude;
        this.country = country;
        this.city = city;
        this.eventType = eventType;
        this.year = year;
    }

    public event(String descendant, double latitude, double longitude, String country, String city, String eventType, String year)
    {
        this.descendant = descendant;
        this.latitude = latitude;
        this.longitude = longitude;
        this.country = country;
        this.city = city;
        this.eventType = eventType;
        this.year = year;
    }

    public event(double latitude, double longitude, String country, String city, String eventType, String year)
    {
        this.latitude = latitude;
        this.longitude = longitude;
        this.country = country;
        this.city = city;
        this.eventType = eventType;
        this.year = year;
    }

    public String toString(){
        return eventType + ": " + city + ", " +  country + " (" + year + ")";
    }

    public void setPersonID(String personID) {
        this.personID = personID;
    }

    public String getEventID() {
        return eventID;
    }

    public void setEventID(String eventID) {
        this.eventID = eventID;
    }

    public String getPerson() {
        return personID;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() { return longitude; }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public String getEventType() {
        return eventType;
    }

    public String getYear() {
        return year;
    }

    public String getPersonID() {
        return personID;
    }

    public String getdescendant() {
        return descendant;
    }

    public void setdescendant(String descendant) {
        this.descendant = descendant;
    }
}
