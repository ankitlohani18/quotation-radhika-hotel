package com.example.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Component {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String solarPVModules;
    private String solarInverter;
    private String mountingStructure;
    private String acCables;
    private String distributionBoxes;
    private String earthing;
    private String systemMonitoring;
    private String mc4Connectors;
    private String switchGears;
    private String balanceOfSystem;
    private String netMeter;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "components")
    private Quotation quotation;

    public Quotation getQuotation() {
        return quotation;
    }

    public void setQuotation(Quotation quotation) {
        this.quotation = quotation;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSolarPVModules() {
        return solarPVModules;
    }

    public void setSolarPVModules(String solarPVModules) {
        this.solarPVModules = solarPVModules;
    }

    public String getSolarInverter() {
        return solarInverter;
    }

    public void setSolarInverter(String solarInverter) {
        this.solarInverter = solarInverter;
    }

    public String getMountingStructure() {
        return mountingStructure;
    }

    public void setMountingStructure(String mountingStructure) {
        this.mountingStructure = mountingStructure;
    }

    public String getAcCables() {
        return acCables;
    }

    public void setAcCables(String acCables) {
        this.acCables = acCables;
    }

    public String getDistributionBoxes() {
        return distributionBoxes;
    }

    public void setDistributionBoxes(String distributionBoxes) {
        this.distributionBoxes = distributionBoxes;
    }

    public String getEarthing() {
        return earthing;
    }

    public void setEarthing(String earthing) {
        this.earthing = earthing;
    }

    public String getSystemMonitoring() {
        return systemMonitoring;
    }

    public void setSystemMonitoring(String systemMonitoring) {
        this.systemMonitoring = systemMonitoring;
    }

    public String getMc4Connectors() {
        return mc4Connectors;
    }

    public void setMc4Connectors(String mc4Connectors) {
        this.mc4Connectors = mc4Connectors;
    }

    public String getSwitchGears() {
        return switchGears;
    }

    public void setSwitchGears(String switchGears) {
        this.switchGears = switchGears;
    }

    public String getBalanceOfSystem() {
        return balanceOfSystem;
    }

    public void setBalanceOfSystem(String balanceOfSystem) {
        this.balanceOfSystem = balanceOfSystem;
    }

    public String getNetMeter() {
        return netMeter;
    }

    public void setNetMeter(String netMeter) {
        this.netMeter = netMeter;
    }
}
