package org.healtheta.model.observation;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.aspectj.apache.bcel.classfile.Code;
import org.healtheta.model.common.CodeableConcept;
import org.healtheta.model.common.Quantity;
import org.healtheta.model.common.Range;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "_ObservationReferenceRange")
public class ObservationReferenceRange {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "_id")
    private Long id;

    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL)
    @JoinColumn(name = "_low")
    private Quantity low;

    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL)
    @JoinColumn(name = "_high")
    private Quantity high;

    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL)
    @JoinColumn(name = "_type")
    private CodeableConcept type;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @Column(name = "_appliesTo")
    private List<CodeableConcept> appliesTo;

    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL)
    @JoinColumn(name = "_age")
    private Range age;

    @Column(name = "_text")
    private String text;

    public Long getId() {
        return id;
    }

    public Quantity getLow() {
        return low;
    }

    public Quantity getHigh() {
        return high;
    }

    public CodeableConcept getType() {
        return type;
    }

    public List<CodeableConcept> getAppliesTo() {
        return appliesTo;
    }

    public Range getAge() {
        return age;
    }

    public String getText() {
        return text;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setLow(Quantity low) {
        this.low = low;
    }

    public void setHigh(Quantity high) {
        this.high = high;
    }

    public void setType(CodeableConcept type) {
        this.type = type;
    }

    public void setAppliesTo(List<CodeableConcept> appliesTo) {
        this.appliesTo = appliesTo;
    }

    public void setAge(Range age) {
        this.age = age;
    }

    public void setText(String text) {
        this.text = text;
    }
}
