grammar turntTest;

//A program is any number of methods.
prgm : method*
| EOF
;

//A method describes top level constructs.
method : dir
| action
| registerMain
| register
| event
;

//Top level constructs
dir : 'dir' ID '{' blocks '}';

action : 'action' ID '{' blocks '}';

registerMain : 'register' ID 'main' INT ';';

register : 'register' ID ID INT ';';

event : 'event' ID ';';

//Blocks exist between the braces of actions and directives.
//Blocks consist of any number of block.
blocks: (block)* ;

//A block is either a flow control construct or line statement(s).
block : for_blk
| while_blk
| if_blk
| line+
;

//Flow control constructs.
for_blk : 'for' '(' for_expr ')' '{' blocks '}';

while_blk : 'while' '(' bexpr ')' '{' blocks '}';

if_blk: 'if''(' bexpr ')' '{' blocks '}'
| 'if' '(' bexpr ')' '{' blocks '}' 'else' '{' blocks '}'
;

//Line statements are single line commands.
line : prompt
| print
| register
| state
| emit
| import_stmt
| action_stmt
| assign ';'
;

//Line statements.
prompt : 'prompt' ID ';';

print : 'print' String ';'
| 'print' stateGet ';'
| 'print' expr ';'
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

import_stmt : 'module' ID '=' 'import' file ';';

action_stmt : 'action' ID ';'
| ID ';'
;

assign : type ID '=' expr
| ID '=' expr
| '(' assign ')'
;

//Various expressions.
//Boolean expressions.
bexpr : expr '==' expr 
| expr RELOP expr
| '!' bexpr 
| bexpr '&&' bexpr
| bexpr '||' bexpr
| '(' bexpr ')'
;

for_expr : (expr|assign) ';' bexpr ';' assign ;

expr : expr OP expr
| '(' expr ')'
| '~' expr
| INT
| FLOAT
| ID
; 

//Basic symbols.
RELOP : '<' | '>' | '<=' | '>=' | '!=' | '!>' | '!<' ;

file : ID '.tt';

type : 'int'
| 'float'
| 'bool'
| 'char'
| 'String'
| 'list'
;

String : '"' .*? '"'
;

//Matches longest pattern.
INT : (Digit)+
;
FLOAT : (Digit)+ '.' (Digit)+
;

OP : '*'
| '/'
| '%'
| '+'
| '-'
;

Digit : [0-9] ;

ID : [A-Za-z]([0-9A-Za-z])* ;

//Commens and whitespace.
WS : [ \t\r\n] -> skip;

COMMENT : '/*' .*? '*/' -> skip;
FORMALCOMMENT :  '//' ~('\n'|'\r')* '\r'? '\n' -> skip;
