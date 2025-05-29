package dev.emrx.challenge.literalura.repository;

import dev.emrx.challenge.literalura.model.entity.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface AutorRepository extends JpaRepository<Autor, Long> {


    @Query("SELECT a FROM Autor a WHERE a.anhioDeNacimiento <= :anio AND a.anhioDeFallecimiento > :anio")
    List<Autor> obtenerAutoresVivosPorAnio(int anio);
}
