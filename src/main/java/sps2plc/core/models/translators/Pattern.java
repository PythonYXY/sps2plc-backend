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
import sps2plc.core.models.plc.ScopeCode;
import sps2plc.core.models.sps.Requirement;

import javax.json.JsonObject;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Pattern {

    public static Map<String, Pattern> loadPattern(String configuration, String reqKey) {
        Map<String, Pattern> patterns = new HashMap<>();

        ParseTreeWalker walker = new ParseTreeWalker();

        InputStream is = ILPattern.class.getResourceAsStream(configuration);
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
            RequirementBuilder reqBuilder = new RequirementBuilder();
            RequirementGrammarLexer reqLexer = new RequirementGrammarLexer(CharStreams.fromString(obj.getString(reqKey)));
            CommonTokenStream tokens = new CommonTokenStream(reqLexer);
            RequirementGrammarParser parser = new RequirementGrammarParser(tokens);

            walker.walk(reqBuilder, parser.list());
            List<Requirement> requirementList = reqBuilder.getContext().getRequirementList();
            Requirement requirement = requirementList.get(0);

            ILPattern pattern = new ILPattern(requirement, ScopeCode.getScopeCode(scopeCode));
            Pattern pattern = createPattern(obj, requirement);
            patterns.put(requirement.key(), pattern);
        }
        return patterns;
    }

    public abstract Pattern createPattern(JsonObject obj, Requirement requirement);
}
