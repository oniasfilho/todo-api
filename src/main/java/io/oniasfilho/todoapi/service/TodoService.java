package io.oniasfilho.todoapi.service;

import io.oniasfilho.todoapi.dto.TodoDTO;
import io.oniasfilho.todoapi.model.Todo;
import io.oniasfilho.todoapi.repository.TodoRepository;
import io.oniasfilho.todoapi.repository.UserRepository;
import io.oniasfilho.todoapi.security.SecurityUtil;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoService {
    private final UserRepository userRepository;
    private final TodoRepository repository;
    public List<TodoDTO> getAllTodos(Integer ownerId){
        return repository.findAllByOwnerId(ownerId).orElseThrow().stream().map(TodoDTO::new).toList();
    }

    public void addTodo(TodoDTO todo) {
        var owner = userRepository.findByEmail(SecurityUtil.getLoggedUser().getEmail()).orElseThrow();
        repository.save(
                Todo.builder()
                        .title(todo.getTitle())
                        .status(todo.getStatus())
                        .owner(owner)
                        .build()
        );
    }

    public void statusToggle(Integer todoId) {
        var todo = repository.findById(todoId).orElseThrow();
        todo.setStatus(!todo.getStatus());
        repository.save(todo);
    }

    public void update(TodoDTO todo) {
        repository.findById(todo.getTodoId()).ifPresentOrElse(existing -> {
            existing.setTitle(todo.getTitle());
            existing.setStatus(todo.getStatus());
            repository.save(existing);
        }, () -> {
            throw new EntityNotFoundException("No such todo with the ID of " + todo.getTodoId());
        });
    }
    @Transactional
    public void deleteTodo(Integer todoId) {
        Todo todo = repository.findById(todoId).orElseThrow(() -> new EntityNotFoundException("Todo not found"));
        repository.delete(todo);
    }

    public void deleteAllCompleted() {
        repository.deleteAllByStatusTrue();
    }
}
