package frontend;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("MainWindow.fxml")); // Get the FXML MainWindow
        primaryStage.setTitle("WebAsGUI"); // Set a title for the window
        primaryStage.setScene(new Scene(root));
        primaryStage.show(); // Show the window
    }


    public static void main(String[] args) {
        launch(args);
    }
}
