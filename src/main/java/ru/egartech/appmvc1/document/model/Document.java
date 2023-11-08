package ru.egartech.appmvc1.document.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Название
     */
    @Column
    private String title;

    /**
     * Серия документа
     */
    @Column(name = "series", length = 10)
    private String series;

    /**
     * Номер документа
     */
    @Column(length = 30)
    private String numeral;

    /**
     * Комментарий
     */
    @Column(columnDefinition = "text")
    private String description;

    /**
     * Тип документа удостоверяющего личность
     */
    @JoinColumn(name = "type_code", referencedColumnName = "code", foreignKey = @ForeignKey(name = "type_code_key"))
    @ManyToOne(fetch = FetchType.EAGER)
    private PersonDocType typeCode;
}
