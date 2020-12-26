function getStates()
{
	var India=["Gujarat","Delhi"];
	var Australia=["Tasmania","Victoria"];
	var states=new Map();
	states.set("India",India);
	states.set("Australia",Australia);
	var x=document.getElementById("country");
	var i = x.selectedIndex;
	var y = x.options[i].text;
	var states_display = states.get(y);
	for(var i=0;i<states_display.length;i++)
	{
		var option=document.createElement("option");
		option.text=states_display[i];
		document.getElementById("state").add(option);
	}
	sessionStorage.setItem("location","Country:"+y+"<br>State:");
}
function getCities()
{
	var Gujarat=["Ahmedabad","Surat"];
	var Delhi=["Faridabad","Agra"];
	var Tasmania=["Hobert","Burnie"];
	var Victoria=["Ararat","Colac"];
	var cities=new Map();
	cities.set("Gujarat",Gujarat);
	cities.set("Delhi",Delhi);
	cities.set("Victoria",Victoria);
	cities.set("Tasmania",Tasmania);
	var x=document.getElementById("state");
	var i = x.selectedIndex;
	var y = x.options[i].text;
	var cities_display = cities.get(y);
	for(var i=0;i<cities_display.length;i++)
	{
		var option=document.createElement("option");
		option.text=cities_display[i];
		document.getElementById("city").add(option);
	}
	var location=sessionStorage.getItem("location");
	location=location+y;
	sessionStorage.setItem("location",location+"<br>City");
}
function getLocation()
{
	var x=document.getElementById("city");
	var i = x.selectedIndex;
	var y = x.options[i].text;
	var location=sessionStorage.getItem("location");
	location=location+y;
	sessionStorage.setItem("location",location);
}
function printLocation(){
	document.getElementById("location").innerHTML=sessionStorage.getItem("location");
}