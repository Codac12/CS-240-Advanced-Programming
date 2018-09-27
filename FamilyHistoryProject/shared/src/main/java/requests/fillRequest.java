package requests;

/**
 * Created by Admin on 2/14/17.
 * String userName user to add generations to
 int generationCount how many generations to add to the user
 *
 */

public class fillRequest {

    String userName;
    int generationCount;

    public fillRequest(String userName, int generationCount) {

        this.userName = userName;
        this.generationCount = generationCount;
    }

    public String getUserName() {
        return userName;
    }

    public int getGenerationCount() {
        return generationCount;
    }
}
