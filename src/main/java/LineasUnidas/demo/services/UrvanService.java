package LineasUnidas.demo.services;

import LineasUnidas.demo.model.Urvan;
import LineasUnidas.demo.repositories.UrvanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UrvanService {

    private final UrvanRepository urvanRepo;


    public UrvanService(UrvanRepository urvanRepo) {
        this.urvanRepo = urvanRepo;
    }

    public Urvan crearUrvan(Urvan urvan) {
        return urvanRepo.save(urvan);
    }

    public Urvan obtenerUrvanPorId(int id) {
        Optional<Urvan> urvan = urvanRepo.findById(id);
        return urvan.orElse(null);
    }

    public List<Urvan> listarUrvans() {
        return urvanRepo.findAll();
    }

    public Urvan actualizarUrvan(int id, Urvan detalles) {
        Optional<Urvan> optUrvan = urvanRepo.findById(id);
        if (optUrvan.isPresent()) {
            Urvan urvan = optUrvan.get();
            urvan.setPlaca(detalles.getPlaca());
            urvan.setCapacidad(detalles.getCapacidad());
            urvan.setConductor(detalles.getConductor());
            urvan.setViajes(detalles.getViajes());
            return urvanRepo.save(urvan);
        }
        return null;
    }

    public boolean eliminarUrvan(int id) {
        if (urvanRepo.existsById(id)) {
            urvanRepo.deleteById(id);
            return true;
        }
        return false;
    }

    public Urvan buscarPorPlaca(String placa) {
        return urvanRepo.findByPlaca(placa);
    }
}

