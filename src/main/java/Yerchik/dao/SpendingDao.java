package Yerchik.dao;

import Yerchik.entity.Currency;
import Yerchik.entity.Spending;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Yerchik on 23.05.2017.
 */
public interface SpendingDao extends JpaRepository<Spending, Integer> {
    List<Spending> findByDate(String date);
    List<Spending> findByCurrency(Currency currency);
}
