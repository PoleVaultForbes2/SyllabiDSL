grammar SyllabusDSL;

syllabus: difficultyLevels breaks? semesterDates? course+ EOF;

breaks: 'BREAKS' ':' breakRange+;

breakRange: '(' DATE '-' DATE ')';

semesterDates: 'SEMESTER DATES' ':' '(' DATE ',' DATE ')';

difficultyLevels: 'DIFFICULTY LEVEL:' difficultyEntry+;

difficultyEntry: INT ':' INT;

course: 'COURSE' WS? ID ':' category+;

category: ('HOMEWORK' | 'PROJECTS' | 'TEST') ':' assignment+;

assignment: '(' STRING ',' DATE (',' INT)? (',' COLOR)? ')';

DATE: MONTH '/' DAY '/' YEAR;

COLOR: 'red' | 'blue' | 'green' | 'yellow'; //red for HOMEWORK, blue for PROJECTS, green for TEST, yellow for BREAKS

fragment MONTH: (('0'?[1-9] | '1'[012]));

fragment DAY: ('0'?[1-9] | [12][0-9] | '3'[01]);

fragment YEAR: [2][0][0-9][0-9];

ID: [a-zA-Z_][a-zA-Z_0-9]*;

STRING: '"' .*? '"';

INT: [0-9]+;

WS: [ \t\r\n]+ -> skip;

INVALID: . -> channel(HIDDEN);