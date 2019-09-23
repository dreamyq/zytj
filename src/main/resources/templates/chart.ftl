<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org"
      xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity3">
<head>
    <title>图表</title>
    <script src="http://how2j.cn/study/js/chartjs/2.8.0/chart.min.js"></script>
</head>
<body>
<div style="width:400px;margin:0px auto">
    <canvas id="myChart" ></canvas>
</div>
<script>
    var ctx = document.getElementById('myChart').getContext('2d');
    var myChart = new Chart(ctx, {
        type: 'line',
        data: {
            labels: [<#list yearData as item>${item.year}<#sep>,</#list>],
            datasets: [<#list yearData as item>{
                label: '示例',
                data: [${item.peopleNums}],
                borderColor:'blue',
                borderWidth: 1,
                fill: false,
            }<#sep>,</#list>]
        },
        options: {
            tooltips: {
                intersect: false,
                mode: 'index'
            }
        }
    });
</script>
</body>
</html>