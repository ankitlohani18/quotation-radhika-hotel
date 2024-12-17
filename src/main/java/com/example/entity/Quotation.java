package com.example.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Quotation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String mobileNo;
    private String date;
    private String address;
    private String subject;
    private String thankYou;

    private String proposedSiteName;
    private String location;

    private String plantCapacity;
    private String moduleTechnology;
    private String mountingStructureTechnology;
    private String projectScheme;
    private String powerEvacuation;
    private String solarPlantOutputConnection;
    private String approxArea;
    private String scheme;

    private String inquiryReceivedFrom;
    private LocalDate proposalBasesInquiryReceivedDate;
    private String offerValidity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getThankYou() {
        return thankYou;
    }

    public void setThankYou(String thankYou) {
        this.thankYou = thankYou;
    }

    public String getProposedSiteName() {
        return proposedSiteName;
    }

    public void setProposedSiteName(String proposedSiteName) {
        this.proposedSiteName = proposedSiteName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPlantCapacity() {
        return plantCapacity;
    }

    public void setPlantCapacity(String plantCapacity) {
        this.plantCapacity = plantCapacity;
    }

    public String getModuleTechnology() {
        return moduleTechnology;
    }

    public void setModuleTechnology(String moduleTechnology) {
        this.moduleTechnology = moduleTechnology;
    }

    public String getMountingStructureTechnology() {
        return mountingStructureTechnology;
    }

    public void setMountingStructureTechnology(String mountingStructureTechnology) {
        this.mountingStructureTechnology = mountingStructureTechnology;
    }

    public String getProjectScheme() {
        return projectScheme;
    }

    public void setProjectScheme(String projectScheme) {
        this.projectScheme = projectScheme;
    }

    public String getPowerEvacuation() {
        return powerEvacuation;
    }

    public void setPowerEvacuation(String powerEvacuation) {
        this.powerEvacuation = powerEvacuation;
    }

    public String getSolarPlantOutputConnection() {
        return solarPlantOutputConnection;
    }

    public void setSolarPlantOutputConnection(String solarPlantOutputConnection) {
        this.solarPlantOutputConnection = solarPlantOutputConnection;
    }

    public String getApproxArea() {
        return approxArea;
    }

    public void setApproxArea(String approxArea) {
        this.approxArea = approxArea;
    }

    public String getScheme() {
        return scheme;
    }

    public void setScheme(String scheme) {
        this.scheme = scheme;
    }

    public String getInquiryReceivedFrom() {
        return inquiryReceivedFrom;
    }

    public void setInquiryReceivedFrom(String inquiryReceivedFrom) {
        this.inquiryReceivedFrom = inquiryReceivedFrom;
    }

    public LocalDate getProposalBasesInquiryReceivedDate() {
        return proposalBasesInquiryReceivedDate;
    }

    public void setProposalBasesInquiryReceivedDate(LocalDate proposalBasesInquiryReceivedDate) {
        this.proposalBasesInquiryReceivedDate = proposalBasesInquiryReceivedDate;
    }

    public String getOfferValidity() {
        return offerValidity;
    }

    public void setOfferValidity(String offerValidity) {
        this.offerValidity = offerValidity;
    }
}

