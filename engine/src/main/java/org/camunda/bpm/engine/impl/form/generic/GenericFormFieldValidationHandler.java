package org.camunda.bpm.engine.impl.form.generic;

import java.util.ArrayList;
import java.util.List;
import org.camunda.bpm.engine.impl.persistence.entity.ExecutionEntity;

/**
 *
 * @author Michael Siebers <info@msiebers.de>
 */
class GenericFormFieldValidationHandler {

    private List<GenericFormFieldValidationConstraintHandler> constraints = new ArrayList<GenericFormFieldValidationConstraintHandler>();
    
    public void addConstraint(GenericFormFieldValidationConstraintHandler constraint) {
        this.constraints.add(constraint);
    }
    
    public List<GenericFormFieldValidationConstraintHandler> getConstraints() {
        return this.constraints;
    }

    public GenericFormFieldValidation initializeGenericFormFieldValidation(ExecutionEntity execution) {
        GenericFormFieldValidation validation = new GenericFormFieldValidation();
        
        for (GenericFormFieldValidationConstraintHandler constraint : constraints) {
            validation.addConstraint(constraint.initializeGenericFormFieldValidationConstraint(execution));
        }
        
        return validation;
    }
}
