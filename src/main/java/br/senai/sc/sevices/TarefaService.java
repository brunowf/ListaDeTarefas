package br.senai.sc.sevices;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.senai.sc.domain.Tarefa;
import br.senai.sc.repositories.TarefaRepository;
import br.senai.sc.sevices.exceptions.ObjetoNaoEncontradoException;

@Service
public class TarefaService {
	
	@Autowired
	private TarefaRepository repo;
	
	public List<Tarefa> listarTodos(){
		return repo.findAll();
	}
	
	public Tarefa buscarPorId(Integer id) {
		Optional<Tarefa> obj = repo.findById(id);
		return obj.orElseThrow( () -> new ObjetoNaoEncontradoException("Tarefa não encontrada"));
	}
	
	public void delete(Integer id) {
		buscarPorId(id);
		repo.deleteById(id);
	}
	
	public void update(Tarefa obj) {
		buscarPorId(obj.getId());
		repo.save(obj);
	}
	
	public void insert(Tarefa obj) {
		obj.setId(null);
		repo.save(obj);
	}

}
