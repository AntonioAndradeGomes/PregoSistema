package model.bean;

import java.util.ArrayList;

public class Devedor {

    private int id;
    private String nome, cidade, bairro, rua, complemento, telefone1, telefone2;
    private ArrayList<Divida> dividas;
    private Usuario usuario;

    public Devedor(Usuario usuario, String nome, String cidade, String bairro, String rua,
            String complemento, String telefone1, String telefone2) {
        this.dividas = new ArrayList<Divida>();
        this.nome = nome;
        this.cidade = cidade;
        this.bairro = bairro;
        this.rua = rua;
        this.complemento = complemento;
        this.telefone1 = telefone1;
        this.telefone2 = telefone2;
        this.usuario = usuario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getRua() {
        return rua;
    }

    public ArrayList<Divida> getDividas() {
        return dividas;
    }

    public void setDividas(ArrayList<Divida> dividas) {
        this.dividas = dividas;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getTelefone1() {
        return telefone1;
    }

    public void setTelefone1(String telefone1) {
        this.telefone1 = telefone1;
    }

    public String getTelefone2() {
        return telefone2;
    }

    public void setTelefone2(String telefone2) {
        this.telefone2 = telefone2;
    }

//    public void addDivida(Divida d) {
//        this.dividas.add(d);
//    }
}
