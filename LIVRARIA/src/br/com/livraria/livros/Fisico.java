package br.com.livraria.livros;
public class Fisico extends Livro{
    private double peso;
    private int estoque;
    //constructor
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
}
