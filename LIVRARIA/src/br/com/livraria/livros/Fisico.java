package br.com.livraria.livros;
import br.com.livraria.util.Vendavel;
public class Fisico extends Livro implements Vendavel{
    private double peso;
    private int estoque;
    //constructor
    public Fisico(){}
    public Fisico(String titulo, String autor, double preco, double peso, int estoque){
        super(titulo, autor, preco);
        this.peso = peso;
        this.estoque = estoque;
    }
    //setters
    public void setPeso(double peso){this.peso = peso;}
    public void setEstoque(int estoque){this.estoque = estoque;}
    //getters
    public double getPeso(){return peso;}
    public int getEstoque(){return estoque;}
    //methods
    public double calcularDesconto(){
        double desconto = this.peso * 0.5;
        return desconto;
    }
    @Override
    public boolean vender(){
        if (this.estoque > 0){
            this.estoque--;
            return true;
        }else{
            return false;
        }
    }
}
