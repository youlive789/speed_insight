$(document).ready(function() {
	
	// 초기 수집 URL 리스트 화면 출력
	$.ajax({
		type:"get",
		url:"/target/getTargetJson",
		async:false,
		success: function(e) {
			var targetJson = JSON.parse(e);
			if (targetJson.result) {

			}
			else {
				var urls = targetJson["target"];
				
				for (var idx = 0; idx < urls.length; idx++) {
					var liHtml = generateUrlLi(urls[idx]);
					$(".url-list").append(liHtml);
				}
			}
		}
	});
	
	// 리스트에서 삭제 버튼 클릭시
	$(document).on("click", ".url-remove", function() {
		$(this).parent().remove();
	});
	
	// 입력 버튼 클릭 시
	$("#url-btn").on("click", function() {
		var url = $("#url-input").val();
		var liHtml = generateUrlLi(url);
		$(".url-list").append(liHtml);
		$("#url-input").val("");
	});
	
	// 저장 버튼 클릭 시
	$(".btn-save-target").on("click", function() {
		var target = makeTargetJson();
		saveTargetJson(target);
	});
	
});

function generateUrlLi(url) {
	return '<li class="url-li" ' + ' data-url="'+ url + '">' + url + '<span class="url-remove">X</span></li>'
}

function makeTargetJson() {
	var target = {"target": []};
	$(".url-li").each(function(index, element) {
		target["target"].push($(element).data("url"));
	});
	return target;
}

function saveTargetJson(target) {	
	$.ajax({
		type:"post",
		data:"target=" + JSON.stringify(target),
		url:"/target/setTargetJson",
		async:false,
		success: function(e) {
			console.log(e);
			var res = JSON.parse(e);
			if (res.result == "success") {
				alert("저장성공");
			}
			else {
				alert("실패");
			}
		}
	});
}
