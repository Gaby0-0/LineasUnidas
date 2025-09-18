package LineasUnidas.demo.repositories;

import LineasUnidas.demo.model.Urvan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UrvanRepository extends JpaRepository<Urvan, Integer> {
  
    Urvan findByPlaca(String placa);
}
