// 자원 지연시간 데이터 가져오기
function getNetworkServerLatencyData(url) {
	var networkServerLatencyData;
	$.ajax({
		url: "/latency/latencyByUrl",
		data: {url:url},
		async: false,
		success: function(response) {
			var data = JSON.parse(response);
			networkServerLatencyData = data;
		}
	});
	
	return networkServerLatencyData;
}