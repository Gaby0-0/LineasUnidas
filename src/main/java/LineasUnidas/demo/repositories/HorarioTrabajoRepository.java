/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LineasUnidas.demo.repositories;

/**
 *
 * @author gabri
 */
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import LineasUnidas.demo.model.HorarioTrabajo;

@Repository
public interface HorarioTrabajoRepository extends JpaRepository<HorarioTrabajo, Integer> {}

