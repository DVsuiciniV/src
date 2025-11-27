import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;


public class Ticket {
    int id;
    Carro carro;
    String DataEntrada;
    String DataSaida;
    int idEstacionamento;
    boolean saida = false;

    public static Ticket criarTicket(int id, Estacionamento estacionamento, String raizTickets) {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalTime horario = LocalTime.now();
        Ticket ticket = new Ticket();
        ticket.id = App.gerarID(estacionamento.qtdVagas, App.listaIDs(raizTickets));
        ticket.carro = Carro.criarCarro();
        ticket.idEstacionamento = estacionamento.num;
        ticket.DataEntrada = LocalDate.now() + " " + horario.format(formato);
        ticket.DataSaida = LocalDate.now() + " " + horario.format(formato);
        ticket.saida = false;
        return ticket;
    }


}
