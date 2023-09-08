package io.oniasfilho.todoapi.dto;

import io.oniasfilho.todoapi.model.Todo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TodoDTO {
    private Integer todoId;
    private Boolean status;
    private String title;

    public TodoDTO (Todo todo) {
        todoId = todo.getTodoId();
        status = todo.getStatus();
        title = todo.getTitle();
    }
}
