package br.com.mercadolivre.desafioquality.entities;


import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@AllArgsConstructor
public class Property {

    @NotBlank(message = "Name cannot be blank.")
    @Size(max = 30, message = "Maximum name size is 30.")
    @Pattern(regexp = "^([A-Z][a-z]+)+$", message = "Name must start with a uppercase letter.")
    private String name;

    @NotBlank(message = "District cannot be blank.")
    @Size(max = 30, message = "Maximum district size is 45.")
    private String district;

    @Valid
    @NotEmpty(message = "There should be at least one room.")
    private List<Room> rooms;

    private int getRoomQuantity(){
        return rooms.size();
    }
}
