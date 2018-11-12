package com.kuerkwitz.Lsystem.UI;

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
