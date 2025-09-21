/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LineasUnidas.demo.repositories;

/**
 *
 * @author gabri
 */

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import LineasUnidas.demo.model.Boleto;

@Repository
public interface BoletoRepository extends JpaRepository<Boleto, Integer> {
    
    @Query("SELECT DISTINCT b FROM Boleto b " +
           "LEFT JOIN FETCH b.viaje v " +
           "LEFT JOIN FETCH v.rutas " +
           "LEFT JOIN FETCH v.horario " +
           "LEFT JOIN FETCH b.cliente c " +
           "WHERE c.idUsuario = :idCliente " +  // ← c.idUsuario 
           "ORDER BY b.idBoleto DESC")
    List<Boleto> findByClienteIdWithViajeInfo(@Param("idCliente") Integer idCliente);
    
    // Método alternativo básico
    List<Boleto> findByCliente_IdUsuario(Integer idCliente);
}