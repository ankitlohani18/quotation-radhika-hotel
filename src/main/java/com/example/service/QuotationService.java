package com.example.service;

import com.example.entity.Quotation;
import java.util.List;

public interface QuotationService {

    List<Quotation> getAllQuotations();

    void saveQuotation(Quotation quotation);

    Quotation findQuotationById(Long id);

    void updateQuotation(Long id, Quotation quotation);

    void deleteQuotation(Long id);

}
