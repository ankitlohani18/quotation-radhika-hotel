package com.example.service;

import com.example.entity.Quotation;
import com.example.repository.QuotationRepository;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.Optional;

@Service
public class QuotationService {

    private final QuotationRepository quotationRepository;

    @Autowired
    public QuotationService(QuotationRepository quotationRepository) {
        this.quotationRepository = quotationRepository;
    }

    // Method to get all quotations
    public List<Quotation> getAllQuotations() {
        return quotationRepository.findAll();
    }

    public void saveQuotation(Quotation quotation) {
        quotationRepository.save(quotation);
    }

    public Quotation findQuotationById(Long id) {
        Optional<Quotation> quotation = quotationRepository.findById(id);
        return quotation.orElse(null);
    }

    public void updateQuotation(Quotation quotation) {
        quotationRepository.save(quotation);
    }

    public void deleteQuotation(Long id) {
        quotationRepository.deleteById(id);
    }

    public byte[] generatePdfForQuotation(Long quotationId) throws DocumentException {
        Quotation quotation = findQuotationById(quotationId);
        // Create a PDF document
        Document document = new Document();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PdfWriter.getInstance(document, outputStream);
        document.open();

        document.addTitle("Quotation Details");
        document.add(new Paragraph("Quotation Details"));
        document.add(new Paragraph("Name: " + quotation.getName()));
        document.add(new Paragraph("Mobile No: " + quotation.getMobileNo()));
        document.add(new Paragraph("Date: " + quotation.getDate()));
        document.add(new Paragraph("Address: " + quotation.getAddress()));

        document.add(new Paragraph("Subject: " + quotation.getSubject()));
        document.add(new Paragraph("Thank You: " + quotation.getThankYou()));

        document.add(new Paragraph("Proposed Site: "));
        document.add(new Paragraph("Name: " + quotation.getProposedSiteName()));
        document.add(new Paragraph("Location: " + quotation.getLocation()));

        document.add(new Paragraph("Solar PV System Specification: On-Grid Rooftop: "));
        document.add(new Paragraph("Plant Capacity: " + quotation.getPlantCapacity()));
        document.add(new Paragraph("Module Technology: " + quotation.getModuleTechnology()));
        document.add(new Paragraph("Mounting Structure Technology: " + quotation.getMountingStructureTechnology()));
        document.add(new Paragraph("Project Scheme: " + quotation.getProjectScheme()));
        document.add(new Paragraph("Power Evacuation: " + quotation.getPowerEvacuation()));
        document.add(new Paragraph("Solar Plant Output Connection: " + quotation.getSolarPlantOutputConnection()));
        document.add(new Paragraph("Approx. Area: " + quotation.getApproxArea()));
        document.add(new Paragraph("Scheme: " + quotation.getScheme()));

        document.add(new Paragraph("Proposal Bases Inquiry Received:"));
        document.add(new Paragraph("From: "+ quotation.getInquiryReceivedFrom()));
        document.add(new Paragraph("Date: "+ quotation.getProposalBasesInquiryReceivedDate()));
        document.add(new Paragraph("Offer Validity: "+ quotation.getOfferValidity()));

        document.close();

        return outputStream.toByteArray();
    }
}
