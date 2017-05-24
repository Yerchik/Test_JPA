package Yerchik.services;

import Yerchik.dto.SignUpDto;
import Yerchik.entity.Account;

/**
 * Created by Yerchik on 22.05.2017.
 */
public interface AccountService {
    public void add(SignUpDto dto);
    public Account findByLogin(String login);
}
