grammar RequirementGrammar;

@header {
    package sps2plc.core.fe.sps.parser;
}

list: requirement+;

requirement: reqID? scope ',' property delay? '.';
reqID: '[' number ']';
scope: 'Globally' | 'After' expr | 'After' expr 'until' expr | 'When' expr;
delay: delayWithEnd1 | delayWithEnd2 | delayWithoutEnd | delayOnBothSides | delayOnRightSide;
property: universality | absence | existence | interlock;

delayWithEnd1: 'between' expr 'timeUnits' 'and' expr 'timeUnits';
delayWithEnd2: 'within' expr 'timeUnits';
delayWithoutEnd: 'after' expr 'timeUnits';
delayOnBothSides: 'after' expr 'timeUnits' 'and' 'the' 'property' 'still' 'holds' 'for' expr 'timeUnits' 'after' 'the' 'end' 'of' 'the' 'scope';
delayOnRightSide: 'and' 'the' 'property' 'still' 'holds' 'for' expr 'timeUnits' 'after' 'the' 'end' 'of' 'the' 'scope';

universality: 'it' 'is' 'always' 'the' 'case' 'that' ID 'holds';
absence: 'it' 'is' 'never' 'the' 'case' 'that' ID 'holds';
existence: ID 'exists' 'immediately';
interlock: 'it' 'is' 'never' 'the' 'case' 'that' '(' ID 'and' ID ')' 'hold';

expr
    : '(' expr ')'                                  #BracketExpression
    | expr ('and' | 'or') expr                      #BooleanExpression
    | 'not' ID                                      #UnaryExpression
    | ID                                            #VariableExpression
    | number                                        #NumberExpression
    ;

number: POSITIVE_INT | FLOAT;
positiveInt: POSITIVE_INT;

FLOAT: '-'? ('.' DIGIT+ | DIGIT+ ('.' DIGIT*)? );
POSITIVE_INT: DIGIT | NONZERODIGIT (DIGIT)*;
ID: (LETTER | CHINESE) | (LETTER | DIGIT | CHINESE) (LETTER | DIGIT | '.' | CHINESE)* (LETTER | DIGIT | CHINESE);

WS: [ \t\r\n]+ -> skip ;
LINE_COMMENT : '#' .*? '\r'? '\n' -> skip; // Match "#" stuff '\n'

fragment NONZERODIGIT: [1-9];
fragment DIGIT : [0-9];
fragment LETTER : [a-zA-Z];
fragment CHINESE: [\u4E00-\u9FA5\uff08-\uff09];