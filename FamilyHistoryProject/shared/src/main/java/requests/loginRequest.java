package requests;

/**
 * Created by Admin on 2/14/17.
 *
 * "userName": "susan", // Non-empty string
 "password": "mysecret" // Non-empty string
 */


public class loginRequest {

    String userName;//": "susan", // Non-empty string
    String password;//": "mysecret" // Non-empty string
    String message;

    public loginRequest(String userName, String password) {

        this.userName = userName;
        this.password = password;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }





}


