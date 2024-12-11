package com.alura.literalura.repositorio;

import com.alura.literalura.modelos.Autores;
import com.alura.literalura.modelos.Libros;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface IAutoresRepository extends JpaRepository<Autores, Long> {
    Autores findByNameIgnoreCase(String nombre);

    List<Autores> findByAñodeNacimientoLessThanEqualAndAñodeMuerteGreaterThanEqual(int añoInicial, int AñoFinal);
}
