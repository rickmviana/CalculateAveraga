package application;

import utils.Calculate; // Importa a classe Calculate do pacote utils

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US); // Configura o local para aceitar o padrão de ponto flutuante dos Estados Unidos
        Scanner scanner = new Scanner(System.in); // Cria um objeto Scanner para entrada do teclado
        scanner.useLocale(Locale.US); // Configura o Scanner para usar o padrão de ponto flutuante dos Estados Unidos

        System.out.print("Quantos alunos? "); // Pede ao usuário para inserir o número de alunos
        int numberStudants = scanner.nextInt(); // Lê o número de alunos fornecido pelo usuário
        scanner.nextLine(); // Limpa o buffer do Scanner

        Calculate calculate = new Calculate(); // Cria um objeto Calculate para calcular as médias das notas dos alunos

        // Loop para solicitar os dados de cada aluno
        for (int i = 0; i < numberStudants; i++){
            System.out.print("Digite o nome do " +(i+1)+ "° Aluno: "); // Pede ao usuário para inserir o nome do aluno
            String nome = scanner.nextLine(); // Lê o nome do aluno fornecido pelo usuário

            List<Double> notas = new ArrayList<>(); // Cria uma lista para armazenar as notas do aluno

            // Loop para solicitar as notas do aluno
            for (int j = 0; j < 3; j++) {
                System.out.print("Digite a nota " + (j + 1) + " do aluno " + nome + ": "); // Pede ao usuário para inserir a nota do aluno
                double nota = scanner.nextDouble(); // Lê a nota do aluno fornecida pelo usuário
                scanner.nextLine(); // Limpa o buffer do Scanner
                notas.add(nota); // Adiciona a nota à lista de notas do aluno
            }

            calculate.addNotas(nome, notas); // Adiciona as notas do aluno ao objeto Calculate
        }

        System.out.println("Dados dos Alunos");

        // Loop para exibir os dados de cada aluno
        for (String nome : calculate.getNomesAlunos()){
            double media = calculate.mediaNotaAluno(nome); // Calcula a média das notas do aluno
            System.out.println("Nome: " + nome + ", Média: " + String.format("%.2f", media)); // Exibe o nome e a média das notas do aluno
        }

        scanner.close(); // Fecha o Scanner para liberar recursos
    }
}
