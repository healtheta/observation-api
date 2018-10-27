package org.healtheta.model.observation;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.healtheta.model.common.*;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "_ObservationValue")
public class ObservationValue {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "_id")
    private Long id;

    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL)
    @JoinColumn(name = "_valueQuantity")
    private Quantity valueQuantity;

    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL)
    @JoinColumn(name = "_valueCodeableConcept")
    private CodeableConcept valueCodeableConcept;

    @Column(name = "_valueString")
    private String valueString;

    @Column(name = "_valueBoolean")
    private String valueBoolean;

    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL)
    @JoinColumn(name = "_valueRange")
    private Range valueRange;

    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL)
    @JoinColumn(name = "_valueRatio")
    private Ratio valueRatio;

    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL)
    @JoinColumn(name = "_valueSampleData")
    private SampleData valueSampleData;

    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL)
    @JoinColumn(name = "_valueAttachment")
    private Attachment valueAttachment;

    @Column(name = "_valueTime")
    private Date valueTime;

    @Column(name = "_valueDateTime")
    private Date valueDateTime;

    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL)
    @JoinColumn(name = "_valuePeriod")
    private Attachment valuePeriod;

    public Long getId() {
        return id;
    }

    public Quantity getValueQuantity() {
        return valueQuantity;
    }

    public CodeableConcept getValueCodeableConcept() {
        return valueCodeableConcept;
    }

    public String getValueString() {
        return valueString;
    }

    public String getValueBoolean() {
        return valueBoolean;
    }

    public Range getValueRange() {
        return valueRange;
    }

    public Ratio getValueRatio() {
        return valueRatio;
    }

    public SampleData getValueSampleData() {
        return valueSampleData;
    }

    public Attachment getValueAttachment() {
        return valueAttachment;
    }

    public Date getValueTime() {
        return valueTime;
    }

    public Date getValueDateTime() {
        return valueDateTime;
    }

    public Attachment getValuePeriod() {
        return valuePeriod;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setValueQuantity(Quantity valueQuantity) {
        this.valueQuantity = valueQuantity;
    }

    public void setValueCodeableConcept(CodeableConcept valueCodeableConcept) {
        this.valueCodeableConcept = valueCodeableConcept;
    }

    public void setValueString(String valueString) {
        this.valueString = valueString;
    }

    public void setValueBoolean(String valueBoolean) {
        this.valueBoolean = valueBoolean;
    }

    public void setValueRange(Range valueRange) {
        this.valueRange = valueRange;
    }

    public void setValueRatio(Ratio valueRatio) {
        this.valueRatio = valueRatio;
    }

    public void setValueSampleData(SampleData valueSampleData) {
        this.valueSampleData = valueSampleData;
    }

    public void setValueAttachment(Attachment valueAttachment) {
        this.valueAttachment = valueAttachment;
    }

    public void setValueTime(Date valueTime) {
        this.valueTime = valueTime;
    }

    public void setValueDateTime(Date valueDateTime) {
        this.valueDateTime = valueDateTime;
    }

    public void setValuePeriod(Attachment valuePeriod) {
        this.valuePeriod = valuePeriod;
    }
}
