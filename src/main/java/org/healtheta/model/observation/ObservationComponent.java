package org.healtheta.model.observation;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.healtheta.model.common.CodeableConcept;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "_ObservationComponent")
public class ObservationComponent {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "_id")
    private Long id;

    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL)
    @JoinColumn(name = "_code")
    private CodeableConcept code;

    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL)
    @JoinColumn(name = "_value")
    private ObservationValue value;

    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL)
    @JoinColumn(name = "_dataAbsentReason")
    private CodeableConcept dataAbsentReason;

    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL)
    @JoinColumn(name = "_interpretation")
    private CodeableConcept interpretation;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @Column(name = "_referenceRange")
    private List<ObservationReferenceRange> referenceRange;

    public Long getId() {
        return id;
    }

    public CodeableConcept getCode() {
        return code;
    }

    public ObservationValue getValue() {
        return value;
    }

    public CodeableConcept getDataAbsentReason() {
        return dataAbsentReason;
    }

    public CodeableConcept getInterpretation() {
        return interpretation;
    }

    public List<ObservationReferenceRange> getReferenceRange() {
        return referenceRange;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCode(CodeableConcept code) {
        this.code = code;
    }

    public void setValue(ObservationValue value) {
        this.value = value;
    }

    public void setDataAbsentReason(CodeableConcept dataAbsentReason) {
        this.dataAbsentReason = dataAbsentReason;
    }

    public void setInterpretation(CodeableConcept interpretation) {
        this.interpretation = interpretation;
    }

    public void setReferenceRange(List<ObservationReferenceRange> referenceRange) {
        this.referenceRange = referenceRange;
    }
}
