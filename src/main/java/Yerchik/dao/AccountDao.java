package Yerchik.dao;

import Yerchik.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Yerchik on 22.05.2017.
 */
public interface AccountDao extends JpaRepository<Account, Integer> {
    Account findByLogin(String login);
}
