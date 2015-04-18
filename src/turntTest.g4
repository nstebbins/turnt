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

blocks: block+;

block : for_blk
| while_blk
| if_blk
| ifelse_blk
| line+
;

for_blk : 'for' '(' for_ex ')' '{' block '}';

while_blk : 'while' '(' bexpr ')' '{' block '}';

if_blk: 'if' '(' bexpr ')' '{' block '}';

ifelse_blk : 'if' '(' bexpr ')' '{' block '}' 'else' '{' block '}';


line : prompt
| print
| register
| state
| emit
| import_ex
| action_inv
| assign
;

prompt : 'prompt' ID ';';

print : 'print' String ';'
| 'print' stateGet ';'
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

import_ex : 'module' ID '=' 'import' file ';';

file : ID '.tt';

action_inv : 'action' ID ';'
| ID ';'
;

assign : type ID '=' expr
| ID '=' expr
| '(' assign ')'
;


for_ex : '(' (aexpr|assign) ';' bexpr ';' assign ')';

bexpr : expr RELOP expr
| '!' bexpr 
| bexpr '&&' bexpr
| bexpr '||' bexpr
| '(' bexpr ')'
;

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

RELOP : '<' | '>' | '==' | '<=' | '>=' | '!=' | '!>' | '!<' ;

OP : '+'
| '-'
| '*'
| '/'
| '%'
;

Digit : [0-9] ;

ID : [A-Za-z]([0-9A-Za-z])* ;

WS : [ \t\r\n] -> skip;
