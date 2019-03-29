package com.co.canservero.tigon.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.co.canservero.tigon.models.entity.Usuario;

public interface IUsuarioDao extends CrudRepository<Usuario, Long> {

}
