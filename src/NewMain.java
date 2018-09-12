import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import model.bean.Divida;
import model.bean.Usuario;
import model.dao.DividaDao;
import model.dao.UsuarioDao;

public class NewMain {

    public static void main(String[] args) {
        Usuario user = UsuarioDao.readUsuario("Antonio");
        ArrayList<Divida> dividas = new ArrayList<Divida>();
        dividas = DividaDao.readDividas(user);
        Date dataV = dividas.get(1).getData_fechamento();
        status(dataV); 
    }
//algoritmo para verificação de divida atrasada, BREVE COLOCAR NO SISTEMA
    public static void status(Date data_fechamento) {
        Date dataSO = new Date();
        //trazendo para a classe calendar
        Calendar dataAtualSo = Calendar.getInstance();
        dataAtualSo.setTime(dataSO);
        
        Calendar dataFechamento = Calendar.getInstance();
        dataFechamento.setTime(data_fechamento);
        
        //algoritmo para ver se as datas de fechamento estão atrasadas
        if(dataAtualSo.get(Calendar.YEAR) > dataFechamento.get(Calendar.YEAR)){
            System.out.println("Data de fechamento " + data_fechamento + " atrasada em relação a atual");
        }else if ((dataAtualSo.get(Calendar.MONTH) > dataFechamento.get(Calendar.MONTH)) && 
                (dataAtualSo.get(Calendar.YEAR) == dataFechamento.get(Calendar.YEAR))){
            System.out.println("Data de fechamento " + data_fechamento + " atrasada em relação a atual");
        }else if ((dataAtualSo.get(Calendar.DATE) > dataFechamento.get(Calendar.DATE)) 
                && (dataAtualSo.get(Calendar.MONTH) == dataFechamento.get(Calendar.MONTH)) && 
                (dataAtualSo.get(Calendar.YEAR) == dataFechamento.get(Calendar.YEAR))){
            System.out.println("Data de fechamento " + data_fechamento + " atrasada em relação a atual");
        }else{
            System.out.println("Data de fechamento " + data_fechamento + " em prazo normal");
        }
    }
}
