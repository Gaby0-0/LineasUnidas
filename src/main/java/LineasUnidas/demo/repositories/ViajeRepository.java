package LineasUnidas.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import LineasUnidas.demo.model.Viaje;

@Repository
public interface ViajeRepository extends JpaRepository<Viaje, Integer> {
    // List<Viaje> findByEstado(String estado);
}
