package com.restaurante.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.restaurante.entities.Usuarios;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.hibernate.validator.constraints.UniqueElements;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuariosDto {

    @NonNull
    @Size(min = 5, max = 200, message = "O campo nome deve ter entre 5 e 200 caracteres.")
    private String nome;
    @NonNull
    @Email
    private String email;
    @NonNull
    @Size(min = 5, max = 200, message = "O campo telefone deve ter entre 10 e 11 caracteres.")
    private String telefone;
    @NonNull
    @Size(min = 5, max = 200, message = "O campo endereço deve ter entre 5 e 200 caracteres.")
    private String endereco;
    @Past(message = "Data de nascimento maior que a data atual.")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataDeNascimento;
    @NonNull
    @Size(min = 8, max = 16, message = "O campo usuário precisa ter entre 8 e 16 caracteres.")
    private String username;
    @NonNull
    @Size(min = 8, max = 16, message = "O campo senha deve ter entre 5 e 200 caracteres.")
    private String senha;

    private LocalDateTime criadoEm;
    private LocalDateTime alteradoEm;
    private LocalDateTime deletadoEm;

    public UsuariosDto(Usuarios usuarios){
        this.nome = usuarios.getNome();
        this.email = usuarios.getEmail();
        this.telefone = usuarios.getTelefone();
        this.endereco = usuarios.getEndereco();
        this.dataDeNascimento = usuarios.getDataDeNascimento();
        this.criadoEm = usuarios.getCriadoEm();
        this.alteradoEm = usuarios.getAlteradoEm();
        this.deletadoEm = usuarios.getDeletadoEm();
    }

}
