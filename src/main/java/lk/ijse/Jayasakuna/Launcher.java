package lk.ijse.Jayasakuna;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

//Inheritance Usage
public class Launcher extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Parent parent =  FXMLLoader.load(getClass().getResource("/view/Loging-form.fxml"));
        stage.setScene(new Scene(parent));
        stage.setTitle("Dashboard");
        stage.centerOnScreen();
        stage.show();
    }
}
