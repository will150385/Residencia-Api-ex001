package br.com.residencia.biblioteca.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.residencia.biblioteca.entity.Alunos;
import br.com.residencia.biblioteca.repository.AlunosRepository;

@Service
public class AlunoServico {
	@Autowired
	AlunosRepository alunoRepository;
	
	
	public List<Alunos> getAllAlunos(){
		return alunoRepository.findAll();
	}
	
	public Alunos getAlunosById(Integer id) {
		return alunoRepository.findById(id).get();
		//return alunoRepository.findById(id).orElse(null);
	}
	
	public Alunos saveAlunos(Alunos alunos) {
		return alunoRepository.save(alunos);
	}
	
	public Alunos updateAluno(Alunos alunos,Integer id) {
		//Alunos alunoExistenteNoBanco=alunoRepository.findById(id).get();
		
		Alunos alunoExistenteNoBanco= getAlunosById(id);
		
		alunoExistenteNoBanco.setBairro(alunos.getBairro());
		alunoExistenteNoBanco.setCidade(alunos.getCidade());
		alunoExistenteNoBanco.setComplemento(alunos.getComplemento());
		alunoExistenteNoBanco.setCpf(alunos.getCpf());
		alunoExistenteNoBanco.setDatanascimento(alunos.getDatanascimento());
		alunoExistenteNoBanco.setEmprestimo(alunos.getEmprestimo());
		alunoExistenteNoBanco.setLogradouro(alunos.getLogradouro());
		alunoExistenteNoBanco.setNumerologradouro(alunos.getNumerologradouro());
		
		return alunoRepository.save(alunoExistenteNoBanco);
		
		//return alunoRepository.save(alunos);
	}
	
	public Alunos deleteAlunos(Integer id) {
		 alunoRepository.deleteById(id);
		 return getAlunosById(id);
		 
	}
		
	
}
		


