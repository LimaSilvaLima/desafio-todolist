package br.com.giulianabezerra.desafio_todolist.service;

//import org.hibernate.mapping.List;
import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import br.com.giulianabezerra.desafio_todolist.repository.TodoRepository;
import br.com.giulianabezerra.desafio_todolist.entity.Todo;



@Service
public class TodoSevice {
    private TodoRepository todoRepository;
    //injeção de dependencia via construtor
    public TodoSevice(TodoRepository todoRepository){
        this.todoRepository = todoRepository;
    }

    public List<Todo> create(Todo todo){
        todoRepository.save(todo);
        return list();
    }



    public List<Todo> list(){
        Sort sort = Sort.by("prioridade").descending().and(Sort.by("nome").ascending());
        return todoRepository.findAll(sort);
        
    }

    public List<Todo> update(Todo todo){
        todoRepository.save(todo);
        return list();
    }

    public List<Todo> delete(Long id){
        todoRepository.deleteById(id);;
        return list();
    }
}
