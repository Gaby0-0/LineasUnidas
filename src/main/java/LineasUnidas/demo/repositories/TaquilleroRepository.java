package LineasUnidas.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import LineasUnidas.demo.model.Taquillero;

@Repository
public interface TaquilleroRepository extends JpaRepository<Taquillero, Integer> {
    
    Taquillero findByCorreo(String correo);

}

