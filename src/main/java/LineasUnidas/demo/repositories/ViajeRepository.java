package LineasUnidas.demo.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import LineasUnidas.demo.model.Viaje;

@Repository
public interface ViajeRepository extends JpaRepository<Viaje, Integer> {
    
    // 🔹 Obtener todos los viajes activos con rutas y horario cargados
    @Query("SELECT DISTINCT v FROM Viaje v " +
           "LEFT JOIN FETCH v.rutas r " +
           "LEFT JOIN FETCH v.horario h " +
           "WHERE v.estado = 'Activo'")
    List<Viaje> findAllWithRutasAndHorario();
    
    // 🔹 Obtener un viaje específico con sus relaciones
    @Query("SELECT DISTINCT v FROM Viaje v " +
           "LEFT JOIN FETCH v.rutas r " +
           "LEFT JOIN FETCH v.horario h " +
           "WHERE v.idViaje = :idViaje")
    Optional<Viaje> findByIdWithRelations(@Param("idViaje") Integer idViaje);
    
    // 🔹 findById() ya lo trae JpaRepository
}
