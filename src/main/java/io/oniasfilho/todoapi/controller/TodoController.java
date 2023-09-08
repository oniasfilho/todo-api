package io.oniasfilho.todoapi.controller;

import io.oniasfilho.todoapi.dto.TodoDTO;
import io.oniasfilho.todoapi.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static io.oniasfilho.todoapi.security.SecurityUtil.*;

@RestController
@RequestMapping("/api/todo")
@RequiredArgsConstructor
public class TodoController {
    private final TodoService service;
    @GetMapping
    public List<TodoDTO> getTodos() {
        return service.getAllTodos(getLoggedUser().getId());
    }

    @PostMapping
    public void addTodo(@RequestBody TodoDTO todo) {
        service.addTodo(todo);
    }

    @PutMapping("/{todoId}/status")
    public void statusToggle(@PathVariable Integer todoId) {
        service.statusToggle(todoId);
    }

    @PutMapping
    public void updateTitle(@RequestBody TodoDTO todo) {
        service.update(todo);
    }

    @DeleteMapping("/{todoId}")
    public void deleteTodo(@PathVariable Integer todoId) {
        service.deleteTodo(todoId);
    }

    @DeleteMapping("/completed")
    public void deleteAllCompleted() {
        service.deleteAllCompleted();
    }
}
