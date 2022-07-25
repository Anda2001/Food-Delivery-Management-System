package businessLogic;

import java.io.Serializable;

public class Client implements Serializable {
    private String username;
    private String password;
    private int id;

    public Client(int id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;

    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
