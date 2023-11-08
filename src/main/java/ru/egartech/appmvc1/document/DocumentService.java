package ru.egartech.appmvc1.document;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.egartech.appmvc1.document.model.Document;
import ru.egartech.appmvc1.document.model.PersonDocType;
import ru.egartech.appmvc1.document.repository.DocumentRepository;
import ru.egartech.appmvc1.document.repository.PersonDocTypeRepository;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class DocumentService {
    private final DocumentRepository documentRepository;
    private final PersonDocTypeRepository personDocTypeRepository;

    public List<Document> listDocuments() {
        return documentRepository.findAll();
    }

    public List<Document> listSearchDocuments(String title) {
        if (title != null){
            title = "%" + title.toLowerCase() + "%";
        }
        return documentRepository.findByTitleDocuments(title);
    }

    public List<Document> listSearchDocuments2(String title, String numeral) {
        if (title != null){
            title = "%" + title.toLowerCase() + "%";
        }
        if (numeral != null){
            numeral = "%" + numeral + "%";
        }
        return documentRepository.findByTitleDocuments2(title, numeral);
    }

    public Document getDocumentByTitle(String title) {
        return documentRepository.findByTitleDocument(title).orElse(null);
    }

    public List<PersonDocType> listDocType() {
        return personDocTypeRepository.getDocType();
    }

    public void saveDocument(Document document) {
        log.info("Saving new {}", document);
        documentRepository.save(document);
    }

    public void deleteDocument(Long id) {
        documentRepository.deleteById(id);
    }

    public Document getDocumentById(Long id) {
        return documentRepository.findById(id).orElse(null);
    }
}
