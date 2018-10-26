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
}
