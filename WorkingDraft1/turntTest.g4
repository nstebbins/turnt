grammar turntTest;

prgm : start body
| body start body
| EOF
;

start : 'register' ID 'main' ';'(start)?
;

body : method (body)?
;

dir : 'dir' ID '{' block '}';

action : 'action' ID '{' block '}';

method : dir
| action
;

block : line(block)?
| 'for' fstmt '{' block '}'
| 'while' bexpr '{' block '}'
| ifstmt
;

line : 'prompt' ID ';'
| 'print' String ';'
| 'event' ID ';'
| 'register' ID ID ';'
| sstmt ';'
| estmt ';'
| istmt ';'
| astmt ';'
| assign ';'
;

ifstmt : 'if' bexpr '{' block '}'
| 'if' bexpr '{' block '}' 'else' '{' block '}'
;

sstmt : 'state' type ID
| 'state' ID
| 'state' assign
;

estmt : 'emit' ID 'in' ID
| 'emit' ID
;

istmt : 'module' ID '= import' file 
;

astmt : 'action' ID
| ID
;

fstmt : '(' (aexpr|assign) ';' bexpr ';' assign ')';

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
| '%'
;

Digit : [0-9] ;

ID : [A-Za-z]([0-9A-Za-z])* ;

WS : [ \t\r\n] -> skip;
