package br.com.residencia.biblioteca.controller;

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
import br.com.residencia.biblioteca.entity.Editora;
import br.com.residencia.biblioteca.service.EditoraServico;

@RestController
@RequestMapping ("/editoras")
public class EditoraController {
	
	@Autowired
	EditoraServico editoraServico;
	
	
	@GetMapping
	public ResponseEntity<List<Editora>>getAllEditora(){
		return new ResponseEntity<>(editoraServico.getAlleditora(),HttpStatus.OK);}
	
	@GetMapping("/{id}")
	public ResponseEntity<Editora>getEditoraById(@PathVariable Integer Id){
		Editora editora = editoraServico.getEditoraById(Id);
		if (null!= editora)
			return new ResponseEntity<>(editora,HttpStatus.OK);
		else 
			return new ResponseEntity<>(editora,HttpStatus.NOT_FOUND);
	}
	@PostMapping
	public ResponseEntity<Editora> saveEditora(@RequestBody Editora editora) {
		return new ResponseEntity<>(editoraServico.saveeditora(editora),
				HttpStatus.CREATED);
	}
	@PutMapping("/{id}")
	public ResponseEntity<Editora>updateeditora(@RequestBody Editora editora,@PathVariable Integer id ){
		return new ResponseEntity<>(editoraServico.updateeditora(editora,id),HttpStatus.OK);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Editora>deleteeditora(@PathVariable Integer id){
		Editora editora = editoraServico.getEditoraById(id);
		if (null==editora)
				return new ResponseEntity<>(editora,HttpStatus.NOT_FOUND);
		else
				return new ResponseEntity<>(editoraServico.deleteeditora(id),HttpStatus.OK);
		
	}
	
		

	

}
