package poo1.af.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import poo1.af.model.Veiculo;
import poo1.af.service.VeiculoService;

@RestController
@RequestMapping("/veiculos")
public class VeiculoController {
    
    @Autowired
    private VeiculoService veiculoService;

    @GetMapping()
    public List<Veiculo> getVeiculos(){
        return veiculoService.getAllVeiculos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Veiculo> getVeiculo (@PathVariable int id){
        Veiculo veiculo = veiculoService.getVeiculoByID(id);
        return ResponseEntity.ok(veiculo);
    }

    @PostMapping()
    public ResponseEntity<Void> createVeiculo(@RequestBody Veiculo veiculo, HttpServletRequest request, UriComponentsBuilder builder) {
        veiculo = veiculoService.createVeiculo(veiculo);
        UriComponents uri = builder.path(request.getRequestURI() + "/" + veiculo.getIdV()).build();
        return ResponseEntity.created(uri.toUri()).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVeiculo(@PathVariable int id){
        veiculoService.removeVeiculoByID(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Veiculo> updateVeiculo (@PathVariable int id, @RequestBody Veiculo veiculo){
        veiculo.setIdV(id);
        veiculo = veiculoService.updateVeiculo(veiculo);
        return ResponseEntity.ok(veiculo);
    }
}
