package org.example;
import com.google.gson.Gson;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class User {

    private String firstname;

    private String lastname;

    private Map<String, Income> incomeList;
    private Map<String, Expense> expenseList;

    public User(String firstname, String lastname) throws IOException {
        this.firstname = firstname;
        this.lastname = lastname;
        incomeList = new HashMap<>();
        expenseList= new HashMap<>();
    }
    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }
    public String setFirstname(String firstname){
        this.firstname = firstname;
        return firstname;
    }
    public String setLastname(String lastname){
        this.lastname = lastname;
        return lastname;
    }

    public Map<String, Income> getIncomeList() {
        return incomeList;
    }

    public Map<String, Expense> getExpenseList() {
        return expenseList;
    }

    @Override
    public String toString() {
        return "User{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }
}
