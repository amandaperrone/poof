package poo1.af.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import poo1.af.model.Veiculo;
import poo1.af.repository.VeiculoRepository;

@Service
public class VeiculoService {
    
    @Autowired
    private VeiculoRepository veiculoRepository;

    public List<Veiculo> getAllVeiculos() {
        return veiculoRepository.getAllVeiculos();
    }

    public Veiculo getVeiculoByID (int id){
        Optional<Veiculo> op = veiculoRepository.getVeiculoByID(id);
        return op.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Veiculo não encontrado"));
    }

    public Veiculo createVeiculo (Veiculo veiculo){
        return veiculoRepository.createVeiculo(veiculo);
    }

    public void removeVeiculoByID(int id){
        veiculoRepository.removeVeiculo(getVeiculoByID(id));
    }

    public Veiculo updateVeiculo (Veiculo veiculo){
        getVeiculoByID(veiculo.getIdV());
        return veiculoRepository.updateVeiculo(veiculo);
    }
}
