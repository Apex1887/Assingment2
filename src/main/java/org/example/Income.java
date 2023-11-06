package org.example;
import java.util.Date;

public class Income extends Transaction {

    private String id;

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
    private EIncomeCategory incomeCategory;

    private Income income;

    public Income(double amount,String id, int categoryStr, Date date) {
        super(amount, id, date);
        this.id = id;
        setCategory(categoryStr);
    }
    public Income getIncome(){
        return income;
    }
    public EIncomeCategory setCategory() {
        return category;
    }
    public void setCategory(int incomeCategory) {
        switch (incomeCategory) {
            case 1:
                this.category = EIncomeCategory.LÖN;
                break;
            case 2:
                this.category = EIncomeCategory.INVISTERINGAR;
                break;
            case 3:
                this.category = EIncomeCategory.GÅVOR;
                break;
            case 4:
                this.category = EIncomeCategory.ANNAT;
                break;
            default:
                this.category = EIncomeCategory.ANNAT;
                break;
        }

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
