package sps2plc.core.fe.sps.parser;

import sps2plc.core.models.sps.Requirement;

import java.util.ArrayList;

public class Context {

    private ArrayList<Requirement> requirementList = new ArrayList<>();

    public Context() {}

    public void addRequirement(Requirement req) { requirementList.add(req); }

    public ArrayList<Requirement> getRequirementList() { return requirementList; }


}
