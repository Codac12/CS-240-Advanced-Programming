package json;

import com.google.gson.Gson;
import com.sun.java_cup.internal.runtime.Scanner;
import com.sun.net.httpserver.HttpExchange;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

/**
 * Class for handling json, converting to and from
 * Created by Admin on 3/6/17.
 */

public class json {

    private Gson gson;

    public json() {
        gson = new Gson();
    }

    public String encode(Object result)
    {
        return gson.toJson(result);
    }

    public Object decodeExchange(HttpExchange exchange, Class objClass) throws IOException {

        InputStream is = exchange.getRequestBody();
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));

        return gson.fromJson(reader,objClass);


    }

    public Object decode(String toDecode, Class objClass) throws FileNotFoundException {
        return gson.fromJson(toDecode,objClass);

    }
}

