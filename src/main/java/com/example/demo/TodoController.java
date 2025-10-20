package com.example.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/todos")
public class TodoController {

    /**
     * Naive in-memory store; swap with a proper persistence layer later.
     */
    private final Map<Long, Todo> todos = new HashMap<>();
    private long nextId = 1;

    /**
     * Return all todos currently in memory.
     */
    @GetMapping
    public ResponseEntity<List<Todo>> getAllTodos() {
        return ResponseEntity.ok(new ArrayList<>(todos.values()));
    }

    /**
     * Return a single todo or 404 if it does not exist.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Todo> getTodoById(@PathVariable Long id) {
        Todo todo = todos.get(id);
        return todo != null ? ResponseEntity.ok(todo)
                : ResponseEntity.notFound().build();
    }

    /**
     * Create a new todo with an auto-incremented id.
     */
    @PostMapping
    public ResponseEntity<Todo> createTodo(@RequestBody Todo newTodo) {
        newTodo.setId(nextId++);
        todos.put(newTodo.getId(), newTodo);
        return ResponseEntity.ok(newTodo);
    }

    /**
     * Replace an existing todo with the payload values.
     */
    @PutMapping("/{id}")
    public ResponseEntity<Todo> updateTodo(@PathVariable Long id, @RequestBody Todo updatedTodo) {
        if (!todos.containsKey(id)) {
            return ResponseEntity.notFound().build();
        }
        updatedTodo.setId(id);
        todos.put(id, updatedTodo);
        return ResponseEntity.ok(updatedTodo);
    }

    /**
     * Delete a todo if present.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable Long id) {
        return todos.remove(id) != null
                ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }
}
