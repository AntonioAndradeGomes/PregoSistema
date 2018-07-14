
package controller;

public interface IControleLogin {
    
    public boolean controleLogin(String UserName, String senha);
    
    public void controleNovoUsuario();
    
    public boolean cadastarUsuario(String nome, String senha);
    
}
