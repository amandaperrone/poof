package poo1.af.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.websocket.server.PathParam;

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

import poo1.af.model.Cliente;
import poo1.af.service.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    
    @Autowired
    private ClienteService clienteService;

    @GetMapping()
    public List<Cliente> getClientes(){
        return clienteService.getAllClientes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> getCliente(@PathVariable int id){
        Cliente cliente = clienteService.getClienteByID(id);
        return ResponseEntity.ok(cliente);
    }

    @PostMapping()
    public ResponseEntity<Void> createCliente(@RequestBody Cliente cliente, HttpServletRequest request, UriComponentsBuilder builder) {
        cliente = clienteService.createCliente(cliente);
        UriComponents uri = builder.path(request.getRequestURI() + "/" + cliente.getIdC()).build();
        return ResponseEntity.created(uri.toUri()).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCliente(@PathVariable int id){
        clienteService.removeClienteByID(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> updateCliente(@PathVariable int id, @RequestBody Cliente cliente){
        cliente.setIdC(id);
        cliente = clienteService.updateCliente(cliente);
        return ResponseEntity.ok(cliente);
    }
}
