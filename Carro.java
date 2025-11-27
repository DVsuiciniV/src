import javax.swing.JOptionPane;

public class Carro {
    String modelo;
    String marca;
    String cor;
    String placa;
    String proprietario;

    public static Carro criarCarro() {
        Carro carro = new Carro();
        carro.modelo = JOptionPane.showInputDialog("Digite o modelo do carro:");
        carro.marca = JOptionPane.showInputDialog("Digite a marca do carro:");
        carro.cor = JOptionPane.showInputDialog("Digite a cor do carro:");
        carro.placa = JOptionPane.showInputDialog("Digite a placa do carro:");
        carro.proprietario = JOptionPane.showInputDialog("Digite o nome do proprietario do carro:");
        return carro;
    }
}
