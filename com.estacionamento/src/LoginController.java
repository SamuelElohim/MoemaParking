import java.io.IOException;

import arduino.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Paint;

public class LoginController {

    @FXML
    private TextField campoUsuario;

    @FXML
    private Button buttonExcluirCadastro;

    @FXML
    private TextField campoPlaca;

    @FXML
    private Button buttonExit;

    @FXML
    private Label labelPlaca;

    @FXML
    private Button buttonEntrar;

    @FXML
    private Label labelUsuario;

    @FXML
    private Label labelLogado;

    @FXML
    private Button buttonPlaca;

    @FXML
    private PasswordField campoSenha;

    @FXML
    private Label labelSenha;

    @FXML
    void corbuttonexit(ActionEvent event) {

    }

    @FXML
    void corbuttonPlaca(ActionEvent event) {

    }

    @FXML
    void entrarConta(ActionEvent event) throws InterruptedException {

        String placa = campoPlaca.getText();
        String usuario = campoUsuario.getText();
        String senha = campoSenha.getText();

        
        long tempoDeChegada = 0;

        Arduino obj = new Arduino("COM5", 115200);
        


        try {
            if(placa.length() < 1 || usuario.length() < 1) {
                throw new ExceptionCamposVazios();
            }
            if(UserList.isUserExist(placa)) {
                for (Clientes car : UserList.getCarro()) {
                    if(car instanceof Horista) {
                        if(senha.length() < 1) {
                            if (placa.equals(car.getPlaca()) && usuario.equals(car.getUsuario())) {

                                if (car.getTempoDeChegada() != 0 || car.getTempoDeSaida() != 0) {
                                    labelLogado.setText("Está dentro");
                                    labelUsuario.setText("");
                                    labelSenha.setText(" ");
                                    labelPlaca.setText("");
                                    break;
                                }
                                long now = System.currentTimeMillis();
                                System.out.println(now);
                                car.setTempoDeChegada(now);

                                labelLogado.setText("LOGADO");

                                ArduinoComands.abrirArduino();
                                ArduinoComands.openGate2();
                                ArduinoComands.fecharArduino();

                                labelUsuario.setText("");
                                labelSenha.setText(" ");
                                labelPlaca.setText("");
                                break;

                            } else {
                                labelLogado.setText("");
                                labelUsuario.setText("Usuário incorreto");
                                labelSenha.setText(" ");
                                labelPlaca.setText("");
                            }
                        }
                    }
                    if(car instanceof Mensalista) {

                            if (placa.equals(car.getPlaca()) && usuario.equals(car.getUsuario()) && senha.equals(car.getSenha())) {

                                if(car.getTempoDeChegada() != 0 || car.getTempoDeSaida() != 0){
                                    labelLogado.setText("Está dentro");
                                    labelUsuario.setText("");
                                    labelSenha.setText(" ");
                                    labelPlaca.setText("");
                                    break;
                                }
                                long now = System.currentTimeMillis();
                                System.out.println(now);
                                car.setTempoDeChegada(now);

                                labelLogado.setText("LOGADO");
                                labelUsuario.setText("");
                                labelSenha.setText(" ");
                                labelPlaca.setText("");

                                ArduinoComands.abrirArduino();
                                ArduinoComands.openGate2();
                                ArduinoComands.fecharArduino();


                                break;
                            } else if (senha.length() > 0) {
                                labelLogado.setText("");
                                labelUsuario.setText("Usuário ou senha incorreto");
                                labelSenha.setText(" ");
                                labelPlaca.setText("");
                            }

                    }
               }
            } 
            else {
                labelUsuario.setText("");
                labelSenha.setText(" ");
                labelPlaca.setText("NÃO CADASTRADA");
                labelLogado.setText("");
            }
        }
        catch (ExceptionCamposVazios camposVazios) {
            System.err.print(camposVazios + ": ");
            System.err.println("Campos vazios ");
            labelPlaca.setText("Campos vazios");
            labelLogado.setText("");
            labelUsuario.setText("");
            labelSenha.setText(" ");
        }
    }

    @FXML
    void excluirConta(ActionEvent event) throws Exception {
        String placa = campoPlaca.getText();
        String usuario = campoUsuario.getText();
        String senha = campoSenha.getText();

        

        try{
            if(UserList.isUserExist(placa)) {
            
                for (Clientes car : UserList.getCarro()) {
                    if(car instanceof Horista) {
                        if(placa.length() < 1 || usuario.length() < 1) {
                            throw new ExceptionCamposVazios();
        
                        }

                        if(car.getPlaca().equals(placa) && car.getUsuario().equals(usuario)) {
                            UserList.excluirCarro(car);
                            labelLogado.setText("Cadastro Excluído");
                            labelLogado.setTextFill(Paint.valueOf("#FF0000"));
                            labelUsuario.setText("");
                            labelSenha.setText(" ");
                            labelPlaca.setText("");

                        }
                        
                        
                    }
                    if(car instanceof Mensalista) {
                        if(placa.length() < 1 || usuario.length() < 1 ) {
                            throw new ExceptionCamposVazios();
                        } 

                        if(car.getPlaca().equals(placa) && car.getUsuario().equals(usuario) && car.getSenha().equals(senha)) {
                            UserList.excluirCarro(car);
                            labelLogado.setText("Cadastro Excluído");
                            labelLogado.setTextFill(Paint.valueOf("#FF0000"));
                            labelUsuario.setText("");
                            labelSenha.setText(" ");
                            labelPlaca.setText("");

                        }
                    }
                }  
           }
           else {
                throw new ExceptionCadastroInexistente();
           }
        }
        catch (ExceptionCamposVazios camposVazios) {
            System.err.print(camposVazios + ": ");
            System.err.println("Campos vazios");
            labelPlaca.setText("Campos vazios");
            labelLogado.setText(" ");
            labelSenha.setText(" ");
            labelUsuario.setText(" ");
        }
        catch (ExceptionCadastroInexistente cadastroInexistente) {
            System.err.print(cadastroInexistente + ": ");
            System.err.println("Cadastro inexistente");
            labelPlaca.setText("Cadastro inexistente");
            labelLogado.setText(" ");
            labelSenha.setText(" ");
            labelUsuario.setText(" ");
        }
        catch (RuntimeException a){
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
    void cortitulo(ActionEvent event) {

    }

    @FXML
    void corlabel(ActionEvent event) {

    }

    @FXML
    void corbuttonEntrar(ActionEvent event) {

    }

    @FXML
    void corbuttonExcluirCadastro(ActionEvent event) {

    }

    public void abrirexit() throws IOException {
        App open = new App();
        open.changeScene("Menu2.fxml");
    }
}