package model;

/**
 * Created by Admin on 2/13/17.
 */

public class user {

    String userName;
    String password;
    String email;
    String firstName;
    String lastName;
    String gender;
    String personID;
    String historyInfo;


    public user(String userName,
                String password,
                String email,
                String firstName,
                String lastName,
                String gender,
                String historyInfo) {
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.personID = personID;
        this.historyInfo = historyInfo;

        //call fill.createDefaultTree
    }

    public user(String userName,
                String password,
                String email,
                String firstName,
                String lastName,
                String gender,
                String historyInfo,
                String personID) {
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.personID = personID;
        this.historyInfo = historyInfo;

        //call fill.createDefaultTree
    }


    public void setPersonID(String personID) {
        this.personID = personID;
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
    
    public String getHistoryInfo() {
        return historyInfo;
    }


    public String getPersonID() {
        return personID;
    }
}
