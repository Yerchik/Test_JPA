package Yerchik.services.implementation;

import Yerchik.dao.AccountDao;
import Yerchik.dao.CurrencyDao;
import Yerchik.dao.SpendingDao;
import Yerchik.dto.SpendingDTO;
import Yerchik.entity.Spending;
import Yerchik.services.SpendingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by Yerchik on 24.05.2017.
 */
@Service
public class SpendingServiceImpl implements SpendingService {
    @Autowired
    private AccountDao accountDao;
    @Autowired
    private SpendingDao spendingDao;
    @Autowired
    private CurrencyDao currencyDao;

    @Override
    public void add(SpendingDTO spendingDTO, String login) {
        String date = spendingDTO.getYear() + "-" + spendingDTO.getMonth() + "-" + spendingDTO.getDay();
        spendingDao.save(new Spending(spendingDTO.getAmount(), date, spendingDTO.getDescription(),
                currencyDao.findByMarking(spendingDTO.getCurrency()), accountDao.findByLogin(login)));
    }

    @Override
    public Set<String> getAllDate(String login) {
        Set<String > dates = new TreeSet<>();
        for (Spending spending : spendingDao.findAll()) {
            if (accountDao.findByLogin(login).getId() == spending.getAccount().getId())
            dates.add(spending.getDate());
        }
        return dates;
    }

    @Override
    public void clearDate(String date, String login) {
        for (Spending spending : spendingDao.findAll()) {
            if (spending.getDate().equals(date) && accountDao.findByLogin(login).getId() == spending.getAccount().getId()){
                spendingDao.delete(spending);
            }
        }
    }

    @Override
    public double total(String currency, String login) {
        double total = 0;
        for (Spending spending : spendingDao.findByCurrency(currencyDao.findByTypeOfCurrency(currency))) {
            if (accountDao.findByLogin(login).getId() == spending.getAccount().getId())
            total+= spending.getAmount();
        }
        return total;
    }

    @Override
    public List<SpendingDTO> getByDate(String date, String login) {
        List<SpendingDTO> dtos = new ArrayList<>();
        for (Spending spending : spendingDao.findByDate(date)) {
            if (accountDao.findByLogin(login).getId() == spending.getAccount().getId())
            dtos.add(new SpendingDTO(spending.getAmount(), spending.getDescription(), spending.getCurrency().getTypeOfCurrency()));
        }
        return dtos;
    }
}
