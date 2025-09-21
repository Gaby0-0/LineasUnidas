package LineasUnidas.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import LineasUnidas.demo.model.Viaje;
import LineasUnidas.demo.repositories.ViajeRepository;

@Service
public class ViajeService {

    private final ViajeRepository viajeRepo;


    public ViajeService(ViajeRepository viajeRepo) {
        this.viajeRepo = viajeRepo;
    }

    public Viaje crearViaje(Viaje viaje) {
        return viajeRepo.save(viaje);
    }

    public Viaje obtenerViajePorId(int id) {
        Optional<Viaje> viaje = viajeRepo.findById(id);
        return viaje.orElse(null);
    }

    public List<Viaje> listarViajes() {
        return viajeRepo.findAll();
    }

    public Viaje actualizarViaje(int id, Viaje detalles) {
        Optional<Viaje> optViaje = viajeRepo.findById(id);
        if (optViaje.isPresent()) {
            Viaje viaje = optViaje.get();
            viaje.setPrecio(detalles.getPrecio());
            viaje.setDisponibilidad(detalles.getDisponibilidad());
            viaje.setEstado(detalles.getEstado());
            viaje.setHorario(detalles.getHorario());
            viaje.setUrbans(detalles.getUrbans());
            viaje.setRutas(detalles.getRutas());
            viaje.setBoletos(detalles.getBoletos());
            return viajeRepo.save(viaje);
        }
        return null;
    }

    public boolean eliminarViaje(int id) {
        if (viajeRepo.existsById(id)) {
            viajeRepo.deleteById(id);
            return true;
        }
        return false;
    }
     @Autowired
    private ViajeRepository viajeRepository;
    
    public List<Viaje> findAllWithRutasAndHorario() {
        return viajeRepository.findAllWithRutasAndHorario();
    }
    
    public Viaje findById(Integer idViaje) {
        return viajeRepository.findById(idViaje)
                .orElseThrow(() -> new RuntimeException("Viaje no encontrado con ID: " + idViaje));
    }
    
    public Viaje findByIdWithRelations(Integer idViaje) {
        return viajeRepository.findByIdWithRelations(idViaje)
                .orElseThrow(() -> new RuntimeException("Viaje no encontrado con ID: " + idViaje));
    }
}

