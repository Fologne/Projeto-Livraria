package br.com.livraria.livros;
public class Ebook extends Livro{
    private double tamanhoArquivo;
    private String formato;
    //constructor
    public Ebook(String titulo, String autor, double preco, double tamanhoArquivo, String formato){
        super(titulo, autor, preco);
        this.tamanhoArquivo = tamanhoArquivo;
        this.formato = formato;
    }
    //setters
    public void setTamanhoArquivo(double tamanhoArquivo){this.tamanhoArquivo = tamanhoArquivo;}
    public void setFormato(String formato){this.formato = formato;}
    //getters
    public double getTamanhoArquivo(){return tamanhoArquivo;}
    public String getFormato(){return formato;}
}
