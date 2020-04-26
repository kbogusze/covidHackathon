package com.itds.covid.hackathon.covid.models;

import com.itds.covid.hackathon.covid.enums.DealStatus;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

import java.math.BigDecimal;
import java.util.Date;

public class Deal {
    @Id
    public String id;
    @Indexed
    public String userId;
    @Indexed
    public String mainPictureId;

    DealStatus status;

    public String collateralTitle;
    public String dueDate;
    public BigDecimal requestedCollateralAmount;
    public String requestDescription;
    public Boolean personalDataAcceptance;
    public Boolean termConditions;
    public Boolean marketingPurposes;

    public String category;
    public BigDecimal value;
    public Integer numberOfInvestors;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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

    public void setRequestedCollateralAmount(BigDecimal requestedCollateralAmount) {
        this.requestedCollateralAmount = requestedCollateralAmount;
    }

    public String getRequestDescription() {
        return requestDescription;
    }

    public void setRequestDescription(String requestDescription) {
        this.requestDescription = requestDescription;
    }

    public Boolean getPersonalDataAcceptance() {
        return personalDataAcceptance;
    }

    public void setPersonalDataAcceptance(Boolean personalDataAcceptance) {
        this.personalDataAcceptance = personalDataAcceptance;
    }

    public Boolean getTermConditions() {
        return termConditions;
    }

    public void setTermConditions(Boolean termConditions) {
        this.termConditions = termConditions;
    }

    public Boolean getMarketingPurposes() {
        return marketingPurposes;
    }

    public void setMarketingPurposes(Boolean marketingPurposes) {
        this.marketingPurposes = marketingPurposes;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
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

    public String getMainPictureId() {
        return mainPictureId;
    }

    public void setMainPictureId(String mainPictureId) {
        this.mainPictureId = mainPictureId;
    }
}
