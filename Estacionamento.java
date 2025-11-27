import javax.swing.JOptionPane;

public class Estacionamento {
    int num;
    int qtdVagas;
    int qtdVagasDisponiveis;
    int qtdVagasOcupadas;

    public static Estacionamento registrarEstacionamento() {
        Estacionamento estacionamento = new Estacionamento();
        estacionamento.num = Integer.parseInt(JOptionPane.showInputDialog("Digite a numeração do estacionamento:"));
        estacionamento.qtdVagas =  Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade de vagas do estacionamento:"));
        return estacionamento;
    }
}
