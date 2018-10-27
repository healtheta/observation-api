package org.healtheta.model.observation.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.healtheta.model.observation.*;
import org.healtheta.model.common.*;
import java.util.List;

@Repository
public interface ObservationRepo extends JpaRepository<Observation, Long> {
    public Observation findObservationById(Long id);
    public Observation findObservationByIdentifier(Identifier identifier);
    public List<Observation> findObservationBySubject(Reference subject);
    public List<Observation> findObservationByPerformer(Reference performer);
}
