package ru.netology.manager;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class Film {
    private int id;
    private String movieName;
    private String movieGenre;
    private boolean premiereTomorrow;
}
