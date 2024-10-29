import java.util.Scanner;

public class Concurso {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
                System.out.print("Qual a quantidade de pessoas? ");
        int n = scanner.nextInt();
        scanner.nextLine(); // Consumir a nova linha

        String[] nomes = new String[n];
        double[] notaEtapa1 = new double[n];
        double[] notaEtapa2 = new double[n];
        double[] medias = new double[n];
        int aprovadosCount = 0;
        double somaMediasAprovados = 0.0;
        String nomeMaiorMedia = "";
        double maiorMedia = 0.0;

        for (int i = 0; i < n; i++) {
            System.out.println("Digite os dados da " + (i + 1) + "a pessoa:");
            System.out.print("Nome: ");
            nomes[i] = scanner.nextLine();
            System.out.print("Nota etapa 1: ");
            notaEtapa1[i] = scanner.nextDouble();
            System.out.print("Nota etapa 2: ");
            notaEtapa2[i] = scanner.nextDouble();
            scanner.nextLine(); // Consumir a nova linha

            medias[i] = (notaEtapa1[i] + notaEtapa2[i]) / 2;

            if (medias[i] >= 70) {
                aprovadosCount++;
                somaMediasAprovados += medias[i];
                
                if (medias[i] > maiorMedia) {
                    maiorMedia = medias[i];
                    nomeMaiorMedia = nomes[i];
                }
            }
        }

        System.out.println("\n### TABELA ###");
        for (int i = 0; i < n; i++) {
            System.out.printf("%s, %.2f, %.2f, MEDIA = %.2f%n", nomes[i], notaEtapa1[i], notaEtapa2[i], medias[i]);
        }

        System.out.println("\n### PESSOAS APROVADAS ###");
        for (int i = 0; i < n; i++) {
            if (medias[i] >= 70) {
                System.out.println(nomes[i]);
            }
        }

        double porcentagemAprovacao = (double) aprovadosCount / n * 100;

        System.out.printf("Porcentagem de aprovação: %.2f %%\n", porcentagemAprovacao);

        System.out.println("Maior média: " + nomeMaiorMedia);

        if (aprovadosCount > 0) {
            double mediaAprovados = somaMediasAprovados / aprovadosCount;
            System.out.printf("Nota média dos aprovados: %.2f%n", mediaAprovados);
        } else {
            System.out.println("Não há candidatos aprovados.");
        }

        scanner.close();
    }
}
