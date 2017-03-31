//Short Circut Evaluation

int index = 0
String S = "Hello";

while(S.charAt(index)!= " " && index < S.length())
{
	index++
}

//Flipped order (Short Circut Evaluation)
while(index < S.length && S.charAt(index)!="")
{
	index++
}

//Demorgan's Law
//If you have two relatin expressions 

//Calculate the negation of the following expression.

(z < x) and (z > y || x >=y)

//Table
Relation | Negation (!)
	>		  <=
	<		  >=
	>=		  <
	<=		  >
	==		  !=
	!=		  ==