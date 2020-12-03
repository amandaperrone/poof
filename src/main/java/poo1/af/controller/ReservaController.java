package poo1.af.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import poo1.af.model.Reserva;
import poo1.af.service.ReservaService;

@RestController
@RequestMapping("/reservas")
public class ReservaController {
    
    @Autowired
    private ReservaService reservaService;

    @GetMapping()
    public List<Reserva> getReservas(){
        return reservaService.getAllReservas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reserva> getReserva (@PathVariable int id) {
        Reserva reserva = reservaService.getReservaByID(id);
        return ResponseEntity.ok(reserva);
    }

    
    
}
