package results;

/**
 * Created by Admin on 2/14/17.
 *
 *     String message error message
        int numUsers number of users added to database
         int numEvents; number of events added to database
         int numPersons;number of persons added to database
 */

public class loadResult {
    private int numUsers;
    private int numEvents;
    private int numPersons;
    private String message;

    public loadResult(int numUsers, int numEvents, int numPersons) {
        this.numUsers = numUsers;
        this.numEvents = numEvents;
        this.numPersons = numPersons;
        message = "Successfully added "+numUsers +" users, "+ numPersons +" persons, and "+ numEvents +" events to the database";
    }

    public int getNumUsers() {
        return numUsers;
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

    public int getNumPersons() {
        return numPersons;
    }
}
