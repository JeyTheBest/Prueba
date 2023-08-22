package com.Login.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import java.util.Date;

/**
 * Clase que representa a una Persona con información básica.
 */
@Entity
@Table(name = "Persona")
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPersona;

    @Column(length = 50)
    private String nombres;

    @Column(length = 50)
    private String apellidos;

    @Column(length = 10)
    private int identificacion;

    private Date fechaNacimiento;

    /**
     * Obtiene el ID de la persona.
     *
     * @return El ID de la persona.
     */
    public int getIdPersona() {
        return idPersona;
    }

    /**
     * Establece el ID de la persona.
     *
     * @param idPersona El nuevo ID de la persona.
     */
    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    /**
     * Obtiene los nombres de la persona.
     *
     * @return Los nombres de la persona.
     */
    public String getNombres() {
        return nombres;
    }

    /**
     * Establece los nombres de la persona.
     *
     * @param nombres Los nuevos nombres de la persona.
     */
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    /**
     * Obtiene los apellidos de la persona.
     *
     * @return Los apellidos de la persona.
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     * Establece los apellidos de la persona.
     *
     * @param apellidos Los nuevos apellidos de la persona.
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    /**
     * Obtiene la identificación de la persona.
     *
     * @return La identificación de la persona.
     */
    public int getIdentificacion() {
        return identificacion;
    }

    /**
     * Establece la identificación de la persona.
     *
     * @param identificacion La nueva identificación de la persona.
     */
    public void setIdentificacion(int identificacion) {
        this.identificacion = identificacion;
    }

    /**
     * Obtiene la fecha de nacimiento de la persona.
     *
     * @return La fecha de nacimiento de la persona.
     */
    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * Establece la fecha de nacimiento de la persona.
     *
     * @param fechaNacimiento La nueva fecha de nacimiento de la persona.
     */
    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     * Constructor que inicializa los atributos de la persona.
     *
     * @param nombres         Los nombres de la persona.
     * @param apellidos       Los apellidos de la persona.
     * @param identificacion  La identificación de la persona.
     * @param fechaNacimiento La fecha de nacimiento de la persona.
     */
    public Persona(String nombres, String apellidos, int identificacion, Date fechaNacimiento) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.identificacion = identificacion;
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     * Constructor vacío para crear una instancia de Persona sin argumentos.
     */
    public Persona() {
    }
}
