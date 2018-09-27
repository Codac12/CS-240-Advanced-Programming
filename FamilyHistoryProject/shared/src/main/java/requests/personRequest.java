package requests;

/**
 * Created by Admin on 2/14/17.
 *
 *     String personID id for the current person
        String authToken; authentication token passed in header
 */


public class personRequest {
    String personID;
    String authToken;

    public personRequest(String personID, String authToken) {
        this.personID = personID;
        this.authToken = authToken;
    }

    public String getAuthToken() {
        return authToken;
    }


    public String getPersonID() {
        return personID;
    }



}
