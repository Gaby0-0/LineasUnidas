/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LineasUnidas.demo.services;

/**
 *
 * @author gabri
 */
import LineasUnidas.demo.model.HorarioTrabajo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import LineasUnidas.demo.repositories.HorarioTrabajoRepository;

@Service
public class HorarioTrabajoService {

    private final HorarioTrabajoRepository horarioRepo;

    @Autowired
    public HorarioTrabajoService(HorarioTrabajoRepository horarioRepo) {
        this.horarioRepo = horarioRepo;
    }

    public HorarioTrabajo crearHorario(List<String> dias, List<String> horas) {
        HorarioTrabajo horario = new HorarioTrabajo(dias, horas);
        return horarioRepo.save(horario);
    }

    public HorarioTrabajo obtenerHorarioPorId(int id) {
        Optional<HorarioTrabajo> horario = horarioRepo.findById(id);
        return horario.orElse(null); 
    }

    public List<HorarioTrabajo> listarHorarios() {
        return horarioRepo.findAll();
    }

    public HorarioTrabajo actualizarHorario(int id, List<String> dias, List<String> horas) {
        Optional<HorarioTrabajo> optHorario = horarioRepo.findById(id);
        if (optHorario.isPresent()) {
            HorarioTrabajo horario = optHorario.get();
            horario.setDias(dias);
            horario.setHoras(horas);
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
}

