/**
 * p72.html
 */
$(document).ready(function() {
	let getRandom = function(num) {
		var my_num = Math.floor(Math.random()*num);
		return my_num;
	};
	
	let hideCode = function() {
		var numRand = getRandom(4); // 0, 1, 2, 3
		numRand = 0; // 테스트용
		$(".guess_box").each(function(index, value) {
			if(numRand === index) {
				$(this).append("<span id='has_discount'></span>");
				return false; // 함수를 종료시키기위해 false를 리턴 (return만 적어도 가능)
			}
		})
	};
	
	hideCode();
	
	let checkForCode = function() {
		let discount = "";
		// contains : 해당 문자열을 찾는 함수 (this에 has_discount라는 명을 가진 this를 찾는 코드)
		if($.contains(this, document.getElementById("has_discount"))) {
			let my_num = getRandom(100); // 할인율 생성
			discount = "<p>Your Code : CODE"+new Date().getTime()+my_num+"</p>";
		} else {
			discount = "<p>Sorry, no discount this time!</p>";
		}
		$(this).append(discount);
		
		$(".guess_box").each(function(){
			if($.contains(this, document.getElementById("has_discount"))){
				$(this).addClass("discount");
			} else {
				$(this).addClass("no_discount");
			}
			$(this).unbind("click");
		});
	}
	$(".guess_box").click(checkForCode);
});