package PersonalFinance;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.time.LocalDate;

public class ExpensesController {

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
    
    public void onclickAddExpense(ActionEvent actionEvent) {
        //read values from input
        LocalDate ld = tfDate.getValue();
        String desc = tfDescription.getText();
        String cat = tfCategory.getText();
        double value = Double.parseDouble(tfValue.getText());

        //new object from ExpenseType
        ExpenseType e1 = new ExpenseType(cat, value, desc, ld);

        //calculate totalExpenses
        e1.addTotalExpense();

        //show output
        taExpenses.setText(taExpenses.getText() + e1.toString());
        lbExpenses.setText("Total expenses: $" + ExpenseType.getTotalExpenses());
        
    }


}
