package io.nai.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.nai.service.ICrudService;
@RequestMapping("/crud_user")
public class CrudController<T, ID>  {
	
	@Autowired
	private ICrudService<T,ID> aservice;
	
	@GetMapping
	public List<T> getAll(){
		return aservice.getAll();
	}
	
	@PostMapping
	public void add(@RequestBody T entity) {
		aservice.add(entity);
	}
	
	@PutMapping
	public void update(@RequestBody T entity) {
		aservice.update(entity);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable ID id) {
		aservice.delete(id);
	}
	
	@PostMapping("/all")
	public ResponseEntity<List<T>> addAll(@RequestBody List<T> list) {
		aservice.saveAll(list);
		return new ResponseEntity<>(list, HttpStatus.ACCEPTED);
	}


}
