package apps.zambrone.com.carpooling;

import com.google.gson.annotations.Expose;

/**
 * Created by Chamith on 23/02/2017.
 */

public class User {
    @Expose
    private String userName;
    @Expose
    private String passwd;

    public User() {
    }

    public User(String userName, String passwd) {
        this.userName = userName;
        this.passwd = passwd;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return passwd;
    }

    public void setPassword(String password) {
        this.passwd = password;
    }
}
