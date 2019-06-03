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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.co.kerbero.atlas.models.entity.Product;
import com.co.kerbero.atlas.services.IProductService;

@RestController
@RequestMapping("/product")
public class ProductRestController {

	@Autowired
	private IProductService service;
	
	@GetMapping("/create")
	public ResponseEntity<?> createProduct(@Valid @RequestBody Product product, BindingResult result) {
		Product pro = new Product();
		Map<String, Object> response = new HashMap<>();
		
		if(result.hasErrors()) {
			List<String> error = result.getFieldErrors().stream().map(err -> { return "El campo '"+err.getField()+"' el mensaje "+ err.getDefaultMessage();}).collect(Collectors.toList());
			
			response.put("errores", error);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}
		try {
			pro = service.createProduct(product);
			response.put("mensaje", "El Producto ha sido creado con éxito");
			response.put("Producto", pro);
			return new ResponseEntity<Map<String, Object>> (response, HttpStatus.CREATED);
		}catch (DataAccessException e) {
			response.put("mensaje", "Error al creacion");
			response.put("error", e.getMessage().concat(". ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
}
