package Yerchik.services.implementation;

import Yerchik.dao.AccountDao;
import Yerchik.dao.RoleDao;
import Yerchik.dto.SignUpDto;
import Yerchik.entity.Account;
import Yerchik.entity.Role;
import Yerchik.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Yerchik on 23.05.2017.
 */
@Service("userDetailsService")
public class AccountServiceImpl implements AccountService, UserDetailsService {

    @Autowired
    private AccountDao accountDao;

    @Autowired
    private RoleDao roleDao;
    @Override
    public void add(SignUpDto dto) {
        Account account = dto.convertToEntity();
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        account.setPassword(encoder.encode(account.getPassword()));
        if (dto.getLogin().equals("admin")) {
            try {
                Role admin = new Role("ADMIN");
                roleDao.save(admin);

            } catch (Exception e) {}
            finally {
                account.setRole(roleDao.findByName("ADMIN"));
            }
        } else {
            try {
                Role user = new Role("USER");
                roleDao.save(user);
            } catch (Exception e) {}
            finally {
                account.setRole(roleDao.findByName("USER"));
            }
        }
        accountDao.save(account);
    }

    @Override
    public Account findByLogin(String login) {
        return accountDao.findByLogin(login);
    }


    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Account account = accountDao.findByLogin(login);
        if (account == null) {
            throw new UsernameNotFoundException("Bad Credentials");
        }
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_" + account.getRole().getName().toUpperCase()));
        return new User(account.getLogin(), account.getPassword(), authorities);
    }
}
