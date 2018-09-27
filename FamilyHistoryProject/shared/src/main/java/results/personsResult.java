package results;

import java.util.ArrayList;

import model.person;

/**
 * Created by Admin on 3/9/17.
 */

public class personsResult{

    private ArrayList<person> persons = new ArrayList<person>();
    private String message;

    public personsResult() {
    }

    public String getMessage() {
        return message;
    }

    public ArrayList<person> getPersons() {
        return persons;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setPersons(ArrayList<person> persons) {
        this.persons = persons;
    }

}



