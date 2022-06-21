/**
 * 
 */
 
 function f1() {
	var id1 = document.getElementById("id1");
	var first_li = id1.firstElementChild;
	var last_li = id1.lastElementChild;
	first_li.style.color = "red";
	last_li.style.color = "blue";
}

function f2() {
	var id2 = document.getElementById("id2");
	var prev_li = id2.previousElementSibling;
	var next_li = id2.nextElementSibling;
	
	prev_li.style.color = "red";
	next_li.style.color = "blue";
}

function f3() {
	var id3 = document.getElementById("id3");
	var ul = id3.parentElement;
	
	ul.style.backgroundColor = "white";
}