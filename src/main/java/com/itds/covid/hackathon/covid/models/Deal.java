package com.itds.covid.hackathon.covid.models;

import com.itds.covid.hackathon.covid.enums.DealStatus;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

import java.math.BigDecimal;

public class Deal {
    @Id
    public String id;
    @Indexed
    String customerId;

    DealStatus status;

    String title;

    String description;

    String category;

    String condition;

    BigDecimal value;

    Integer numberOfInvestors;



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public DealStatus getStatus() {
        return status;
    }

    public void setStatus(DealStatus status) {
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

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
