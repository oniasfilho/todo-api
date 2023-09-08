package io.oniasfilho.todoapi.repository;

import io.oniasfilho.todoapi.model.Todo;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface TodoRepository extends JpaRepository<Todo, Integer> {
    Optional<List<Todo>> findAllByOwnerId(Integer ownerId);

    @Transactional
    @Modifying
    @Query("DELETE FROM Todo t WHERE t.status = true")
    void deleteAllByStatusTrue();

}
