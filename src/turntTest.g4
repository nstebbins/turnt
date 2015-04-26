grammar turntTest;

prgm : method*
| EOF
;

method : dir
| action
| registerMain
| register
| event
;

registerMain : 'register' ID 'main' ';';

register : 'register' ID ID ';';

dir : 'dir' ID '{' blocks '}';

action : 'action' ID '{' blocks '}';

event : 'event' ID ';';

blocks: (block)* ;

block : for_blk
| while_blk
| if_blk
| line+
;

for_blk : 'for' '(' for_expr ')' '{' blocks '}';

while_blk : 'while' '(' bexpr ')' '{' blocks '}';

if_blk: 'if''(' bexpr ')' '{' blocks '}'
| 'if' '(' bexpr ')' '{' blocks '}' 'else' '{' blocks '}'
;


line : prompt
| print
| register
| state
| emit
| import_stmt
| action_stmt
| assign ';'
;

prompt : 'prompt' ID ';';

print : 'print' String ';'
| 'print' stateGet ';'
| print expr ';'
;

state :  stateNew
| stateGet
| stateSet
;

stateNew : 'state' type ID String ';';
stateGet : 'state' ID ';';
stateSet : 'state' ID String ';';

emit : 'emit' ID 'in' ID ';'
| 'emit' ID ';'
;

bexpr : expr '==' expr 
| expr RELOP expr
| '!' bexpr 
| bexpr '&&' bexpr
| bexpr '||' bexpr
| '(' bexpr ')'
;

RELOP : '<' | '>' | '<=' | '>=' | '!=' | '!>' | '!<' ;


import_stmt : 'module' ID '=' 'import' file ';';

file : ID '.tt';

action_stmt : 'action' ID ';'
| ID ';'
;


assign : type ID '=' expr
| ID '=' expr
| '(' assign ')'
;


for_expr : (aexpr|assign) ';' bexpr ';' assign ;

expr : aexpr
| '(' expr ')'
| Number
| ID
; 

aexpr : aexpr OP aexpr
| '-' '(' aexpr OP aexpr ')'
| '(' aexpr ')'
;


type : 'int'
| 'float'
| 'bool'
| 'char'
| 'String'
| 'list'
;

String : '"' .*? '"'
;

Number : INT | FLOAT ;

INT : Digit(INT)?
| '-' INT
;

FLOAT : INT.(INT)?
| '-' FLOAT
;

OP : '*'
| '/'
| '%'
| '+'
| '-'
;

Digit : [0-9] ;

ID : [A-Za-z]([0-9A-Za-z])* ;

WS : [ \t\r\n] -> skip;

COMMENT : '/*' .*? '*/' -> skip;
FORMALCOMMENT :  '//' ~('\n'|'\r')* '\r'? '\n' -> skip;
