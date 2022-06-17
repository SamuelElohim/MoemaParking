import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class CriarContaController {

    @FXML
    private Button buttonHorista;

    @FXML
    private Button buttonMensalista;

    @FXML
    private Button buttonExit;

    @FXML
    void corbuttonMensalista(ActionEvent event) {

    }

    @FXML
    void corbuttonHorista(ActionEvent event) {

    }

    @FXML
    void openMensalista(ActionEvent event) throws IOException {
        abriropenMensalista();
        
    }

    @FXML
    void openHorista(ActionEvent event) throws IOException {
        abriropenHorista();
    }

    @FXML
    void exit(ActionEvent event) throws IOException {
        abrirexit();
    }

    public void abrirexit() throws IOException {
        App open = new App();
        open.changeScene("Menu2.fxml");
    }

    public void abriropenMensalista() throws IOException {
        App open = new App();
        open.changeScene("Mensalista2.fxml");
    }

    public void abriropenHorista() throws IOException {
        App open = new App();
        open.changeScene("Horista2.fxml");
    }

    

}