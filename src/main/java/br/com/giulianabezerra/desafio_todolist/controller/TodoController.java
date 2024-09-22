package br.com.giulianabezerra.desafio_todolist.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.giulianabezerra.desafio_todolist.entity.Todo;
import br.com.giulianabezerra.desafio_todolist.service.TodoSevice;


@RestController
@RequestMapping("/todos")
public class TodoController {
    private TodoSevice todoSevice;
    
   
    public TodoController(TodoSevice todoSevice) {
        this.todoSevice = todoSevice;
    }

    @PostMapping
    List<Todo> create(@RequestBody Todo todo){
        return todoSevice.create(todo);
    }

    @GetMapping
    List<Todo> list(){
        return todoSevice.list();
    }

    @PutMapping
    List<Todo> update(@RequestBody Todo todo){
        return todoSevice.update(todo);
    }

    @DeleteMapping("{id}")
    List<Todo> delete(@PathVariable("id") Long id){
        return todoSevice.delete(id);
    }


}
