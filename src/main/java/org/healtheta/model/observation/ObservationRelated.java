package org.healtheta.model.observation;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.healtheta.model.common.Quantity;
import org.healtheta.model.common.Reference;

import javax.persistence.*;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "_ObservationRelated")
public class ObservationRelated {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "_id")
    private Long id;

    @Column(name = "_type")
    private String type;

    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL)
    @JoinColumn(name = "_target")
    private Reference target;

    public Long getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public Reference getTarget() {
        return target;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setTarget(Reference target) {
        this.target = target;
    }
}
