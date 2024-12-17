package com.example.service;

import com.itextpdf.text.DocumentException;

public interface GeneratePdfService {
    byte[] generatePdfForQuotation(Long quotationId) throws DocumentException;
}