package LineasUnidas.demo.services;

import LineasUnidas.demo.model.Checador;
import LineasUnidas.demo.repositories.ChecadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChecadorService {

    private final ChecadorRepository checadorRepo;

    @Autowired
    public ChecadorService(ChecadorRepository checadorRepo) {
        this.checadorRepo = checadorRepo;
    }

    public Checador crearChecador(Checador checador) {
        return checadorRepo.save(checador);
    }

    public Checador obtenerChecadorPorId(int id) {
        Optional<Checador> checador = checadorRepo.findById(id);
        return checador.orElse(null);
    }

    public List<Checador> listarChecadores() {
        return checadorRepo.findAll();
    }

    public Checador actualizarChecador(int id, Checador detalles) {
        Optional<Checador> optChecador = checadorRepo.findById(id);
        if (optChecador.isPresent()) {
            Checador checador = optChecador.get();
            checador.setNombre(detalles.getNombre());
            checador.setApellidoP(detalles.getApellidoP());
            checador.setApellidoM(detalles.getApellidoM());
            checador.setTelefono(detalles.getTelefono());
            checador.setCorreo(detalles.getCorreo());
            checador.setRol(detalles.getRol());
            checador.setHorario(detalles.getHorario());
            return checadorRepo.save(checador);
        }
        return null;
    }

    public boolean eliminarChecador(int id) {
        if (checadorRepo.existsById(id)) {
            checadorRepo.deleteById(id);
            return true;
        }
        return false;
    }

    public Checador buscarPorCorreo(String correo) {
        return checadorRepo.findByCorreo(correo);
    }
}

