package sps2plc.core.models.smt;

import org.json.JSONObject;

import javax.json.JsonObject;

public class Formula {

    private String smtFormula;
    private String scopeSmtFormula;

    public Formula(String smtFormula, String scopeSmtFormula) {
        this.smtFormula = smtFormula;
        this.scopeSmtFormula = scopeSmtFormula;
    }

    public String getSmtFormula() {
        return smtFormula;
    }

    public void setSmtFormula(String smtFormula) {
        this.smtFormula = smtFormula;
    }

    public String getScopeSmtFormula() {
        return scopeSmtFormula;
    }

    public void setScopeSmtFormula(String scopeSmtFormula) {
        this.scopeSmtFormula = scopeSmtFormula;
    }

    public static Formula getFormula(JSONObject obj) {
        return new Formula(obj.getString("smt"), obj.getString("scope_smt"));
    }
}
