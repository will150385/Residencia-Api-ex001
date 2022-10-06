package br.com.residencia.biblioteca.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.residencia.biblioteca.entity.Emprestimo;
import br.com.residencia.biblioteca.repository.EmprestimoRepository;

@Service
public class EmprestimoService {
	@Autowired
	EmprestimoRepository emprestimoRepository;
	
	
	public List<Emprestimo> getAllEmprestimo(){
		return emprestimoRepository.findAll();
	}
	
	public Emprestimo getEmprestimoById(Integer id) {
		return emprestimoRepository.findById(id).get();
		//return alunoRepository.findById(id).orElse(null);
	}
	public Emprestimo saveEmprestimo(Emprestimo emprestimo) {
		return emprestimoRepository.save(emprestimo);
	}
	
	public Emprestimo updateEmprestimo(Emprestimo emprestimo,Integer id) {
		//Alunos alunoExistenteNoBanco=alunoRepository.findById(id).get();
		
		Emprestimo emprestimoExistenteNoBanco= getEmprestimoById(id);
		
		emprestimoExistenteNoBanco.setDataEmprestimo(emprestimo.getDataEmprestimo());
		emprestimoExistenteNoBanco.setDataEntrega(emprestimo.getDataEntrega());
		emprestimoExistenteNoBanco.setValorEmprestimo(emprestimo.getValorEmprestimo());
		/*emprestimoExistenteNoBanco.setCpf(alunos.getCpf());
		emprestimoExistenteNoBanco.setDatanascimento(alunos.getDatanascimento());
		emprestimoExistenteNoBanco.setEmprestimo(alunos.getEmprestimo());
		emprestimoExistenteNoBanco.setLogradouro(alunos.getLogradouro());
		emprestimoExistenteNoBanco.setNumerologradouro(alunos.getNumerologradouro());*/
		
		return emprestimoRepository.save(emprestimoExistenteNoBanco);
		
		//return alunoRepository.save(alunos);
	}
	public Emprestimo deleteEmprestimo(Integer id) {
		 emprestimoRepository.deleteById(id);
		 return getEmprestimoById(id);
		 
	}
}
