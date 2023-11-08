package ru.egartech.appmvc1.document.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.egartech.appmvc1.document.model.PersonDocType;

import java.util.List;

public interface PersonDocTypeRepository extends JpaRepository<PersonDocType, Integer> {
    @Query("select pdt from PersonDocType pdt")
    List<PersonDocType> getDocType();
}
