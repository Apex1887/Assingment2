package org.example;
import java.util.Date;

public class Income extends Transaction {
    public EIncomeCategory getIncomeCategory() {
        return incomeCategory;
    }

    public void setIncomeCategory(EIncomeCategory incomeCategory) {
        this.incomeCategory = incomeCategory;
    }

    public void setIncome(Income income) {
        this.income = income;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    private EIncomeCategory incomeCategory;

    private Income income;

    private String id;

    public Income(double amount, Date date, EIncomeCategory category) {
        super(amount, date);
        this.id = id;
        setCategory(EIncomeCategory.LÖN.INVISTERINGAR.GÅVOR.ANNAT);
    }
    public Income getIncome(){
        return income;
    }
    public EIncomeCategory getCategory() {
        return category;
    }

    public void setCategory(EIncomeCategory category) {
        this.category = category;
    }

    private EIncomeCategory category;


    @Override
    public String toString() {
        return "Income{" +
                "income=" + income +
                ", id='" + id + '\'' +
                ", category=" + category +
                '}';
    }
}
