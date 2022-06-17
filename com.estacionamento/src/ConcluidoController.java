import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class ConcluidoController {

    @FXML
    private Button buttonLogin;

    @FXML
    private Button buttonExit;

    @FXML
    void corbuttonLogin(ActionEvent event) {
        
    }

    @FXML
    void corbuttonExit(ActionEvent event) {
        
    }

    @FXML
    void exit(ActionEvent event) throws IOException {
        abrirexit();
    }

    @FXML
    void facaSeuLogin(ActionEvent event) throws IOException {
        abrirlogin();
    }

    public void abrirexit() throws IOException {
        App open = new App();
        open.changeScene("Menu2.fxml");
    }

    public void abrirlogin() throws IOException {
        App open = new App();
        open.changeScene("Login2.fxml");
    }
}