package Yerchik.services;

import Yerchik.dto.SpendingDTO;

import java.util.List;
import java.util.Set;

/**
 * Created by Yerchik on 24.05.2017.
 */
public interface SpendingService {
    void add(SpendingDTO spendingDTO, String login);
    Set<String > getAllDate(String login);
    void clearDate(String date, String login);
    double total(String currency, String login);
    List<SpendingDTO> getByDate(String date, String login);
}
