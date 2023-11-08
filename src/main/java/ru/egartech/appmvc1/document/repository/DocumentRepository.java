package ru.egartech.appmvc1.document.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.egartech.appmvc1.document.model.Document;

import java.util.List;
import java.util.Optional;

public interface DocumentRepository extends JpaRepository<Document, Long> {
    @Query("select d from Document d where ?1 is null or lower(d.title) = ?1")
    Optional<Document> findByTitleDocument(String titleDocument);

    @Query("select d from Document d where ?1 is null or lower(d.title) like ?1")
    List<Document> findByTitleDocuments(String titleDocument);

    @Query("select d from Document d where ?1 is null or lower(d.title) like ?1 and " +
            "( ?1 is null or d.numeral like ?2)")
    List<Document> findByTitleDocuments2(String titleDocument, String numeral);
}
