package br.com.residencia.biblioteca.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.residencia.biblioteca.entity.Livros;
import br.com.residencia.biblioteca.repository.LivrosRepository;

@Service
public class LivrosService {
	@Autowired
	LivrosRepository livrosRepository;
	
	public List<Livros> getAllLivros(){
		return livrosRepository.findAll();
	}
	public Livros getLivrosById(Integer id) {
		return livrosRepository.findById(id).get();
		//return alunoRepository.findById(id).orElse(null);
	}
	public Livros savelivros(Livros livros) {
		return livrosRepository.save(livros);
	}
	
	public Livros updateLivros(Livros livros,Integer id) {
		//Alunos alunoExistenteNoBanco=alunoRepository.findById(id).get();
		
		Livros livrosExistenteNoBanco= getLivrosById(id);
		
		livrosExistenteNoBanco.setCodigoIsbn(livros.getCodigoIsbn());
		livrosExistenteNoBanco.setDataLancamento(livros.getDataLancamento());
		livrosExistenteNoBanco.setNomeAutor(livros.getNomeAutor());
		livrosExistenteNoBanco.setNomeLivro(livros.getNomeLivro());
		/*livrosExistenteNoBanco.setDatanascimento(alunos.getDatanascimento());
		livrosExistenteNoBanco.setEmprestimo(alunos.getEmprestimo());
		livrosExistenteNoBanco.setLogradouro(alunos.getLogradouro());
		livrosExistenteNoBanco.setNumerologradouro(alunos.getNumerologradouro());*/
		
		return livrosRepository.save(livrosExistenteNoBanco);
		
		//return alunoRepository.save(alunos);
	}
	public Livros deleteLivros(Integer id) {
		 livrosRepository.deleteById(id);
		 return getLivrosById(id);
		 
	}
	

}
