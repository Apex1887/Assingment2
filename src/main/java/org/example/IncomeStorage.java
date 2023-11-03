package org.example;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.*;
import java.lang.reflect.Type;
import java.util.*;

public class IncomeStorage {

    private Map<String, User> incomes;
    static String filename = "src/main/java/user.json";
    Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public IncomeStorage()throws IOException{
    }
        public void listAllIncomes() {
            for (Map.Entry<String, User> entry : incomes.entrySet()) {
                System.out.println("Användare: " + entry.getKey());
                System.out.println("Inkomst: " + entry.getValue());
            }
        }
    public double calculateTotalIncome() {
        return 0;
    }
    public void searchIncome(String search) {
    }
    public void savefile() {
        try {
            FileWriter fw = new FileWriter(new File(filename));
            gson.toJson(incomes, fw);
            fw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void readfile() {
        try {
            Type type = new TypeToken<Map<String, User>>() {}.getType();
            Reader reader = new FileReader(new File(filename));
            incomes = gson.fromJson(reader, type);
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
