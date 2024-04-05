package com.springboot.todomanagement.service;

import com.springboot.todomanagement.dto.TodoDto;

import java.util.List;

public interface TodoService {

    TodoDto addTodo(TodoDto todoDto);
    TodoDto getTodo(Long todoId);
    List<TodoDto> getAllTodo();
    TodoDto updateTodo(TodoDto todoDto, Long todoId);

    void deleteTodo(Long todoId);
    TodoDto completeTodo(Long todoId);
    TodoDto inCompleteTodo(Long todoId);
}
