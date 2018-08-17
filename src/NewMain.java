
import java.util.ArrayList;
import java.util.Date;
import model.bean.Devedor;
import model.bean.Divida;
import model.dao.DevedorDao;
import model.dao.DividaDao;



public class NewMain {

    public static void main(String[] args) {
        ArrayList<Devedor> devedores = DevedorDao.readDevedor("Antonio");
        Divida divida = new Divida(devedores.get(0), 200, "cabos");
        divida.setDataAberturaAtual();
        divida.setStatus("Aberta");
        Date fechamento = new Date();
        divida.setData_fechamento(fechamento);
        System.out.println(fechamento);
        
    }
}
