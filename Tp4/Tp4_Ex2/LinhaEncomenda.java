public class LinhaEncomenda {
    
    private String referencia;
    private String descricao;
    private double preco;
    private int quantidade;
    private double imposto;
    private double desconto;

    //Construtores:
    // Construtor por omissão
    public LinhaEncomenda(){
        this.referencia = "";
        this.descricao = "";
        this.preco = 0;
        this.quantidade = 0;
        this.imposto = 0;
        this.desconto = 0;
    }

    //Construtor Parametrizado
    public LinhaEncomenda(String referencia, String descricao, double preco, 
    int quantidade, double imposto, double desconto){
        this.referencia = referencia;
        this.descricao = descricao;
        this.preco = preco;
        this.quantidade = quantidade;
        this.imposto = imposto;
        this.desconto = desconto;
    }

    //Construtor Cópia
    public LinhaEncomenda(LinhaEncomenda lE){
        this.referencia = lE.getReferencia();
        this.descricao = lE.getDescricao();
        this.preco = lE.getPreco();
        this.quantidade = lE.getQuantidade();
        this.imposto = lE.getImposto();
        this.desconto = lE.getDesconto();
    }

    //Getters e Setters:
    public String getReferencia(){
        return this.referencia;
    }

    public String getDescricao(){
        return this.descricao;
    }

    public double getPreco(){
        return this.preco;
    }

    public int getQuantidade(){
        return this.quantidade;
    }

    public double getImposto(){
        return this.imposto;
    }

    public double getDesconto(){
        return this.desconto;
    }

    public void setReferencia(String referencia){
        this.referencia = referencia;
    }

    public void setDescricao(String descricao){
        this.descricao = descricao;
    }

    public void setPreco(double preco){
        this.preco = preco;
    }

    public void setQuantidade(int quantidade){
        this.quantidade = quantidade;
    }

    public void setImposto(double imposto){
        this.imposto = imposto;
    }

    public void setDesconto(double desconto){
        this.desconto = desconto;
    }

    public String toString(){
        return "Referencia: " + this.referencia + "\n" +
               "Descrição: " + this.descricao + "\n" +
               "Preco: " + this.preco + "\n" +
               "Quantidade: " + this.imposto + "\n" +
               "Imposto: " + this.imposto + "\n" + 
               "Desconto: " + this.desconto + "\n";
    }

    public LinhaEncomenda clone(){
        return new LinhaEncomenda(this);
    }

    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || this.getClass() != o.getClass()) return false;
        LinhaEncomenda lE = (LinhaEncomenda) o;
        return(this.referencia == lE.referencia && this.descricao == lE.descricao && this.preco == lE.preco && 
        this.quantidade == lE.quantidade && this.imposto == lE.quantidade && this.desconto == lE.desconto);
    }

    // Método que calcula o valor da encomenda
    public double calculaValor(){
        return this.preco * this.quantidade * this.imposto * this.desconto;
    }
    // Método que calcula o valor do desconto
    public double calculaValorDesconto(){
        return this.preco - (this.preco * this.desconto);
    }
}

