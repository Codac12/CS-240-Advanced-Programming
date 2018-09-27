package serverProxy;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import requests.clearRequest;
import requests.eventRequest;
import requests.fillRequest;
import requests.loadRequest;
import requests.loginRequest;
import requests.personRequest;
import requests.registerRequest;
import results.clearResult;
import results.eventResult;
import results.fillResult;
import results.loadResult;
import results.loginResult;
import results.personsResult;
import results.registerResult;
import json.json;

/**
 * Created by Admin on 2/16/17.
 *
 * Handles http request and converts to json objects to pass to handlers
 */

public class proxy {

    String serverHost;
    String serverPort;
    json jsn;
    HttpURLConnection http = null;


    public proxy(String serverHost, String serverPort) {
        this.serverHost = serverHost;
        this.serverPort = serverPort;
        jsn = new json();

    }

    private static String readString(InputStream is) throws IOException {
        StringBuilder sb = new StringBuilder();
        InputStreamReader sr = new InputStreamReader(is);
        char[] buf = new char[1024];
        int len;
        while ((len = sr.read(buf)) > 0) {
            sb.append(buf, 0, len);
        }
        return sb.toString();
    }

    private static void writeString(String str, OutputStream os) throws IOException {
        OutputStreamWriter sw = new OutputStreamWriter(os);
        sw.write(str);
        sw.flush();
    }


