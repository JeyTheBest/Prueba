package com.Login.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 * Clase que representa a un usuario en la aplicación.
 */
@Entity
@Table(name = "Usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUsuario;

    @Column(length = 20, unique = true)
    private String usuario;

    @Column(length = 50)
    private String contrasena;

    @Column(length = 255)
    private String correo;

    @Column(length = 1)
    private char SesionActivada;

    @ManyToOne
    @JoinColumn(name = "idPersona2")
    private Persona persona;

    @Column(length = 20)
    private String status;

    /**
     * Obtiene el ID del usuario.
     *
     * @return El ID del usuario.
     */
    public int getIdUsuario() {
        return idUsuario;
    }

    /**
     * Establece el ID del usuario.
     *
     * @param idUsuario El nuevo ID del usuario.
     */
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    /**
     * Obtiene el nombre de usuario.
     *
     * @return El nombre de usuario.
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * Establece el nombre de usuario.
     *
     * @param usuario El nuevo nombre de usuario.
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * Obtiene la contraseña del usuario.
     *
     * @return La contraseña del usuario.
     */
    public String getContrasena() {
        return contrasena;
    }

    /**
     * Establece la contraseña del usuario.
     *
     * @param contrasena La nueva contraseña del usuario.
     */
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    /**
     * Obtiene el correo electrónico del usuario.
     *
     * @return El correo electrónico del usuario.
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * Establece el correo electrónico del usuario.
     *
     * @param correo El nuevo correo electrónico del usuario.
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * Obtiene el estado de la sesión del usuario.
     *
     * @return El estado de la sesión del usuario.
     */
    public char getSesionActivada() {
        return SesionActivada;
    }

    /**
     * Establece el estado de la sesión del usuario.
     *
     * @param sesionActivada El nuevo estado de la sesión del usuario.
     */
    public void setSesionActivada(char sesionActivada) {
        SesionActivada = sesionActivada;
    }

    /**
     * Obtiene la persona asociada al usuario.
     *
     * @return La persona asociada al usuario.
     */
    public Persona getPersona() {
        return persona;
    }

    /**
     * Establece la persona asociada al usuario.
     *
     * @param persona La nueva persona asociada al usuario.
     */
    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    /**
     * Obtiene el estado del usuario.
     *
     * @return El estado del usuario.
     */
    public String getStatus() {
        return status;
    }

    /**
     * Establece el estado del usuario.
     *
     * @param status El nuevo estado del usuario.
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Constructor que inicializa los atributos del usuario.
     *
     * @param usuario         El nombre de usuario.
     * @param contrasena      La contraseña del usuario.
     * @param correo          El correo electrónico del usuario.
     * @param sesionActivada  El estado de la sesión del usuario.
     * @param persona         La persona asociada al usuario.
     * @param status          El estado del usuario.
     */
    public Usuario(String usuario, String contrasena, String correo, char sesionActivada, Persona persona,
                   String status) {
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.correo = correo;
        SesionActivada = sesionActivada;
        this.persona = persona;
        this.status = status;
    }

    /**
     * Constructor vacío para crear una instancia de Usuario sin argumentos.
     */
    public Usuario() {
    }
}
