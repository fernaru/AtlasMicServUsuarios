package com.co.kerbero.atlas.services;

import java.util.List;

import com.co.kerbero.atlas.models.entity.Usuario;

public interface IUsuarioService {
	
	public List<Usuario> findAll();
	
	public Usuario findById(Long id);
	
	public Usuario save(Usuario usuario);
	
	public void delete(Long id);

}