    /**
     * Handles a register request
     * @param r - register object to send to handlers
     * @return
     */
    public registerResult register(registerRequest r)
    {
        registerResult rgstrResult = null;
        try {
            URL url = new URL("http://" + serverHost + ":" + serverPort + "/user/register");

            http = (HttpURLConnection)url.openConnection();

            http.setRequestMethod("POST");
            http.setDoOutput(true);	// There is a request body

            http.addRequestProperty("Content-Type", "application/json");

            String reqData = jsn.encode(r);

            OutputStream reqBody = http.getOutputStream();
            writeString(reqData, reqBody);
            reqBody.close();

            if (http.getResponseCode() == HttpURLConnection.HTTP_OK)
            {
                InputStream respBody = http.getInputStream();
                String respData = readString(respBody);
                rgstrResult = (registerResult) jsn.decode(respData, registerResult.class);
            }
            else {
                System.out.println("ERROR: " + http.getResponseMessage());
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally {
            if(http != null)
                http.disconnect();

        }
       return rgstrResult;
    }

    /**
     *  Handles a loginRequest
     * @param r - login item
     * @return
     */
    public loginResult login(loginRequest r)
    {
        try {
            loginResult lginResult;
            URL url = new URL("http://" + serverHost + ":" + serverPort + "/user/login");

            http = (HttpURLConnection)url.openConnection();

            http.setRequestMethod("POST");
            http.setDoOutput(true);	// There is a request body

            http.addRequestProperty("Content-Type", "application/json");

            String reqData = jsn.encode(r);

            OutputStream reqBody = http.getOutputStream();
            writeString(reqData, reqBody);
            reqBody.close();

            if (http.getResponseCode() == HttpURLConnection.HTTP_OK)
            {
                InputStream respBody = http.getInputStream();
                String respData = readString(respBody);
                lginResult = (loginResult) jsn.decode(respData, loginResult.class);
                return lginResult;
            }
            else {
                System.out.println("ERROR: " + http.getResponseMessage());
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if(http != null)
                http.disconnect();
        }
        return null;
    }


    /**
     *  Handles an event
     * @param r - event item
     * @return
     */
    public eventResult event(eventRequest r)
    {
        try {
            eventResult evntResult = null;
            URL url = new URL("http://" + serverHost + ":" + serverPort + "/event");

            http = (HttpURLConnection)url.openConnection();

            http.setRequestMethod("POST");
            http.setDoOutput(true);	// There is a request body

            http.addRequestProperty("Authorization", r.getAuthToken());
            http.addRequestProperty("Content-Type", "application/json");

            String reqData = jsn.encode(r);

            OutputStream reqBody = http.getOutputStream();
            writeString(reqData, reqBody);
            reqBody.close();

            if (http.getResponseCode() == HttpURLConnection.HTTP_OK)
            {
                InputStream respBody = http.getInputStream();
                String respData = readString(respBody);
                evntResult = (eventResult) jsn.decode(respData, eventResult.class);
                return evntResult;
            }
            else {
                System.out.println("ERROR: " + http.getResponseMessage());
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if(http != null)
            http.disconnect();
        }
        return null;
    }

    /**
     *  Handles an person request
     * @param r - person request item
     * @return
     */
    public personsResult person(personRequest r)
    {
        personsResult prsnsResult = null;
        try {
            URL url = new URL("http://" + serverHost + ":" + serverPort + "/person");

            http = (HttpURLConnection)url.openConnection();

            http.setRequestMethod("POST");
            http.setDoOutput(true);	// There is a request body

            http.addRequestProperty("Authorization", r.getAuthToken());
            http.addRequestProperty("Content-Type", "application/json");


            String reqData = jsn.encode(r);

            OutputStream reqBody = http.getOutputStream();
            writeString(reqData, reqBody);
            reqBody.close();

            if (http.getResponseCode() == HttpURLConnection.HTTP_OK)
            {
                InputStream respBody = http.getInputStream();
                String respData = readString(respBody);
                prsnsResult = (personsResult) jsn.decode(respData, personsResult.class);
                return prsnsResult;
            }
            else {
                System.out.println("ERROR: " + http.getResponseMessage());
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if(http != null)
                http.disconnect();
        }
        return null;
    }

    /**
     * Handles an load database request
     * @param r - load request item
     * @return
     */
    public loadResult load(loadRequest r)
    {
        loadResult ldResult = null;
        try {
            URL url = new URL("http://" + serverHost + ":" + serverPort + "/load");

            http = (HttpURLConnection)url.openConnection();

            http.setRequestMethod("POST");
            http.setDoOutput(true);	// There is a request body

            http.addRequestProperty("Content-Type", "application/json");

            String reqData = jsn.encode(r);

            OutputStream reqBody = http.getOutputStream();
            writeString(reqData, reqBody);
            reqBody.close();

            if (http.getResponseCode() == HttpURLConnection.HTTP_OK)
            {
                InputStream respBody = http.getInputStream();
                String respData = readString(respBody);
                ldResult = (loadResult) jsn.decode(respData, loadResult.class);
                return ldResult;
            }
            else {
                System.out.println("ERROR: " + http.getResponseMessage());
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if(http != null)
                http.disconnect();
        }
        return null;
    }

    /**
     * Handles an fill database request
     * @param r - fill request item
     * @return
     */
    public fillResult fill(fillRequest r)
    {
        fillResult flResult = null;
        try {
            URL url = new URL("http://" + serverHost + ":" + serverPort + "/fill/"+r.getUserName()+"/"+r.getGenerationCount());

            http = (HttpURLConnection)url.openConnection();

            http.setRequestMethod("POST");
            http.setDoOutput(false);	// There is not a request body

            http.addRequestProperty("Authorization", "mobile");
            http.addRequestProperty("Content-Type", "application/json");

            if (http.getResponseCode() == HttpURLConnection.HTTP_OK)
            {
                InputStream respBody = http.getInputStream();
                String respData = readString(respBody);
                flResult = (fillResult) jsn.decode(respData, fillResult.class);
                return flResult;
            }
            else {
                System.out.println("ERROR: " + http.getResponseMessage());
                return null;
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if(http != null)
                http.disconnect();
        }
        return null;
    }


    /**
     * Handles an clear request
     * @param r - clear request
     * @return
     */
    public clearResult clear(clearRequest r)
    {
        clearResult clrResult = null;
        try {
            URL url = new URL("http://" + serverHost + ":" + serverPort + "/clear");

            http = (HttpURLConnection)url.openConnection();

            http.setRequestMethod("POST");
            http.setDoOutput(false);	// There is a request body

            http.addRequestProperty("Authorization", r.getToken());
            http.addRequestProperty("Content-Type", "application/json");

            if (http.getResponseCode() == HttpURLConnection.HTTP_OK)
            {
                InputStream respBody = http.getInputStream();
                String respData = readString(respBody);
                clrResult = (clearResult) jsn.decode(respData, clearResult.class);
                return clrResult;
            }
            else {
                System.out.println("ERROR: " + http.getResponseMessage());
                return null;
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if(http != null)
                http.disconnect();
        }
        return null;
    }


}
