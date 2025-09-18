package LineasUnidas.demo.services;

import LineasUnidas.demo.model.Boleto;
import LineasUnidas.demo.repositories.BoletoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BoletoService {

    private final BoletoRepository boletoRepo;

    @Autowired
    public BoletoService(BoletoRepository boletoRepo) {
        this.boletoRepo = boletoRepo;
    }

    public Boleto crearBoleto(Boleto boleto) {
        return boletoRepo.save(boleto);
    }

    public Boleto obtenerBoletoPorId(int id) {
        Optional<Boleto> boleto = boletoRepo.findById(id);
        return boleto.orElse(null);
    }

    public List<Boleto> listarBoletos() {
        return boletoRepo.findAll();
    }

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

    public boolean eliminarBoleto(int id) {
        if (boletoRepo.existsById(id)) {
            boletoRepo.deleteById(id);
            return true;
        }
        return false;
    }

  
}
