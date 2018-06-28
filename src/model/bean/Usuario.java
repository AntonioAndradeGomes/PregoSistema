package model.bean;
import java.util.ArrayList;

public class Usuario {
    private String nome;
    private ArrayList<Devedor> devedores;
    

    public Usuario(String nome)
    {
        this.nome = nome;
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
    
    
}
