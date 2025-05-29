package dev.emrx.challenge.literalura.service;

import dev.emrx.challenge.literalura.domain.AutorDto;
import dev.emrx.challenge.literalura.domain.LibroDto;
import dev.emrx.challenge.literalura.model.entity.Autor;
import dev.emrx.challenge.literalura.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class AutorService {

    @Autowired
    private AutorRepository repository;


    public List<AutorDto> obtenerAutores() {
        return repository.findAll().stream()
                .map(autor -> new AutorDto(autor))
                .toList();
    }


    public List<AutorDto> obtenerAutoresVivosPorAnio(int anio) {
        return repository.obtenerAutoresVivosPorAnio(anio).stream()
                .map(autor -> new AutorDto(autor))
                .toList();
    }
}
