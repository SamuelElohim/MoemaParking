public class Mensalista extends Clientes{

    private String senha;

    public Mensalista(String usuario, String placa, String senha, long tempoDeChegada, long tempoDeSaida) {
        super(usuario, placa, tempoDeChegada, tempoDeSaida);

        this.senha = senha;
    }

    @Override
    public String getSenha() {
        return senha;
        } 
    
    @Override
    public void setSenha(String senha) {
        this.senha = senha;
        UserList.jasonUpdate();
    }

}