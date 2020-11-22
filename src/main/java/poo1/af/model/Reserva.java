package poo1.af.model;

import java.text.DateFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Reserva {
    
    private int idR;

    @JsonFormat (pattern = "dd/MM/yyyy")
    private DateFormat dataInicio;
    @JsonFormat (pattern = "dd/MM/yyyy")
    private DateFormat dataFim;

}
