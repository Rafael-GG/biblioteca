package com.rafaelgg.biblioteca.modelos;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class LibroController {

    private final LibroService service;

    public LibroController(LibroService service) {
        this.service = service;
    }

    @GetMapping
    public List<Libro> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Libro getById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Libro create(@Valid @RequestBody Libro libro) {
        return service.save(libro);
    }

    @PutMapping("/{id}")
    public Libro update(@PathVariable Long id, @Valid @RequestBody Libro libro) {
        return service.update(id, libro);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
