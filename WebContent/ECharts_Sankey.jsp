<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   <jsp:useBean id="qwer" class="joyou.StringTok" scope="page"/>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>sankey</title>
    <!-- 引入 echarts.js -->
   <script src="js/echarts.min.js"></script>
</head>
<body>
    <!-- 为ECharts准备一个具备大小（宽高）的Dom -->
    <div id="main" style="width: 600px;height:400px;"></div>
    <script type="text/javascript">
        // 基于准备好的dom，初始化echarts实例
        var myChart = echarts.init(document.getElementById('main'));
        // 指定图表的配置项和数据
      option = {  title: {
          text: '使用者足跡',
          
      },
    series: {
        type: 'sankey',
        layout: 'none',
        focusNodeAdjacency: 'allEdges',
        data: [{
            name: '0'
        },{
            name: 'a'
        }, {
            name: '1'
        }, {
            name: '2'
        }, {
            name: '3'
        }, {
            name: '4'
        }, {
            name: 'b'
        },{
            name: 'c'
        }],
        links: [{
            source: '0',
            target: 'a',
            value: 100
        },{
            source: 'a',
            target: '1',
            value: 50
        }, {
            source: 'a',
            target: '2',
            value: 10
        }, {
            source: 'a',
            target: '3',
            value: 10
        }, {
            source: 'a',
            target: '4',
            value: 30
        }, {
            source: '1',
            target: 'b',
            value: 30
        }, {
            source: '3',
            target: 'b',
            value: 8
        }, {
            source: '4',
            target: 'c',
            value: 20
        }]
    }
};

        // 使用刚指定的配置项和数据显示图表。
        myChart.setOption(option);
    </script>
</body>
</html>