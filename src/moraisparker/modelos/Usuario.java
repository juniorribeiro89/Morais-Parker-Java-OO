package moraisparker.modelos;

public class Usuario {
    
    private String usuario;
    private String senha;

    public Usuario() {

    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "Usuario: {" + "usuario: " + usuario + '}';
    }
    
    
    
}
