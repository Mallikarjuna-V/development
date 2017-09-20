<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div id="container">
    <input type="text" id="input" value="">
</div>
	<div id="output"></div>
      


<script src="https://code.jquery.com/jquery-3.0.0.js" 
integrity="sha256-jrPLZ+8vDxt2FnE1zvZXCkCcebI/C8Dt5xyaQBjxQIo=" crossorigin="anonymous"></script>

<script>
var questionNum = 0;													// keep count of question, used for IF condition.
//var question = '<h1>what is your name?</h1>';				  // first question
var greeting = '<h1>Hi !! how may I assist you</h1>'

var output = document.getElementById('output');				// store id="output" in output variable
output.innerHTML = greeting;													// ouput first question

function bot() { 
    var input = document.getElementById("input").value;
    console.log(input);
    var  subInput = "name",subInput1 = "what",subInput3 = "chat",subInput4 = "end";
    	if(questionNum == 0) {
    	if(input.includes(subInput) && input.includes(subInput1)){
			if(input.includes("pet")){
				output.innerHTML = '<h1>you have never asked so I have never thought about it</h1>';
	    		document.getElementById("input").value = "";
	    		setTimeout(timedQuestion, 2000);
			} else {
    		output.innerHTML = '<h1>hello I am pkrmini</h1>';
    		document.getElementById("input").value = "";
    		setTimeout(timedQuestion, 2000);
			}
    	}
    	else if(input.includes(subInput3) && input.includes(subInput4)){
    		output.innerHTML = '<h1>Have a nice day !!</h1>';
    	}
    	else {
    			var res = input.replace(/ /g, "+");
    			var result = "https://www.google.co.in/search?q="+res;
    			document.getElementById("input").value = "";
    			setTimeout(timedQuestion, 2000);
    	 }
    	}
}

function timedQuestion() {
	var question1 = "Is there anything more?"
    output.innerHTML = question1;
}

//push enter key (using jquery), to run bot function.
$(document).keypress(function(e) {
  if (e.which == 13) {
    bot();																						// run bot function when enter key pressed
   // questionNum++;																		// increase questionNum count by 1
  }
});

</script>

</body>
</html>
