grammar turnt;

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

event : 'event' ID '{' blocks '}'	 	# AE_EVENT
| 'event' ID ';'						# NAE_EVENT
;

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

while_blk : 'while' conditional '{' blocks '}';

if_blk: 'if' conditional '{' blocks '}'
| 'if' conditional '{' blocks '}' 'else' '{' blocks '}'
;

conditional : '(' bexpr ')' ;

//Line statements are single line commands.
line : prompt
| print
| register
| state
| emit
| emitOn
| import_stmt
| action_stmt
| declare_line
| assign_line
;

//Line statements.
prompt : 'prompt' ID ';';

print : 'print' String ';'  # STRING_PRINT
| 'print' stateGet ';'      # STATE_PRINT
| 'print' expr ';'          # EXPR_PRINT
;

state :  stateNew
| stateGet
| stateSet
;

stateNew : 'state' type ID String ';'
| 'state' type ID INT ';'
| 'state' type ID FLOAT ';'
| 'state' type ID BOOL ';'
;
stateGet : 'state' ID ';';
stateSet : 'state' ID String ';'
| 'state' ID INT ';'
| 'state' ID FLOAT ';'
| 'state' ID BOOL ';'
;

emit : 'emit' ID 'in' ID ';'
| 'emit' ID ';'
;

emitOn : 'emitOn' bexpr ';';

import_stmt : 'module' ID '=' 'import' file ';';

action_stmt : 'action' ID ';'
| ID ';'
;

declare_line : declare ';' ;

declare : type ID;

assign_line : assign ';' ;

assign : declare '=' rexpr  # DEC_ASSIGN
| declare '=' rbexpr        # BDEC_ASSIGN
| ID '=' rexpr              # ID_ASSIGN
| ID '=' rbexpr             # BID_ASSIGN
| '(' assign ')'            # P_ASSIGN
;

//Various expressions.
//Boolean expressions.
bexpr : expr '==' eqlsexpr  # EQ_BEXPR
| expr '!=' eqlsexpr		# NE_BEXPR
| expr RELOP rexpr          # REL_BEXPR
| bexpr '==' eqlsbexpr      # BEQ_BEXPR
| bexpr '!=' eqlsbexpr      # BNE_BEXPR
| '!' rbexpr                # N_BEXPR
| bexpr '&&' rbexpr         # L_BEXPR
| bexpr '||' rbexpr         # L_BEXPR
| '(' bexpr ')'             # P_BEXPR
| BOOL                      # BOOL
| ID                        # ID_BEXPR
;

eqlsexpr : expr ;

eqlsbexpr : bexpr ;

rbexpr : bexpr ;

for_expr : for_init for_condition assign ;

for_init : (expr|assign) ';' ;

for_condition : bexpr ';' ;

expr : '(' expr ')' 			# P_EXPR
| '~' expr          			# NEG_EXPR
| expr OP rexpr     			# OP_EXPR
| INT               			# TERM_EXPR
| FLOAT             			# TERM_EXPR
| ID                			# TERM_EXPR
| ID '[' INT ']'				# ELEM_EXPR
| '{' expr (',' expr)* '}' 		# ARRAY_EXPR
; 

rexpr : expr;

//Basic symbols.
RELOP : '<' | '>' | '<=' | '>=' | '!>' | '!<' ;

file : ID '.tt';

type : 'int'
| 'float'
| 'bool'
| 'char'
| 'String'
| list_type
;

list_type : 'list int'
| 'list float'
;

String : '"' .*? '"'
;

//Matches longest pattern.
INT : (Digit)+
;
FLOAT : (Digit)+ '.' (Digit)+
;

BOOL: 'true'
| 'false'
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
