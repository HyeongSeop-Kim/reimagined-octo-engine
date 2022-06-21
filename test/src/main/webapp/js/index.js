/**
 * 
 */
 window.onload = function() {
	toggleConstraint();
	toggleRrequired()
}

 function toggleConstraint() {
	var input = document.querySelectorAll(".join-form__input");
	var pwInput = input.item(1);
	
	pwInput.addEventListener("focus", function showConstraint() {
		var constraintSpan = document.querySelector(".constraint__span");
		constraintSpan.classList.remove('hide');
	});
	pwInput.addEventListener("blur", function hideConstraint() {
		var constraintSpan = document.querySelector(".constraint__span");
		constraintSpan.classList.add('hide');
	});
}

function toggleRrequired() {
	var inputAll = document.querySelectorAll(".join-form__input");
	var constraintSpanAll = document.querySelectorAll(".required__span");
	
	var inputID = inputAll.item(0);
	var constraintSpanID = constraintSpanAll.item(0);
	
	inputID.addEventListener("blur", function checkValue() {
		if(!this.value) {
			constraintSpanID.classList.remove('hide');
		} else {
			constraintSpanID.classList.add('hide');
		}
	});
	
	var inputPW = inputAll.item(1);
	var constraintSpanPW = constraintSpanAll.item(1);
	
	inputPW.addEventListener("blur", function checkValue() {
		if(!this.value) {
			constraintSpanPW.classList.remove('hide');
		} else {
			constraintSpanPW.classList.add('hide');
		}
	});
	
	var inputChkPW = inputAll.item(2);
	var constraintSpanChkPW = constraintSpanAll.item(2);
	
	inputChkPW.addEventListener("blur", function checkValue() {
		if(!this.value) {
			constraintSpanChkPW.classList.remove('hide');
		} else {
			constraintSpanChkPW.classList.add('hide');
		}
	});
}