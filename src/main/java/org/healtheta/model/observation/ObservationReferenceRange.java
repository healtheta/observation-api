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
}
