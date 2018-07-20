//execuções enquanto não há uma interface grafica e por eu não gostar de ficar codificando testes
import java.util.ArrayList;
import model.bean.*;
import model.dao.*;

public class NewMain {

    public static void main(String[] args) {
        ArrayList<Devedor> lista = DevedorDao.readDevedor("Antonio");
        for (Devedor d: lista){
            System.out.println(d.getId() + " " + d.getNome());
        }
    }
    
}
