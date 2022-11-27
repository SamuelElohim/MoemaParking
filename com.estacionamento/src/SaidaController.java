import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Paint;

public class SaidaController {

    @FXML
    private Button buttonPagar;

    @FXML
    private TextField campoUsuario;

    @FXML
    private Button buttonexit;

    @FXML
    private TextField campoPlaca;

    @FXML
    private Label labelValor;

    @FXML
    private Button buttonValor;

    @FXML
    private Label labelPlaca;

    @FXML
    private Label labelUsuario;

    @FXML
    private Button buttonPlaca;

    @FXML
    private TextField campoSenha;

    @FXML
    private Label labelSenha;

    @FXML
    void corlabelSenha(ActionEvent event) {

    }

    @FXML
    void corlabelUsuario(ActionEvent event) {

    }

    @FXML
    void exit(ActionEvent event) throws IOException {
        abrirexit();
    }

   
    
    @FXML
    void pagar(ActionEvent event) throws IOException, InterruptedException {
        if(labelValor.getText().length() > 0 && !labelValor.getText().equals("Está fora do estacionamento")) {
            ArduinoComands.abrirArduino();
            ArduinoComands.openGate1();
            ArduinoComands.fecharArduino();

            abrirtelafinal();
        }
        else {
            labelPlaca.setText("Pagamento não realizado");
            labelValor.setText("");
            labelUsuario.setText(" ");
            labelSenha.setText(" ");
        }
    }

    @FXML
    void valoraPagar(ActionEvent event) {

        String placa = campoPlaca.getText();
        String usuario = campoUsuario.getText();
        String senha = campoSenha.getText();
        long tempoDeChegada = 0;
        long tempoDeSaida = 0;

        Mensalista aux = new Mensalista(usuario, placa, senha, tempoDeChegada, tempoDeSaida);

        if(UserList.isUserExist(aux)) {
            
            for (Clientes car : UserList.getCarro()) {
                if(car instanceof Horista) {
                    if(car.getTempoDeChegada() > 0) {
                        if(aux.getPlaca().equals(car.getPlaca()) && aux.getUsuario().equals(car.getUsuario()) && senha.length() < 1) {
                            long now = System.currentTimeMillis();
                            System.out.print(now);
                            car.setTempoDeSaida(now);
                            labelUsuario.setText("");
                            if(car.getTempoDeChegada() == 0) {
                                double valor = 0;
                                labelValor.setText(Double.toString(valor));
                                labelPlaca.setText("");
                                labelUsuario.setText(" ");
                                labelSenha.setText(" ");
                            }
                            else {
                                double valor = (((car.getTempoDeSaida() - car.getTempoDeChegada())/1000)*AlterarValor.getValorHora());

                                car.setTempoDeChegada(0);
                                car.setTempoDeSaida(0);

                                labelValor.setText(Double.toString(valor));
                                labelPlaca.setText("");
                                labelUsuario.setText(" ");
                                labelSenha.setText(" ");
                            }
                            break;
                        }
                        else {
                            labelValor.setText("");
                            labelUsuario.setText("Usuário incorreto");
                            labelPlaca.setText("");
                            labelSenha.setText(" ");
                        }
                    }
                    else {
                        labelValor.setTextFill(Paint.valueOf("#FF0000"));
                        labelValor.setText("Está fora do estacionamento");
                        labelUsuario.setText("");
                        labelPlaca.setText("");
                        labelSenha.setText(" ");
                    }
                }
                if(car instanceof Mensalista) {
                    if(car.getTempoDeChegada() > 0) {
                        if(aux.getPlaca().equals(car.getPlaca()) && aux.getUsuario().equals(car.getUsuario()) && aux.getSenha().equals(car.getSenha())) {
                            long now = System.currentTimeMillis();
                            System.out.print(now);
                            car.setTempoDeSaida(now);
                            car.setTempoDeChegada(0);
                            car.setTempoDeSaida(0);
                            labelValor.setText("Mensalista");
                            labelUsuario.setText("");
                            labelPlaca.setText("");
                            labelSenha.setText(" ");
                            break;
                        }
                        else {
                            labelValor.setText("");
                            labelUsuario.setText("Usuário ou senha incorreto");
                            labelPlaca.setText("");
                            labelSenha.setText(" ");
                        }
                    }
                    else {
                        labelValor.setTextFill(Paint.valueOf("#FF0000"));
                        labelValor.setText("Está fora do estacionamento");
                        labelUsuario.setText("");
                        labelPlaca.setText("");
                        labelSenha.setText(" ");
                    }
                }
            }
        }
        else {
            labelPlaca.setText("PLACA NÃO CADASTRADA");
            labelUsuario.setText("");
            labelSenha.setText(" ");
            labelValor.setText("");
        }
    }

    @FXML
    void lerPlaca(ActionEvent event) throws InterruptedException {
        ArduinoComands.abrirArduino();
        campoPlaca.setText(ArduinoComands.getRFIDreading().toLowerCase());
        ArduinoComands.fecharArduino();
    }

    @FXML
    void corbuttonPagar(ActionEvent event) {

    }

    @FXML
    void corbuttonValor(ActionEvent event) {

    }

    @FXML
    void corlabelPlaca(ActionEvent event) {

    }

    public void abrirexit() throws IOException {
        App open = new App();
        open.changeScene("Menu2.fxml");
    }

    public void abrirtelafinal() throws IOException {
        App open = new App();
        open.changeScene("TelaFinal.fxml");
    }
}