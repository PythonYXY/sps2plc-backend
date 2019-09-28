package sps2plc.core.models.translators;


import sps2plc.core.fe.sps.parser.RequirementBuilder;
import sps2plc.core.fe.sps.parser.RequirementGrammarLexer;
import sps2plc.core.fe.sps.parser.RequirementGrammarParser;
import sps2plc.core.models.plc.ScopeCode;
import sps2plc.core.models.sps.Requirement;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.apache.commons.io.IOUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Pattern {

    public static final String PATTERNS_FILE = "/pattern_to_plc.json";

    private final ScopeCode scopeCode;

    private final Requirement requirement;

    public Pattern(Requirement requirement, ScopeCode scopeCode) {
        this.requirement = requirement;
        this.scopeCode = scopeCode;
    }

    public Requirement getRequirement() {
        return requirement;
    }

    public ScopeCode getScopeCode() {
        return scopeCode;
    }

    public static Map<String, Pattern> loadPattern(String configuration) {
        Map<String, Pattern> patterns = new HashMap<>();

        ParseTreeWalker walker = new ParseTreeWalker();

        InputStream is = Pattern.class.getResourceAsStream(configuration);
        if (is == null) throw new RuntimeException("Resource not found!");

        String json = null;

        try {
            json = IOUtils.toString(is);
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }

        JSONArray jsonArray = new JSONArray(json);

        for (int i = 0; i < jsonArray.length(); ++i) {
            JSONObject obj = jsonArray.getJSONObject(i);

            String reqText = obj.getString("scope");
            JSONObject scopeCode = obj.getJSONObject("plc");

            RequirementBuilder reqBuilder = new RequirementBuilder();
            RequirementGrammarLexer reqLexer = new RequirementGrammarLexer(CharStreams.fromString(reqText));
            CommonTokenStream tokens = new CommonTokenStream(reqLexer);
            RequirementGrammarParser parser = new RequirementGrammarParser(tokens);

            walker.walk(reqBuilder, parser.list());
            List<Requirement> requirementList = reqBuilder.getContext().getRequirementList();
            Requirement requirement = requirementList.get(0);

            Pattern pattern = new Pattern(requirement, ScopeCode.getScopeCode(scopeCode));
            patterns.put(requirement.key(), pattern);
        }
        return patterns;
    }
}
