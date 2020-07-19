// 성능점수 가져오기
function getPerformanceData() {
	var performanceData;
	$.ajax({
		url: "/mainscore/avgPerformanceScore",
		async: false,
		success: function(response) {
			var data = JSON.parse(response);
			performanceData = data;
		}
	});
	
	url = [], performance = [];
	for (var key in performanceData) {
		url.push(key);
		performance.push(performanceData[key]);
	}
	
	return {"url":url,"performance":performance};
}

// 지연시간 데이터 가져오기
function getLatencyData() {
	var latencyData;
	$.ajax({
		url: "/summary/avgMaxLatencyTime",
		async: false,
		success: function(response) {
			var data = JSON.parse(response);
			latencyData = data;
		}
	});
	
	url = [], latency = [];
	for (var key in latencyData) {
		url.push(key);
		latency.push(latencyData[key]);
	}
	
	return {"url":url,"latency":latency};
}

// 총 수행 시간 데이터 가져오기
function getTotalTaskTimeData() {
	var totalTaskTimeData;
	$.ajax({
		url: "/summary/avgTotalTaskTime",
		async: false,
		success: function(response) {
			var data = JSON.parse(response);
			totalTaskTimeData = data;
		}
	});
	
	url = [], totalTaskTime = [];
	for (var key in totalTaskTimeData) {
		url.push(key);
		totalTaskTime.push(totalTaskTimeData[key]);
	}
	
	return {"url":url,"totalTaskTime":totalTaskTime};
}