import java.util.ArrayList;
import junit.framework.TestCase;
import model.bean.Devedor;
import model.bean.Usuario;

public class TesteUsuario extends TestCase {

    private Usuario user;

    protected void setUp() throws Exception {
        //resto do codigo 
        super.setUp();
        System.out.println("setUp");
        user = new Usuario("nome", "senha");
    }

    public void testeGetNome() {
        System.out.println("Teste em getNome");
        assertEquals("nome", user.getNome());
    }

    public void testeGetSenha() {
        System.out.println("Teste em getSenha");
        assertEquals("senha", user.getSenha());
    }

    public void testeGetDevedores() {
        System.out.println("Teste em getDevedores");
        assertEquals(0, user.getDevedores().size());
        assertEquals(true,user.getDevedores().isEmpty());
    }

    public void testeSetNome() {
        System.out.println("Teste em setNome");
        this.user.setNome("Teste");
        assertEquals("Teste", user.getNome());
    }

    public void testeSetSenha() {
        System.out.println("Teste em setSenha");
        this.user.setSenha("teste");
        assertEquals("teste", user.getSenha());
    }

    public void testeSetDevedores() {
        System.out.println("Teste em setDevedores");
        Devedor teste = new Devedor(user, "Teste", "Teste", "Teste", "Teste", "Teste", "Teste", "Teste");
        ArrayList<Devedor> dev = new ArrayList<Devedor>();
        dev.add(teste);
        this.user.setDevedores(dev);
        assertEquals(1, user.getDevedores().size());
        assertEquals(false, user.getDevedores().isEmpty());
    }

    protected void tearDown() throws Exception {
        //resto do codigo
        System.out.println("tearDown");
    }
}
