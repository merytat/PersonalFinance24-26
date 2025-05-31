package PersonalFinance;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.*;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class ExpensesController implements Initializable {

    @FXML
    DatePicker tfDate = new DatePicker();
    @FXML
    TextField tfDescription = new TextField();
    @FXML
    TextField tfValue = new TextField();
    @FXML
    TextField tfCategory = new TextField();
    @FXML
    TextArea taExpenses = new TextArea();
    @FXML
    Label lbExpenses = new Label();

    File expenses = new File("src/main/resources/PersonalFinance/expenses.txt");


    
    public void onclickAddExpense(ActionEvent actionEvent) throws IOException {
        //read values from input
        LocalDate ld = tfDate.getValue();
        String desc = tfDescription.getText();
        String cat = tfCategory.getText();
        double value = Double.parseDouble(tfValue.getText());

        //new object from ExpenseType
        ExpenseType e1 = new ExpenseType(cat, value, desc, ld);

        //calculate totalExpenses
        e1.addTotalExpense();

        //save the expense on a file
        expenses.createNewFile();
        FileWriter fw = new FileWriter(expenses, true);
        PrintWriter pw = new PrintWriter(fw);
        pw.print(e1.toString());
        pw.flush();
        pw.close();
        fw.close();




        taExpenses.setText(taExpenses.getText() + e1.toString());
        lbExpenses.setText("Total expenses: $" + ExpenseType.getTotalExpenses());
        
    }

    //method that initialize parameters for my screen
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //show output - reading from the file
        FileReader fr = null;
        String allExpenses = "";
        try {
            fr = new FileReader(expenses);
            BufferedReader br = new BufferedReader(fr);
            String exp = "";
            while((exp = br.readLine()) != null){
                allExpenses = allExpenses + exp + "\n";
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        taExpenses.setText(allExpenses);
        lbExpenses.setText("Total expenses: $" + ExpenseType.getTotalExpenses());


    }
}
