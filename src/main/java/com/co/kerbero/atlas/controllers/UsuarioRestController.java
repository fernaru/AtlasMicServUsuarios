package com.co.kerbero.atlas.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.co.kerbero.atlas.models.entity.Usuario;
import com.co.kerbero.atlas.services.IUsuarioService;

@CrossOrigin(origins= {"http://localhost:8088"})
@RestController
@RequestMapping("/service")
public class UsuarioRestController {

	@Autowired
	private IUsuarioService usuarioService;
	
	@GetMapping("/usuario")
	public List<Usuario> index(){
		return usuarioService.findAll();
	}
	
	@GetMapping("/usuario/{id}")
	public ResponseEntity<?> show(@PathVariable Long id) {
		Usuario usuario= usuarioService.findById(id);
		
		Map<String, Object> response = new HashMap<>();
		try {
		if(usuario == null){
			response.put("Mensaje", "El Usuario con ID: ".concat(id.toString().concat(" no existe en la base de datos!")));
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
	public ResponseEntity<?> create(@Valid @RequestBody Usuario usuario, BindingResult result) {
		Usuario usuarioNew = new Usuario();
		Map<String, Object> response = new HashMap<>();
		
		if(result.hasErrors()) {
			/*List<String> errors = new ArrayList<String>();
			for(FieldError err: result.getFieldErrors()) {
				errors.add("El campo '"+err.getField()+"' el mensaje "+ err.getDefaultMessage());
			}*/
			List<String> errors = result.getFieldErrors().stream().map(err -> { return "El campo '"+err.getField()+"' el mensaje "+ err.getDefaultMessage();}).collect(Collectors.toList());
			
			response.put("errores", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}
		try {
			usuarioNew = usuarioService.save(usuario);
			response.put("mensaje", "El usuario ha sido creado con éxito");
			response.put("usuario", usuarioNew);
			return new ResponseEntity<Map<String, Object>> (response, HttpStatus.CREATED);
		}catch (DataAccessException e) {
			response.put("mensaje", "Error al creacion");
			response.put("error", e.getMessage().concat(". ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@PutMapping("/usuario/{id}")
	public ResponseEntity<?> update(@Valid @RequestBody Usuario usuario, @PathVariable Long id, BindingResult result) {
		
		Usuario usuarioActual = usuarioService.findById(id);
		Usuario usuarioUpdate = new Usuario();
		Map<String, Object> response = new HashMap<>();
		
		if(result.hasErrors()){
			List<String> errors = result.getFieldErrors().stream().map(err -> {return "El campo '"+err.getField()+"' el mensaje "+ err.getDefaultMessage();}).collect(Collectors.toList());
			
			response.put("errores", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}
		try {
		if(usuarioActual == null){
			response.put("Mensaje", "El Usuario ID: ".concat(id.toString().concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
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
			//usuarioActual.setRol(usuario.getRol());
			usuarioUpdate = usuarioService.save(usuarioActual);
			response.put("mensaje", "El usuario ha sido Actualizado con éxito");
			response.put("usuario", usuarioUpdate);
			return new ResponseEntity<Map<String, Object>> (response, HttpStatus.CREATED);
		}catch (DataAccessException e) {
			response.put("Mensaje", "Error al actualizar el usuario");
			response.put("error", e.getMessage().concat(". ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}	
	}
	
	@DeleteMapping("/usuario/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		Map<String, Object> response = new HashMap<>();
		try {
			usuarioService.delete(id);
			response.put("mensaje", "El usuario ha sido eliminado con éxito");
			return new ResponseEntity<Map<String, Object>> (response, HttpStatus.CREATED);
		}catch (DataAccessException e) {
			response.put("Mensaje", "Error al actualizar el usuario");
			response.put("error", e.getMessage().concat(". ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		
		}
	}
}
