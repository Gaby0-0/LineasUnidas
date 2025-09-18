package LineasUnidas.demo.repositories;

import LineasUnidas.demo.model.Ruta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RutaRepository extends JpaRepository<Ruta, Integer> {
   
    java.util.List<Ruta> findByOrigen(String origen);
    java.util.List<Ruta> findByDestino(String destino);
}
