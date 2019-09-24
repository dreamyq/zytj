<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org"
      xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity3">
<head>
    <meta charset="utf-8">
    <title>ECharts</title>
    <script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
    <!-- 引入 echarts.js -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/echarts/4.3.0/echarts-en.common.min.js"></script>
</head>
<body>
<a href="javascript:history.go(-1)">返回上一步</a>
<!-- 为ECharts准备一个具备大小（宽高）的Dom -->
<div id="main" style="width: 100%;height:450px;"></div>
<script type="text/javascript">
    var xValue;
    // 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById('main'));
    var xData=[];
    var d = getQueryString("month");
    var nf = getQueryString("param");//得到地址栏的年份
    <#if minYear??>
        for(var i=${minYear};i<=${maxYear};i++){
            xData.push(i);
        }
    <#else>
        for(var i=1;i<=12;i++){
            xData.push(i);
        }
    </#if>
    if(d!=null){
        xData=[];
        var ry=[1,3,5,7,8,10,12];//闰月
        var ny=[4,6,9,11];//非闰月非二月
        //if(isInArray(ry,d)){
            for(var i = 1;i<=31;i++){
                xData.push(i);
            }
        // }
        // if(isInArray(ny,d)){
        //     for(var i = 1;i<=30;i++){
        //         xData.push(i);
        //     }
        // }
        // if(d==2){
        //     if((nf%100!=0&&nf%4==0)||(nf%100==0&&nf%400==0)){
        //         for(var i = 1;i<28;i++){
        //             xData.push(i);
        //         }
        //     }else {
        //         for(var i = 1;i<29;i++){
        //             xData.push(i);
        //         }
        //     }
        // }
    }
    xValue="年份";
    if(nf!=null){
        xValue="月份";
    }
    if(d!=null){
        xValue="天";
    }

    getYear();
    var option;
    function getYear() {
        // 指定图表的配置项和数据
        option = {
            backgroundColor: '#FFF0F5',

            title: {
                text: '资源使用统计',
                subtext: '统计图',
                x: 'center'
            },

            legend: {
                // orient 设置布局方式，默认水平布局，可选值：'horizontal'（水平） ¦ 'vertical'（垂直）
                orient: 'horizontal',
                // x 设置水平安放位置，默认全图居中，可选值：'center' ¦ 'left' ¦ 'right' ¦ {number}（x坐标，单位px）
                x: 'left',
                // y 设置垂直安放位置，默认全图顶端，可选值：'top' ¦ 'bottom' ¦ 'center' ¦ {number}（y坐标，单位px）
                y: 'top',
                data: ['预期','实际','假设']
            },

            //  图表距边框的距离,可选值：'百分比'¦ {number}（单位px）
            grid: {
                top: '16%',   // 等价于 y: '16%'
                left: '3%',
                right: '8%',
                bottom: '3%',
                containLabel: true
            },

            // 提示框
            tooltip: {
                trigger: 'axis'
            },

            //工具框，可以选择
            toolbox: {
                feature: {
                    saveAsImage: {} //下载工具
                }
            },

            xAxis: {
                name: xValue,
                type: 'category',
                axisLine: {
                    lineStyle: {
                        // 设置x轴颜色
                        color: '#912CEE'
                    }
                },
                // 设置X轴数据旋转倾斜
                axisLabel: {
                    rotate: 0, // 旋转角度
                    interval: 0  //设置X轴数据间隔几个显示一个，为0表示都显示
                },
                // boundaryGap值为false的时候，折线第一个点在y轴上
                boundaryGap: false,
                data: xData
            },

            yAxis: {
                name: '数值',
                type: 'value',
                min:0, // 设置y轴刻度的最小值
                max:2500,  // 设置y轴刻度的最大值
                splitNumber:9,  // 设置y轴刻度间隔个数
                axisLine: {
                    lineStyle: {
                        // 设置y轴颜色
                        color: '#87CEFA'
                    }
                },
            },
            series: [
                <#list rooms as room>
                {
                    name: '${room.name}',
                    data: [<#list yearData as year><#if room.id==year.readRoomID>
                        ${year.peopleNums},</#if></#list>],
                    type: 'line',
                    // 设置折线上圆点大小
                    symbolSize:8,
                    itemStyle:{
                        normal:{
                            // 拐点上显示数值
                            label : {
                                show: true
                            },
                            borderColor:'red',  // 拐点边框颜色
                            lineStyle:{
                                width:5,  // 设置线宽
                                type:'solid'  //'dotted'虚线 'solid'实线
                            }
                        }
                    }
                },

                </#list>

            ],

            color: ['#00EE00', '#FF9F7F','#FFD700','#FF1545','#319DFF']
        };
    }
    myChart.on('click', function (params) {
        // 控制台打印数据的名称

        if(params.name.length==4){
            console.log("hl");
            getMonth(params.name);
            location.href="/chart/page?param="+params.name;
        }else{
            location.href="/chart/page?param="+getQueryString("param")+"&month="+params.name;
        }
        console.log(params.name);
    });

    // 使用刚指定的配置项和数据显示图表。
    myChart.setOption(option);

    function getMonth(year) {
        console.log(year);
    }
    //地址：http://xxxxxx.com?a=1&b=2
    //获取浏览器参数a和b

    function getQueryString(name) {

        var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
        var r = window.location.search.substr(1).match(reg);
        if (r != null) return unescape(r[2]); return null;
    }
    function isInArray(arr,value){
        for(var i = 0; i < arr.length; i++){
            if(value === arr[i]){
                return true;
            }
        }
        return false;
    }


</script>
</body>
</html>