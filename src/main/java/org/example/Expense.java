package org.example;
import java.util.Date;

public class Expense extends Transaction{

    private String id;

    public Expense(double amount, String id, EExpenseCategory category) {
        super(amount);
        this.id = id;
        setCategory(EExpenseCategory.FOOD.HOUSING.TRANSPORTATION.ENTERTAINMENT.OTHER);
    }
    public static Expense getexpense() {
        return getexpense();
    }
    public EExpenseCategory getCategory() {
        return category;
    }
    public void setCategory(EExpenseCategory category) {
        this.category = category;
    }
    private EExpenseCategory category;

    @Override
    public String toString() {
        return "Expense{" +
                "category=" + category +
                '}';
    }

    public String getId() {
        return id;
    }
}
