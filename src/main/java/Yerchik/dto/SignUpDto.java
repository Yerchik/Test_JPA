package Yerchik.dto;


import Yerchik.entity.Account;

/**
 * Created by Yerchik on 25.03.2017.
 */
public class SignUpDto {
    private String name;
    private String secondName;
    private String login;
    private String password;

    public SignUpDto() {
    }

    public SignUpDto(String name, String secondName,  String login, String password) {
        this.name = name;
        this.secondName = secondName;
        this.login = login;
        this.password = password;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

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

    public Account convertToEntity(){
        return new Account(this.name, this.secondName, this.login, this.password);
    }
}
