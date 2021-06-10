package br.com.mercadolivre.desafioquality.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
public class Room {

    @NotBlank(message = "Room name cannot be blank.")
    @Size(max = 30, message = "Maximum room name size is 30.")
    @Pattern(regexp = "^([A-Z][a-z]+)+$", message = "Room name must start with a uppercase letter.")
    private String name;

    @NotNull(message = "Room height cannot be null.")
    @Range(min = 0, max = 33, message = "Room height must be 33 meters maximum.")
    private Double height;

    @NotNull(message = "Room width cannot be null.")
    @Range(min = 0, max = 33, message = "Room width must be 25 meters maximum.")
    private Double width;

    public Double getSquareFoot(){
        return height * width;
    }
}
