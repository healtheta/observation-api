package org.healtheta.web;


import org.healtheta.model.common.Identifier;
import org.healtheta.model.common.OperationOutcome;
import org.healtheta.model.common.Reference;
import org.healtheta.model.common.repos.IdentifierRepo;
import org.healtheta.model.common.repos.ReferenceRepo;
import org.healtheta.model.observation.repo.ObservationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.healtheta.model.observation.Observation;
import java.util.List;

@RestController
@RequestMapping(value = "/observation")
public class ObservationController {
    @Autowired
    ObservationRepo observationRepo;
    @Autowired
    private IdentifierRepo identifierRepo;
    @Autowired
    private ReferenceRepo referenceRepo;

    @RequestMapping(value = "/create", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    @ResponseBody
    public ResponseEntity<?> create(@RequestBody Observation observation){
        Identifier tmpId = observation.getIdentifier();
        if(tmpId.getValue() == null){
            return new ResponseEntity<OperationOutcome>(OperationOutcome.InvalidParameter(),
                    HttpStatus.OK);
        }

        if(identifierRepo.findIdentifierByValue(tmpId.getValue()) != null){
            return new ResponseEntity<OperationOutcome>(OperationOutcome.RecordExists(),
                    HttpStatus.OK);
        }

        try{
            Observation tmp = new Observation();
            tmp = observationRepo.save(tmp);
            observation.setId(tmp.getId());

            Reference ref = new Reference();
            ref.setIdentifier(observation.getIdentifier());
            ref.setDisplay("observation-reference");
            observation.setReference(ref);
            observation = observationRepo.save(observation);
            return new ResponseEntity<Observation>(observation, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<OperationOutcome>(OperationOutcome.InternalError(),
                    HttpStatus.OK);
        }
    }

    @RequestMapping(value = "/read/{id}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public ResponseEntity<?> read(@PathVariable String id){
        try{
            Long lId = Long.parseLong(id);
            Observation observation = observationRepo.findObservationById(lId);
            if(observation != null){
                return new ResponseEntity<Observation>(observation, HttpStatus.OK);
            }else{
                return new ResponseEntity<OperationOutcome>(OperationOutcome.RecordNotFound(), HttpStatus.NOT_FOUND);
            }
        }catch(Exception e){
            return new ResponseEntity<OperationOutcome>(OperationOutcome.InternalError(),
                    HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    @ResponseBody
    public ResponseEntity<?> update(@RequestBody Observation observation){
        Long id = observation.getId();
        Observation tmp = observationRepo.findObservationById(id);
        if ( tmp != null){
            //record exists let;s update.
            //reference and identifiers are not to be updated.
            observation.setIdentifier(tmp.getIdentifier());
            observation.setReference(tmp.getReference());
            observation = observationRepo.save(observation);
            return new ResponseEntity<Observation>(observation, HttpStatus.OK);
        }else{
            return new ResponseEntity<OperationOutcome>(OperationOutcome.RecordNotFound(), HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = "application/json")
    @ResponseBody
    public ResponseEntity<?> delete(String id) {
        return null;
    }

    @RequestMapping(value = "/search",
            method = RequestMethod.GET,
            produces = "application/json")
    @ResponseBody
    public ResponseEntity<?> search(@RequestParam(value = "subject", required=false) Long subject,
                                    @RequestParam(value = "performer", required=false) Long performer){
        if(subject != null){
            Reference ref = referenceRepo.findReferenceById(subject);
            List<Observation> observationList = observationRepo.findObservationBySubject(ref);
            return new ResponseEntity<List>(observationList, HttpStatus.OK);
        }else if ( performer != null){
            Reference ref = referenceRepo.findReferenceById(performer);
            List<Observation> observationList = observationRepo.findObservationByPerformer(ref);
            return new ResponseEntity<List>(observationList, HttpStatus.OK);
        }else{
            return new ResponseEntity<OperationOutcome>(OperationOutcome.OperationNotSupported(),
                    HttpStatus.OK);
        }
    }

    @RequestMapping(value = "/format",
            method = RequestMethod.GET,
            produces = "application/json")
    @ResponseBody
    public ResponseEntity<?> format(){
        Observation observation = new Observation();
        Identifier identifier = new Identifier();
        identifier.setValue("OBSERVATION:KDJMDMKD-92929229-DKDKDKDDK-92929292");
        observation.setIdentifier(identifier);
        return new ResponseEntity<Observation>(observation, HttpStatus.OK);
    }

}
