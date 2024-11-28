import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SaladeCinema {
    private static char[][] Sala = new char[5][5];
    private static char Cliente = 'R';
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        List<Aluno> Cliente1 = new ArrayList<>();

        inicializarSala();
        mostrarSala();

        while (true) {
            int linha, coluna;
            do {

                System.out.print(Cliente + ", escolha a linha (1-5): ");
                linha = scanner.nextInt() - 1;
                System.out.print(Cliente + ", escolha a coluna (1-5): ");
                coluna = scanner.nextInt() - 1;
            } while (!validarLugares(linha, coluna));

            ComprarAssentos(linha, coluna);
            mostrarSala();

            if (verificarAcentos(Cliente)) {
                System.out.print("Digite o nome dos clientes (ou 'fim' para encerrar): ");
                String nome = scanner.nextLine();
                if (nome.equalsIgnoreCase("fim")) {
                    break;
                }

            }

            Cliente = (Cliente == 'R') ? 'L' : 'R';
        }
    }

    private static void inicializarSala() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                Sala[i][j] = 'L';
            }
        }
    }

    private static void mostrarSala() {
        System.out.println("---------------------");
        for (int i = 0; i < 5; i++) {
            System.out.print("| ");
            for (int j = 0; j < 5; j++) {
                System.out.print(Sala[i][j] + " | ");
            }
            System.out.println();
            System.out.println("---------------------");
        }
    }

    private static boolean validarLugares(int linha, int coluna) {
        if (linha < 0 || linha >= 5 || coluna < 0 || coluna >= 5) {
            System.out.println("Posição de assentos não Existente, escolha a linha (1-5) ");
            return false;
        }

        return true;
    }



    private static void ComprarAssentos(int linha, int coluna) {

    }

    private static boolean verificarAcentos(char Cliente) {
        for (int i = 0; i < 5; i++) {
            if (Sala[i][0] == Cliente && Sala[i][1] == Cliente && Sala[i][2] == Cliente && Sala[i][3] == Cliente && Sala[i][4] == Cliente) {
                return true;
            }
            if (Sala[0][i] == Cliente && Sala[1][i] == Cliente && Sala[2][i] == Cliente && Sala[3][i] == Cliente && Sala[4][i] == Cliente) {
                return true;
            }
        }
        if (Sala[0][0] == Cliente && Sala[1][1] == Cliente && Sala[2][2] == Cliente && Sala[3][3] == Cliente && Sala[4][4] == Cliente) {
            return true;
        }
        if (Sala[0][2] == Cliente && Sala[1][1] == Cliente && Sala[2][0] == Cliente && Sala[0][3] == Cliente && Sala[2][2] == Cliente && Sala[3][0] == Cliente && Sala[0][4] == Cliente && Sala[3][3] == Cliente && Sala[4][0] == Cliente) {
            return true;


        }
        return false;
    }
}

