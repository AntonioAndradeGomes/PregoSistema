import java.util.ArrayList;
import junit.framework.TestCase;
import model.bean.Devedor;
import model.bean.Divida;
import model.bean.Usuario;

public class TesteDevedor extends TestCase {

    private Usuario user = new Usuario("nome", "senha");
    private Devedor dev;

    protected void setUp() throws Exception {
        super.setUp();
        System.out.println("setUp");
        dev = new Devedor(user, "Teste", "Teste1", "Teste2", "Teste3", "Teste4", "Teste5", "Teste6");
        dev.setId(0); //não deveria mais testar o setId mais o professor pede!!
    }

    public void testeGetUser() {
        System.out.println("teste em GetUser");
        assertEquals("nome", dev.getUsuario().getNome());
        assertEquals("senha", dev.getUsuario().getSenha());
    }

    public void testeGetId() {
        System.out.println("Teste em getID");
        assertEquals(0, dev.getId());
    }

    public void testeGet() {
        System.out.println("Teste em demais Get's");
        assertEquals("Teste", dev.getNome());
        assertEquals("Teste1", dev.getCidade());
        assertEquals("Teste2", dev.getBairro());
        assertEquals("Teste3", dev.getRua());
        assertEquals("Teste4", dev.getComplemento());
        assertEquals("Teste5", dev.getTelefone1());
        assertEquals("Teste6", dev.getTelefone2());
    }

    public void testeSetUser() {
        System.out.println("Teste em set user");
        Usuario user2 = new Usuario("Code", "testes");
        dev.setUsuario(user2);
        assertEquals("Code", dev.getUsuario().getNome());
        assertEquals("testes", dev.getUsuario().getSenha());
    }

    public void testeSetId() {
        System.out.println("Teste em set Id");
        dev.setId(2);
        assertEquals(2, dev.getId());
    }

    public void testeSet() {
        System.out.println("Testes em demais Set's");
        dev.setNome("Cara");
        dev.setCidade("Ufal");
        dev.setBairro("Blocos");
        dev.setRua("Bloco c");
        dev.setComplemento("Cheio de salas");
        dev.setTelefone1("xxxxxxx");
        dev.setTelefone2("yyyyyy");
        assertEquals("Cara", dev.getNome());
        assertEquals("Ufal", dev.getCidade());
        assertEquals("Blocos", dev.getBairro());
        assertEquals("Bloco c", dev.getRua());
        assertEquals("Cheio de salas", dev.getComplemento());
        assertEquals("xxxxxxx", dev.getTelefone1());
        assertEquals("yyyyyy", dev.getTelefone2());
    }
    
    public void testeGetDividas() {
    	System.out.println("Teste em get Divida");
    	assertEquals(0, dev.getDividas().size());
    	assertEquals(true, dev.getDividas().isEmpty());
    }
    
    public void testeSetDividas() {
    	System.out.println("Teste em set Divida");
    	Divida d = new Divida(dev, 222, "teste");
    	ArrayList<Divida> dividas = dev.getDividas();
    	dividas.add(d);
    	dev.setDividas(dividas);
    	assertEquals(1, dev.getDividas().size());
    	assertEquals(false, dev.getDividas().isEmpty());
    }

    protected void tearDown() throws Exception {
        //resto do codigo
        System.out.println("tearDown");
    }
}
