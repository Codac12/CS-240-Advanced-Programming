package results;

/**
 * Created by Admin on 2/14/17.
 */

public class fillResult {
    private int numPersons;
    private int numEvents;
    private String message;

    public fillResult(int numPersons, int numEvents) {
        this.numPersons = 1+numPersons;
        this.numEvents = numEvents;
        this.message = "Successfully added "+ this.numPersons +" persons and "+this.numEvents+" events to the database";
    }

    public fillResult() {
    }

    public int getNumPersons() {
        return numPersons;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getNumEvents() {
        return numEvents;
    }
}
