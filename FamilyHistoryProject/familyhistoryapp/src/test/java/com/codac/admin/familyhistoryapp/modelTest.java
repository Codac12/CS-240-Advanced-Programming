package com.codac.admin.familyhistoryapp;

import com.codac.admin.familyhistoryapp.aModel.aModel;
import com.google.gson.Gson;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

import model.event;
import model.person;
import results.eventResult;
import results.loginResult;
import results.personsResult;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class modelTest {

    Util util = new Util();
    personsResult prsnsResult = new personsResult();
    eventResult evntResult = new eventResult();
    personsResult prsnResult = new personsResult();
    loginResult logResult = new loginResult();
    aModel m;

    @Before
    public void setup()
    {
        Gson json = new Gson();
        //Initialize people and events
        String jsonLog = "{\n" +
                "\t\"authToken\":\"52f1a97d-a357-46e1-8bd5-7afbab26413d\",\n" +
                "\t\"userName\":\"codac\",\n" +
                "\t\"personId\":\"06a2c957-96c5-44f5-8a3e-db1c5c217701\"\n" +
                "}";
        String jsonPrsn=
                "     {\n" +
                "       \"persons\": [\n" +
                        "    {\n" +
                        "      \"firstName\": \"cod_kesler\",\n" +
                        "      \"lastName\": \"Kesler\",\n" +
                        "      \"gender\": \"male\",\n" +
                        "      \"personID\": \"cod_kesler\",\n" +
                        "      \"descendant\": \"cod_kesler\",\n" +
                        "      \"father\": \"matt_kesler\",\n" +
                        "      \"mother\": \"tauna_baliey\"\n" +
                        "    }\n" +
                        "    ]\n" +
                        "    }\n";

        String jsonPrsns =
                "    {\n" +
                "    \"persons\": [" +
                "    {\n" +
                "      \"firstName\": \"cod_kesler\",\n" +
                "      \"lastName\": \"Kesler\",\n" +
                "      \"gender\": \"male\",\n" +
                "      \"personID\": \"cod_kesler\",\n" +
                "      \"descendant\": \"cod_kesler\",\n" +
                "      \"father\": \"matt_kesler\",\n" +
                "      \"mother\": \"tauna_bailey\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"firstName\": \"Matt\",\n" +
                "      \"lastName\": \"Kesler\",\n" +
                "      \"gender\": \"male\",\n" +
                "      \"personID\": \"matt_kesler\",\n" +
                "      \"descendant\": \"cod_kesler\",\n" +
                "      \"father\": \"orson_kesler\",\n" +
                "      \"mother\": \"claudia_lastname\",\n" +
                "      \"spouse\": \"tauna_bailey\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"firstName\": \"Tauna\",\n" +
                "      \"lastName\": \"Bailey\",\n" +
                "      \"gender\": \"female\",\n" +
                "      \"personID\": \"tauna_bailey\",\n" +
                "      \"descendant\": \"cod_kesler\",\n" +
                "      \"father\": \"tom_baliey\",\n" +
                "      \"mother\": \"lejoice_lastnametwo\",\n" +
                "      \"spouse\": \"matt_kesler\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"firstName\": \"Orson\",\n" +
                "      \"lastName\": \"kesler\",\n" +
                "      \"gender\": \"male\",\n" +
                "      \"personID\": \"orson_kesler\",\n" +
                "      \"descendant\": \"cod_kesler\",\n" +
                "      \"spouse\": \"claudia_lastname\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"firstName\": \"Claudia\",\n" +
                "      \"lastName\": \"Lastname\",\n" +
                "      \"gender\": \"female\",\n" +
                "      \"personID\": \"claudia_lastname\",\n" +
                "      \"descendant\": \"cod_kesler\",\n" +
                "      \"spouse\": \"orson_kesler\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"firstName\": \"Tom\",\n" +
                "      \"lastName\": \"Bailey\",\n" +
                "      \"gender\": \"male\",\n" +
                "      \"personID\": \"tom_baliey\",\n" +
                "      \"descendant\": \"cod_kesler\",\n" +
                "      \"spouse\": \"lejoice_lastnametwo\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"firstName\": \"Lejoice\",\n" +
                "      \"lastName\": \"Lastnametwo\",\n" +
                "      \"gender\": \"female\",\n" +
                "      \"personID\": \"lejoice_lastnametwo\",\n" +
                "      \"descendant\": \"cod_kesler\",\n" +
                "      \"spouse\": \"tom_baliey\"\n" +
                "    }\n" +
                "  ]\n" +
                "  }";

        String jsonE = "{\n" +
                "\"events\": [" +
                "    {\n" +
                "      \"eventType\": \"Birth\",\n" +
                "      \"personID\": \"cod_kesler\",\n" +
                "      \"city\": \"Orem\",\n" +
                "      \"country\": \"United States\",\n" +
                "      \"latitude\": 40.296898,\n" +
                "      \"longitude\": -111.694649,\n" +
                "      \"year\": 1994,\n" +
                "      \"descendant\":\"cod_kesler\",\n" +
                "      \"eventID\": \"event1\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"eventType\": \"Served a Mission\",\n" +
                "      \"personID\": \"cod_kesler\",\n" +
                "      \"city\": \"Cape Town\",\n" +
                "      \"country\": \"South Africa\",\n" +
                "      \"latitude\": 30.5595,\n" +
                "      \"longitude\": 22.9375,\n" +
                "      \"year\": 2013,\n" +
                "      \"descendant\":\"cod_kesler\",\n" +
                "      \"eventID\": \"event2\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"eventType\": \"Baptism\",\n" +
                "      \"personID\": \"cod_kesler\",\n" +
                "      \"city\": \"Berlin\",\n" +
                "      \"country\": \"Germany\",\n" +
                "      \"latitude\": 52.520008,\n" +
                "      \"longitude\": 13.404954,\n" +
                "      \"year\": 1969,\n" +
                "      \"descendant\":\"cod_kesler\",\n" +
                "      \"eventID\": \"event3\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"eventType\": \"Marriage\",\n" +
                "      \"personID\": \"cod_kesler\",\n" +
                "      \"city\": \"Bremen\",\n" +
                "      \"country\": \"Germany\",\n" +
                "      \"latitude\": 53.0833,\n" +
                "      \"longitude\": 8.8000,\n" +
                "      \"year\": 1993,\n" +
                "      \"descendant\":\"cod_kesler\",\n" +
                "      \"eventID\": \"event4\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"eventType\": \"Birth\",\n" +
                "      \"personID\": \"matt_kesler\",\n" +
                "      \"city\": \"Düsseldorf\",\n" +
                "      \"country\": \"Germany\",\n" +
                "      \"latitude\": 51.2333,\n" +
                "      \"longitude\": 6.7833,\n" +
                "      \"year\": 1959,\n" +
                "      \"descendant\":\"cod_kesler\",\n" +
                "      \"eventID\": \"event5\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"eventType\": \"Moved to America\",\n" +
                "      \"personID\": \"matt_kesler\",\n" +
                "      \"city\": \"New York City\",\n" +
                "      \"country\": \"United States\",\n" +
                "      \"latitude\": 40.6667,\n" +
                "      \"longitude\": -72.0667,\n" +
                "      \"year\": 1994,\n" +
                "      \"descendant\":\"cod_kesler\",\n" +
                "      \"eventID\": \"event6\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"eventType\": \"Death\",\n" +
                "      \"personID\": \"matt_kesler\",\n" +
                "      \"city\": \"Flensburg\",\n" +
                "      \"country\": \"Germany\",\n" +
                "      \"latitude\": 54.7833,\n" +
                "      \"longitude\": 9.4333,\n" +
                "      \"year\": 2015,\n" +
                "      \"descendant\":\"cod_kesler\",\n" +
                "      \"eventID\": \"event7\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"eventType\": \"Baptism\",\n" +
                "      \"personID\": \"matt_kesler\",\n" +
                "      \"city\": \"Provo\",\n" +
                "      \"country\": \"United States\",\n" +
                "      \"latitude\": 40.2338,\n" +
                "      \"longitude\": -111.6585,\n" +
                "      \"year\": 2016,\n" +
                "      \"descendant\":\"cod_kesler\",\n" +
                "      \"eventID\": \"event8\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"eventType\": \"Visited America\",\n" +
                "      \"personID\": \"tauna_bailey\",\n" +
                "      \"city\": \"Woodland Hills\",\n" +
                "      \"country\": \"United States\",\n" +
                "      \"latitude\": 40.0179,\n" +
                "      \"longitude\": -111.6482,\n" +
                "      \"year\": 2001,\n" +
                "      \"descendant\":\"cod_kesler\",\n" +
                "      \"eventID\": \"event9\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"eventType\": \"Birth\",\n" +
                "      \"personID\": \"tauna_bailey\",\n" +
                "      \"city\": \"Gdynia\",\n" +
                "      \"country\": \"Poland\",\n" +
                "      \"latitude\": 54.5000,\n" +
                "      \"longitude\": 18.5500,\n" +
                "      \"year\": 1932,\n" +
                "      \"descendant\":\"cod_kesler\",\n" +
                "      \"eventID\": \"event10\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"eventType\": \"Called as General Authority\",\n" +
                "      \"personID\": \"tauna_bailey\",\n" +
                "      \"city\": \"Salt Lake City\",\n" +
                "      \"country\": \"United States\",\n" +
                "      \"latitude\": 40.7500,\n" +
                "      \"longitude\": -110.1167,\n" +
                "      \"year\": 1992,\n" +
                "      \"descendant\":\"cod_kesler\",\n" +
                "      \"eventID\": \"event11\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"eventType\": \"Birth\",\n" +
                "      \"personID\": \"tauna_bailey\",\n" +
                "      \"city\": \"Jerusalem\",\n" +
                "      \"country\": \"Israel\",\n" +
                "      \"latitude\": 31.7833,\n" +
                "      \"longitude\": 35.2167,\n" +
                "      \"year\": 1940,\n" +
                "      \"descendant\":\"cod_kesler\",\n" +
                "      \"eventID\": \"event12\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"eventType\": \"Death\",\n" +
                "      \"personID\": \"orson_kesler\",\n" +
                "      \"city\": \"Bluffdale\",\n" +
                "      \"country\": \"United States\",\n" +
                "      \"latitude\": 40.4897,\n" +
                "      \"longitude\": -111.939619,\n" +
                "      \"year\": 2004,\n" +
                "      \"descendant\":\"cod_kesler\",\n" +
                "      \"eventID\": \"event13\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"eventType\": \"Served a Mission\",\n" +
                "      \"personID\": \"orson_kesler\",\n" +
                "      \"city\": \"Linz\",\n" +
                "      \"country\": \"Austria\",\n" +
                "      \"latitude\": 48.3000,\n" +
                "      \"longitude\": 14.2833,\n" +
                "      \"year\": 1994,\n" +
                "      \"descendant\":\"cod_kesler\",\n" +
                "      \"eventID\": \"event14\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"eventType\": \"Baptism\",\n" +
                "      \"personID\": \"orson_kesler\",\n" +
                "      \"city\": \"Eureka\",\n" +
                "      \"country\": \"Canada\",\n" +
                "      \"latitude\": 79.9833,\n" +
                "      \"longitude\": -84.0667,\n" +
                "      \"year\": 2002,\n" +
                "      \"descendant\":\"cod_kesler\",\n" +
                "      \"eventID\": \"event15\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"eventType\": \"Marriage\",\n" +
                "      \"personID\": \"orson_kesler\",\n" +
                "      \"city\": \"Los Angeles\",\n" +
                "      \"country\": \"United States\",\n" +
                "      \"latitude\": 34.0500,\n" +
                "      \"longitude\": -117.7500,\n" +
                "      \"year\": 2013,\n" +
                "      \"descendant\":\"cod_kesler\",\n" +
                "      \"eventID\": \"event16\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"eventType\": \"Birth\",\n" +
                "      \"personID\": \"claudia_lastname\",\n" +
                "      \"city\": \"Longyearbyen\",\n" +
                "      \"country\": \"Norway\",\n" +
                "      \"latitude\": 78.2167,\n" +
                "      \"longitude\": 15.6500,\n" +
                "      \"year\": 1969,\n" +
                "      \"descendant\":\"cod_kesler\",\n" +
                "      \"eventID\": \"event17\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"eventType\": \"Served a Mission\",\n" +
                "      \"personID\": \"claudia_lastname\",\n" +
                "      \"city\": \"Qaanaaq\",\n" +
                "      \"country\": \"Denmark\",\n" +
                "      \"latitude\": 77.4667,\n" +
                "      \"longitude\": -68.7667,\n" +
                "      \"year\": 1990,\n" +
                "      \"descendant\":\"cod_kesler\",\n" +
                "      \"eventID\": \"event18\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"eventType\": \"Went to India\",\n" +
                "      \"personID\": \"claudia_lastname\",\n" +
                "      \"city\": \"Srinagar\",\n" +
                "      \"country\": \"India\",\n" +
                "      \"latitude\": 34.0833,\n" +
                "      \"longitude\": 74.7833,\n" +
                "      \"year\": 1980,\n" +
                "      \"descendant\":\"cod_kesler\",\n" +
                "      \"eventID\": \"event19\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"eventType\": \"Baptism\",\n" +
                "      \"personID\": \"claudia_lastname\",\n" +
                "      \"city\": \"Tokushima\",\n" +
                "      \"country\": \"Japan\",\n" +
                "      \"latitude\": 34.0667,\n" +
                "      \"longitude\": 134.5500,\n" +
                "      \"year\": 1987,\n" +
                "      \"descendant\":\"cod_kesler\",\n" +
                "      \"eventID\": \"event20\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"eventType\": \"Birth\",\n" +
                "      \"personID\": \"tom_baliey\",\n" +
                "      \"city\": \"Rabat\",\n" +
                "      \"country\": \"Morocco\",\n" +
                "      \"latitude\": 34.0333,\n" +
                "      \"longitude\": -5.1667,\n" +
                "      \"longitude\": 9.4333,\n" +
                "      \"year\": 1930,\n" +
                "      \"descendant\":\"cod_kesler\",\n" +
                "      \"eventID\": \"event21\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"eventType\": \"Visited America\",\n" +
                "      \"personID\": \"tom_baliey\",\n" +
                "      \"city\": \"Columbia\",\n" +
                "      \"country\": \"United States\",\n" +
                "      \"latitude\": 34.0000,\n" +
                "      \"longitude\": -80.9500,\n" +
                "      \"year\": 2002,\n" +
                "      \"descendant\":\"cod_kesler\",\n" +
                "      \"eventID\": \"event22\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"eventType\": \"Marriage\",\n" +
                "      \"personID\": \"tom_baliey\",\n" +
                "      \"city\": \"Riverside\",\n" +
                "      \"country\": \"United States\",\n" +
                "      \"latitude\": 33.9500,\n" +
                "      \"longitude\": -116.6000,\n" +
                "      \"year\": 1975,\n" +
                "      \"descendant\":\"cod_kesler\",\n" +
                "      \"eventID\": \"event23\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"eventType\": \"Had First Child\",\n" +
                "      \"personID\": \"tom_baliey\",\n" +
                "      \"city\": \"Casablanca\",\n" +
                "      \"country\": \"Morocco\",\n" +
                "      \"latitude\": 33.5333,\n" +
                "      \"longitude\": -6.4167,\n" +
                "      \"year\": 1952,\n" +
                "      \"descendant\":\"cod_kesler\",\n" +
                "      \"eventID\": \"event24\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"eventType\": \"Served a Mission\",\n" +
                "      \"personID\": \"lejoice_lastnametwo\",\n" +
                "      \"city\": \"Kumamoto\",\n" +
                "      \"country\": \"Japan\",\n" +
                "      \"latitude\": 32.7833,\n" +
                "      \"longitude\": 130.7333,\n" +
                "      \"year\": 1989,\n" +
                "      \"descendant\":\"cod_kesler\",\n" +
                "      \"eventID\": \"event25\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"eventType\": \"Served a Mission\",\n" +
                "      \"personID\": \"lejoice_lastnametwo\",\n" +
                "      \"city\": \"Funchal\",\n" +
                "      \"country\": \"Portugal\",\n" +
                "      \"latitude\": 32.6500,\n" +
                "      \"longitude\": -15.0833,\n" +
                "      \"year\": 1983,\n" +
                "      \"descendant\":\"cod_kesler\",\n" +
                "      \"eventID\": \"event26\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"eventType\": \"Birth\",\n" +
                "      \"personID\": \"lejoice_lastnametwo\",\n" +
                "      \"city\": \"Tijuana\",\n" +
                "      \"country\": \"Mexico\",\n" +
                "      \"latitude\": 32.5333,\n" +
                "      \"longitude\": -116.9667,\n" +
                "      \"year\": 1940,\n" +
                "      \"descendant\":\"cod_kesler\",\n" +
                "      \"eventID\": \"event27\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"eventType\": \"Baptism\",\n" +
                "      \"personID\": \"lejoice_lastnametwo\",\n" +
                "      \"city\": \"Hermosillo\",\n" +
                "      \"country\": \"Mexico\",\n" +
                "      \"latitude\": 29.1000,\n" +
                "      \"longitude\": -109.0500,\n" +
                "      \"year\": 1948,\n" +
                "      \"descendant\":\"cod_kesler\",\n" +
                "      \"eventID\": \"event28\"\n" +
                "    }   \n" +
                "  ]\n" +
                " }";
        // Initialize
        logResult = json.fromJson(jsonLog, loginResult.class);
        prsnResult = json.fromJson(jsonPrsn, personsResult.class);
        prsnsResult = json.fromJson(jsonPrsns, personsResult.class);
        evntResult = json.fromJson(jsonE, eventResult.class);
    }

    @Test
    public void test() throws Exception {
        util.setModelData("localhost", "8080", prsnResult, prsnsResult, evntResult, logResult, null);
        m = aModel.getInstance();
        assertTrue(testMaternalAncestors());
        assertTrue(testPaternalAncestors());
        assertTrue(testPersonEventsMap());
        assertTrue(testPersonMap());
        assertTrue(testEventMap());

    }

    private boolean testEventMap() {
        if(m.getEvents().get("event1").getEventID().equals("event1"))
        {
            if(m.getEvents().get("event2").getEventID().equals("event2"))
            {
                if(m.getEvents().get("event10").getEventID().equals("event10"))
                {
                    if(m.getEvents().get("event20").getEventID().equals("event20"))
                    {
                        if(m.getEvents().get("event23").getEventID().equals("event23"))
                        {
                            //has correct events mapped out
                            return true;
                        }
                    }

                }
            }
        }
        return false;
    }

    private boolean testPersonEventsMap() {
        ArrayList<event> events = m.getPersonEvents().get("cod_kesler");

        for(event evnt : events)
        {
            if(!evnt.getPersonID().equals("cod_kesler"))
                return false;
        }

        events = m.getPersonEvents().get("tauna_bailey");
        for(event evnt : events)
        {
            if(!evnt.getPersonID().equals("tauna_bailey"))
                return false;
        }

        events = m.getPersonEvents().get("claudia_lastname");
        for(event evnt : events)
        {
            if(!evnt.getPersonID().equals("claudia_lastname"))
                return false;
        }

        //contains all correct events for person mapped out
        return true;
    }

    private boolean testPersonMap() {
        if(m.getPeople().get("cod_kesler").getPersonID().equals("cod_kesler"))
        {
            if(m.getPeople().get("matt_kesler").getPersonID().equals("matt_kesler"))
            {
                if(m.getPeople().get("orson_kesler").getPersonID().equals("orson_kesler"))
                {
                    //has person map mapped correctly
                    return true;
                }
            }
        }
        return false;
    }

    private boolean testMaternalAncestors() {
        if(m.getMaternalAncestors().containsKey("tauna_bailey"))
        {
            if(m.getMaternalAncestors().containsKey("tom_baliey"))
            {
                if(m.getMaternalAncestors().containsKey("lejoice_lastnametwo")) {
                    //has mothers side mapped out correctly
                    return true;
                }
            }
        }
        return false;
    }

    private boolean testPaternalAncestors() {
        if(m.getPaternalAncestors().containsKey("matt_kesler"))
        {
            if(m.getPaternalAncestors().containsKey("orson_kesler"))
            {
                if(m.getPaternalAncestors().containsKey("claudia_lastname")) {
                    //has fathers side mapped correctly
                    return true;
                }
            }
        }
        return false;
    }
}