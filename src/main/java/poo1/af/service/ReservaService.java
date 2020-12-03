package poo1.af.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import poo1.af.model.Reserva;
import poo1.af.repository.ReservaRepository;

@Service
public class ReservaService {
    
    @Autowired
    private ReservaRepository reservaRepository;

    public List<Reserva> getAllReservas() {
        return reservaRepository.getAllReservas();
    }

    public Reserva getReservaByID(int id){
        Optional <Reserva> op = reservaRepository.getReservaByID(id);
        return op.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Reserva não encontrada"));
    }

    // colocar save depois se der
}
