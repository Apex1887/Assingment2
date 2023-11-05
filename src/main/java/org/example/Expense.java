package org.example;

import java.util.Date;

public class Expense extends Transaction{

    private String id;

    public Expense(double amount, String id, int expensecategory, Date date) {
        super(amount, id, date);
        this.id = id;
        setCategory(expensecategory);
    }
    public static Expense getexpense() {
        return getexpense();
    }

    public EExpenseCategory getCategory() {
        return expenseCategory;
    }
    public void setCategory(EExpenseCategory category) {
        this.expenseCategory = category;
    }
    private EExpenseCategory expenseCategory;


    public void setCategory(int expenseCategory) {
        switch (expenseCategory) {
            case 1:
                this.expenseCategory = EExpenseCategory.FOOD;
                break;
            case 2:
                this.expenseCategory = EExpenseCategory.RENT;
                break;
            case 3:
                this.expenseCategory = EExpenseCategory.TRANSPORTATION;
                break;
            case 4:
                this.expenseCategory = EExpenseCategory.ENTERTAINMENT;
                break;
            default:
                this.expenseCategory = EExpenseCategory.OTHER;
                break;
        }
    }

    public String getId () {
            return id;
    }


}