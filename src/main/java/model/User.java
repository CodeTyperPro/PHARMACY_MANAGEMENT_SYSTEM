package model;

public class User {
    private String name;
    private String username;
    private String password;
    private Integer level;

    public User() {
        this.name = "Default";
        this.username = "default";
        this.password = "####";
    }

    public User(String name, String username, String password, Integer acessLevel) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.level = acessLevel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", level=" + level +
                '}';
    }
}
