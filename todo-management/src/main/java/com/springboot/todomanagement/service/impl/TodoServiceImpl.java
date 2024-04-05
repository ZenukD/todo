package com.springboot.todomanagement.service.impl;

import com.springboot.todomanagement.dto.TodoDto;
import com.springboot.todomanagement.entity.Todo;
import com.springboot.todomanagement.exception.ResourceNotFoundException;
import com.springboot.todomanagement.repository.TodoRepository;
import com.springboot.todomanagement.service.TodoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TodoServiceImpl implements TodoService {

    private TodoRepository todoRepository;
    private ModelMapper modelMapper;

    @Override
    public TodoDto addTodo(TodoDto todoDto) {
        Todo todo = modelMapper.map(todoDto, Todo.class);

        Todo savedTodo = todoRepository.save(todo);

        TodoDto savedTodoDto = modelMapper.map(savedTodo, TodoDto.class);

        return savedTodoDto;
    }

    @Override
    public TodoDto getTodo(Long todoId) {

        Todo todo = todoRepository.findById(todoId).orElseThrow(
                () -> new ResourceNotFoundException("Not fount todo with id: " + todoId)
        );

        return modelMapper.map(todo, TodoDto.class);
    }

    @Override
    public List<TodoDto> getAllTodo() {

        List<Todo> todos = todoRepository.findAll();

        return todos.stream().map((todo) -> modelMapper.map(todo, TodoDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public TodoDto updateTodo(TodoDto todoDto, Long id) {

        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Todo not found with id : " + id));
        todo.setTitle(todoDto.getTitle());
        todo.setDescription(todoDto.getDescription());
        todo.setCompleted(todoDto.isCompleted());

        Todo updatedTodo = todoRepository.save(todo);

        return modelMapper.map(updatedTodo, TodoDto.class);
    }

    @Override
    public void deleteTodo(Long todoId) {
        Todo todo = todoRepository.findById(todoId).orElseThrow(
                () -> new ResourceNotFoundException("Not fount todo with id: " + todoId)
        );
        todoRepository.deleteById(todoId);
    }

    @Override
    public TodoDto completeTodo(Long todoId) {
        Todo todo = todoRepository.findById(todoId).orElseThrow(
                () -> new ResourceNotFoundException("Not fount todo with id: " + todoId)
        );
        todo.setCompleted(Boolean.TRUE);
        Todo updatedTodo = todoRepository.save(todo);

        return modelMapper.map(updatedTodo, TodoDto.class);
    }

    @Override
    public TodoDto inCompleteTodo(Long todoId) {
        Todo todo = todoRepository.findById(todoId).orElseThrow(
                () -> new ResourceNotFoundException("Not fount todo with id: " + todoId)
        );
        todo.setCompleted(Boolean.FALSE);
        Todo updatedTodo = todoRepository.save(todo);
        return modelMapper.map(updatedTodo, TodoDto.class);
    }
}
