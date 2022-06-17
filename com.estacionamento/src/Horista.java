public class Horista extends Clientes {

    public Horista(String usuario, String placa, long tempoDeChegada, long tempoDeSaida) {
        super(usuario, placa, tempoDeChegada, tempoDeSaida);

    }

    @Override
    public String getSenha() {
        return "";
    }

    @Override
    public void setSenha(String senha) {
        
    }
}
