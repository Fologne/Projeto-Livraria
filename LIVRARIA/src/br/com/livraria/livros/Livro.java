package br.com.livraria.livros;
public abstract class Livro{
    private String titulo;
    private String autor;
    private double preco;
    //constructor
    public Livro(String titulo, String autor, double preco){
        this.titulo = titulo;
        this.autor = autor;
        this.preco = preco;
    }
    //setters
    public void setTitulo(String titulo){this.titulo = titulo;}
    public void setAutor(String autor){this.autor = autor;}
    public void setPreco(double preco){this.preco = preco;}
    //getters
    public String getTitulo(){return titulo;}
    public String getAutor(){return autor;}
    public double getPreco(){return preco;}
}
