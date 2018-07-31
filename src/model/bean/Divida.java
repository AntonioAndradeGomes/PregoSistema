package model.bean;

import java.util.Date;

public class Divida {
    private long id;
    private Devedor devedor;
    private double valor;
    private String especificacao, status;
    private Date data_abertura, data_fechamento, data_pagamento;

    public Divida(Devedor devedor, double valor, String especificacao) //data de fechamento não é passado na construção do objeto
    //ja que o usuario pode não passar essa data, e haver somente dois status (pago, não pago)
    {
        //data de fechamento - data em que usuario acredita ser pago
        //data de pagamento - data em que o status foi mudado para pago
        this.devedor = devedor;
        this.valor = valor;
        this.especificacao = especificacao;
    }
//pra quando pegar as dividas do bd
    public void setData_abertura(Date data_abertura) {
        this.data_abertura = data_abertura;
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
        this.status = status;//só pode ser aberto, fechado ou em atraso(data corrente > data de fechamento
                            //data de fachamento == null, só pode ser aberto ou fechado
    }

    public void setData_fechamento(Date data_fechamento) {
        this.data_fechamento = data_fechamento;
    }

    public void setData_pagamento(Date data_pagamento) {
        this.data_pagamento = data_pagamento;
    }
    
//para quando criar as dividas como obejto no sistema 
    public void setDataAberturaAtual() {
        Date data_Abertura = new Date(); //pega a data e hota atual do SO e salva na variavel
        this.data_abertura = data_Abertura;
        /*
        /No momento de enviar pro banco de dados formatar a data para yyyy-mm-dd
        /SimpleDateFormat formato = new SimpleDateFormat("yyyy/MM/dd");
        /data = formato.parse(dataInicio);
         */
    }
    
    public void setSemFechamento(){
        this.data_fechamento = null;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    
    
}
