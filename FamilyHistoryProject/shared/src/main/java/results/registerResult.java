package results;

/**
 * Created by Admin on 2/14/17.
 *
 *  String authToken;//": "cf7a368f", // Non-empty auth token string
    String userName;// ": "susan", // User name passed in with request
    String personId;//": "39f9fe46" // Non-empty string containing the Person ID of the
    String message;//”: “Description of the error”
 */

public class registerResult {

    private String authToken;//": "cf7a368f", // Non-empty auth token string
    private String userName;// ": "susan", // User name passed in with request
    private String personId;//": "39f9fe46" // Non-empty string containing the Person ID of the
    private String message;


    public registerResult() {
    }

    public registerResult(String authToken, String userName, String personId) {

        this.authToken = authToken;
        this.userName = userName;
        this.personId = personId;

    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public String getAuthToken() {
        return authToken;
    }

    public String getUserName() {
        return userName;
    }

    public String getPersonId() {
        return personId;
    }
}
