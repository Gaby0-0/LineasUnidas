/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LineasUnidas.demo.model;

/**
 *
 * @author magal
 */
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "horario_trabajo")
public class HorarioTrabajo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_horario")
    private int idHorario;

    @ElementCollection
    @CollectionTable(name = "horario_dias", joinColumns = @JoinColumn(name = "id_horario"))
    @Column(name = "dia")
    private List<String> dias = new ArrayList<>();

    @ElementCollection
    @CollectionTable(name = "horario_horas", joinColumns = @JoinColumn(name = "id_horario"))
    @Column(name = "hora")
    private List<String> horas = new ArrayList<>();

    @OneToMany(mappedBy = "horario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Conductor> conductores = new ArrayList<>();

    @OneToMany(mappedBy = "horario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Taquillero> taquilleros = new ArrayList<>();

    @OneToMany(mappedBy = "horario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Gerente> gerentes = new ArrayList<>();

    public HorarioTrabajo() {}

    public HorarioTrabajo(List<String> dias, List<String> horas) {
        this.dias = dias;
        this.horas = horas;
    }

    public int getIdHorario() {
        return idHorario;
    }

    public List<String> getDias() {
        return dias;
    }

    public void setDias(List<String> dias) {
        this.dias = dias;
    }

    public List<String> getHoras() {
        return horas;
    }

    public void setHoras(List<String> horas) {
        this.horas = horas;
    }

    public List<Conductor> getConductores() {
        return conductores;
    }

    public void setConductores(List<Conductor> conductores) {
        this.conductores = conductores;
    }

    public List<Taquillero> getTaquilleros() {
        return taquilleros;
    }

    public void setTaquilleros(List<Taquillero> taquilleros) {
        this.taquilleros = taquilleros;
    }


    public void agregarConductor(Conductor conductor) {
        conductores.add(conductor);
        conductor.setHorario(this);
    }

    public void agregarTaquillero(Taquillero taquillero) {
        taquilleros.add(taquillero);
        taquillero.setHorario(this);
    }
    public List<Gerente> getGerentes() {
    return gerentes;
        }

        // Setter
        public void setGerentes(List<Gerente> gerentes) {
            this.gerentes = gerentes;
        }
        }

