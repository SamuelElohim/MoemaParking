import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class MensalistaController {

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
    private TextField campoSenha;

    @FXML
    private Button buttonCriar;

    @FXML
    private Label labelSenha;

    @FXML
    void corbuttonPlaca(ActionEvent event) {

    }

    @FXML
    void corbuttonCriar(ActionEvent event) {

    }

    @FXML
    void criarConta(ActionEvent event) throws IOException {

        String placa = campoPlaca.getText().toLowerCase();
        String usuario = campoUsuario.getText().toLowerCase();
        String senha = campoSenha.getText().toLowerCase();

        Clientes mensalista = new Mensalista(usuario, placa, senha, 0, 0);
        
        try {
            if(placa.contains(" ") || usuario.contains(" ") || senha.contains(" ")) {
                throw new ExceptionCadastro();
            }
            if(!UserList.isUserExist(mensalista)) {
                if(campoSenha.getText().length() > 0 && campoUsuario.getText().length() > 0 && campoPlaca.getText().length() > 0) {
                    UserList.addCarro(mensalista);
                    abrirconcluido();
                } 
                else {
                    throw new ExceptionCamposVazios();
                }
            } 
            else {
                labelPlaca.setText("Placa já cadastrada!");
                labelSenha.setText(" ");
            }
        }
        catch (ExceptionCadastro cadastro) {
            System.err.print(cadastro + ": ");
            System.err.println("Campos não podem conter espaços ");
            labelPlaca.setText("Não pode espaços");
            labelSenha.setText(" ");
        }
        catch (ExceptionCamposVazios camposVazios) {
            System.err.print(camposVazios + ": ");
            System.err.println("Campos vazios ");
            labelPlaca.setText("Campos vazios");
            labelSenha.setText(" ");
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
    void corlabelNomedeUusuario(ActionEvent event) {

    }

    @FXML
    void corlabelSenha(ActionEvent event) {

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