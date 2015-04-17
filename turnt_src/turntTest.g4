grammar turntTest;

prgm : start body
| body start body
| EOF
;

start : 'register' ID 'main' ';'(start)?
;

body : (method)*
;

method : dir
| action
;

dir: 'dir' ID '{' block '}'
;

action: 'action' ID '{' block '}'
;

block : line(block)?
| for
| while
| if
;

for: 'for' '(' (aexpr|assign) ';' bexpr ';' assign ')';

while: 'while' bexpr '{' block '}';

if : 'if' bexpr '{' block '}'
| 'if' bexpr '{' block '}' 'else' '{' block '}'
;

line : prompt';'
| print ';'
| event ';'
| reg ';'
| state ';'
| emit ';'
| import ';'
| action ';'
| assign ';'
;

prompt : 

state : 'state' type ID
| 'state' ID
| 'state' assign
;

emit : 'emit' ID 'in' ID
| 'emit' ID
;

import : 'module' ID '= import' file 
;

action : 'action' ID
| ID
;

file : ID '.tt'
;

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

assign : type ID '=' expr
| ID '=' expr
| '(' assign ')'
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
;

Digit : [0-9] ;

ID : [A-Za-z]([0-9A-Za-z])* ;

WS : [ \t\r\n] -> skip;
