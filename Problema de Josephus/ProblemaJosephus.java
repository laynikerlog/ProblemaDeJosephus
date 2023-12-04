import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.List;

class Pessoa {
    int numero;
    String nome;
    String telefone;
    String endereco;
    String cpf;

    public Pessoa(int numero, String nome, String telefone, String endereco, String cpf) {
        this.numero = numero;
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
        this.cpf = cpf;
    }
}

public class ProblemaJosephus {

    public static void main(String[] args) {
        // Número total de pessoas na roda
        int n = 20;

        // Solicitar ao usuário que insira o valor de m 
        String inputM = JOptionPane
                .showInputDialog("Insira o valor de m (número de pessoas a serem puladas antes de eliminar alguém):");

        // Converter a entrada do usuário para um inteiro
        int m = Integer.parseInt(inputM);

        // Criando uma lista de pessoas
        List<Pessoa> roda = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            roda.add(new Pessoa(i, "Nome" + i, "Telefone" + i, "Endereco" + i, "CPF" + i));
        }

        // Chama o método para encontrar a pessoa sobrevivente
        Pessoa sobrevivente = encontrarSobrevivente(roda, m);

        // Exibir o número da pessoa sobrevivente 
        JOptionPane.showMessageDialog(null, "A pessoa sobrevivente é a de número: " + sobrevivente.numero);
    }

    // Função para encontrar a pessoa sobrevivente usando o algoritmo de Josephus
    private static Pessoa encontrarSobrevivente(List<Pessoa> roda, int m) {
        int index = 0;

        while (roda.size() > 1) {
            // Calcula o próximo índice a ser removido
            index = (index + m - 1) % roda.size();

            // Remove a pessoa na posição calculada
            roda.remove(index);
        }

        // Retorna a pessoa sobrevivente
        return roda.get(0);
    }
}
