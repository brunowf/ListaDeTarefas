package br.senai.sc.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.senai.sc.domain.Tarefa;
import br.senai.sc.sevices.TarefaService;

@RestController
@RequestMapping(value="/tarefas")
public class TarefaResource {
	
	@Autowired
	private TarefaService serv;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Tarefa>> ListarTodos() {
		
		List<Tarefa> lista = serv.listarTodos();
		return ResponseEntity.ok(lista);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Tarefa> buscar(@PathVariable Integer id) {
		
		Tarefa obj = serv.buscarPorId(id);
		return ResponseEntity.ok(obj);
	}
	
	@RequestMapping(value="{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> deletar(@PathVariable Integer id){
		
		serv.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value="{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody Tarefa obj, @PathVariable Integer id){
		
		obj.setId(id);
		serv.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody Tarefa obj){
		
		serv.insert(obj);
		return ResponseEntity.noContent().build();
	}
	

}
