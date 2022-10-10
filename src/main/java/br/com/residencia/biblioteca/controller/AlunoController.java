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

import br.com.residencia.biblioteca.entity.Alunos;
import br.com.residencia.biblioteca.service.AlunoServico;

@RestController
@RequestMapping("/alunos") 
public class AlunoController {
	@Autowired
	AlunoServico alunoServico;
	
	@GetMapping
	public ResponseEntity<List<Alunos>>getAllAlunos(){
		return new ResponseEntity<>(alunoServico.getAllAlunos(),HttpStatus.OK);
	}
	//@GetMapping("/hello")
	//public ResponseEntity<String> helloWord() {
		//return new ResponseEntity<>("A api esta funcionando",HttpStatus.OK);
	//}
	@GetMapping("/{id}")
	public ResponseEntity<Alunos>getAlunosById(@PathVariable Integer Id){
		Alunos alunos = alunoServico.getAlunosById(Id);
		if (null!= alunos)
			return new ResponseEntity<>(alunos,HttpStatus.OK);
		else 
			return new ResponseEntity<>(alunos,HttpStatus.NOT_FOUND);
	}
	
	@PostMapping
	public ResponseEntity<Alunos> saveAlunos(@RequestBody Alunos alunos) {
		return new ResponseEntity<>(alunoServico.saveAlunos(alunos),
				HttpStatus.CREATED);
	}
	@PutMapping("/{id}")
	public ResponseEntity<Alunos>updateAluno(@RequestBody Alunos alunos,@PathVariable Integer id ){
		return new ResponseEntity<>(alunoServico.updateAluno(alunos,id),HttpStatus.OK);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Alunos>deleteAlunos(@PathVariable Integer id){
		return new ResponseEntity<>(alunoServico.deleteAlunos(id),HttpStatus.OK);
	}
	
	
	
	

}
