package org.example;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.*;
import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Scanner;

public class ExpenseStorage {

    private static Map<String, User> expenseList;
    static String filename = "src/main/java/user.json";
    static Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public ExpenseStorage() throws IOException {
        savefile();
    }
    public static void savefile()throws IOException{
            Gson gson = new Gson();
            FileWriter fw = new FileWriter(new File(filename));
            gson.toJson(expenseList, fw);
            fw.close();
            System.out.println("File saved: " + filename);
    }
    public static void readfile()throws IOException{
            Type type = new TypeToken<Map<String, Expense>>() {}.getType();
            Reader reader = new FileReader(new File(filename));
            expenseList = gson.fromJson(reader, type);
            reader.close();// Initialize the 'Expense' map
    }
    public void listAllExpenses() throws IOException {
        readfile();
        System.out.println("List of all your expenses");
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your firstname");
        String firstname = scanner.next();

        if (expenseList.containsKey(firstname)) {
            User user = expenseList.get(firstname);
            System.out.println("Expense list for " + user.getFirstname() + " " + user.getLastname());
            System.out.println();
            System.out.println("Expenses: " + Expense.getexpense());
        } else {
            System.out.println("The user is not in the list.");
        }
      //  savefile();
    }
    public static void updateExpense(String firstname, double newAmount) throws IOException {
        User expense = expenseList.get(firstname);
        //expense.setAmount(newAmount);
        savefile();
    }

    public void searchExpense(String search1) throws IOException {
    }
    static void createExpense()throws IOException{
        System.out.println("Ange belopp: ");
        Scanner scanner = new Scanner(System.in);
        double amount = scanner.nextDouble();
        scanner.nextLine(); // Konsumera ny rad efter nästaDouble()

        System.out.println("Ange kategori (FOOD, HOUSING, TRANSPORTATION, ENTERTAINMENT, OTHER): ");
        String categoryStr = scanner.nextLine();
        EExpenseCategory category = EExpenseCategory.valueOf(categoryStr);

        System.out.println("Ange datum (yyyy-MM-dd): ");
        String dateStr = scanner.nextLine();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        savefile();
        try {
            date = dateFormat.parse(dateStr);
        } catch (Exception e) {
            System.out.println("Ogiltigt datumformat. Använd formatet 'yyyy-MM-dd'.");
        }
        new Expense(amount, date, category);
    }
    public double calculateTotalExpenses() {
        return 0;
    }

}
