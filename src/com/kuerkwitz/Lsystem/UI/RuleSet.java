package com.kuerkwitz.Lsystem.UI;

/**
 * @author Kyle Uerkwitz
 * Takes a given variable and associated rules to easily store a string of values
 * for easy access to user desired inputs. Contains variable for provided variable
 * and associated rules, along with getter methods.
 */
class RuleSet {

    private char variable;

    private String rules;
    RuleSet(char Variable, String rules){
        this.variable = Variable;
        this.rules = rules;
    }
    public char getVariable() {
        return variable;
    }
    public String getRules() {
        return rules;
    }
}
