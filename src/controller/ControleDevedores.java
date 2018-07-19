package controller;

import java.util.ArrayList;
import model.bean.Devedor;
import model.bean.Usuario;
import model.dao.*;

public class ControleDevedores implements IControleDevedores{
    
    public ArrayList<Devedor> listarDevedores(String username) {
        return DevedorDao.readDevedor(username);
    }

//    public boolean cadastrarDevedor(String user, String nome, String cidade, String bairro, String rua,
//            String complemento, String telefone1, String telefone2) {
//        Usuario usuario = DevedorDao.buscaUsuario(user);
//        Devedor devedor = new Devedor(usuario, nome, cidade, bairro, rua, complemento, telefone1, telefone2);
//        if(DevedorDao.create(devedor)){
//            return true;
//        }else{
//            return false;
//        }
//    }

    public Usuario buscaUsuario(String user) {
       return UsuarioDao.readUsuario(user);
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

   
    
}
