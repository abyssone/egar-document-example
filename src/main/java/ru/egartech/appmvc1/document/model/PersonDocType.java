package ru.egartech.appmvc1.document.model;

import jakarta.persistence.*;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Data
@Table(name = "doc_type")
public class PersonDocType implements Serializable {
    /**
     * Идентификатор
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    protected Integer id;
    /**
     * Код
     */
    @Column(name = "code", unique = true)
    @NotBlank
    @Size(min=2, max=3)
    private String code;

    /**
     * Наименование
     */
    @Size(max = 250, message = "Наименование типа документов удостоверяющих личность не более 250 символов")
    @Column(name = "name", length = 250)
    private String name;
}
