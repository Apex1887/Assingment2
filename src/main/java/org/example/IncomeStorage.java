package org.example;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.*;
import java.lang.reflect.Type;
import java.util.*;

public class IncomeStorage {

    private Map<String, Income> incomelist;
    static String filename = "src/main/java/user.json";
    Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public IncomeStorage(){
    }
     /*   public void listAllIncomes() {
            for (Map.Entry<String, User> entry : incomes.entrySet()) {
                System.out.println("Användare: " + entry.getKey());
                System.out.println("Inkomst: " + entry.getValue());
            }
        }*/
    public double calculateTotalIncome() {
        return 0;
    }
    public void searchIncome(String search) {
    }
    public void savefile()throws IOException{
        FileWriter fw = new FileWriter(new File(filename));
        gson.toJson(incomelist, fw);
        fw.close();
        System.out.println("File saved: " + filename);
    }
    public void readfile()throws IOException{
        Type type = new TypeToken<Map<String, Expense>>() {}.getType();
        Reader reader = new FileReader(new File(filename));
        incomelist = gson.fromJson(reader, type);
        reader.close();// Initialize the 'Expense' map
    }

    public void addIncome(Income income) {
        incomelist.put(income.getId(), income);
    }

    public void updateIncome(Income income) {
        incomelist.put(income.getId(), income);
        income.setAmount();
    }


}
