import java.io.IOException;
import java.lang.Exception;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Paint;

public class AlterarValorController {

    private static final Exception Exception = null;

    @FXML
    private Button buttonAlterar;

    @FXML
    private Button buttonExit;

    @FXML
    private Label labelNovoValor;

    @FXML
    private PasswordField campoSenha;

    @FXML
    private TextField campoNovoValor;

    @FXML
    private Label labelSenha;

    @FXML
    void corbuttonAlterar(ActionEvent event) {

    }

    @FXML
    void corbuttonExit(ActionEvent event) {

    }

    @FXML
    void alterarValor(ActionEvent event) throws java.lang.Exception {
        // ARDUINO

        String senha = campoSenha.getText();

        if(senha.toString().equals("moema")) {
            labelSenha.setTextFill(Paint.valueOf("#376e9a"));
            labelSenha.setText("Senha correta");
        }
        else {
            labelSenha.setText("Senha incorreta");
            throw Exception;
        }

        try {
            Double.parseDouble(campoNovoValor.getText());
            if(labelSenha.getText().equals("Senha correta")) {
                labelNovoValor.setTextFill(Paint.valueOf("#376e9a"));
                labelNovoValor.setText("Valor alterado!");
                AlterarValor.valorHoraAlterar(Double.parseDouble(campoNovoValor.getText()));

                ArduinoComands.abrirArduino();
                ArduinoComands.setPrice(campoNovoValor.getText());
                ArduinoComands.fecharArduino();
            }
        }
        catch (Exception exception) {
            labelNovoValor.setText("Valor não alterado!");
        }
        finally {
            System.err.println("FIM");
        }
    }

    @FXML
    void exit(ActionEvent event) throws IOException {
        abrirexit();
    }

    @FXML
    void corlabelNovoValor(ActionEvent event) {

    }

    @FXML
    void corlabelSenha(ActionEvent event) {

    }

    public void abrirexit() throws IOException {
        App open = new App();
        open.changeScene("Menu2.fxml");
    }

}