Chart.defaults.global.defaultFontFamily = 'Nunito', '-apple-system,system-ui,BlinkMacSystemFont,"Segoe UI",Roboto,"Helvetica Neue",Arial,sans-serif';
Chart.defaults.global.defaultFontColor = '#858796';

$(document).ready(function(){
	
	// 성능 점수 차트
	var performanceData = getPerformanceData();
	var chart = document.getElementById("performanceChartByUrl");
	var chartConfig = makeBarChartByUrl(performanceData["url"], '', performanceData["performance"], '점');
	var chartInstance = new Chart(chart, chartConfig);

	// 지연시간 차트
	var latencyData = getLatencyData();
	var chart = document.getElementById("maxLatencyChartByUrl");
	var chartConfig = makeBarChartByUrl(latencyData["url"], '', latencyData["latency"], 'ms');
	var chartInstance = new Chart(chart, chartConfig);
	
	
	// 총 수행시간 차트
	var totalTaskTimeData = getTotalTaskTimeData();
	var chart = document.getElementById("totalTaskTimeChartByUrl");
	var chartConfig = makeBarChartByUrl(totalTaskTimeData["url"], '', totalTaskTimeData["totalTaskTime"], 'ms');
	var chartInstance = new Chart(chart, chartConfig);
});

//시간별 라인 차트 JSON 가져오기
function makeBarChartByUrl(xData, xDataLabel, yData, yDataLabel, color) {
	var configJson = {
		  type: "bar",
		  data: {
		    labels: xData,
		    datasets: [{label: xDataLabel, lineTension: 0.3, pointRadius: 3, pointHitRadius:10, pointBorderWidth:2, data: yData,}],
		  },
		  options: {
			  maintainAspectRatio: false,
			  layout: {padding: {left: 10, right: 25, top: 25, bottom: 0}},
			  scales: {
				  xAxes: [{time: {unit: xDataLabel}, gridLines: {display: false, drawBorder: false}}],
				  yAxes: [{ticks: {maxTicksLimit:5, padding:10, callback: function(value, index, values) {return value + " " + yDataLabel;}},
					  		gridLines: {color: "rgb(234, 236, 244)", zeroLineColor: "rgb(234, 236, 244)", drawBorder: false, borderDash: [2], zeroLineBorderDash: [2]}}],
			  },
			  legend: {display: false},
			  tooltips: {backgroundColor: "rgb(255,255,255)", bodyFontColor: "#858796", titleMarginBottom: 10, titleFontColor: '#6e707e', titleFontSize: 14,
				  borderColor: '#dddfeb', borderWidth: 1, xPadding: 15, yPadding: 15, displayColors: false, intersect: false, mode: 'index', caretPadding: 10,
				  callbacks: {label: function(tooltipItem, chart) { return tooltipItem.yLabel + " " + yDataLabel;}}
			  }
		  	}
		};
	return configJson;
}

// 시간별 라인 차트 데이터 업데이트
function updateTimeChartData(chart, yData) {
	chart.data.datasets[0].data = yData;
	chart.update();
}