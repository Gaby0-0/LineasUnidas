package LineasUnidas.demo.services;

import LineasUnidas.demo.model.Conductor;
import LineasUnidas.demo.repositories.ConductorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConductorService {

    private final ConductorRepository conductorRepo;

    public ConductorService(ConductorRepository conductorRepo) {
        this.conductorRepo = conductorRepo;
    }

    public Conductor crearConductor(Conductor conductor) {
        return conductorRepo.save(conductor);
    }

    public Conductor obtenerConductorPorId(int id) {
        Optional<Conductor> conductor = conductorRepo.findById(id);
        return conductor.orElse(null);
    }

    public List<Conductor> listarConductores() {
        return conductorRepo.findAll();
    }

    public Conductor actualizarConductor(int id, Conductor detalles) {
        Optional<Conductor> optConductor = conductorRepo.findById(id);
        if (optConductor.isPresent()) {
            Conductor conductor = optConductor.get();
            conductor.setNombre(detalles.getNombre());
            conductor.setApellidoP(detalles.getApellidoP());
            conductor.setApellidoM(detalles.getApellidoM());
            conductor.setTelefono(detalles.getTelefono());
            conductor.setCorreo(detalles.getCorreo());
            conductor.setRol(detalles.getRol());
            conductor.setHorario(detalles.getHorario());
            conductor.setPermiso(detalles.getPermiso());
            conductor.setUrvan(detalles.getUrvan());
            return conductorRepo.save(conductor);
        }
        return null;
    }

    public boolean eliminarConductor(int id) {
        if (conductorRepo.existsById(id)) {
            conductorRepo.deleteById(id);
            return true;
        }
        return false;
    }

    public Conductor buscarPorCorreo(String correo) {
        return conductorRepo.findByCorreo(correo);
    }

    public List<Conductor> buscarPorPermiso(String permiso) {
        return conductorRepo.findByPermiso(permiso);
    }
}

