package com.Login.model;

import jakarta.persistence.*;

/**
 * Clase que representa un rol de usuario en la aplicación.
 */
@Entity
@Table(name = "Rol")
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 20)
    private String RolNombre;

    /**
     * Obtiene el ID del rol.
     *
     * @return El ID del rol.
     */
    public int getId() {
        return id;
    }

    /**
     * Establece el ID del rol.
     *
     * @param id El nuevo ID del rol.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre del rol.
     *
     * @return El nombre del rol.
     */
    public String getRolNombre() {
        return RolNombre;
    }

    /**
     * Establece el nombre del rol.
     *
     * @param rolNombre El nuevo nombre del rol.
     */
    public void setRolNombre(String rolNombre) {
        RolNombre = rolNombre;
    }

    /**
     * Constructor que inicializa el nombre del rol.
     *
     * @param rolNombre El nombre del rol.
     */
    public Rol(String rolNombre) {
        this.RolNombre = rolNombre;
    }
}
