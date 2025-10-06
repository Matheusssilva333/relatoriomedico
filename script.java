package  RelatorioMedico;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Paciente {
    String nome;
    String sexo;
    double peso;
    int idade;
    double altura;

    public Paciente(String nome, String sexo, double peso, int idade, double altura) {
        this.nome = nome;
        this.sexo = sexo.toLowerCase();
        this.peso = peso;
        this.idade = idade;
        this.altura = altura;
    }
}

public class RelatorioMedico {
    public static void main(String[] args) {
        List<Paciente> pacientes = new ArrayList<>();
        Scanner ler = new Scanner(System.in);

        int opcao;

        do {
            System.out.println("\nMENU");
            System.out.println("==========");
            System.out.println("1 - Ver a quantidade de pacientes");
            System.out.println("2 - Cadastrar paciente");
            System.out.println("3 - Ver a média de idade dos homens");
            System.out.println("4 - Ver a quantidade de mulheres com altura entre 1.60 e 1.70 e com peso acima de 70kg");
            System.out.println("5 - Ver quantidade de pessoas com idade entre 10 e 25");
            System.out.println("6 - Ver nome do paciente mais velho");
            System.out.println("7 - Ver nome da mulher mais baixa");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = ler.nextInt();
            ler.nextLine(); // Limpar buffer

            switch (opcao) {
                case 1:
                    System.out.println("Quantidade de pacientes: " + pacientes.size());
                    break;
                case 2:
                    System.out.print("Digite o nome do paciente: ");
                    String nome = ler.nextLine();
                    System.out.print("Digite o sexo do paciente (M/F): ");
                    String sexo = ler.nextLine();
                    System.out.print("Digite o peso do paciente (kg): ");
                    double peso = ler.nextDouble();
                    System.out.print("Digite a idade do paciente: ");
                    int idade = ler.nextInt();
                    System.out.print("Digite a altura do paciente (ex: 1.70): ");
                    double altura = ler.nextDouble();
                    ler.nextLine(); // Limpar buffer

                    pacientes.add(new Paciente(nome, sexo, peso, idade, altura));
                    System.out.println("Paciente cadastrado com sucesso!");
                    break;
                case 3:
                    int somaIdades = 0;
                    int qtdHomens = 0;
                    for (Paciente p : pacientes) {
                        if (p.sexo.equals("m")) {
                            somaIdades += p.idade;
                            qtdHomens++;
                        }
                    }
                    if (qtdHomens > 0) {
                        System.out.println("Média de idade dos homens: " + (somaIdades / (double) qtdHomens));
                    } else {
                        System.out.println("Nenhum homem cadastrado.");
                    }
                    break;
                case 4:
                    int contMulheres = 0;
                    for (Paciente p : pacientes) {
                        if (p.sexo.equals("f") && p.altura >= 1.60 && p.altura <= 1.70 && p.peso > 70) {
                            contMulheres++;
                        }
                    }
                    System.out.println("Quantidade de mulheres com altura entre 1.60 e 1.70 e peso acima de 70kg: " + contMulheres);
                    break;
                case 5:
                    int contIdade = 0;
                    for (Paciente p : pacientes) {
                        if (p.idade >= 10 && p.idade <= 25) {
                            contIdade++;
                        }
                    }
                    System.out.println("Quantidade de pessoas com idade entre 10 e 25: " + contIdade);
                    break;
                case 6:
                    if (pacientes.isEmpty()) {
                        System.out.println("Nenhum paciente cadastrado.");
                    } else {
                        Paciente maisVelho = pacientes.get(0);
                        for (Paciente p : pacientes) {
                            if (p.idade > maisVelho.idade) {
                                maisVelho = p;
                            }
                        }
                        System.out.println("Paciente mais velho: " + maisVelho.nome);
                    }
                    break;
                case 7:
                    Paciente mulherMaisBaixa = null;
                    for (Paciente p : pacientes) {
                        if (p.sexo.equals("f")) {
                            if (mulherMaisBaixa == null || p.altura < mulherMaisBaixa.altura) {
                                mulherMaisBaixa = p;
                            }
                        }
                    }
                    if (mulherMaisBaixa != null) {
                        System.out.println("Nome da mulher mais baixa: " + mulherMaisBaixa.nome);
                    } else {
                        System.out.println("Nenhuma mulher cadastrada.");
                    }
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 0);

        ler.close();
    }
}
