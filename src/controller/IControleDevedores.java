package controller;

import java.util.ArrayList;
import model.bean.Devedor;
import model.bean.Usuario;

public interface IControleDevedores {
    public ArrayList<Devedor> listarDevedores(String username);
    public boolean cadastrarDevedor(Devedor devedor);
//    public boolean cadastrarDevedor(String user, String nome, String cidade, String bairro, String rua,
//            String complemento, String telefone1, String telefone2);
    public Usuario buscaUsuario(String user);
    public boolean existeDevedor (String nome, String user);
    
}
