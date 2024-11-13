package PersonalFinance;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class ExpensesController {

    @FXML
    DatePicker tfDate = new DatePicker();
    @FXML
    TextField tfDescription = new TextField();
    @FXML
    TextField tfValue = new TextField();
    @FXML
    TextField tfCategory = new TextField();
    
    public void onclickAddExpense(ActionEvent actionEvent) {
        
    }

    public void onClickSeeExpenses(ActionEvent actionEvent) {
    }
}
