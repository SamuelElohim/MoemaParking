public abstract class Clientes {

    private String usuario;
    private String placa;
    long tempoDeChegada;
    long tempoDeSaida;
    public Clientes() {
        
    }

    public Clientes (String usuario, String placa, long tempoDeChegada, long tempoDeSaida) {

        this.usuario = usuario;
        this.placa = placa;
        this.tempoDeChegada = tempoDeChegada;
        this.tempoDeSaida = tempoDeSaida;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
        UserList.jasonUpdate();
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
        UserList.jasonUpdate();
    }

    public boolean openMensalist() {
        return false;
    } 

    public long getTempoDeChegada() {
        return tempoDeChegada;
    }

    public void setTempoDeChegada(long tempoDeChegada) {
        this.tempoDeChegada = tempoDeChegada;
        UserList.jasonUpdate();
    }
    
    public long getTempoDeSaida() {
        return tempoDeSaida;
    }

    public void setTempoDeSaida(long tempoDeSaida) {
        this.tempoDeSaida = tempoDeSaida;
        UserList.jasonUpdate();
    }
    
    public abstract String getSenha();

    public abstract void setSenha(String senha);
        
    
}