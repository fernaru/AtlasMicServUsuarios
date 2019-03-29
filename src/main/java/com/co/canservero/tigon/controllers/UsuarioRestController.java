package com.co.canservero.tigon.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.co.canservero.tigon.models.entity.Usuario;
import com.co.canservero.tigon.models.services.IUsuarioService;

@CrossOrigin(origins= {"http://localhost:8088"})
@RestController
@RequestMapping("/service")
public class UsuarioRestController {

	@Autowired
	private IUsuarioService usuarioService;
	
	@GetMapping("/getUsers")
	public List<Usuario> index(){
		return usuarioService.findAll();
	}
	
	@GetMapping("/getUsers/{id}")
	public ResponseEntity<?> show(@PathVariable Long id) {
		Usuario usuario= usuarioService.findById(id);
		
		Map<String, Object> response = new HashMap<>();
		try {
		if(usuario == null){
			response.put("Mensaje", "El cliente ID: ".concat(id.toString().concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
		}catch (DataAccessException e) {
			response.put("Mensaje", "Error al realizar la consulta");
			response.put("error", e.getMessage().concat(". ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/usuario")
	public ResponseEntity<?> create(@RequestBody Usuario usuario) {
		Usuario usuarioNew = new Usuario();
		Map<String, Object> response = new HashMap<>();
		try {
			usuarioNew = usuarioService.save(usuario);
			response.put("mensaje", "El cliente ha sido creado con éxito");
			response.put("cliente", usuarioNew);
			return new ResponseEntity<Map<String, Object>> (response, HttpStatus.CREATED);
		}catch (DataAccessException e) {
			response.put("mensaje", "Error al creacion");
			response.put("error", e.getMessage().concat(". ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@PutMapping("/getUsers/{id}")
	public Usuario update(@RequestBody Usuario usuario, @PathVariable Long id) {
		Usuario usuarioActual = usuarioService.findById(id);
		
		usuarioActual.setTipoIdenti(usuario.getTipoIdenti());;
		usuarioActual.setNumIdenti(usuario.getNumIdenti());
		usuarioActual.setNombre(usuario.getNombre());
		usuarioActual.setApellido(usuario.getApellido());
		usuarioActual.setUsername(usuario.getUsername());
		usuarioActual.setEmail(usuario.getEmail());
		usuarioActual.setFechaNacimiento(usuario.getFechaNacimiento());
		usuarioActual.setCreateAt(usuario.getCreateAt());
		usuarioActual.setTelefono(usuario.getTelefono());
		usuarioActual.setNombreEmpresa(usuario.getNombreEmpresa());
		usuarioActual.setNitEmpresa(usuario.getNitEmpresa());
		
		return usuarioService.save(usuarioActual);		
	}
	
	@DeleteMapping("/getUsers/{id}")
	public void delete(@PathVariable Long id) {
		usuarioService.delete(id);
	}
}
