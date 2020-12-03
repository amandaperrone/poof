package poo1.af.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import poo1.af.model.Cliente;
import poo1.af.model.Reserva;

@Component
public class ClienteRepository {
    
    private List<Cliente> clientes;
    private int nextIdCliente;
    
    @PostConstruct
    public void criarCliente(){
        Cliente c1 = new Cliente();
        c1.setIdC(1);
        c1.setNome("Amanda");
        c1.setEndereco("Rua 7 de Setembro");
        c1.setCpf("123.456.789-00");

        Cliente c2 = new Cliente();
        c2.setIdC(2);
        c2.setNome("Guilherme");
        c2.setEndereco("Rua 9 de Julho");
        c2.setCpf("321.654.987-00");

        clientes = new ArrayList<Cliente>();
        clientes.add(c1);
        clientes.add(c2);
        nextIdCliente = 3;
    }

    public List<Cliente> getAllClientes(){
        return clientes;
    }

    public Optional<Cliente> getClienteByID(int id){
        for (Cliente aux: clientes){
            if (aux.getIdC() == id){
                return Optional.of(aux);
            }
        }
        return Optional.empty();
    }

    public Cliente createCliente(Cliente cliente){
        cliente.setIdC(nextIdCliente++);
        clientes.add(cliente);
        return cliente;
    }

    public Cliente updateCliente(Cliente cliente){
        Cliente aux = getClienteByID(cliente.getIdC()).get();
        if (aux!=null){
            aux.setNome(cliente.getNome());
            aux.setEndereco(cliente.getEndereco());
            aux.setCpf(cliente.getCpf());
        }
        return aux;
    }

    public void removeCliente(Cliente cliente){
        clientes.remove(cliente);
    }


    public List<Reserva> getReservas(Cliente cliente) {
        return cliente.getReservas();
    }
}
