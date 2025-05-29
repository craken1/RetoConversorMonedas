package dev.emrx.challenge.literalura.service;

import dev.emrx.challenge.literalura.domain.LibroDto;
import dev.emrx.challenge.literalura.model.DatosLibro;
import dev.emrx.challenge.literalura.model.entity.Idioma;
import dev.emrx.challenge.literalura.model.entity.Libro;
import dev.emrx.challenge.literalura.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibroService {

    @Autowired
    private LibroRepository repository;


    public LibroDto guardarLibro(DatosLibro datos) {
        Optional<Libro> nuevo = repository.findByTitulo(datos.titulo());

        if(!nuevo.isPresent()) {
            Libro libro = repository.save(new Libro(datos));
            return new LibroDto(libro);
        } else {
            System.out.println("El libro ya existe en la base de datos");
        }

        return new LibroDto(nuevo.get());
    }


    public LibroDto obtenerLibroPorId(Long id) {
        return repository.findById(id).map(LibroDto::new).orElse(null);
    }


    public List<LibroDto> obtenerLibros() {
        return repository.findAll().stream()
                .map(LibroDto::new)
                .toList();
    }


    public List<LibroDto> obtenerLibrosPorIdioma(Idioma idioma) {
        return repository.obtenerLibrosPorIdioma(idioma).stream()
                .map(LibroDto::new)
                .toList();
    }
}
