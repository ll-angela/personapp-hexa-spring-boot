package co.edu.javeriana.as.personapp.terminal.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EstudiosModelCli {

    private Integer IdDuenio;
    private Integer IdProfesion;
    private LocalDate fechaGrad;
    private String universidad;
}
