package controller;

import java.util.ArrayList;
import model.bean.Devedor;
import model.dao.DevedorDao;

public class ControleDevedores implements IControleDevedores{
    
    public ArrayList<Devedor> listarDevedores(String username) {
        return DevedorDao.readDevedor(username);
    }
    
}
