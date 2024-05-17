// Já tinha feito este exercício da forma proposta na ficha 3
import java.time.LocalDate;
import java.util.ArrayList;

public class Encomenda {
    
    private String nome;
    private String nif;
    private String morada;
    private int numEnc;
    private LocalDate data;
    private ArrayList<LinhaEncomenda> encomenda;

    //Construtores:
    // Construtor por Omissão
    public Encomenda(){
        this.nome = "";
        this.nif = "";
        this.morada = "";
        this.numEnc = 0;
        this.data = LocalDate.now();
        this.encomenda = new ArrayList<>();
    }

    // Construtor Parametrizado
    public Encomenda(String nome, String nif, String morada, int numEnc, LocalDate data, ArrayList<LinhaEncomenda> encomenda){
        this.nome = nome;
        this.nif = nif;
        this.morada = morada;
        this.numEnc = numEnc;
        this.data = data;
        this.encomenda = encomenda;
    }

    // Construtor Cópia
    public Encomenda(Encomenda e){
        this.nome = e.getNome();
        this.nif = e.getNif();
        this.morada = e.getMorada();
        this.numEnc = e.getNumEnc();
        this.data = e.getData();
        this.encomenda = e.getEncomenda();
    }

    //Getters e Setters:
    public String getNome(){
        return this.nome;
    }

    public String getNif(){
        return this.nif;
    }

    public String getMorada(){
        return this.morada;
    }

    public int getNumEnc(){
        return this.numEnc;
    }   

    public LocalDate getData(){
        return this.data;
    }       

    public ArrayList<LinhaEncomenda> getEncomenda(){
        return this.encomenda;
    }   

    public void setNome(String nome){
        this.nome = nome;
    }

    public void setNif(String nif){
        this.nif = nif;
    }

    public void setMorada(String morada){
        this.morada = morada;
    }

    public void setNumEnc(int numEnc){
        this.numEnc = numEnc;
    }

    public void setData(LocalDate data){
        this.data = data;
    }

    public void setEncomenda(ArrayList<LinhaEncomenda> encomenda){
        this.encomenda = encomenda;
    }

    public Encomenda clone(){
        return new Encomenda(this);
    }

    public String toString(){
        return "Nome: " + this.nome + "\n" +
               "NIF: " + this.nif + "\n" +
               "Morada: " + this.morada + "\n" +
               "Número de Encomenda: " + this.numEnc + "\n" +
               "Data: " + this.data + "\n" +
               "Encomenda: " + this.encomenda.toString() + "\n";
    }

    public boolean equals(Object o){
        if (this == o) return true;
        if ((o == null) || (this.getClass() != o.getClass())) return false;
        Encomenda e = (Encomenda) o;
        return this.nome.equals(e.getNome()) &&
               this.nif.equals(e.getNif()) &&
               this.morada.equals(e.getMorada()) &&
               this.numEnc == e.getNumEnc() &&
               this.data.equals(e.getData()) &&
               this.encomenda.equals(e.getEncomenda());
    }

    // Métodos:
    // Método que calcula o valor total da Encomenda
    public double calculaValorTotal(){
        double soma = 0;
        for(LinhaEncomenda linha : this.encomenda){
            soma += linha.calculaValor();
        }
        return soma;
    }
    
    //Método que calcula o valor total do desconto da Encomenda
    public double calculaValorDesconto(){
        double soma = 0;
        for(LinhaEncomenda linha : this.encomenda){
            soma += linha.calculaValorDesconto();
        }
        return soma;
    }

    //Método que conta o numero total de produtos;
    public int numeroTotalProdutos(){
        int soma = 0;
        for(LinhaEncomenda linha : this.encomenda){
            soma += linha.getQuantidade();
        }
        return soma;
    }
    
    // Verificar se um determinado produto está na encomenda
    public boolean existeProdutoEncomenda(String refProduto){
        for(LinhaEncomenda linha : this.encomenda){
            if(refProduto == linha.getReferencia()) return true;
        }
        return false;
    }

    // Adicionar uma linha de encomenda à encomenda
    public void adicionaLinha(LinhaEncomenda linha){
        this.encomenda.add(linha);
    }

    // Remove uma linha de encomenda à encomenda
    public void removeProduto(String codProd){
        for(int i = 0; i < this.encomenda.size(); i++){
            if(this.encomenda.get(i).getReferencia() == codProd){
                this.encomenda.remove(i);
                break;
            }
        }
    }
}
