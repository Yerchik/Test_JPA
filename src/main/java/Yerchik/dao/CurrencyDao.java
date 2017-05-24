package Yerchik.dao;

import Yerchik.entity.Currency;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Yerchik on 23.05.2017.
 */
public interface CurrencyDao extends JpaRepository<Currency, Integer> {
    Currency findByMarking(String marking);
    Currency findByTypeOfCurrency(String typeOfCurrency);
}
