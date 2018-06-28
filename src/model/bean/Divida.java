package model.bean;
import java.util.Date;

public class Divida {
    private Devedor devedor;
    private double valor;
    private String especificacao, status;
    private Date data_abertura, data_fechamento, data_pagamento;

    public Divida(Devedor devedor, double valor, String especificacao,
            Date data_fechamento, Date data_pagamento) 
    {
        this.devedor = devedor;
        this.valor = valor;
        this.especificacao = especificacao;
        this.setDataAbertura();
        this.setStatus("aberta");
        this.data_fechamento = data_fechamento;
        this.data_pagamento = data_pagamento;
    }

    public Devedor getDevedor() {
        return devedor;
    }

    public void setDevedor(Devedor devedor) {
        this.devedor = devedor;
    }

    public double getValor() {
        return valor;
    }

    public String getEspecificacao() {
        return especificacao;
    }

    public String getStatus() {
        return status;
    }

    public Date getData_abertura() {
        return data_abertura;
    }

    public Date getData_fechamento() {
        return data_fechamento;
    }

    public Date getData_pagamento() {
        return data_pagamento;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public void setEspecificacao(String especificacao) {
        this.especificacao = especificacao;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setData_fechamento(Date data_fechamento) {
        this.data_fechamento = data_fechamento;
    }

    public void setData_pagamento(Date data_pagamento) {
        this.data_pagamento = data_pagamento;
    }
    
    private void setDataAbertura(){
        Date data_Abertura = new Date(); //pega a data e hota atual do SO e salva na variavel
        this.data_abertura = data_Abertura;
        /*
        /No momento de enviar pro banco de dados formatar a data para yyyy-mm-dd
        /SimpleDateFormat formato = new SimpleDateFormat("yyyy/MM/dd");
        /data = formato.parse(dataInicio);
        */
    }
}
