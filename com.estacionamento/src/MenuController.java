import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class MenuController {

    @FXML
    private Button buttonLogin;

    @FXML
    private Button buttonsaida;

    @FXML
    private Button buttonAlterarValor;

    @FXML
    private Button buttonCriarConta;

    @FXML
    void corbuttonLogin(ActionEvent event) {

    }

    @FXML
    void fazerLogin(ActionEvent event) throws IOException{
        abrirfazerLogin();
    }

    @FXML
    void corbuttonSaida(ActionEvent event) {

    }

    @FXML
    void criarCadastro(ActionEvent event) throws IOException {
        
        abrircriarConta();
    }

    @FXML
    void corbuttonCriarConta(ActionEvent event) {

    }

    @FXML
    void alterarValorEstacionamento(ActionEvent event) throws IOException {
        
        abriralterarValor();
    }

    @FXML
    void saida(ActionEvent event) throws IOException {
        
        abrirsaida();
    }

    public void abrirfazerLogin() throws IOException {
        App open = new App();
        open.changeScene("Login2.fxml");
    }
    
    public void abrircriarConta() throws IOException {
         App open = new App();
        open.changeScene("CriarConta.fxml");
    }
    
    public void abriralterarValor() throws IOException {
        App open = new App();
        open.changeScene("AlterarValor.fxml");
    }

    public void abrirsaida() throws IOException {
        App open = new App();
        open.changeScene("Saida2.fxml");
    }
}
