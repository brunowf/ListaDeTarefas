package br.senai.sc.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.senai.sc.domain.Tarefa;
import br.senai.sc.repositories.TarefaRepository;

@RestController
@RequestMapping(value="/tarefas")
public class TarefaResource {
	
	@Autowired
	private TarefaRepository repo;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Tarefa>> ListarTodos() {
		List<Tarefa> lista = repo.findAll();
		return ResponseEntity.ok(lista);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Tarefa> buscar(@PathVariable Integer id) {
		
		Optional<Tarefa> obj = repo.findById(id);
		return ResponseEntity.ok(obj.orElse(null));
	}
	
	@RequestMapping(value="{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> deletar(@PathVariable Integer id){
		repo.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value="{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody Tarefa obj, @PathVariable Integer id){
		
		obj.setId(id);
		repo.save(obj);
		return ResponseEntity.noContent().build();
		
	}

}
