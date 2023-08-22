package com.Login.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Login.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

}
