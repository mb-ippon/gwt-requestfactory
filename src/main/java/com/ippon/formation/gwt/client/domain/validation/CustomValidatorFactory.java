package com.ippon.formation.gwt.client.domain.validation;

import javax.validation.Validator;

import com.google.gwt.core.client.GWT;
import com.google.gwt.validation.client.AbstractGwtValidatorFactory;
import com.google.gwt.validation.client.GwtValidation;
import com.google.gwt.validation.client.impl.AbstractGwtValidator;
import com.ippon.formation.gwt.client.domain.bindery.rf.proxy.PlayerProxy;

public class CustomValidatorFactory extends AbstractGwtValidatorFactory {

    @GwtValidation(PlayerProxy.class)
    public interface GwtValidator extends Validator {
    }

    @Override
    public AbstractGwtValidator createValidator() {
        return GWT.create(GwtValidator.class);
    }

}
