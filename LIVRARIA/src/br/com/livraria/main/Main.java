package br.com.livraria.main;
import br.com.livraria.livros.*;
import br.com.livraria.exceptions.PrecoInvalidoException;
import br.com.livraria.util.Teclado;

import java.util.ArrayList;
import java.util.Objects;
public class Main{
    public static void main(String[] args){
        ArrayList <Fisico> fisico = new ArrayList<>();
        ArrayList <Ebook> ebook = new ArrayList<>();
        int escolha;
        do{
            escolha = Teclado.LerInteiro("Digite\n1 para cadastrar um livro\n2 para realizar uma venda\n3 para listar livros cadastrados\n4 para aumentar o estoque de um livro\n0 para sair");
            switch(escolha){
                case 1://cadastro = não feito
                    do{
                        escolha = Teclado.LerInteiro("Digite\n1 para cadastrar um livro fisico\n2 para cadastrar um ebook\n0 para sair");
                        switch(escolha){
                            case 1:
                                cadastroFisico(fisico);
                                break;
                            case 2:
                                cadastroEbook(ebook);
                                break;
                            case 0:
                                System.out.println("Voltando ao menu...");
                                break;
                        }
                    }while(escolha != 0);
                    escolha = 1;
                    break;
                case 2:
                    venda(fisico, ebook);
                    break;
                case 3://listagem = não feito
                    listagem(fisico, ebook);
                    break;
                case 4://aumento de estoque = não feito
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
            }
        }while(escolha != 0);
    }
    public static void cadastroFisico(ArrayList <Fisico> fisico){
        String titulo = Teclado.LerString("Digite o titulo do livro");
        String autor = Teclado.LerString("Digite o nome do autor do livro");
        double preco, peso;
        int estoque;
        while(true){//preco
            String s = Teclado.LerString("Digite o preco do livro (ex: 39,90):").replace(",", ".").trim();
            try{
                preco = Double.parseDouble(s);
                Fisico livro = new Fisico();
                livro.setPreco(preco);
                break;
            }catch(NumberFormatException e){
                System.out.println("Preço inválido");
            }catch (PrecoInvalidoException e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }
        while(true){//peso
            String s = Teclado.LerString("Digite o peso do livro (ex: 1,3)").replace(",", ".").trim();
            try{
                peso = Double.parseDouble(s);
                break;
            }catch(NumberFormatException e){
                System.out.println("Peso inválido");
            }
        }
        while(true){//estoque
            String s = Teclado.LerString("Digite o estoque do livro (ex: 45)").trim();
            try{
                estoque = Integer.parseInt(s);
                break;
            }catch(NumberFormatException e){
                System.out.println("Estoque inválido");
            }
        }
        Fisico novo = new Fisico(titulo, autor,preco,peso,estoque);
        fisico.add(novo);
    }
    public static void cadastroEbook(ArrayList <Ebook> ebook){
        String titulo = Teclado.LerString("Digite o titulo do livro");
        String autor = Teclado.LerString("Digite o nome do autor do livro");
        double preco, tamanho;
        while(true){//preco
            String s = Teclado.LerString("Digite o preco do livro (ex: 39,90):").replace(",", ".").trim();
            try{
                preco = Double.parseDouble(s);
                Ebook livro = new Ebook();
                livro.setPreco(preco);
                break;
            }catch(NumberFormatException e){
                System.out.println("Preço inválido");
            }catch(PrecoInvalidoException e){
                System.out.println("Erro: " + e.getMessage());
            }
        }
        while(true){//tamanho
            String s = Teclado.LerString("Digite o tamanho do arquivo do livro em MB (ex: 25)").replace(",", ".").trim();
            try{
                tamanho = Double.parseDouble(s);
                break;
            }catch(NumberFormatException e){
                System.out.println("Tamanho inválido");
            }
        }
        String formato = Teclado.LerString("Digite o formato do livro (ex: PDF)");
        Ebook novo = new Ebook(titulo, autor, preco, tamanho, formato);
        ebook.add(novo);
    }
    public static void venda(ArrayList <Fisico> fisico, ArrayList <Ebook> ebook){
        int escolha;
        do{
            escolha = Teclado.LerInteiro("Digite\n1 para vender um livro fisico\n2 para vender um ebook\n0 para voltar");
            switch(escolha){
                case 1:
                    vFisico(fisico);
                    break;
                case 2:
                    vEbook(ebook);
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
            }
        }while(escolha != 0);
    }
    public static void vFisico(ArrayList <Fisico> fisico){
        String nome = Teclado.LerString("Digite o nome do livro que deseja vender");
        for(int i = 0; i < fisico.size(); i++){
            if(Objects.equals(fisico.get(i).getTitulo(), nome)){
                fisico.get(i).vender();
                return;
            }
        }
        System.out.println("Não foi achado um livro com esse nome");
    }
    public static void vEbook(ArrayList <Ebook> ebook){
        String nome = Teclado.LerString("Digite o nome do ebook que deseja vender");
        for(int i = 0; i < ebook.size(); i++){
            if(Objects.equals(ebook.get(i).getTitulo(), nome)){
                ebook.get(i).vender();
                return;
            }
        }
        System.out.println("Não foi achado um livro com esse nome");
    }
    public static void listagem(ArrayList <Fisico> fisico, ArrayList <Ebook> ebook){
        System.out.println("Livros fisicos:");
        for(int i = 0; i < fisico.size(); i++){
            System.out.println("Titulo: " + fisico.get(i).getTitulo() + "\nAutor: " + fisico.get(i).getAutor() + "\nPreço: " + fisico.get(i).getPreco());
            System.out.println("Peso: " + fisico.get(i).getPeso() + "\nEstoque: " + fisico.get(i).getEstoque() + "\n");
        }
        System.out.println("Livros digitais (Ebook):");
        for(int i = 0; i < ebook.size(); i++){
            System.out.println("Titulo: " + ebook.get(i).getTitulo() + "\nAutor: " + ebook.get(i).getAutor() + "\nPreço: " + ebook.get(i).getPreco());
            System.out.println("Tamanho do arquivo: " + ebook.get(i).getTamanhoArquivo() + "\nFormato: " + ebook.get(i).getFormato());
        }
    }
}
