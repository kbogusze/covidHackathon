package com.itds.covid.hackathon.covid.models;

import com.itds.covid.hackathon.covid.enums.DealStatus;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

import java.math.BigDecimal;

public class Deal {
    @Id
    public String id;
    @Indexed

    public String customerId;
    DealStatus status;

    public String collateralTitle;
    public String dueDate;
    public BigDecimal requestedCollateralAmount;
    public String requestDescription;
    public String personalDataAcceptance;
    public String termConditions;
    public String marketingPurposes;

    public String description;
    public String category;
    public String condition;
    public BigDecimal value;
    public Integer numberOfInvestors;



    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getCustomerId() {
        return customerId;
    }
    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public DealStatus getStatus() {
        return status;
    }
    public void setStatus(DealStatus status) {
        this.status = status;
    }

    public String getCollateralTitle() {
        return collateralTitle;
    }
    public void setCollateralTitle(String collateralTitle) {
        this.collateralTitle = collateralTitle;
    }

    public String getDueDate() {
        return dueDate;
    }
    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public BigDecimal getRequestedCollateralAmount() {
        return requestedCollateralAmount;
    }
    public void setRequestedCollateralAmount(BigDecimal requestedCollateralAmount) { this.requestedCollateralAmount = requestedCollateralAmount; }

    public String getRequestDescription() {
        return requestDescription;
    }
    public void setRequestDescription(String requestDescription) {
        this.dueDate = requestDescription;
    }

    public String getPersonalDataAcceptance() {
        return personalDataAcceptance;
    }
    public void setPersonalDataAcceptance(String personalDataAcceptance) { this.personalDataAcceptance = personalDataAcceptance; }

    public String getTermConditions() {
        return termConditions;
    }
    public void setTermConditions(String termConditions) { this.termConditions = termConditions; }

    public String getMarketingPurposes() {
        return marketingPurposes;
    }
    public void setMarketingPurposes(String marketingPurposes) { this.marketingPurposes = marketingPurposes; }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }

    public String getCondition() {
        return condition;
    }
    public void setCondition(String condition) {
        this.condition = condition;
    }

    public BigDecimal getValue() {
        return value;
    }
    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public Integer getNumberOfInvestors() {
        return numberOfInvestors;
    }
    public void setNumberOfInvestors(Integer numberOfInvestors) {
        this.numberOfInvestors = numberOfInvestors;
    }


}
