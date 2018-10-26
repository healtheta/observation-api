package org.healtheta.model.observation.repo;

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


}
