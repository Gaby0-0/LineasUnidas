package LineasUnidas.demo.services;

import LineasUnidas.demo.model.Taquillero;
import LineasUnidas.demo.repositories.TaquilleroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaquilleroService {

    private final TaquilleroRepository taquilleroRepo;

    public TaquilleroService(TaquilleroRepository taquilleroRepo) {
        this.taquilleroRepo = taquilleroRepo;
    }

    public Taquillero crearTaquillero(Taquillero taquillero) {
        return taquilleroRepo.save(taquillero);
    }

    public Taquillero obtenerTaquilleroPorId(int id) {
        Optional<Taquillero> taquillero = taquilleroRepo.findById(id);
        return taquillero.orElse(null);
    }

    public List<Taquillero> listarTaquilleros() {
        return taquilleroRepo.findAll();
    }

    public Taquillero actualizarTaquillero(Taquillero detalles) {
        Optional<Taquillero> optTaquillero = taquilleroRepo.findById(detalles.getIdUsuario());
        if (optTaquillero.isPresent()) {
            Taquillero taquillero = optTaquillero.get();
            taquillero.setNombre(detalles.getNombre());
            taquillero.setApellidoP(detalles.getApellidoP());
            taquillero.setApellidoM(detalles.getApellidoM());
            taquillero.setTelefono(detalles.getTelefono());
            taquillero.setCorreo(detalles.getCorreo());
            taquillero.setRol(detalles.getRol());
            taquillero.setHorario(detalles.getHorario());
            taquillero.setBoletos(detalles.getBoletos());
            taquillero.setContrasenia(detalles.getContrasenia());
            return taquilleroRepo.save(taquillero);
        }
        return null;
    }

    public boolean eliminarTaquillero(int id) {
        if (taquilleroRepo.existsById(id)) {
            taquilleroRepo.deleteById(id);
            return true;
        }
        return false;
    }

    public Taquillero buscarPorCorreo(String correo) {
        return taquilleroRepo.findByCorreo(correo);
    }

}
