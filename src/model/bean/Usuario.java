package model.bean;
import java.util.ArrayList;

public class Usuario {
    private String nome;
    private String senha;
    private ArrayList<Devedor> devedores;
    
    public Usuario(String nome, String senha)
    {
        this.nome = nome;
        this.senha = senha;
        this.devedores = new ArrayList<Devedor>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<Devedor> getDevedores() {
        return devedores;
    }

    public void setDevedores(ArrayList<Devedor> devedores) {
        this.devedores = devedores;
    }
    
    public void addDevedores(Devedor d){
        this.devedores.add(d);
    }
    
    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
}
