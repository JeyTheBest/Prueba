package com.Login.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import java.util.Date;

/**
 * Clase que representa las sesiones de usuarios en la aplicación.
 */
@Entity
@Table(name = "Sesiones")
public class Sesiones {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date fechaEntrada;
    private Date fechaSalida;

    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;

    /**
     * Obtiene la fecha de entrada de la sesión.
     *
     * @return La fecha de entrada de la sesión.
     */
    public Date getFechaEntrada() {
        return fechaEntrada;
    }

    /**
     * Establece la fecha de entrada de la sesión.
     *
     * @param fechaEntrada La nueva fecha de entrada de la sesión.
     */
    public void setFechaEntrada(Date fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    /**
     * Obtiene la fecha de salida de la sesión.
     *
     * @return La fecha de salida de la sesión.
     */
    public Date getFechaSalida() {
        return fechaSalida;
    }

    /**
     * Establece la fecha de salida de la sesión.
     *
     * @param fechaSalida La nueva fecha de salida de la sesión.
     */
    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    /**
     * Obtiene el usuario asociado a esta sesión.
     *
     * @return El usuario asociado a la sesión.
     */
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     * Establece el usuario asociado a esta sesión.
     *
     * @param usuario El nuevo usuario asociado a la sesión.
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    /**
     * Constructor que inicializa los atributos de la sesión.
     *
     * @param fechaEntrada La fecha de entrada de la sesión.
     * @param fechaSalida  La fecha de salida de la sesión.
     * @param usuario      El usuario asociado a la sesión.
     */
    public Sesiones(Date fechaEntrada, Date fechaSalida, Usuario usuario) {
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
        this.usuario = usuario;
    }

    /**
     * Establece el usuario asociado a esta sesión utilizando el nombre del usuario.
     *
     * @param nombreUsuario El nombre del usuario asociado a la sesión.
     */
    public void setUsuario(String nombreUsuario) {
        // Implementa la lógica para establecer el usuario por el nombre.
    }
}
