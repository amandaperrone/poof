package poo1.af.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import poo1.af.model.Reserva;

@Component
public class ReservaRepository {
    
    private List<Reserva> reservas;
    private int nextIdReserva;

    public List<Reserva> getAllReservas(){
        return reservas;
    }

    public Optional<Reserva> getReservaByID(int id){
        for (Reserva aux: reservas){
            if (aux.getIdR() == id){
                return Optional.of(aux);
            }
        }
        return Optional.empty();
    }

    public Reserva createReserva (Reserva reserva){
        reserva.setIdR(nextIdReserva++);
        reserva.setCliente(reserva.getCliente());
        reserva.setVeiculo(reserva.getVeiculo());
        reserva.setDataInicio(reserva.getDataInicio());
        reserva.setDataFim(reserva.getDataFim());
        reserva.getTotalReserva();
        reservas.add(reserva);
        return reserva;
    }
}
