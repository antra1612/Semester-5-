function moveSelectedColdDrink()
{
	var x=document.getElementById("colddrinks");
	var selected_index=x.selectedIndex;
	
	var option=document.createElement("option");
	option.text=x.options[selected_index].text;
	console.log(option.text);
	document.getElementById("selected_colddrinks").add(option);
}
function moveSelectedFoodItems()
{
	var x=document.getElementById("fooditems");
	var selected_index=x.selectedIndex;
	
	var option=document.createElement("option");
	option.text=x.options[selected_index].text;
	console.log(option.text);
	document.getElementById("selected_fooditems").add(option);
}
function removeSelectedColdDrink()
{
	var x = document.getElementById("selected_colddrinks");
	var i=x.selectedIndex;
	x.options.remove(i);
}
function removeSelectedFoodItems()
{
	var x = document.getElementById("selected_fooditems");
	var i=x.selectedIndex;
	x.options.remove(i);
}
function getBill()
{
	var total=0;
	var bill="";
	var colddrinks=document.getElementById("selected_colddrinks");
	var fooditems=document.getElementById("selected_fooditems");
	for(var i=0;i<colddrinks.length;i++){
		var item=colddrinks.options[i].text;
		bill=bill.concat(item);
		bill=bill+"<br>";
		total = total + parseInt(item.slice((item.indexOf("Rs"))+3,item.length));
	}
	bill=bill+"<br>";
	for(var i=0;i<fooditems.length;i++){
		var item=fooditems.options[i].text;
		bill=bill.concat(item);
		bill=bill+"<br>";
		total = total + parseInt(item.slice((item.indexOf("Rs"))+3,item.length));
	}
	bill=bill+"<br>";
	bill=bill+"Total:";
	bill=bill+total;
	sessionStorage.setItem("bill",bill);
}
function printBill()
{
	document.getElementById("Bill").innerHTML=sessionStorage.getItem("bill");
}