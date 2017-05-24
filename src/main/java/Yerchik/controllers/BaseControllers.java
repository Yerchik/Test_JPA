package Yerchik.controllers;

import Yerchik.dto.CurrencyDTO;
import Yerchik.dto.SignUpDto;
import Yerchik.dto.SpendingDTO;
import Yerchik.dto.UserDto;
import Yerchik.services.AccountService;
import Yerchik.services.CurrencyService;
import Yerchik.services.SpendingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.Set;

/**
 * Created by Yerchik on 22.05.2017.
 */
@Controller
public class BaseControllers {

    @Autowired
    private AccountService accountService;

    @Autowired
    private CurrencyService currencyService;

    @Autowired
    private SpendingService spendingService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(){
        return "home";
    }

    @RequestMapping(value = "/sign-in", method = RequestMethod.GET)
    public String signIn(){
        return "signIn";
    }

    @RequestMapping(value = "/sign-up", method = RequestMethod.GET)
    public String signUp(){
        currencyService.addList();
        return "signUp";
    }

    @RequestMapping(value = "/sign-up", method = RequestMethod.POST)
    @ResponseBody
    public void signUn(@RequestBody SignUpDto dto){
        accountService.add(dto);
    }

    @RequestMapping(value = "/user/info", method = RequestMethod.GET)
    @ResponseBody
    public UserDto getUserInfo(Principal principal){
        return UserDto.convertToDTO(accountService.findByLogin(principal.getName()));
    }

    @RequestMapping(value = "/getAllCurrency", method = RequestMethod.GET)
    @ResponseBody
    public List<CurrencyDTO> getAllCurrency(){
        return currencyService.findAll();
    }

    @RequestMapping(value = "/add/", method = RequestMethod.POST)
    @ResponseBody
    public void addSpending(@RequestBody SpendingDTO dto, Principal principal) {
        spendingService.add(dto, principal.getName());
    }

    @RequestMapping(value = "/getAllDates", method = RequestMethod.GET)
    @ResponseBody
    public Set<String> getAllDates(Principal principal){
        return spendingService.getAllDate(principal.getName());
    }

    @RequestMapping(value = "/clearDate/{date}", method = RequestMethod.POST)
    @ResponseBody
    public void clearDate(@PathVariable String date, Principal principal){
        spendingService.clearDate(date, principal.getName());
    }

    @RequestMapping(value = "/total/{marking}", method = RequestMethod.GET)
    @ResponseBody
    public String total(@PathVariable String marking, Principal principal){
        return "Total " + spendingService.total(marking, principal.getName()) + " " + marking;
    }

    @RequestMapping(value = "/getByDates/{date}", method = RequestMethod.GET)
    @ResponseBody
    public List<SpendingDTO> getByDates(@PathVariable String date, Principal principal){
        return spendingService.getByDate(date, principal.getName());
    }


    @RequestMapping(value = "/addCurrency", method = RequestMethod.POST)
    @ResponseBody
    public void addCurrency(@RequestBody CurrencyDTO dto){
        currencyService.add(dto);
    }
}
