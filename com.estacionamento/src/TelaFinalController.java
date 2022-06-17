import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class TelaFinalController {

    @FXML
    private Button buttonExit;

    @FXML
    void corbuttonexit(ActionEvent event) {

    }

    @FXML
    void cortitulo(ActionEvent event) {

    }

    @FXML
    void exit(ActionEvent event) throws IOException {
        abrirexit();
    }

    public void abrirexit() throws IOException {
        App open = new App();
        open.changeScene("Menu2.fxml");
    }
}


