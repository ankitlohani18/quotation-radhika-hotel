package com.example.service;

import com.itextpdf.text.DocumentException;

import java.io.IOException;

public interface GeneratePdfService {
    byte[] generatePdfForQuotation(Long quotationId) throws DocumentException, IOException;
}