package ru.netology.manager;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class PosterManager {  // Менеджер афиши для фильмов
    private Film[] films = new Film[0]; // массив фильмов
    private int filmsQuantity = 10; // выставлен лимит менеджера в 10

    public PosterManager(int filmsQuantity) {
        this.filmsQuantity = filmsQuantity;
    }

    // Добавление нового фильма методом "save"
    public void save(Film film) {
        // создаем новый массив размером на единицу больше
        // int length = filmsQuantity;
        int length = films.length + 1;
        Film[] tmp = new Film[length];
        // itar + tab
        // копируем поэлементно
        // for (int i = 0; i < films.length; i++) {
        //   tmp[i] = films[i];
        // }
        System.arraycopy(films, 0, tmp, 0, films.length);
        // кладём последний наш элемент
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = film;
        films = tmp;
    }

    //Вывод всех фильмов в порядке добавления
    public Film[] findAll() {
        return films;
    }

    // Метод получения последних фильмов.
    // Вывод максимум лимит* последних добавленных фильмов в обратном от добавления порядке.
    // По умолчанию выводятся последние 10 добавленных фильмов,
    // но при создании менеджера можно указать другое число,
    // чтобы, например, выдавать 5 (а не 10)
    public Film[] findLast() {
        //вычисляем правильный ожидаемый размер
        //результирующего массива-ответа
        int resultLength = films.length;
        if (resultLength > filmsQuantity) {
            resultLength = filmsQuantity;
        }
        Film[] result = new Film[resultLength];
        for (int i = 0; i < resultLength; i++) { // раворачиваем массив
            int index = films.length - i - 1;
            result[i] = films[index];
        }
        return result;
    }
}
