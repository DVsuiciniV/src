import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JOptionPane;

public class Estacionamento {
    int num;
    int qtdVagas;
    int qtdVagasDisponiveis;
    int qtdVagasOcupadas;

    public static Estacionamento registrarEstacionamento(String raiz) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new FileReader(raiz));
        int num = Integer.parseInt(br.readLine());
        Estacionamento estacionamento = new Estacionamento();
        estacionamento.num = num + 1;
        estacionamento.qtdVagas = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade de vagas do estacionamento:"));
        estacionamento.qtdVagasDisponiveis = estacionamento.qtdVagas;
        if(num != estacionamento.num){
            try(PrintWriter pw = new PrintWriter(new FileWriter(raiz))){
                pw.print(estacionamento.num+"");
            } catch (IOException e){
                e.printStackTrace();
            }
        }
        return estacionamento;
    }
}
