package com.example.controllers;

import com.example.entity.Quotation;
import com.example.service.QuotationService;
import com.itextpdf.text.DocumentException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/quotation")
public class QuotationController {

    private final QuotationService quotationService;

    @Autowired
    public QuotationController(QuotationService quotationService) {
        this.quotationService = quotationService;
    }

    @GetMapping("/getAll")
    public String getAllQuotation(Model model) {
        model.addAttribute("quotations", quotationService.getAllQuotations());
        return "view-all-quotation";
    }

    // Show form to add a new quotation
    @GetMapping("/showCreateForm")
    public String showCreateQuotationForm(Model model, HttpServletRequest request) {
        model.addAttribute("quotation", new Quotation());
        return "create-quotation";
    }

    // Add a new quotation
    @PostMapping("/create")
    public String addQuotation(@ModelAttribute Quotation quotation, Model model) {
        quotationService.saveQuotation(quotation);
        return "redirect:/quotation/view/"+quotation.getId();
    }

    // Show form to edit a quotation
    @GetMapping("/edit/{id}")
    public String showEditQuotationForm(@PathVariable Long id, Model model, HttpServletRequest request) {
        Quotation quotation = quotationService.findQuotationById(id);
        model.addAttribute("quotation", quotation);
        return "edit-quotation";
    }

    // Update a quotation
    @PostMapping("/update/{id}")
    public String updateQuotation(@PathVariable Long id, @ModelAttribute Quotation quotation) {
        quotationService.updateQuotation(id, quotation);
        return "redirect:/";
    }

    // Delete a specific quotation
    @GetMapping("/delete/{id}")
    public String deleteQuotation(@PathVariable Long id) {
        quotationService.deleteQuotation(id);
        return "redirect:/quotation/getAll";
    }

    // View a specific quotation
    @GetMapping("/view/{id}")
    public String viewQuotation(@PathVariable Long id, Model model) {
        Quotation quotation = quotationService.findQuotationById(id);
        model.addAttribute("quotation", quotation);
        return "view-quotation";
    }

    // Generate PDF for a quotation
    @GetMapping("/generatePdf/{id}")
    public ResponseEntity<byte[]> generateQuotationPdf(@PathVariable Long id) {
        try {
            byte[] pdfBytes = quotationService.generatePdfForQuotation(id);

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
