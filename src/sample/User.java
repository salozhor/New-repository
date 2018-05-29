package sample;

public class User {
    private String login;
    private String password;
    private int avto;
    private int time;

    public User(String login, String password, int avto, int time) {
        this.login = login;
        this.password = password;
        this.avto = avto;
        this.time = time;
    }

    public User(){}

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAvto() {
        return avto;
    }

    public void setAvto(int avto) {
        this.avto = avto;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
}
