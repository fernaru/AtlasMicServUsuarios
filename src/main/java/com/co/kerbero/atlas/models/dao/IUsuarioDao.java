package com.co.kerbero.atlas.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.co.kerbero.atlas.models.entity.Usuario;

public interface IUsuarioDao extends CrudRepository<Usuario, Long> {

}
