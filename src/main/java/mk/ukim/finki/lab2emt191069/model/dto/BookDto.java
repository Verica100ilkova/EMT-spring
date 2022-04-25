package mk.ukim.finki.lab2emt191069.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookDto {

    private String name;

    private Long category;

    private Long author;

    private Integer availableCopies;

    private Boolean mark = false;
}