package LineasUnidas.demo.services;

import LineasUnidas.demo.model.Gerente;
import LineasUnidas.demo.repositories.GerenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GerenteService {

    private final GerenteRepository gerenteRepo;


    public GerenteService(GerenteRepository gerenteRepo) {
        this.gerenteRepo = gerenteRepo;
    }

    public Gerente crearGerente(Gerente gerente) {
        return gerenteRepo.save(gerente);
    }

    public Gerente obtenerGerentePorId(int id) {
        Optional<Gerente> gerente = gerenteRepo.findById(id);
        return gerente.orElse(null);
    }

    public List<Gerente> listarGerentes() {
        return gerenteRepo.findAll();
    }

    public Gerente actualizarGerente(int id, Gerente detalles) {
        Optional<Gerente> optGerente = gerenteRepo.findById(id);
        if (optGerente.isPresent()) {
            Gerente gerente = optGerente.get();
            gerente.setNombre(detalles.getNombre());
            gerente.setApellidoP(detalles.getApellidoP());
            gerente.setApellidoM(detalles.getApellidoM());
            gerente.setTelefono(detalles.getTelefono());
            gerente.setCorreo(detalles.getCorreo());
            gerente.setRol(detalles.getRol());
            return gerenteRepo.save(gerente);
        }
        return null;
    }

    public boolean eliminarGerente(int id) {
        if (gerenteRepo.existsById(id)) {
            gerenteRepo.deleteById(id);
            return true;
        }
        return false;
    }

    public Gerente buscarPorCorreo(String correo) {
        return gerenteRepo.findByCorreo(correo);
    }

    // Métodos específicos de Gerente
    public String habilitarEmpleado(int idUsuario) {
        return "Empleado " + idUsuario + " habilitado.";
    }

    public String deshabilitarEmpleado(int idUsuario) {
        return "Empleado " + idUsuario + " deshabilitado.";
    }

    public String habilitarUrvan(int idUrvan) {
        return "Urván " + idUrvan + " habilitada.";
    }

    public String deshabilitarUrvan(int idUrvan) {
        return "Urván " + idUrvan + " deshabilitada.";
    }
}
