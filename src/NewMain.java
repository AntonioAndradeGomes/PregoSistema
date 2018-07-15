//execuções enquanto não há uma interface grafica e por eu não gostar de ficar codificando testes
import java.util.ArrayList;
import model.bean.Usuario;
import model.dao.DevedorDao;
import model.dao.UsuarioDao;


public class NewMain {

    public static void main(String[] args) {
        
        Usuario usua = DevedorDao.buscaUsuario("Antonio");
        System.out.println(usua.getNome() + " " + usua.getSenha());
    }
    
}
