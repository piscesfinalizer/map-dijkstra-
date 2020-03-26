<%--
  Created by IntelliJ IDEA.
  User: 10530
  Date: 2020/3/25
  Time: 10:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta name="viewport" content="initial-scale=1.0, user-scalable=no" />
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <title>山东大学(威海)校园导航系统</title>
  <style type="text/css">
    html{height:100%}
    body{height:100%;margin:0px;padding:0px}
    #container{
      height:80%;
      width: 80%;
      float: left;
    }
    #top{height: 30%;}
    #mid{height:30%;}
    #bottom{height:20%}
    #box{
      height: 80%;
      width: 20%;
      float: left;
    }
    #body{
      background-color: #c9e8ff;
    }

  </style>
  <script type="text/javascript" src="https://api.map.baidu.com/api?v=1.0&type=webgl&ak=Y0UYcnjeW09tMQOPGAlkgM6P5aXfTnFv" >
  </script>
</head>

<body id="body" >
<div style="height: 20%" >
  <h1 align="center">山东大学（威海）校园导航</h1>
  <h3 align="center">作者:&nbsp;18计算机&nbsp;方禧</h3>

</div>
<div id="container"></div>
<div id="box" align="center">
  <div id="top">
    <form id = "path" action="./Servlet">
      <input type="text" name="sourse" placeholder="出发地点" list="places" autofocus required>
      <datalist id="places" style="display: none">
        <option value="图书馆"></option>
        <option value="商学院"></option>
        <option value="海洋学院"></option>
        <option value="南门"></option>
        <option value="泰园餐厅"></option>
        <option value="体育馆"></option>
        <option value="西南门"></option>
        <option value="北门"></option>
        <option value="西门"></option>
        <option value="东门"></option>
        <option value="科学实验楼"></option>
        <option value="空间物理学院"></option>
        <option value="风雨操场"></option>
        <option value="知行楼"></option>
      </datalist>

    </form>
  </div>
  <div id="mid" align="center">
    <input type="text" form="path" name="destination" placeholder="目的地点" list="places" required>
  </div>
  <div id="bottom" align="center">
    <input type="submit" form="path" formmethod="post" value="开始导航" formtarget="_self" >
  </div>
</div>
<script type="text/javascript">
  var map = new BMapGL.Map("container");
  // 创建地图实例
  var point = new BMapGL.Point(122.066616,37.536707);
  // 创建点坐标

  var polyline1 = new BMapGL.Polyline([
    new BMapGL.Point(122.06709,37.532649),
    new BMapGL.Point(122.067451,37.534845),
    new BMapGL.Point(122.067514,37.535775),
    new BMapGL.Point(122.066683,37.53808),
    new BMapGL.Point(122.064054,37.539411),
    new BMapGL.Point(122.061801,37.535873),
    new BMapGL.Point(122.062618,37.533663),
    new BMapGL.Point(122.06709,37.532649)
  ], {strokeColor:"blue", strokeWeight:2, strokeOpacity:0.5});
  map.addOverlay(polyline1);

  var polyline2 = new BMapGL.Polyline([
    new BMapGL.Point(122.067451,37.534845),
    new BMapGL.Point(122.068947,37.534092),
  ], {strokeColor:"blue", strokeWeight:2, strokeOpacity:0.5});
  map.addOverlay(polyline2);

  var polyline3 = new BMapGL.Polyline([
    new BMapGL.Point(122.071608,37.536382),
    new BMapGL.Point(122.067545,37.535794),
    new BMapGL.Point(122.068893,37.537118),
    new BMapGL.Point(122.069701,37.539042),
    new BMapGL.Point(122.069927,37.54089)

  ], {strokeColor:"blue", strokeWeight:2, strokeOpacity:0.5});
  map.addOverlay(polyline3);

  var polyline4 = new BMapGL.Polyline([
    new BMapGL.Point(122.068884,37.537082),
    new BMapGL.Point(122.067186,37.537168),
    new BMapGL.Point(122.066674,37.538084)
  ], {strokeColor:"blue", strokeWeight:2, strokeOpacity:0.5});
  map.addOverlay(polyline4);

  var polyline5 = new BMapGL.Polyline([
    new BMapGL.Point(122.063063,37.540924),
    new BMapGL.Point(122.064054,37.539411),
    new BMapGL.Point(122.059846,37.539022),
    new BMapGL.Point(122.061787,37.53588),

  ], {strokeColor:"blue", strokeWeight:2, strokeOpacity:0.5});
  map.addOverlay(polyline5);

  map.centerAndZoom(point, 17);
  // 初始化地图，设置中心点坐标和地图级别
  map.enableScrollWheelZoom(true);     //开启鼠标滚轮缩放

</script>
</body>
</html>

