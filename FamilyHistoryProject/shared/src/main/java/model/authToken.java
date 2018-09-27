package model;

import java.util.UUID;

/**
 * Created by Admin on 2/13/17.
 */

public class authToken {

    String token;
    double time_created;

    public authToken()
    {
        token = UUID.randomUUID().toString();
        time_created = System.currentTimeMillis();
    }

    public double getTime_created() {
        return time_created;
    }

    public String getToken() {
        return token ;
    }
}
