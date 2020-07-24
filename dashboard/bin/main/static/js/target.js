$(document).ready(function() {
	
	var test = {"target": ["https://www.naver.com/"]};
	
	$.ajax({
		type:"post",
		data:"target=" + JSON.stringify(test),
		url:"/target/setTargetJson",
		async:false,
		success: function(e) {
			console.log(e);
		}
	});
});

