import java.io.IOException;

import org.json.simple.parser.ParseException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {
    public static void main(String[] args) throws IOException, ParseException {
        UserList.loadJSON();
        launch(args);
    }

    public static Stage stg;

    @Override
    public void start(Stage primaryStage) throws Exception {
        stg = primaryStage;
        primaryStage.setResizable(false);
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Menu2.fxml"));
        Parent root = fxmlLoader.load();
        Scene tela = new Scene(root);
        primaryStage.setTitle("MoemaParking");
        primaryStage.setScene(tela);
        primaryStage.show();

    }

    public void changeScene(String fxml) throws IOException {
        Parent pane = FXMLLoader.load(getClass().getResource(fxml));
        stg.getScene().setRoot(pane);
    }

}