package PersonalFinance;

import java.time.LocalDate;

public class ExpenseType {
    //attributes
    private String category;
    private double value;
    private String description;
    private LocalDate date;
    private static double totalExpenses = 0;

    //constructor
    public ExpenseType(String c, double v, String d, LocalDate date){
        this.category = c;
        this.date = date;
        this.value = v;
        this.description = d;
    }

    public void addTotalExpense(){
        totalExpenses = totalExpenses + value;
    }

    public static double getTotalExpenses(){
        return totalExpenses;
    }

    @Override
    public String toString(){
        return date + "\t " + description + "\t $" + value + "\t" + category + "\n";
    }
}
