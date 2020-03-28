package sps2plc.core.models.translators;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.apache.commons.io.IOUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import sps2plc.core.fe.sps.parser.RequirementBuilder;
import sps2plc.core.fe.sps.parser.RequirementGrammarLexer;
import sps2plc.core.fe.sps.parser.RequirementGrammarParser;
import sps2plc.core.models.smt.Formula;
import sps2plc.core.models.sps.Requirement;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SMTPattern {

    public static final String PATTERNS_FILE = "/pattern_to_smt.json";
    private final Formula formula;
    private final Requirement requirement;

    public SMTPattern(Requirement requirement, Formula formula) {
        this.formula = formula;
        this.requirement = requirement;
    }

    public Requirement getRequirement() {
        return requirement;
    }

    public Formula getFormula() {
        return formula;
    }

    public static Map<String, SMTPattern> loadPattern(String configuration) {
        Map<String, SMTPattern> patterns = new HashMap<>();
        ParseTreeWalker walker = new ParseTreeWalker();

        InputStream is = SMTPattern.class.getResourceAsStream(configuration);
        if (is == null) {
            throw new RuntimeException("Resource not found!");
        }

        String json = null;
        try {
            json = IOUtils.toString(is);
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }

        JSONArray jsonArray = new JSONArray(json);

        for (int i = 0; i < jsonArray.length(); ++i) {
            JSONObject obj = jsonArray.getJSONObject(i);

            String reqText = obj.getString("pattern");

            RequirementBuilder reqBuilder = new RequirementBuilder();
            RequirementGrammarLexer reqLexer = new RequirementGrammarLexer(CharStreams.fromString(reqText));
            CommonTokenStream tokens = new CommonTokenStream(reqLexer);
            RequirementGrammarParser parser = new RequirementGrammarParser(tokens);

            walker.walk(reqBuilder, parser.list());
            List<Requirement> requirementList = reqBuilder.getContext().getRequirementList();
            Requirement requirement = requirementList.get(0);

            SMTPattern pattern = new SMTPattern(requirement, Formula.getFormula(obj.getJSONObject("smt")));
            patterns.put(requirement.key(), pattern);
        }
        return patterns;
    }
}
