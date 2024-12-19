package com.proyect.GameStore.Implements;

import com.proyect.GameStore.Entity.ConsolaEntity;
import com.proyect.GameStore.Repository.ConsolaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

@Service
public class ConsolaImplt {
    @Autowired
    private ConsolaRepository consolaRepository;

    @Transactional
    public Stream<ConsolaEntity> getConsolasStream() {
        return consolaRepository.findAll().stream();
    }

    public void inicioConsola(String name) {
        System.out.println("llega al implement");
        ConsolaEntity consola = consolaRepository.findByName(name);
        System.out.println("Name: " + consola.getName() + "id: " + consola.getConsole_id());

        exercise1(getConsolasStream());


    }


    /*
     *Regresar un Stream unicamente con los titulos de todas las consolas que sean de XBOX
     * durante el proceso imprimir los resultados ignorando los repetidos.
     */
    static void exercise1(Stream<ConsolaEntity> stream) {
        boolean r = stream.filter(e-> e.getName().equals("nintendo"))
                .count() == 1;
        System.out.println("Exercise 1");
        System.out.println("Respuesta: " + r);
    }

    /*
     *Regresar true si el stream contiene al menos un videojuego con número de ventas mayor a 10
     * y no este en descuento o su precio sea mayor a 9.99 de lo contrario regresar false.
     */
    static Stream<String> exercise2(Stream<ConsolaEntity> stream) {
        return null;
    }

    /*
     *Regresar el videojuego con el mayor número de ventas
     * unicamente contemplando los primers 10 elementos del stream.
     */
    static ConsolaEntity exercise3(Stream<ConsolaEntity> stream) {
        return null;
    }

    /*
     *Regresar un stream con todos los comentarios del cada review de todos los videojuegos del stream.
     */
    static Stream<String> exercise4(Stream<ConsolaEntity> stream) {
        return null;
    }

    /*
     *Regresar un stream con los todos los videojuegos con precio menores a 20.0
     * sin utilizar el operador filter().
     */
    static Stream<Double> exercise5(Stream<ConsolaEntity> stream) {
        return null;
    }
}
