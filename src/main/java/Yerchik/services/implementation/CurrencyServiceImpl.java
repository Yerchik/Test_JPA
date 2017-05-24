package Yerchik.services.implementation;

import Yerchik.dao.CurrencyDao;
import Yerchik.dto.CurrencyDTO;
import Yerchik.entity.Currency;
import Yerchik.services.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yerchik on 24.05.2017.
 */
@Service
public class CurrencyServiceImpl implements CurrencyService {

    @Autowired
    private CurrencyDao currencyDao;

    @Override
    public void addList() {
        try {
            currencyDao.save(new Currency("USD","$"));
            currencyDao.save(new Currency("UAH","₴"));
            currencyDao.save(new Currency("EUR","€"));

        }catch (Exception e){}
    }

    @Override
    public void add(CurrencyDTO dto) {
        currencyDao.save(new Currency(dto.getTypeOfCurrency(), dto.getMarking()));
    }

    @Override
    public List<CurrencyDTO> findAll() {
        List<CurrencyDTO> currencyDTOS = new ArrayList<>();
        for (Currency currency : currencyDao.findAll()) {
            currencyDTOS.add(CurrencyDTO.convertToDTO(currency));
        }
        return currencyDTOS;
    }


}
