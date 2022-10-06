package br.com.residencia.biblioteca.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.residencia.biblioteca.entity.Editora;
import br.com.residencia.biblioteca.repository.EditoraRepository;

@Service
public class EditoraServico {
	@Autowired
	EditoraRepository editoraRepository;
	
	
	public List<Editora> getAlleditora(){
		return editoraRepository.findAll();
	}
	public Editora getEditoraById(Integer id) {
		return editoraRepository.findById(id).get();
		//return alunoRepository.findById(id).orElse(null);
	}
	public Editora saveeditora(Editora editora) {
		return editoraRepository.save(editora);
	}
	
	public Editora updateeditora(Editora editora,Integer id) {
		//Alunos alunoExistenteNoBanco=alunoRepository.findById(id).get();
		
		Editora editoraExistenteNoBanco= getEditoraById(id);
		
		editoraExistenteNoBanco.setNome(editora.getNome());
		//editoraExistenteNoBanco.setCodigoEditora(editora.getCodigoEditora());
		/*editoraExistenteNoBanco.setComplemento(editora.getComplemento());
		editoraExistenteNoBanco.setCpf(editora.getCpf());
		editoraExistenteNoBanco.setDatanascimento(editora.getDatanascimento());
		editoraExistenteNoBanco.setEmprestimo(editora.getEmprestimo());
		editoraExistenteNoBanco.setLogradouro(editora.getLogradouro());
		editoraExistenteNoBanco.setNumerologradouro(editora.getNumerologradouro());*/
		
		return editoraRepository.save(editoraExistenteNoBanco);
		
		//return alunoRepository.save(alunos);
	}
		
	public Editora deleteeditora(Integer id) {
		 editoraRepository.deleteById(id);
		 return getEditoraById(id);
		 
	}
}
