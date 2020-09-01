package server.entities;

public class AdminAccount {
    private String userName;
    private String password;
    public AdminAccount(String userName, String password){
        this.userName = userName;
        this.password = password;
    }

    public String getName() {
        return this.userName;
    }

    public void setName(String name) {
        this.userName = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
