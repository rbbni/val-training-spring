package com.example.valtrainingspring.model;

import jakarta.persistence.*;

@Entity
@Table(name = "outcome")
public class Outcome {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long percentageWeigth;

    private String autoEvaluation;

    private String othersEvaluation;

    private String expectedEvaluation;

    private String possibModExpEvaluation;

    private String outcomeDescription;

    private Long returnCode;

    @OneToOne
    private Outcome outcome;

    @Column(nullable = false)
    private boolean flgDelete;

    public Outcome() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPercentageWeigth() {
        return percentageWeigth;
    }

    public void setPercentageWeigth(Long percentageWeigth) {
        this.percentageWeigth = percentageWeigth;
    }

    public String getAutoEvaluation() {
        return autoEvaluation;
    }

    public void setAutoEvaluation(String autoEvaluation) {
        this.autoEvaluation = autoEvaluation;
    }

    public String getOthersEvaluation() {
        return othersEvaluation;
    }

    public void setOthersEvaluation(String othersEvaluation) {
        this.othersEvaluation = othersEvaluation;
    }

    public String getExpectedEvaluation() {
        return expectedEvaluation;
    }

    public void setExpectedEvaluation(String expectedEvaluation) {
        this.expectedEvaluation = expectedEvaluation;
    }

    public String getPossibModExpEvaluation() {
        return possibModExpEvaluation;
    }

    public void setPossibModExpEvaluation(String possibModExpEvaluation) {
        this.possibModExpEvaluation = possibModExpEvaluation;
    }

    public String getOutcomeDescription() {
        return outcomeDescription;
    }

    public void setOutcomeDescription(String outcomeDescription) {
        this.outcomeDescription = outcomeDescription;
    }

    public Long getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(Long returnCode) {
        this.returnCode = returnCode;
    }

    public boolean isFlgDelete() {
        return flgDelete;
    }

    public void setFlgDelete(boolean flgDelete) {
        this.flgDelete = flgDelete;
    }
}
