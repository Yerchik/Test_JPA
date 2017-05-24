package Yerchik.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Yerchik on 23.05.2017.
 */
@Entity
public class Currency {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;
    @Column(nullable = false, unique = true)
    private String typeOfCurrency;
    @Column(nullable = false, unique = true)
    private String marking;
    @OneToMany(mappedBy = "currency")
    private List<Spending> transactionList;

    public Currency() {
    }

    public Currency(String typeOfCurrency, String marking) {
        this.typeOfCurrency = typeOfCurrency;
        this.marking = marking;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

}
