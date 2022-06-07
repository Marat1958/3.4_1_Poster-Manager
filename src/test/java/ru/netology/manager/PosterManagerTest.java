package ru.netology.manager;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class PosterManagerTest {

    @Test
    void showAllAddedMovies() {
        Film first = new Film(1, "Смерть на Ниле", "mysticism", true);
        Film second = new Film(2, "Тор", "action", false);
        Film third = new Film(3, "Равнодушные", "drama", false);
        Film fourth = new Film(4, "Утраченные иллюзии", "historical", false);
        Film fifth = new Film(5, "Воспоминания о будущем", "biography", true);
        Film sixth = new Film(6, "Первый встречный", "melodrama", false);
        Film seventh = new Film(7, "Пламенное сердце", "cartoon", false);
        Film eighth = new Film(8, "Однажды в пустыне", "action", true);
        Film ninth = new Film(9, "Зверопой 2", "cartoon", false);
        Film tenth = new Film(10, "Жажда золота", "thriller", false);

        PosterManager manager = new PosterManager();
        manager.save(first);
        manager.save(second);
        manager.save(third);
        manager.save(fourth);
        manager.save(fifth);
        manager.save(sixth);
        manager.save(seventh);
        manager.save(eighth);
        manager.save(ninth);
        manager.save(tenth);

        Film[] expected = {first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth};
        Film[] actual = manager.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void showAllMoviesInReverseOrder() {
        Film first = new Film(1, "Смерть на Ниле", "mysticism", true);
        Film second = new Film(2, "Тор", "action", false);
        Film third = new Film(3, "Равнодушные", "drama", false);
        Film fourth = new Film(4, "Утраченные иллюзии", "historical", false);
        Film fifth = new Film(5, "Воспоминания о будущем", "biography", true);
        Film sixth = new Film(6, "Первый встречный", "melodrama", false);
        Film seventh = new Film(7, "Пламенное сердце", "cartoon", false);
        Film eighth = new Film(8, "Однажды в пустыне", "action", true);
        Film ninth = new Film(9, "Зверопой 2", "cartoon", false);
        Film tenth = new Film(10, "Жажда золота", "thriller", false);

        PosterManager manager = new PosterManager();
        manager.save(first);
        manager.save(second);
        manager.save(third);
        manager.save(fourth);
        manager.save(fifth);
        manager.save(sixth);
        manager.save(seventh);
        manager.save(eighth);
        manager.save(ninth);
        manager.save(tenth);

        Film[] expected = {tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second, first};
        Film[] actual = manager.findLast();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSaveNineFilms() {
        Film first = new Film(1, "Смерть на Ниле", "mysticism", true);
        Film second = new Film(2, "Тор", "action", false);
        Film third = new Film(3, "Равнодушные", "drama", false);
        Film fourth = new Film(4, "Утраченные иллюзии", "historical", false);
        Film fifth = new Film(5, "Воспоминания о будущем", "biography", true);
        Film sixth = new Film(6, "Первый встречный", "melodrama", false);
        Film seventh = new Film(7, "Пламенное сердце", "cartoon", false);
        Film eighth = new Film(8, "Однажды в пустыне", "action", true);
        Film ninth = new Film(9, "Зверопой 2", "cartoon", false);
        Film tenth = new Film(10, "Жажда золота", "thriller", false);

        PosterManager manager = new PosterManager();
        manager.save(first);
        manager.save(second);
        manager.save(third);
        manager.save(fourth);
        manager.save(fifth);
        manager.save(sixth);
        manager.save(seventh);
        manager.save(eighth);
        manager.save(ninth);

        Film[] expected = {ninth, eighth, seventh, sixth, fifth, fourth, third, second, first};
        Film[] actual = manager.findLast();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldLeaveTenFilms() {
        Film first = new Film(1, "Смерть на Ниле", "mysticism", true);
        Film second = new Film(2, "Тор", "action", false);
        Film third = new Film(3, "Равнодушные", "drama", false);
        Film fourth = new Film(4, "Утраченные иллюзии", "historical", false);
        Film fifth = new Film(5, "Воспоминания о будущем", "biography", true);
        Film sixth = new Film(6, "Первый встречный", "melodrama", false);
        Film seventh = new Film(7, "Пламенное сердце", "cartoon", false);
        Film eighth = new Film(8, "Однажды в пустыне", "action", true);
        Film ninth = new Film(9, "Зверопой 2", "cartoon", false);
        Film tenth = new Film(10, "Жажда золота", "thriller", false);
        Film eleventh = new Film(11, "Бладшот", "action", false);

        PosterManager manager = new PosterManager();
        manager.save(first);
        manager.save(second);
        manager.save(third);
        manager.save(fourth);
        manager.save(fifth);
        manager.save(sixth);
        manager.save(seventh);
        manager.save(eighth);
        manager.save(ninth);
        manager.save(tenth);
        manager.save(eleventh);

        Film[] expected = {eleventh, tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second};
        Film[] actual = manager.findLast();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSaveInConstructorRange() {
        Film first = new Film(1, "Смерть на Ниле", "mysticism", true);
        Film second = new Film(2, "Тор", "action", false);
        Film third = new Film(3, "Равнодушные", "drama", false);
        Film fourth = new Film(4, "Утраченные иллюзии", "historical", false);
        Film fifth = new Film(5, "Воспоминания о будущем", "biography", true);
        PosterManager manager = new PosterManager(3);
        manager.save(first);
        manager.save(second);
        manager.save(third);
        manager.save(fourth);
        manager.save(fifth);

        Film[] expected = {fifth, fourth, third};
        Film[] actual = manager.findLast();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSaveOneFilm() {
        Film first = new Film(1, "Смерть на Ниле", "mysticism", true);

        PosterManager manager = new PosterManager();
        manager.save(first);

        Film[] expected = {first};
        Film[] actual = manager.findLast();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldRemainEmpty() {

        PosterManager manager = new PosterManager();
        manager.findAll();

        Film[] expected = {};
        Film[] actual = manager.findLast();
        assertArrayEquals(expected, actual);
    }
}