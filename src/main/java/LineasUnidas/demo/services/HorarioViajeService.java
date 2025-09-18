package LineasUnidas.demo.services;

import LineasUnidas.demo.model.HorarioViaje;
import LineasUnidas.demo.repositories.HorarioViajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HorarioViajeService {

    private final HorarioViajeRepository horarioRepo;


    public HorarioViajeService(HorarioViajeRepository horarioRepo) {
        this.horarioRepo = horarioRepo;
    }

    public HorarioViaje crearHorario(HorarioViaje horario) {
        return horarioRepo.save(horario);
    }

    public HorarioViaje obtenerHorarioPorId(int id) {
        Optional<HorarioViaje> horario = horarioRepo.findById(id);
        return horario.orElse(null);
    }

    public List<HorarioViaje> listarHorarios() {
        return horarioRepo.findAll();
    }

    public HorarioViaje actualizarHorario(int id, HorarioViaje detalles) {
        Optional<HorarioViaje> optHorario = horarioRepo.findById(id);
        if (optHorario.isPresent()) {
            HorarioViaje horario = optHorario.get();
            horario.setFecha(detalles.getFecha());
            horario.setHoraSalida(detalles.getHoraSalida());
            horario.setHoraLlegada(detalles.getHoraLlegada());
            horario.setEstado(detalles.getEstado());
            return horarioRepo.save(horario);
        }
        return null;
    }

    public boolean eliminarHorario(int id) {
        if (horarioRepo.existsById(id)) {
            horarioRepo.deleteById(id);
            return true;
        }
        return false;
    }

    public List<HorarioViaje> buscarPorEstado(String estado) {
        return horarioRepo.findByEstado(estado);
    }
}

