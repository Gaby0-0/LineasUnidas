package LineasUnidas.demo.services;

import LineasUnidas.demo.model.Ruta;
import LineasUnidas.demo.repositories.RutaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RutaService {

    private final RutaRepository rutaRepo;


    public RutaService(RutaRepository rutaRepo) {
        this.rutaRepo = rutaRepo;
    }

    public Ruta crearRuta(Ruta ruta) {
        return rutaRepo.save(ruta);
    }

    public Ruta obtenerRutaPorId(int id) {
        Optional<Ruta> ruta = rutaRepo.findById(id);
        return ruta.orElse(null);
    }

    public List<Ruta> listarRutas() {
        return rutaRepo.findAll();
    }

    public Ruta actualizarRuta(int id, Ruta detalles) {
        Optional<Ruta> optRuta = rutaRepo.findById(id);
        if (optRuta.isPresent()) {
            Ruta ruta = optRuta.get();
            ruta.setOrigen(detalles.getOrigen());
            ruta.setDestino(detalles.getDestino());
            ruta.setDistancia(detalles.getDistancia());
            ruta.setViajes(detalles.getViajes());
            return rutaRepo.save(ruta);
        }
        return null;
    }

    public boolean eliminarRuta(int id) {
        if (rutaRepo.existsById(id)) {
            rutaRepo.deleteById(id);
            return true;
        }
        return false;
    }

    public List<Ruta> buscarPorOrigen(String origen) {
        return rutaRepo.findByOrigen(origen);
    }

    public List<Ruta> buscarPorDestino(String destino) {
        return rutaRepo.findByDestino(destino);
    }
}
