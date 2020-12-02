package poo1.af.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import poo1.af.model.Veiculo;

@Component
public class VeiculoRepository {
    
    private List<Veiculo> veiculos;
    private int nextIdVeiculo;


    @PostConstruct
    public void criarVeiculo(){
        Veiculo v1 = new Veiculo();
        v1.setIdV(1);
        v1.setModelo("Fiat 500");
        v1.setValorDiaria(150.00);

        Veiculo v2 = new Veiculo();
        v2.setIdV(2);
        v2.setModelo("New Beetle");
        v2.setValorDiaria(200.00);

        veiculos = new ArrayList<Veiculo>();
        veiculos.add(v1);
        veiculos.add(v2);
        nextIdVeiculo = 3;
    }

    public List<Veiculo> getAllVeiculos(){
        return veiculos;
    }

    public Optional<Veiculo> getVeiculoByID(int id){
        for (Veiculo aux: veiculos){
            if(aux.getIdV() == id){
                return Optional.of(aux);
            }
        }
        return Optional.empty();
    }

    public Veiculo createVeiculo(Veiculo veiculo){
        veiculo.setIdV(nextIdVeiculo++);
        veiculos.add(veiculo);
        return veiculo;
    }

    public Veiculo updateVeiculo (Veiculo veiculo){
        Veiculo aux = getVeiculoByID(veiculo.getIdV()).get();
        if(aux!=null){
            aux.setModelo(veiculo.getModelo());
            aux.setValorDiaria(veiculo.getValorDiaria());
        }
        return aux;
    }

    public void removeVeiculo(Veiculo veiculo){
        veiculos.remove(veiculo);
    }
}
