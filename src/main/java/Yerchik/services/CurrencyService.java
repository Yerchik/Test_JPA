package Yerchik.services;

import Yerchik.dto.CurrencyDTO;

import java.util.List;

/**
 * Created by Yerchik on 24.05.2017.
 */
public interface CurrencyService {
    void addList();
    void add(CurrencyDTO dto);
    List<CurrencyDTO> findAll();
}
