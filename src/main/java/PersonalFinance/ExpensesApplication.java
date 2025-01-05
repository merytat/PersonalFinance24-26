package PersonalFinance;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ExpensesApplication extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(ExpensesApplication.class.getResource("expense-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 619,419);
        primaryStage.setTitle("Add Expense");
        primaryStage.setScene(scene);
        primaryStage.show();



    }
}
