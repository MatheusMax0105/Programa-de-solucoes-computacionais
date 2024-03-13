package exerciciocardapio;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ExercicioCardapio {

    private List<ItemCardapio> itensCardapio;
    private Scanner scanner;
    private List<Pedido> pedidos;
    
    public ExercicioCardapio() {
        itensCardapio = new ArrayList<>();
        scanner = new Scanner(System.in);
        pedidos = new ArrayList<>();
        adicionarItemCardapio("Hotdog", 7.50);
        adicionarItemCardapio("Hamburguer", 13.00);
        adicionarItemCardapio("Suco", 3.70);
        adicionarItemCardapio("Refrigerante", 8.25);
    }

    public void adicionarItemCardapio(String nome, double preco) {
        itensCardapio.add(new ItemCardapio(nome, preco));
    }

    public void imprimirCardapio() {
        System.out.println("Cardápio do Restaurante:");
        for (int i = 0; i < itensCardapio.size(); i++) {
            ItemCardapio item = itensCardapio.get(i);
            System.out.println((i + 1) + ". " + item.getNome() + ", Preço: " + item.getPreco());
        }
    }

    public void fazerPedido() {
        while (true) {
            imprimirCardapio();
            System.out.println("Digite o número do item que deseja (ou 0 para sair):");
            int escolha = scanner.nextInt();

            if (escolha == 0) {
                System.out.println("Saindo do sistema...");
                break;
                
            } 
            else if (escolha > 0 && escolha <= itensCardapio.size()) {
                int indiceItem = escolha - 1;
                ItemCardapio itemSelecionado = itensCardapio.get(indiceItem);
                System.out.println("Você selecionou: " + itemSelecionado.getNome());
                System.out.println("Informe a quantidade desejada:");
                int quantidade = scanner.nextInt();

                
                double precoTotal = itemSelecionado.getPreco() * quantidade;
                System.out.println("Total: " + precoTotal);
                
                pedidos.add(new Pedido(itemSelecionado, quantidade));
                
            } 
            else {
                System.out.println("Opção inválida. Tente novamente.");
            }
        }
        
        double totalGeral = 0;
        for (Pedido pedido : pedidos) {
            totalGeral += pedido.getPrecoTotal();
      
        }
        
        System.out.println("-------------------");
        System.out.println("Total Geral dos Pedidos: " + totalGeral);
        
    }

    public static void main(String[] args) {
        ExercicioCardapio cardapio = new ExercicioCardapio();
        cardapio.fazerPedido();
    }
}

class ItemCardapio {

    private String nome;
    private double preco;

    public ItemCardapio(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }
}

class Pedido{
    private ItemCardapio item;
    private int quantidade;
    private double precoTotal;
    
public Pedido(ItemCardapio item, int quantidade){
    this.item = item;
    this.quantidade = quantidade;
    this.precoTotal = item.getPreco() * quantidade;
    }
public ItemCardapio getItem(){
    return item;
}
public int getQuantidade(){
    return quantidade;
}
public double getPrecoTotal(){
    return precoTotal;
}
}

