package com.co.canservero.tigon.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.co.canservero.tigon.models.dao.IUsuarioDao;
import com.co.canservero.tigon.models.entity.Usuario;

@Service
public class UsuarioServiceImple implements IUsuarioService {

	@Autowired
	private IUsuarioDao UsuarioDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Usuario> findAll() {
		return (List<Usuario>) UsuarioDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Usuario findById(Long id) {
		return UsuarioDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Usuario save(Usuario usuario) {
		return UsuarioDao.save(usuario);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		UsuarioDao.deleteById(id);
		
	}

}
