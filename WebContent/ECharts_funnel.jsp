<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   <jsp:useBean id="qwer" class="joyou.StringTok" scope="page"/>

   
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>funnel</title>
    <!-- 引入 echarts.js -->
   <script src="js/echarts.min.js"></script>
</head>
<body>

<!--  
<div>${qwer.footff[0]}</div>
<div>${qwer.footff[1]}</div>
<div>${qwer.footff[2]}</div>
<div>${qwer.footff[3]}</div>


<div>================================</div>
-->
    <!-- 为ECharts准备一个具备大小（宽高）的Dom -->
    <div id="main" style="width: 800px;height:600px;"></div>
    <script type="text/javascript">
        // 基于准备好的dom，初始化echarts实例
        var myChart = echarts.init(document.getElementById('main'));
        // 指定图表的配置项和数据
      option = {
    title: {
        text: '轉換漏斗',
        subtext: ''
    },
    tooltip: {
        trigger: 'item',
        formatter: "{a} <br/>{b} : {c}%"
    },
    toolbox: {
        feature: {
            dataView: {readOnly: false},
            
            saveAsImage: {}
        }
    },
    legend: {
        data: ['進入首頁','註冊','瀏覽商品頁面','放入購物車','完成交易']
    },
    series: [
        {
            name: '預期',
            type: 'funnel',
            left: '10%',
            width: '80%',
            label: {
                formatter: '{b}(預期)'
            },
            labelLine: {
                show: false
            },
            itemStyle: {
                opacity: 0.7
            },
            emphasis: {
                label: {
                    position: 'inside',
                    formatter: '{b}預期: {c}%'
                }
            },
            data: [
                {value: 100, name: '進入首頁'},
                {value: 80, name: '註冊'},
                {value: 60, name: '瀏覽商品頁面'},
                {value: 40, name: '放入購物車'},
                {value: 20, name: '完成交易'}
            ]
        },
        {
            name: '實際',
            type: 'funnel',
            left: '10%',
            width: '80%',
            maxSize: '80%',
            label: {
                position: 'inside',
                formatter: '{c}%',
                color: '#fff'
            },
            itemStyle: {
                opacity: 0.5,
                borderColor: '#fff',
                borderWidth: 2
            },
            emphasis: {
                label: {
                    position: 'inside',
                    formatter: '{b}實際: {c}%'
                }
            },
            data: [
                {value: ${qwer.footff[0]}, name: '進入首頁'},
                {value: ${qwer.footff[1]}, name: '註冊'},
                {value: ${qwer.footff[5]}, name: '瀏覽商品頁面'},
                {value: ${qwer.footff[7]} , name: '放入購物車'},
                {value: ${qwer.footff[8]} , name: '完成交易'},
            ]
        }
    ]
};


        // 使用刚指定的配置项和数据显示图表。
        myChart.setOption(option);
    </script>
</body>
</html>