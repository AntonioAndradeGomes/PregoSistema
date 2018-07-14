//execuções enquanto não há uma interface grafica e por eu não gostar de ficar codificando testes
import java.util.ArrayList;
import model.bean.Usuario;
import model.dao.UsuarioDao;


public class NewMain {

    public static void main(String[] args) {
        
        ArrayList<Usuario> usuarios = UsuarioDao.readUsuario();
        for (Usuario u : usuarios){
            System.out.println(u.getNome());
        }
        
    }
    
}
