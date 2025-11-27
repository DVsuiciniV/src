import javax.swing.JOptionPane;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.FileReader;
import java.util.Random;

public class App {
    public static void main(String[] args) throws Exception {
        String raiz = "Estabelecimento/";
        String raizTickets = raiz + "Tickets/";
        String raizEstacionamento = raiz + "Estacionamento/";
        criarDiretorios(raiz, raizTickets, raizEstacionamento);
        Estacionamento estacionamento = new Estacionamento();
        switch (exibirMenu()) {
            case 1:
                switch (exibirMenuTickets()) {
                    case 1:
                        int id = 
                        System.out.println(id);
                        
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        main(args);
                        break;
                }
                break;
            case 2:
                switch (exibirMenuEstacionamento()) {
                    case 1:
                        estacionamento = Estacionamento.registrarEstacionamento();
                        break;
                    case 2:
                        estacionamento.qtdVagasDisponiveis = estacionamento.qtdVagas - estacionamento.qtdVagasOcupadas;
                        JOptionPane.showMessageDialog(null, estacionamento.qtdVagasDisponiveis);
                        break;
                    case 3:
                        break;
                    case 4:
                        main(args);
                        break;
                }
                break;
            case 3:
                JOptionPane.showMessageDialog(null, "Encerrando o sistema...");
        }
    }

    private static int exibirMenu() {
        int op = Integer.parseInt(JOptionPane.showInputDialog(
                "      Valet System\n" +
                        "1 - Tickets\n" +
                        "2 - Estacionamento\n" +
                        "3 - Sair\n" +
                        "Escolha uma opção:"));
        return op;
    }

    private static int exibirMenuTickets() {
        int op = Integer.parseInt(JOptionPane.showInputDialog(
                "      Tickets\n" +
                        "1 - Gerar ticket\n" +
                        "2 - Imprimir ticket\n" +
                        "3 - Buscar carro\n" +
                        "4 - Voltar\n" +
                        "Escolha uma opção:"));
        return op;
    }

    private static int exibirMenuEstacionamento() {
        int op = Integer.parseInt(JOptionPane.showInputDialog(
                "      Estacionamento\n" +
                        "1 - Registrar estacionamento\n" +
                        "2 - Quantidade de vagas disponíveis no estacionamento atual\n" +
                        "3 - Listar carros estacionados no estacionamento atual\n" +
                        "4 - Voltar\n" +
                        "Escolha uma opção:"));
        return op;
    }

    private static void criarDiretorios(String raiz, String raizTickets, String raizEstacionamento) {
        File dir = new File(raiz);
        if (!dir.exists()) {
            dir.mkdir();
        }
        dir = new File(raizTickets);
        if (!dir.exists()) {
            dir.mkdir();
        }
        dir = new File(raizEstacionamento);
        if (!dir.exists()) {
            dir.mkdir();
        }
    }

    public static int gerarID(int qtdVagas, String[] listaIDs) {
        Random random = new Random();
        boolean contem = true;
        int id = 0;
        String s = "";
        do {
            id = random.nextInt(qtdVagas);
            s = id + "";
            if (listaIDs == null) {
                contem = false;
            } else {
                for (String i : listaIDs) {
                    if (i.equals(s)) {
                        contem = true;
                    } else {
                        contem = false;
                    }
                }
            }
        } while (contem);
        return id;
    }

    public static String[] listaIDs(String raizTickets) {
        File dir = new File(raizTickets);
        String[] lista = dir.list();
        return lista;
    }

    public static void cadastrarTicket(String raizTickets, Estacionamento estacionamento, int id)
            throws FileNotFoundException {
        Ticket ticket = Ticket.criarTicket(id, estacionamento, raizTickets);
        if (ticket != null) {
            gravarTicket(raizTickets, ticket);
        }
    }

    public static void gravarTicket(String raizTickets, Ticket ticket) throws FileNotFoundException {
        File dir = new File(raizTickets + ticket.id);
        if(!dir.exists()) {dir.mkdir();}
        PrintWriter pw = new PrintWriter(raizTickets + ticket.id);
        pw.append(ticket.id + "\n");
        pw.append(ticket.idEstacionamento + "\n");
        pw.append(ticket.DataEntrada + "\n");
        pw.append(ticket.carro + "\n");
        pw.append(ticket.saida + "\n");
    }

    public static void cadastrarEstacionamento() throws FileNotFoundException {
        Estacionamento estacionamento = Estacionamento.registrarEstacionamento();
        if (estacionamento != null) {
            gravarEstacionamento();
        }
    }

    public static void gravarEstacionamento(Estacionamento estacionamento, String raizEstacionamento) throws FileNotFoundException {
        File dir = new File(raizEstacionamento+estacionamento.num);
        if(!dir.exists()){dir.mkdir();}

        PrintWriter pw = new PrintWriter(raizEstacionamento+estacionamento.num);
        pw.append(estacionamento.num+"\n");
        pw.append(estacionamento.qtdVagas+"\n");
        pw.append(estacionamento.qtdVagasDisponiveis+"\n");
    }
}
