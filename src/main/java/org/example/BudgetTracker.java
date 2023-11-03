package org.example;
import com.google.gson.Gson;

import java.awt.List;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;


public class BudgetTracker {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        ExpenseStorage expenseStorage = new ExpenseStorage();
        IncomeStorage incomeStorage = new IncomeStorage();

        List list = new List();
        Gson gson = new Gson();

        String filename = "src/main/java/user.json";
        User user = new User("Amrit","Singh");

        FileWriter fw = new FileWriter (filename);
        gson.toJson(user, fw);
        fw.flush();

        try {
            while (true) {
                System.out.println("BudgetTracker ");
                System.out.println("1. Lägg till utgift");
                System.out.println("2. Lägg till inkomst");
                System.out.println("3. Visa utgifter");
                System.out.println("4. Visa inkomster");
                System.out.println("5. Se budget");
                System.out.println("6. Sök utgift/inkomst");
                System.out.println("7. Avsluta program");

                int choice = scanner.nextInt();
                scanner.nextLine(); // Konsumera ny rad efter nästaInt()


                switch (choice) {
                    case 1:
                        // Lägg till en utgift eller uppdatera/ta bort utgift
                        System.out.println("1: Lägg till utgift,2: Ta bort utgift, 3: Uppdatera utgift ");
                        int expenseChoice = scanner.nextInt();

                        if (expenseChoice == 1) {
                            ExpenseStorage.createExpense();
                            //Expense expense = createExpense(scanner);
                        } else if (expenseChoice == 2) {
                            ExpenseStorage.updateExpense("Amrit", scanner.nextDouble());

                        } else if (expenseChoice == 3) {

                        }
                        break;

                    case 2:
                        // Lägg en inkomst eller uppdatera/ta bort inkomst
                        System.out.println("1: Lägg till inkomst,2: Ta bort inkomst, 3: Uppdatera inkomst ");
                        //Income income = createIncome(scanner);
                        int incomeChoice = scanner.nextInt();

                        if (incomeChoice == 1) {
                                scanner = new Scanner(System.in);
                                System.out.println("Ange belopp: ");
                                double amount = scanner.nextDouble();
                                scanner.nextLine();

                                System.out.println("Ange kategori med stora bokstäver(Lön, Ivesteringar, Gåvor, Annat): ");
                                String categoryStr = scanner.nextLine();
                                EIncomeCategory category = EIncomeCategory.valueOf(categoryStr);

                                System.out.println("Ange datum (yyyy-MM-dd): ");
                                String dateStr = scanner.nextLine();
                                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                                Date date = new Date();


                                try {
                                    date = dateFormat.parse(dateStr);
                                } catch (Exception e) {
                                    System.out.println("Ogiltigt datumformat. Använd formatet 'yyyy-MM-dd'.");
                                }
                                new Income(amount, date, category);
                            }
                    case 3:
                        // Visa utgifter
                        expenseStorage.listAllExpenses();
                        expenseStorage.readfile();

                        break;
                    case 4:
                        // Visa inkomster
                        incomeStorage.listAllIncomes();
                        incomeStorage.readfile();
                        break;
                    case 5:
                        // Se budget
                        double totalIncome = incomeStorage.calculateTotalIncome();
                        double totalExpenses = expenseStorage.calculateTotalExpenses();
                        double budget = totalIncome - totalExpenses;
                        System.out.println("Total inkomst: " + totalIncome);
                        System.out.println("Totala utgifter: " + totalExpenses);
                        System.out.println("Budget: " + budget);
                        incomeStorage.readfile();
                        break;
                    case 6:
                        // Sök utgift eller inkomst
                        System.out.println("Ange sökterm: ");
                        String search = scanner.nextLine();
                        incomeStorage.searchIncome(search);
                        expenseStorage.searchExpense(search);
                        incomeStorage.readfile();
                        break;
                    case 7:
                        System.out.println("Avslut program");
                        System.exit(0);

                    default:
                        System.out.println("Ogiltigt val. Försök igen.");
                        break;
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input please try again");
        }
    }

}
