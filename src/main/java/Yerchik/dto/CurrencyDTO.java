package Yerchik.dto;

import Yerchik.entity.Currency;

/**
 * Created by Yerchik on 24.05.2017.
 */
public class CurrencyDTO {
    private String typeOfCurrency;
    private String marking;

    public CurrencyDTO() {
    }

    public CurrencyDTO(String typeOfCurrency, String marking) {
        this.typeOfCurrency = typeOfCurrency;
        this.marking = marking;
    }

    public String getTypeOfCurrency() {
        return typeOfCurrency;
    }

    public void setTypeOfCurrency(String typeOfCurrency) {
        this.typeOfCurrency = typeOfCurrency;
    }

    public String getMarking() {
        return marking;
    }

    public void setMarking(String marking) {
        this.marking = marking;
    }

    public static CurrencyDTO convertToDTO(Currency currency){
        return new CurrencyDTO(currency.getTypeOfCurrency(), currency.getMarking());
    }
}
