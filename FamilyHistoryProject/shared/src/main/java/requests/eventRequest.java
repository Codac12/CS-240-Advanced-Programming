package requests;

/**
 * Created by Admin on 2/14/17.
 *
 *     String authToken authenication token passed in header
        String eventID eventID of the event to return

 */

public class eventRequest {

    String authToken;
    String eventID;

    public eventRequest(String eventID, String authToken) {
        this.authToken = authToken;
        this.eventID = eventID;
    }

    public String getAuthToken() {
        return authToken;
    }

    public String getEventID() {
        return eventID;
    }
}
