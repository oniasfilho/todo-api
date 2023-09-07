package io.oniasfilho.todoapi.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Todo")
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int todoId;

    private String status;
    private String title;
    private Integer ownerId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ownerId", referencedColumnName = "id", insertable = false, updatable = false)
    private User owner;
}