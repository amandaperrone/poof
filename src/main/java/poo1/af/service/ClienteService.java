package poo1.af.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import poo1.af.dto.ClienteDTO;
import poo1.af.model.Cliente;
import poo1.af.model.Reserva;
import poo1.af.repository.ClienteRepository;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente fromDTO(ClienteDTO dto){
        Cliente cliente = new Cliente();
        cliente.setEndereco(dto.getEndereco());
        cliente.setNome(dto.getNome());

        return cliente;
    }
    
    public List<Cliente> getAllClientes() {
        return clienteRepository.getAllClientes();
    }

    public Cliente getClienteByID (int id){
        Optional<Cliente> op = clienteRepository.getClienteByID(id);
        return op.orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado"));
    }

    public Cliente createCliente(Cliente cliente){
        return clienteRepository.createCliente(cliente);
    }

    public void removeClienteByID(int id){
        clienteRepository.removeCliente(getClienteByID(id));
    }

    public Cliente updateCliente(Cliente cliente){
        getClienteByID(cliente.getIdC());
        return clienteRepository.updateCliente(cliente);
    }

    public List<Reserva> getReservasPorCliente(Cliente cliente) {
        return clienteRepository.getReservas(cliente);
    }
}
