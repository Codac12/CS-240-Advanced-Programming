package proxyTest;

import requests.loginRequest;
import requests.registerRequest;
import serverProxy.proxy;

/**
 * Created by Admin on 3/10/17.
 */

public class main {

    public static void main(String[] args)
    {
        proxy sProxy = new proxy(args[1], args[2]);

        System.out.println("Testing Register Proxy...");
        registerRequest rRequest = new registerRequest("codac", "codac1234", "codac@live.com", "cody", "kesler", "m");
        if(sProxy.register(rRequest) != null)
        {
            System.out.println("Register Proxy passed!");

        }

        loginRequest lRequest = new loginRequest("codac","codac1234");
        sProxy.login(lRequest);


    }
}
