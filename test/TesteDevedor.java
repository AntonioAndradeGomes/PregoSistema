
import java.util.ArrayList;
import junit.framework.TestCase;
import model.bean.Devedor;
import model.bean.Usuario;

public class TesteDevedor extends TestCase {
    
    private Usuario user = new Usuario("nome", "senha");
    private Devedor dev;
    protected void setUp() throws Exception {
        super.setUp();
        System.out.println("setUp");
        dev = new Devedor(user, "Teste", "Teste", "Teste", "Teste", "Teste", "Teste", "Teste");
        dev.setId(0); //não deveria mais testar o setId mais o professor pede!!
    }

    private void testeGetUser(){
        System.out.println("teste em GetUser");
        
    }
    protected void tearDown() throws Exception {
        //resto do codigo
        System.out.println("tearDown");
    }
}
