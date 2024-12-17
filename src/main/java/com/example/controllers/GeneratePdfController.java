package com.example.controllers;

import com.example.service.impl.GeneratePdfServiceImpl;
import com.itextpdf.text.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/generatePdf")
public class GeneratePdfController {

    @Autowired
    private GeneratePdfServiceImpl generatePdfService;

    // Generate PDF for a quotation
    @GetMapping("/{id}")
    public ResponseEntity<byte[]> generateQuotationPdf(@PathVariable Long id) {
        try {
            byte[] pdfBytes = generatePdfService.generatePdfForQuotation(id);

            HttpHeaders headers = new HttpHeaders();
            headers.add("Content-Disposition", "inline; filename=quotation.pdf");
            headers.add("Content-Type", "application/pdf");

            return ResponseEntity.ok()
                    .headers(headers)
                    .body(pdfBytes);
        } catch (DocumentException e) {
            throw new RuntimeException("Error generating PDF", e);
        }
    }
}
