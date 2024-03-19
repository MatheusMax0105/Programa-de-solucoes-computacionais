package aluno;

import java.util.Scanner;

public class Aluno {
    private String nome;
    private int ra;
    private double a1;
    private double a2;
    private double a3;

    public void digitarDados() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Digite o nome do aluno: ");
            nome = scanner.nextLine();
            
            System.out.print("Digite o RA do aluno: ");
            ra = scanner.nextInt();
            
            System.out.print("Digite a nota da A1: ");
            a1 = scanner.nextDouble();
            
            System.out.print("Digite a nota da A2: ");
            a2 = scanner.nextDouble();
            
            System.out.print("Digite a nota da A3: ");
            a3 = scanner.nextDouble();
        }
    }

    public void calcularMedia() {
        double soma = a1 + a2 + a3;
        double media = soma / 3;

        System.out.printf("Media do aluno %s (RA %d): %.2f%n", nome, ra, media);
    }

    public static void main(String[] args) {
        Aluno aluno = new Aluno();
        aluno.digitarDados();
        aluno.calcularMedia();
    }
}
