package dataAccessTest;

import org.junit.* ;

import java.sql.SQLException;
import java.util.UUID;

import dataAccessObject.authTokenDAO;
import dataAccessObject.clearDAO;
import dataAccessObject.database;
import dataAccessObject.databaseException;
import dataAccessObject.eventDAO;
import dataAccessObject.personDAO;
import dataAccessObject.userDAO;
import model.authToken;
import model.event;
import model.person;
import model.user;

import static org.junit.Assert.* ;



/**
 * Created by Admin on 3/10/17.
 */

public class databaseTest {

    private database db;
    private user usr = new user("codac", "1234", "codac@live.com", "Cody", "Kesler", "Male", "History");
    private person prsn = new person(usr.getPersonID(), usr.getFirstName(),usr.getLastName(), usr.getGender(), usr.getUserName());
    event evnt = new event(usr.getPersonID(), usr.getUserName(), 45.0, 65.3, "USA","Provo","Marriage","1994");


        @Before
    public void setUp() throws databaseException {
        db = new database();
        db.openConnection();
        db.createTables();
        user usr = null;
    }

    @After
    public void tearDown() throws databaseException {
        db.createTables();
        db.closeConnection(false);
        db = null;
    }

    @Test
    public void testDatabaseAccess() throws databaseException {

        assertTrue(testUserDAO());
        assertTrue(testPersonDAO());
        assertTrue(testEventDAO());
        assertTrue(testAuthTokenDAO());
        assertTrue(clear());
    }

    public boolean clear()
    {
        clearDAO clrDAO = new clearDAO(db);
        try {
            return clrDAO.clear();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }


    public boolean testUserDAO()
    {
        System.out.println("testing inserting user....");
        usr.setPersonID(UUID.randomUUID().toString());
        userDAO usrDao = new userDAO(db);
        try {
            usrDao.add(usr);

            System.out.println("testing user login....");
            usr = usrDao.loginQuery(usr.getUserName(), usr.getPassword());
            if(usr != null) {
                System.out.println("Passed inserting and finding user!");
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return false;
    }

    public boolean testPersonDAO()
    {
        System.out.println("testing inserting person....");
        personDAO prsnDAO = new personDAO(db);
        prsn.setPersonID(usr.getPersonID());
        try {
            prsnDAO.add(prsn);

            System.out.println("testing finding person....");
            prsn = prsnDAO.query(prsn.getPersonID());
            if(prsn != null) {
                System.out.println("Passed inserting and finding person!");
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return false;
    }

    public boolean testEventDAO()
    {
        System.out.println("testing inserting event....");
        evnt.setEventID(UUID.randomUUID().toString());
        evnt.setPersonID(usr.getPersonID());
        evnt.setdescendant(usr.getUserName());
        eventDAO evntDAO = new eventDAO(db);
        try {
            evnt = evntDAO.add(evnt);
            if (evnt != null) {
                System.out.println("testing inserting event passed!");
                System.out.println("testing finding event....");
                evnt = evntDAO.query(evnt.getEventID());
                if (evnt != null) {
                    System.out.println("testing finding event passed!");
                    return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean testAuthTokenDAO()
    {
        System.out.println("testing inserting authtoken....");
        authToken token = new authToken();
        authTokenDAO tokenDAO = new authTokenDAO(db);
        try {
            token = tokenDAO.add(usr,token);
            if(token != null)
            {
                System.out.println("testing inserting authToken passed!");
                System.out.println("testing finding event....");
                tokenDAO.queryToken(usr.getUserName());
                System.out.println("testing finding event passed!");
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
