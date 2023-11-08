package ru.egartech.appmvc1.document.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.egartech.appmvc1.document.DocumentService;
import ru.egartech.appmvc1.document.model.Document;

@Controller
@RequiredArgsConstructor
public class DocumentController {
    private final DocumentService documentService;
    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/document/search")
    public String searchDocuments(@RequestParam(name = "title", required = false) String title, Model model) {
        if (title != null) {
            model.addAttribute("documents", documentService.listSearchDocuments(title));
            return "documents";
        }
        return "redirect:/";
    }

    @GetMapping("/document/search/{title}/{numeral}")
    public String searchDocuments2(@PathVariable("id") String title, @PathVariable("numeral") String numeral, Model model) {
        model.addAttribute("documents", documentService.listSearchDocuments2(title, numeral));
        return "documents";
    }

    @GetMapping("/document/{id}")
    public String documentInfo(@PathVariable Long id, Model model) {
        Document document = documentService.getDocumentById(id);
        model.addAttribute("document", document);
        model.addAttribute("type", document.getTypeCode());
        return "document-info";
    }

    @GetMapping("/document-register")
    public String documentRegister(Model model) {
        model.addAttribute("documents", documentService.listDocuments());
        return "documents";
    }

    @GetMapping("/dict-document-type")
    public String dictDocumentType(Model model) {
        model.addAttribute("docsType", documentService.listDocType());
        return "dict-doc-type";
    }

    @PostMapping("/document/create")
    public String createDocument(Document document) {
        documentService.saveDocument(document);
        return "redirect:/";
    }

    @PostMapping("/document/delete/{id}")
    public String deleteDocument(@PathVariable Long id) {
        documentService.deleteDocument(id);
        return "redirect:/";
    }

}
