package br.senai.sc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.senai.sc.domain.Lista;
import br.senai.sc.domain.Tarefa;
import br.senai.sc.repositories.ListaRepository;
import br.senai.sc.repositories.TarefaRepository;

@SpringBootApplication
public class ListaDeTarefasApplication implements CommandLineRunner{

	@Autowired
	private ListaRepository listaRepo;
	
	@Autowired
	private TarefaRepository tarefaRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(ListaDeTarefasApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		
		Lista l1 = new Lista(null, "Primeira lista");
		
		Tarefa i1 = new Tarefa(null, "Item 1", false, l1);
		Tarefa i2 = new Tarefa(null, "Item 2", false, l1);
		Tarefa i3 = new Tarefa(null, "Item 3", false, l1);
		Tarefa i4 = new Tarefa(null, "Item 4", false, l1);
		Tarefa i5 = new Tarefa(null, "Item 5", false, l1);

		l1.getTarefas().add(i1);
		l1.getTarefas().add(i2);
		l1.getTarefas().add(i3);
		l1.getTarefas().add(i4);
		l1.getTarefas().add(i5);
		
		listaRepo.save(l1);
		tarefaRepo.save(i1);
		tarefaRepo.save(i2);
		tarefaRepo.save(i3);
		tarefaRepo.save(i4);
		tarefaRepo.save(i5);
		
	}
}
