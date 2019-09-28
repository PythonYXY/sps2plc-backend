grammar RequirementGrammar;

@header {
    package sps2plc.core.fe.sps.parser;
}

list: requirement+;

requirement: reqID? (scope ',') (delay ',')? property '.';
reqID: '[' number ']';
scope: 'Globally' | 'After' expr | 'After' expr 'until' expr | 'When' expr;
delay: delayWithEnd | delayWithoutEnd | delayOnBothSides;
property: universality | absence | existence | interlock;

delayWithEnd: 'delayL' '=' expr ',' 'delayR' '=' expr;
delayWithoutEnd: 'delayL' '=' expr;
delayOnBothSides: 'delayL' '=' expr ',' 'delayRE' '=' expr;

universality: ID 'is' 'true';
absence: ID 'is' 'false';
existence: ID 'exists';
interlock: '(' ID 'and' ID ')' 'is' 'false';

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
ID: LETTER | (LETTER | DIGIT) (LETTER | DIGIT | '.')* (LETTER | DIGIT);

WS: [ \t\r\n]+ -> skip ;
LINE_COMMENT : '#' .*? '\r'? '\n' -> skip; // Match "#" stuff '\n'

fragment NONZERODIGIT: [1-9];
fragment DIGIT : [0-9];
fragment LETTER : [a-zA-Z];