package requests;

/**
 * Created by Admin on 2/14/17.
 */

public class clearRequest {

    String token;

    public clearRequest(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
