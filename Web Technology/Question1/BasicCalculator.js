function getExpression(e)
{
	var expression=sessionStorage.getItem("expression");
	var flag=sessionStorage.getItem("flag");
	var dot=sessionStorage.getItem("dot");
	if( expression == null){
		expression="";
		sessionStorage.setItem("expression",expression);
		sessionStorage.setItem("flag",0);
		sessionStorage.setItem("dot",0);
	}
	if(e=="+" || e=="-" || e=="%" || e=="/" || e=="*"){
		var count=sessionStorage.getItem("count");
		if(flag==0){
			alert("Wrong input!");
		}
		else{
			expression=expression.concat(e);
			sessionStorage.setItem("flag",0);
			sessionStorage.setItem("dot",0);
			sessionStorage.setItem("expression",expression);
			document.getElementById("result").value=expression;
		}
	}
	else if(e=="."){
		if(dot==1){
			alert("Wrong input!");
		}
		else{
			expression=expression.concat(e);
			sessionStorage.setItem("expression",expression);
			sessionStorage.setItem("dot",1);
			document.getElementById("result").value=expression;
		}
	}
	else if( /\d/.test(e)){
		expression=expression.concat(e);
		sessionStorage.setItem("flag",1);
		sessionStorage.setItem("expression",expression);
		document.getElementById("result").value=expression;
	}
	else if(e=="=" && flag==0){
		alert("Wrong input!");
	}
	else if(e=="=" ){
		var result=eval(expression);
		document.getElementById("result").value=result;
		console.log(result);
		sessionStorage.setItem("expression","");
		sessionStorage.setItem("dot",0);
		sessionStorage.setItem("flag",0);
	}
	else if(e=="C"){
		sessionStorage.setItem("expression","");
		sessionStorage.setItem("flag",0);
		document.getElementById("result").value=null;
	}
}