

package LineasUnidas.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import LineasUnidas.demo.model.Boleto;
import LineasUnidas.demo.model.Cliente;
import LineasUnidas.demo.repositories.ClienteRepository;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepo;

    public ClienteService(ClienteRepository clienteRepo) {
        this.clienteRepo = clienteRepo;
    }

    public Cliente registrarCliente(Cliente cliente) {
        return clienteRepo.save(cliente);
    }

    public Cliente obtenerClientePorId(int id) {
        Optional<Cliente> optCliente = clienteRepo.findById(id);
        return optCliente.orElse(null);
    }


    public Cliente obtenerClientePorCorreo(String correo) {
        return clienteRepo.findByCorreo(correo);
    }

    public List<Cliente> listarClientes() {
        return clienteRepo.findAll();
    }


    public Cliente actualizarMetodoCompra(int idCliente, String metodoCompra) {
        Optional<Cliente> optCliente = clienteRepo.findById(idCliente);
        if (optCliente.isPresent()) {
            Cliente cliente = optCliente.get();
            cliente.setMetodoCompra(metodoCompra);
            return clienteRepo.save(cliente);
        }
        return null;
    }


    public String comprarBoleto(int idCliente, Boleto boleto) {
        Cliente cliente = obtenerClientePorId(idCliente);
        if (cliente != null) {
            return cliente.comprarBoleto(boleto);
        }
        return "Cliente no encontrado";
    }

  
    public String cancelarBoleto(int idCliente, Boleto boleto) {
        Cliente cliente = obtenerClientePorId(idCliente);
        if (cliente != null) {
            return cliente.cancelarBoleto(boleto);
        }
        return "Cliente no encontrado";
    }
}

