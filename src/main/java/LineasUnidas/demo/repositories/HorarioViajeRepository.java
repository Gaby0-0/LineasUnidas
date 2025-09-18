package LineasUnidas.demo.repositories;

import LineasUnidas.demo.model.HorarioViaje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HorarioViajeRepository extends JpaRepository<HorarioViaje, Integer> {
   
    java.util.List<HorarioViaje> findByEstado(String estado);
}
