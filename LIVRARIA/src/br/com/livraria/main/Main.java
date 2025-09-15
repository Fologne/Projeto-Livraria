package br.com.livraria.main;
import br.com.livraria.livros.*;
import br.com.livraria.exceptions.PrecoInvalidoException;
import br.com.livraria.util.Teclado;

import java.util.ArrayList;
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
                            case 1://feito
                                cadastroFisico(fisico);
                                break;
                            case 2://não feito
                                break;
                            case 0:
                                System.out.println("Voltando ao menu...");
                                break;
                        }
                    }while(escolha != 0);
                    escolha = 1;
                    break;
                case 2://venda = não feito
                    break;
                case 3://listagem = não feito
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
        //titulo autor preco peso estoque
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
}
