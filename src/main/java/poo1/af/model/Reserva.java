package poo1.af.model;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class Reserva {
    
    private int idR;
    private Cliente cliente;
    private Veiculo veiculo;
    @JsonFormat (pattern = "dd/MM/yyyy")
    private LocalDate dataInicio;
    @JsonFormat (pattern = "dd/MM/yyyy")
    private LocalDate dataFim;
    private double totalReserva;
    
    public long qtdDias() {
        long dias = ChronoUnit.DAYS.between(getDataInicio(), getDataFim());
        return dias;
    }

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


    public double getTotalReserva() {
        double soma = 0;
        soma += qtdDias() * getVeiculo().getValorDiaria();
        return totalReserva;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataFim() {
        return dataFim;
    }

    public void setDataFim(LocalDate dataFim) {
        this.dataFim = dataFim;
    }

    public boolean isDomingo() {
        DayOfWeek inicio = getDataInicio().getDayOfWeek();
        DayOfWeek fim = getDataFim().getDayOfWeek();
        if ( inicio == DayOfWeek.SUNDAY || fim == DayOfWeek.SUNDAY)
            return true;
        else
            return false;
    }

    public void setTotalReserva(double totalReserva) {
        this.totalReserva = totalReserva;
    }

    @JsonIgnore
    public boolean dataOk(){
        boolean a = getDataInicio().getDayOfWeek().equals(DayOfWeek.SUNDAY);
        boolean b = getDataFim().getDayOfWeek().equals(DayOfWeek.SUNDAY);
        if (a && b)
            return true;
        else
            return false;
    }

    
}
