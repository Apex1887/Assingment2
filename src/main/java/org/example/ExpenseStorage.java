package org.example;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.*;
import java.lang.reflect.Type;
import java.util.Map;
import java.util.Scanner;

public class ExpenseStorage {
    private Map<String, Expense> expenseList;
    static String filename = "src/main/java/user.json";
    static Gson gson = new GsonBuilder().setPrettyPrinting().create();
    

    public ExpenseStorage() {
    }
    public void savefile()throws IOException{
            FileWriter fw = new FileWriter(new File(filename));
            gson.toJson(expenseList, fw);
            fw.close();
            System.out.println("File saved: " + filename);
    }
    public void readfile()throws IOException{
            Type type = new TypeToken<Map<String, Expense>>() {}.getType();
            Reader reader = new FileReader(new File(filename));
            expenseList = gson.fromJson(reader, type);
            reader.close();// Initialize the 'Expense' map
    }
    public void listAllExpenses() throws IOException {
        readfile();
        System.out.println("List of all your expenses");
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your id");
        String id = scanner.next();

        if (expenseList.containsKey(id)) {
            Expense expense = expenseList.get(id);
            System.out.println("Expense list for " + expense.getAmount() + " " + expense.getDate());
            System.out.println();
            System.out.println("Expenses: " + Expense.getexpense());
        } else {
            System.out.println("The user is not in the list.");
        }

    }
    public void updateExpense(Expense expense) {
        expenseList.put(expense.getId(), expense);
        expense.setAmount();
    }

    public void searchExpense(String search1) throws IOException {
    }
   /* public void createExpense()throws IOException{
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
        //new Expense(amount, category);
    }*/

    public void addExpense(Expense expense) {
        expenseList.put(expense.getId(), expense);
    }
    public double calculateTotalExpenses() {
        return 0;
    }

}
