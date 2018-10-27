package org.healtheta.model.observation;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.healtheta.model.common.*;
import org.healtheta.model.observation.ObservationComponent;
import org.healtheta.model.observation.ObservationRelated;
import org.healtheta.model.observation.ObservationValue;

import java.util.List;
import java.util.Date;
import javax.persistence.*;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "Observation")
public class Observation {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "_id")
    private Long id;

    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL)
    @JoinColumn(unique=true, name = "_identifier")
    private Identifier identifier;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @Column(name = "_basedOn")
    private List<Reference> basedOn;

    @Column(name = "_status")
    private String status;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @Column(name = "_category")
    private List<CodeableConcept> category;

    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL)
    @JoinColumn(name = "_code")
    private CodeableConcept code;

    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL)
    @JoinColumn(name = "_subject")
    private Reference subject;

    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL)
    @JoinColumn(name = "_context")
    private Reference context;

    @Column(name = "_effectiveDateTime")
    private Date effectiveDateTime;

    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL)
    @JoinColumn(name = "_effectivePeriod")
    private Period effectivePeriod;

    @Column(name = "_instant")
    private Date instant;

    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL)
    @JoinColumn(name = "_performer")
    private Reference performer;

    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL)
    @JoinColumn(name = "_value")
    private ObservationValue value;

    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL)
    @JoinColumn(name = "_dateAbsentReason")
    private CodeableConcept dateAbsentReason;

    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL)
    @JoinColumn(name = "_interpretation")
    private CodeableConcept interpretation;

    @Column(name = "_comment")
    private String comment;

    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL)
    @JoinColumn(name = "_bodySite")
    private CodeableConcept bodySite;

    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL)
    @JoinColumn(name = "_method")
    private CodeableConcept method;

    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL)
    @JoinColumn(name = "_specimen")
    private Reference specimen;

    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL)
    @JoinColumn(name = "_device")
    private Reference device;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @Column(name = "_related")
    private List<ObservationRelated> related;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @Column(name = "_component")
    private List<ObservationComponent> component;

    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL)
    @JoinColumn(name = "_reference")
    private Reference reference;

    public Long getId() {
        return id;
    }

    public Identifier getIdentifier() {
        return identifier;
    }

    public List<Reference> getBasedOn() {
        return basedOn;
    }

    public String getStatus() {
        return status;
    }

    public List<CodeableConcept> getCategory() {
        return category;
    }

    public CodeableConcept getCode() {
        return code;
    }

    public Reference getSubject() {
        return subject;
    }

    public Reference getContext() {
        return context;
    }

    public Date getEffectiveDateTime() {
        return effectiveDateTime;
    }

    public Period getEffectivePeriod() {
        return effectivePeriod;
    }

    public Date getInstant() {
        return instant;
    }

    public Reference getPerformer() {
        return performer;
    }

    public ObservationValue getValue() {
        return value;
    }

    public CodeableConcept getDateAbsentReason() {
        return dateAbsentReason;
    }

    public CodeableConcept getInterpretation() {
        return interpretation;
    }

    public String getComment() {
        return comment;
    }

    public CodeableConcept getBodySite() {
        return bodySite;
    }

    public CodeableConcept getMethod() {
        return method;
    }

    public Reference getSpecimen() {
        return specimen;
    }

    public Reference getDevice() {
        return device;
    }

    public List<ObservationRelated> getRelated() {
        return related;
    }

    public List<ObservationComponent> getComponent() {
        return component;
    }

    public Reference getReference() {
        return reference;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setIdentifier(Identifier identifier) {
        this.identifier = identifier;
    }

    public void setBasedOn(List<Reference> basedOn) {
        this.basedOn = basedOn;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setCategory(List<CodeableConcept> category) {
        this.category = category;
    }

    public void setCode(CodeableConcept code) {
        this.code = code;
    }

    public void setSubject(Reference subject) {
        this.subject = subject;
    }

    public void setContext(Reference context) {
        this.context = context;
    }

    public void setEffectiveDateTime(Date effectiveDateTime) {
        this.effectiveDateTime = effectiveDateTime;
    }

    public void setEffectivePeriod(Period effectivePeriod) {
        this.effectivePeriod = effectivePeriod;
    }

    public void setInstant(Date instant) {
        this.instant = instant;
    }

    public void setPerformer(Reference performer) {
        this.performer = performer;
    }

    public void setValue(ObservationValue value) {
        this.value = value;
    }

    public void setDateAbsentReason(CodeableConcept dateAbsentReason) {
        this.dateAbsentReason = dateAbsentReason;
    }

    public void setInterpretation(CodeableConcept interpretation) {
        this.interpretation = interpretation;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setBodySite(CodeableConcept bodySite) {
        this.bodySite = bodySite;
    }

    public void setMethod(CodeableConcept method) {
        this.method = method;
    }

    public void setSpecimen(Reference specimen) {
        this.specimen = specimen;
    }

    public void setDevice(Reference device) {
        this.device = device;
    }

    public void setRelated(List<ObservationRelated> related) {
        this.related = related;
    }

    public void setComponent(List<ObservationComponent> component) {
        this.component = component;
    }

    public void setReference(Reference reference) {
        this.reference = reference;
    }
}
