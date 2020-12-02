package poo1.af.model;

public class Veiculo {
    
    private int idV;
    private String modelo;
    private double valorDiaria;

    //GETTERS AND SETTERS
    public int getIdV() {
        return idV;
    }

    public void setIdV(int idV) {
        this.idV = idV;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public double getValorDiaria() {
        return valorDiaria;
    }

    public void setValorDiaria(double valorDiaria) {
        this.valorDiaria = valorDiaria;
    }
    
    
    // TO STRING
    @Override
    public String toString() {
        return "Veiculo [idV=" + idV + ", modelo=" + modelo + ", valorDiaria=" + valorDiaria + "]";
    }

    
    
}
