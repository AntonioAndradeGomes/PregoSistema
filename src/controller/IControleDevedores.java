package controller;

import java.util.ArrayList;
import model.bean.Devedor;

public interface IControleDevedores {
    public ArrayList<Devedor> listarDevedores(String username);
    
    
}
