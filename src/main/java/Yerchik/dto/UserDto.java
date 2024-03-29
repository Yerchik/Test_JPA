package Yerchik.dto;

import Yerchik.entity.Account;

/**
 * Created by Yerchik on 26.03.2017.
 */
public class UserDto {
    private String name;
    private String secondName;
    private String login;

    public UserDto() {
    }

    public UserDto(String name, String secondName, String login) {
        this.name = name;
        this.secondName = secondName;
        this.login = login;
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

    public static UserDto convertToDTO(Account account){
        return new UserDto(account.getName(), account.getSecondName(), account.getLogin());
    }
}
