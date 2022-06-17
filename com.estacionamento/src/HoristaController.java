import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HoristaController {

    @FXML
    private TextField campoUsuario;

    @FXML
    private TextField campoPlaca;

    @FXML
    private Button buttonExit;

    @FXML
    private Button buttonPlaca;

    @FXML
    private Label labelPlaca;

    @FXML
    private Button buttonCriar;

    @FXML
    private Label labelUsuario;

    @FXML
    void corbuttonCriar(ActionEvent event) {

    }

    @FXML
    void corbuttonPlaca(ActionEvent event) {

    }

    @FXML
    void criarConta(ActionEvent event) throws IOException, ExceptionCamposVazios {

        String placa = campoPlaca.getText().toLowerCase();
        String usuario = campoUsuario.getText().toLowerCase();

        Horista horista = new Horista(usuario, placa, 0, 0);
        
        try {
            if(!UserList.isUserExist(horista)) {
                if(placa.contains(" ") || usuario.contains(" ")) {
                    throw new ExceptionCadastro();
                }
                if(placa.length() > 0 && usuario.length() > 0) {
                    UserList.addCarro(horista);
                    abrirconcluido();
                }
                else {
                    throw new ExceptionCamposVazios();
                }
            } 
            else {
                labelPlaca.setText("Placa já cadastrada!");
                labelUsuario.setText(" ");
            }
        }
        catch (ExceptionCadastro cadastro) {
            System.err.print(cadastro + ": ");
            System.err.println("Campos não podem conter espaços ");
            labelPlaca.setText("Não pode espaços");
            labelUsuario.setText(" ");
        }
        catch (ExceptionCamposVazios camposVazios) {
            System.err.print(camposVazios + ": ");
            System.err.println("Campos vazios ");
            labelPlaca.setText("Campos vazios");
            labelUsuario.setText(" ");
        }
    }

    @FXML
    void exit(ActionEvent event) throws IOException {
        abrirexit();
    }

    @FXML
    void lerPlaca(ActionEvent event) throws InterruptedException {
        ArduinoComands.abrirArduino();
        campoPlaca.setText(ArduinoComands.getRFIDreading().toLowerCase());
        ArduinoComands.fecharArduino();
    }

    @FXML
    void corlabelNomedeUsuario(ActionEvent event) {

    }

    public void abrirexit() throws IOException {
        App open = new App();
        open.changeScene("Menu2.fxml");
    }

    public void abrirconcluido() throws IOException {
        App open = new App();
        open.changeScene("Concluido.fxml");
    }
}