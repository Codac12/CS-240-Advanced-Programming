package proxyTest;

import com.google.gson.Gson;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.UUID;

import dataAccessObject.database;
import dataAccessObject.databaseException;
import model.person;
import model.user;
import requests.clearRequest;
import requests.eventRequest;
import requests.fillRequest;
import requests.loadRequest;
import requests.loginRequest;
import requests.personRequest;
import requests.registerRequest;
import results.clearResult;
import results.fillResult;
import results.loadResult;
import results.loginResult;
import results.registerResult;
import serverProxy.proxy;
import json.json;

import static org.junit.Assert.assertTrue;

/**
 * Created by Admin on 3/10/17.
 */

public class proxyTest {

    proxy prxy = new proxy("localhost", "8080");
    registerResult regResult;
    loginResult logResult;

    @Before
    public void setUp() throws databaseException {

    }

    @After
    public void tearDown() throws databaseException {

    }

    @Test
    public void testDatabaseAccess() throws databaseException {

        assertTrue(testRegisterProxy());
        assertTrue(testLoginProxy());
        assertTrue(testPersonProxy());
        assertTrue(testEventProxy());
        assertTrue(testFillProxy());
        assertTrue(testClearProxy());
        assertTrue(testLoadProxy());

    }

    private boolean testFillProxy() {
        System.out.println("Testing fill proxy with 3 generations....");
        fillRequest request = new fillRequest(logResult.getUserName(), 5);
        fillResult result = prxy.fill(request);
        if (result != null) {
            System.out.println("Testing fill proxy with 3 generations passed!");

            request = new fillRequest(logResult.getUserName(), 3);

            System.out.println("Testing fill proxy with 5 generations....");
            result = prxy.fill(request);
            if (result != null) {
                System.out.println("Testing fill proxy with 5 generations passed!");
                return true;
            }
        }
        return false;
    }

    private boolean testLoadProxy() {
        json jsn = new json();
        System.out.println("Testing load proxy....");
        loadRequest request = (loadRequest) jsn.decode("{\n" +
                "  \"users\": [\n" +
                "    {\n" +
                "      \"userName\": \"sheila\",\n" +
                "      \"password\": \"parker\",\n" +
                "      \"email\": \"sheila@parker.com\",\n" +
                "      \"firstName\": \"Sheila\",\n" +
                "      \"lastName\": \"Parker\",\n" +
                "      \"gender\": \"f\",\n" +
                "      \"personID\": \"Sheila_Parker\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"persons\": [\n" +
                "    {\n" +
                "      \"firstName\": \"Sheila\",\n" +
                "      \"lastName\": \"Parker\",\n" +
                "      \"gender\": \"f\",\n" +
                "      \"personID\": \"Sheila_Parker\",\n" +
                "      \"descendant\": \"sheila\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"events\": [\n" +
                "    {\n" +
                "      \"eventType\": \"started family map\",\n" +
                "      \"personID\": \"Sheila_Parker\",\n" +
                "      \"city\": \"Salt Lake City\",\n" +
                "      \"country\": \"United States\",\n" +
                "      \"latitude\": 40.7500,\n" +
                "      \"longitude\": -110.1167,\n" +
                "      \"year\": 2016,\n" +
                "      \"descendant\":\"sheila\",\n" +
                "      \"eventID\": \"e5244e18-8fc6-4996-a457-aaa60c7ef066\"\n" +
                "    }\n" +
                "  ]\n" +
                "}", loadRequest.class);

        loadResult result = prxy.load(request);
        if(result != null) {
            System.out.println("Load proxy success!!");
            return true;
        }
        return false;
    }

    private boolean testClearProxy() {
        System.out.println("Testing clear proxy....");
        clearRequest request = new clearRequest(logResult.getAuthToken());
        clearResult result = prxy.clear(request);
        if(result != null) {
            System.out.println("Testing clear proxy passed!");
            return true;
        }
        return false;
    }

    private boolean testEventProxy() {
        person prsn = new person(UUID.randomUUID().toString(), "Cody","Kesler", "m", "codac");
        System.out.println("Testing getting all events proxy with no personID.....");
        eventRequest request = new eventRequest("", logResult.getAuthToken());
        if(prxy.event(request) != null)
        {
            System.out.println("Getting all events Proxy passed!");
            System.out.println("Testing getting one event....");
            request = new eventRequest(logResult.getPersonId(), logResult.getAuthToken());
            if(prxy.event(request) != null)
            {
                System.out.println("Getting one person passed! ");

                return true;
            }
            return true;
        }
        return false;
    }


    private boolean testPersonProxy() {
        person prsn = new person(UUID.randomUUID().toString(), "Cody","Kesler", "m", "codac");
        System.out.println("Testing getting all persons proxy with no personID.....");
        personRequest request = new personRequest(logResult.getPersonId(), logResult.getAuthToken());
        if(prxy.person(request) != null)
        {
            System.out.println("Getting all persons Proxy passed!");
            System.out.println("Testing getting one person....");
            request = new personRequest(logResult.getPersonId(), logResult.getAuthToken());
            if(prxy.person(request) != null)
            {
                System.out.println("Getting one person passed! ");

                return true;
            }
            return true;
        }
        return false;
    }

    private boolean testLoginProxy() {
        System.out.println("Testing login proxy.....");
        loginRequest logRequest = new loginRequest("codac2", "codac1234");
        logResult = prxy.login(logRequest);
        if(logResult != null)
        {
            System.out.println("Login Proxy passed!");
            return true;
        }
        return false;
    }

    private boolean testRegisterProxy() {

        System.out.println("Testing request proxy.....");
        registerRequest request = new registerRequest("codac2", "codac1234", "codac@Live.com", "Cody", "Kesler", "m");
        regResult = prxy.register(request);
        if(regResult != null)
        {
            System.out.print(regResult.getUserName());
            System.out.print(regResult.getAuthToken());

            System.out.print(regResult.getPersonId());

            System.out.println("Request Proxy passed!");
            return true;
        }
        return false;
    }


}
