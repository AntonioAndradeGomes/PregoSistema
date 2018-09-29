package controller;

import java.util.ArrayList;
import java.util.Date;
import model.bean.*;

public interface IControleDivida {
    public void cadastrarDivida(Devedor devedor, double valor, String especificacao, Date dataFechamento);
    public ArrayList<Divida> listarDividasDevedor(Devedor devedor);
    public ArrayList<Divida> listarDividasTodas(Usuario user);
    public boolean dividaPaga(Divida divida, Date data);
    public Divida buscarDivida(int codigo, Usuario user);
    public void excluirDivida(Divida divida);
    public void verificarAtraso(Usuario user);
}
