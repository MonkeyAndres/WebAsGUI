package frontend;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.concurrent.Worker;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import netscape.javascript.JSException;
import netscape.javascript.JSObject;

public class Controller implements Initializable{

    @FXML
    private WebView webContent; // Import WebView from FXML

    private WebEngine webEngine; // Initialize a WebEngine


    /**
     * This method initialize the GUI of the app
     * */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        webEngine = webContent.getEngine(); // Get Engine
        webEngine.setJavaScriptEnabled(true); // Enable JS in the engine

        // Get the index.html from www folder.
        URL baseURL = getClass().getClassLoader().getResource("index.html");

        // Detect changes in the webEngine
        webEngine.getLoadWorker().stateProperty().addListener(
                (observable, oldValue, newValue) -> {
                    if (newValue == Worker.State.SUCCEEDED) {
                        JSObject windowObject = (JSObject) webEngine.executeScript("window");
                        windowObject.setMember("app", new Bridge()); // Inject the "Bridge" JavaClass as a "app" js class

                        // Try if the init() function exist.
                        try{
                            webEngine.executeScript("init();"); // If exist it execute this.
                        } catch (JSException e) {
                            System.out.println("The WebApp does't contain a init() function."); // If doest exist print this.
                        }
                    }
                }
        );

        // Try to load the index.html
        try {
            webEngine.load(baseURL.toExternalForm());
            System.out.println("All Working :D"); // If it is done print this.
        } catch(NullPointerException ex){
            System.out.println("The index.html doest exist."); // If it isn't done print this and exit;
            Platform.exit(); // Exit
        }
    }
}
