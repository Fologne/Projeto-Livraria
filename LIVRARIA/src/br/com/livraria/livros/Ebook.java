package br.com.livraria.livros;
import br.com.livraria.util.Vendavel;
public class Ebook extends Livro implements Vendavel{
    private double tamanhoArquivo;
    private String formato;
    //constructor
    public Ebook(){}
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
    //methods
    @Override
    public boolean vender(){
        System.out.println("Venda concluída com sucesso");
        return true;
    }
}
