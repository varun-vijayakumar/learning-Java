package com.javaprep.object_oriented_design.abstraction;

import javax.xml.validation.Schema;

public class InterfaceAndAbstractClassExample {
     public void execute() {
        Validate v0 = new ValidateInputAgainstSchema();
        v0.validate();
        Validate v1 = new VnbtUnderlayValidation();
        Validate v2 = new VnbtOverlayValidation();
        v1.validate();
        v2.validate();
    }
}

interface Validate {
    public void validate();
}

abstract class VnbtValiation implements Validate {

}

class VnbtUnderlayValidation extends VnbtValiation {
    public void validate() {
        System.out.println("Vnbt Underlay Validation");
    }
    public void underlayInfo() {
        System.out.println("Vnbt underlay info : ");
    }
}

class VnbtOverlayValidation extends VnbtValiation {
    public void validate() {
        System.out.println("Vnbt Overlay Validation");
    }
}

class ValidateInputAgainstSchema implements Validate {
    public void validate() {
        System.out.println("schema validation done");
    }
    public void underlayInfo() {
        System.out.println("Vnbt underlay info : ");
    }
}
