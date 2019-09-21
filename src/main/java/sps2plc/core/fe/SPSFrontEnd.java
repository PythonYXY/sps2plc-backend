package sps2plc.core.fe;

import sps2plc.core.fe.sps.SpsParserException;
import sps2plc.core.fe.sps.parser.RequirementBuilder;
import sps2plc.core.fe.sps.parser.RequirementGrammarLexer;
import sps2plc.core.fe.sps.parser.RequirementGrammarParser;
import sps2plc.core.fe.sps.parser.ThrowingErrorListener;
import sps2plc.core.models.plc.ILCode;
import sps2plc.core.models.sps.Requirement;
import sps2plc.core.models.translators.SPS2PLC;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.ParseCancellationException;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class SPSFrontEnd {

    private RequirementBuilder builder = null;

    private Lexer lexer;
    private Parser parser;

    public SPSFrontEnd() {

    }

    /**
     * Parse the input file with given path
     * @param filePath path of input file of the list of requirements
     * @return IL code
     * @throws SpsParserException
     * @throws IOException
     */
    public void parseFile(String filePath) throws SpsParserException, IOException {
        parse(CharStreams.fromFileName(filePath));
    }

    /**
     * Parse the input string
     * @param text the list of requirements
     * @return IL code
     * @throws SpsParserException
     */
    public void parseString(String text) throws SpsParserException {
        parse(CharStreams.fromString(text));
    }

    public void parse(CharStream inStream) throws SpsParserException {
        try {
            lexer = getLexer(inStream);
            lexer.removeErrorListeners();
            lexer.addErrorListener(ThrowingErrorListener.INSTANCE);

            CommonTokenStream tokens = new CommonTokenStream(lexer);

            parser = getParser(tokens);
            parser.removeErrorListeners();
            parser.addErrorListener(ThrowingErrorListener.INSTANCE);

            ParseTreeWalker walker = new ParseTreeWalker();
            walker.walk(getParseTreeListener(), getParseTree(parser));
        } catch (ParseCancellationException e) {
            throw new SpsParserException(e.getMessage());
        }
    }

    public Lexer getLexer(CharStream inStream) {
        return new RequirementGrammarLexer(inStream);
    }

    public Parser getParser(TokenStream tokens) {
        return new RequirementGrammarParser(tokens);
    }

    public ParseTree getParseTree(Parser parser) {
        return ((RequirementGrammarParser)parser).list();
    }

    public ParseTreeListener getParseTreeListener() {
        builder = new RequirementBuilder();
        return builder;
    }

    public List<Requirement> getRequirements() {
        return builder.getContext().getRequirementList();
    }

    /**
     * @param conflictedRequirements passed as null when the function's called for the first time.
     * @return the ILCode object
     */
    public ILCode getILCode(Map<String, List<String>> conflictedRequirements) {
        return new SPS2PLC().translate(getRequirements(), conflictedRequirements);
    }
}
