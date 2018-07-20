package controller;

import java.util.ArrayList;
import model.bean.Devedor;
import model.bean.Usuario;
import model.dao.*;

public class ControleDevedores implements IControleDevedores{
    
    public ArrayList<Devedor> listarDevedores(String username) {
        return DevedorDao.readDevedor(username);
    }

    public boolean cadastrarDevedor(Devedor devedor) {
        if(DevedorDao.create(devedor)){
            return true;
        }else{
            return false;
        }
    }

    public boolean existeDevedor(String nome, String user) {
       if(DevedorDao.nomeIgual(nome, user)){
           return false;
       }else{
           return true;
       }
    }

    public Devedor buscaDedevor(Usuario user, String nome) {
        return DevedorDao.buscarDevedorEspeci(user, nome);
    }

   
    
}
