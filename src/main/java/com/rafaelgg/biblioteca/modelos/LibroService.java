package com.rafaelgg.biblioteca.modelos;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class LibroService {
    private final LibroRepository repository;

    public LibroService(LibroRepository repository) {
        this.repository = repository;
    }

    public List<Libro> findAll() {
        return repository.findAll();
    }

    public Libro findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Libro no encontrado con id: " + id));
    }

    public Libro save(Libro libro) {
        return repository.save(libro);
    }

    public Libro update(Long id, Libro libro) {
        Libro existing = findById(id);
        existing.setTitle(libro.getTitle());
        existing.setAuthor(libro.getAuthor());
        existing.setYear(libro.getYear());
        existing.setDescription(libro.getDescription());
        return repository.save(existing);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
