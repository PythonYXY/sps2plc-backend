package sps2plc.core.models.sps;

public interface ScopeVisitor {

    void visitGloballyScope(Scope scope);

    void visitAfterUntilScope(Scope scope);

    void visitAfterScope(Scope scope);

    void visitWhenScope(Scope scope);
}
