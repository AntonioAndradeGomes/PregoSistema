package controller;

import java.util.ArrayList;
import model.bean.Devedor;
import model.bean.Usuario;

public interface IControleDevedores {
    public ArrayList<Devedor> listarDevedores(String username);
    public boolean cadastrarDevedor(Devedor devedor);
    public boolean existeDevedor (String nome, String user);
    public Devedor buscaDedevor(Usuario user, String nome);
    public void excluirDevedor(Usuario user, Devedor devedor);
    public boolean atualizarDevedor(Usuario user, Devedor devedorAntigo, Devedor devedorNovo);
}
