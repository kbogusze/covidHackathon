package com.itds.covid.hackathon.covid.models;

import com.itds.covid.hackathon.covid.enums.DealRelationStatus;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

public class DealRelation {
    @Id
    public String id;
    @Indexed
    String customerId;
    @Indexed
    String dealID;

    DealRelationStatus status;

    String description;

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

    public String getDealID() {
        return dealID;
    }

    public void setDealID(String dealID) {
        this.dealID = dealID;
    }

    public DealRelationStatus getStatus() {
        return status;
    }

    public void setStatus(DealRelationStatus status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
