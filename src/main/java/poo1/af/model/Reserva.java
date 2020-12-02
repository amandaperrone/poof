package poo1.af.model;

import java.text.DateFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Reserva {
    
    private int idR;
    private Cliente cliente;
    private Veiculo veiculo;
    @JsonFormat (pattern = "dd/MM/yyyy")
    private DateFormat dataInicio;
    @JsonFormat (pattern = "dd/MM/yyyy")
    private DateFormat dataFim;
    private double totalReserva;

    //GETTERS AND SETTERS
    public int getIdR() {
        return idR;
    }

    public void setIdR(int idR) {
        this.idR = idR;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public DateFormat getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(DateFormat dataInicio) {
        this.dataInicio = dataInicio;
    }

    public DateFormat getDataFim() {
        return dataFim;
    }

    public void setDataFim(DateFormat dataFim) {
        this.dataFim = dataFim;
    }

    public double getTotalReserva() {
        return totalReserva;
    }

    public void setTotalReserva(double totalReserva) {
        this.totalReserva = totalReserva;
    }


    
}
