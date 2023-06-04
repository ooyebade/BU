Q1. (30 points)

Write a	Node.js	module,	projectModule.js, with the following functionality. The	module maintains an array of JavaScript	objects, each with	the	property projectName, and a	unique projectId value.	Each project,	in	turn, has an array	of	employee JavaScript	objects. An	employee has the properties, fullName, and a unique employeeId.	The	module	should	export	the	functions lookupByProjectId and lookupByEmployeeId.
The	function lookupByProjectId	should	return	the	JavaScript	object	from the data whose projectId	matches	the	specified argument.	If the specified id	is not present,	undefined is returned. The function lookupByEmployeeId should return the array of JavaScript objects	from	the	data	
that	has	all	the	projects	in	which	the	specified	employee	is	working.	If	the	specified	employeeId	is	not	assigned	to	any	project,	[]	is	returned.	
Write	the	code	for	the	two	module functions using	JavaScript.	The	template	file	is	shown	
below. Please	note	that	there	can	be	any	number	of	projects	and	any	number	of	employees	for	each	project	in	the	data.


Q2.	 (20	points)

Using	the	projectModule functionality	from	Question1,	show	how	you	would	develop	Node	
web	application	that	can	display	the	information	about	the	requested	project.	The	web	
application	should	handle	GET	requests	for	the	form	/project/<projectId>. The	server	code	using	the	Express	and	handlebars	framework	is	shown	below.	Write	only the	
code	for	the	/project/:id	route	as	given	in	the	template	code	below. The	project	should	be	
looked	up	using	the	projectModule from	the	previous	question.	This	project	should	be	passed	
as	the	model	for	the	projectView page.
Now,	write	the	projectView page	for	rendering	the	corresponding	project.	The	template	for	the	
page	is	shown	below.


Q3.	 (15 points)

Write	a	PHP	script	for	determining	which	characters	inside	of	a	given array	are	vowels	(a,	e,	i,	o,	
u),	consonants,	and	integers.	You	can	assume	that	the	array	only	holds	letters	and	numbers	and	
you	do	not need	to	handle	objects. The	letters	in	the	array	are	strings	of	unit	length.	The	
numbers	in	the	array	will	only	be	single	digit	numbers.	The	PHP	function	is_int(arg) returns	true	
if	the	given	argument	is	an	integer. Note	that	the	code	should	work	for	any	size	array	containing	
a	mixture	of	vowels,	consonants,	and	single	digits.


Q4.	(15 points)

Write	the	code	for a	PHP	class	called	Rectangle that	can	be	used	to	create	rectangle	objects.	
Your	class	should	include	the	following	information:
a. A	private	instance variable	named	width that	specifies	the	width	of	the	rectangle.
b. A	private	instance variable	named	height that	specifies	the	height	of	the	rectangle.
c. A	constructor with	two	arguments that	creates	a	rectangle	with	the	specified	width	
and	height.
d. A	method	named	getArea() that	returns	the	area	of	the	rectangle.
Hint:	Area	=	 width	*	height
Now,	write	the	code	for	a	PHP	class,	Square,	extending	the	Rectangle	class,	with	no private	
instance	variables	and	with	a	single	constructor	with	the	side	of	the	square	as	the	only	
constructor argument.
Now, create	an	instance	of	Rectangle with	a	width	of	10	and	a	height	of	20.	Show	how you	
would	display	the	area	of	this	rectangle.
Now,	create	an	instance	of	Square with	a	side	of	20.	Show	how	you	would	display	the	area	of	
this	square.
A	template	for	the	Rectangle	class	is	shown	below