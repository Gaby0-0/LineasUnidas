package LineasUnidas.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import LineasUnidas.demo.model.Boleto;
import LineasUnidas.demo.repositories.BoletoRepository;

@Service
public class BoletoService {

    private final BoletoRepository boletoRepo;

    public BoletoService(BoletoRepository boletoRepo) {
        this.boletoRepo = boletoRepo;
    }

    // Crear o guardar boleto
    public Boleto crearBoleto(Boleto boleto) {
        return boletoRepo.save(boleto);
    }

    public Boleto guardarBoleto(Boleto boleto) {
        return boletoRepo.save(boleto);
    }

    // Obtener boleto por ID
    public Boleto obtenerBoletoPorId(int id) {
        Optional<Boleto> boleto = boletoRepo.findById(id);
        return boleto.orElse(null);
    }

    // Listar todos los boletos
    public List<Boleto> listarBoletos() {
        return boletoRepo.findAll();
    }

    // Actualizar boleto existente
    public Boleto actualizarBoleto(int id, Boleto detalles) {
        Optional<Boleto> optBoleto = boletoRepo.findById(id);
        if (optBoleto.isPresent()) {
            Boleto boleto = optBoleto.get();
            boleto.setEstado(detalles.getEstado());
            boleto.setTipo(detalles.getTipo());
            boleto.setCliente(detalles.getCliente());
            boleto.setViaje(detalles.getViaje());
            boleto.setTaquilleros(detalles.getTaquilleros());
            return boletoRepo.save(boleto);
        }
        return null;
    }

    // Eliminar boleto
    public boolean eliminarBoleto(int id) {
        if (boletoRepo.existsById(id)) {
            boletoRepo.deleteById(id);
            return true;
        }
        return false;
    }

    // Listar boletos de un cliente con información del viaje
    public List<Boleto> findByClienteIdWithViajeInfo(Integer idCliente) {
        return boletoRepo.findByClienteIdWithViajeInfo(idCliente);
    }
}

