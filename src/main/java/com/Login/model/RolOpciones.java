package com.Login.model;

import jakarta.persistence.*;

/**
 * Clase que representa una opción de rol en la aplicación.
 */
@Entity
@Table(name = "RolOpciones")
public class RolOpciones {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idOpcion;

    @Column(length = 20)
    private String NombreOpcion;

    /**
     * Obtiene el ID de la opción.
     *
     * @return El ID de la opción.
     */
    public int getIdOpcion() {
        return idOpcion;
    }

    /**
     * Establece el ID de la opción.
     *
     * @param idOpcion El nuevo ID de la opción.
     */
    public void setIdOpcion(int idOpcion) {
        this.idOpcion = idOpcion;
    }

    /**
     * Obtiene el nombre de la opción.
     *
     * @return El nombre de la opción.
     */
    public String getNombreOpcion() {
        return NombreOpcion;
    }

    /**
     * Establece el nombre de la opción.
     *
     * @param nombreOpcion El nuevo nombre de la opción.
     */
    public void setNombreOpcion(String nombreOpcion) {
        NombreOpcion = nombreOpcion;
    }

    /**
     * Constructor que inicializa el nombre de la opción.
     *
     * @param nombreOpcion El nombre de la opción.
     */
    public RolOpciones(String nombreOpcion) {
        this.NombreOpcion = nombreOpcion;
    }
}
