package Yerchik.dao;

import Yerchik.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Yerchik on 23.05.2017.
 */
public interface RoleDao extends JpaRepository<Role, Integer> {
    Role findByName(String name);
}
