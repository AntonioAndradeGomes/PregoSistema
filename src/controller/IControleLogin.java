
package controller;

import model.bean.Usuario;

public interface IControleLogin {
    
    public boolean controleLogin(String UserName, String senha);
    
    public void controleNovoUsuario();
    
    public boolean cadastarUsuario(String nome, String senha);
    
    public void deletarUsuario(String UserName);
    
    public Usuario buscaUser(String UserName);
    
    public void atualizarUser(Usuario novo, Usuario antigo);
    
}
