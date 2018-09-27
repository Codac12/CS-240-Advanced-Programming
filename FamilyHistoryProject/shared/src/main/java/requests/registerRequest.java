package requests;

/**
 * Created by Admin on 2/14/17.
 * "userName": "susan", // Non-empty string
 "password": "mysecret", // Non-empty string
 "email": "susan@gmail.com", // Non-empty string
 "firstName": "Susan", // Non-empty string
 "lastName": "Ellis", // Non-empty string
 "gender": "f" // “f” or “m”
 */

public class registerRequest {
        String userName;
        String password;
        String email;
        String firstName;
        String lastName;
        String gender;

    public registerRequest(String userName, String password, String email, String firstName, String lastName, String gender) {
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
    }


    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getGender() {
        return gender;
    }

}
