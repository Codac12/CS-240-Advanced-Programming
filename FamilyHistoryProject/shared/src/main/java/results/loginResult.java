package results;

/**
 * Created by Admin on 2/14/17.
 *
 *     String authToken;//": "cf7a368f", // Non-empty auth token string
 String userName;//": "susan", // User name passed in with request
 String personId;//": "39f9fe46"
 String message;//”: “Description of the error”
 */

public class loginResult {

    private String authToken;//": "cf7a368f", // Non-empty auth token string
    private String userName;//": "susan", // User name passed in with request
    private String personId;//": "39f9fe46"
    private String message;


    public loginResult(String authToken, String userName, String personId) {
        this.authToken = authToken;
        this.userName = userName;
        this.personId = personId;
    }

    public loginResult() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
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
