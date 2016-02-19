 <%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
 
 <style>
 table td{padding:10px}
 </style>
 
 <script>

$(document).ready(function () {
	
	com.calendar("startDt");
	com.calendar("endDt");
	
	 $("#dateCheck").mask("0000-00-00", {placeholder: "____-__-__"});
	 $("#number").mask("0000000000");
	 $('#money').mask("#,##0,000", {reverse: true});
});


function openWin(){
	com.popup({
		url :"",
		title : "가운데",
		width : 600,
		height : 400
	})
}


function openWin2(){
	com.popup({
		url :"",
		title : "삑딱하게",
		width : 600,
		height : 400,
		left : 100,
		top : -100
	})
}

 </script>
 
 
 <div class="row" >

<div id="print">

	 <div class="col-lg-12">
	     <h3 class="page-header">UI</h3>
	 </div>
	 
	 
     <h5 class="page-header"><span class="glyphicon glyphicon-th-large"></span> 캘린더</h5>
	<div class="input-group date" id="startDt" style="width:150px;float: left">
  		<input type="text" class="form-control"><span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
	</div>
	<div class="input-group date" id="endDt" style="width:150px;">
  		<input type="text" class="form-control"><span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
	</div>
	
	
	<h5 class="page-header"><span class="glyphicon glyphicon-th-large"></span> 윈도우 팝업</h5>
	<button type="button" class="btn btn-default" onClick="openWin()">가운데</button>
	<button type="button" class="btn btn-default" onClick="openWin2()">삑딱하게</button>
	
	<h5 class="page-header"><span class="glyphicon glyphicon-th-large"></span> 레이어 팝업</h5>
	<button type="button" class="btn btn-default">일반</button>
	<button type="button" class="btn btn-default">Iframe</button>
	
	
	<h5 class="page-header"><span class="glyphicon glyphicon-th-large"></span> 화면프린트</h5>
	<button type="button" class="btn btn-default" onClick="com.print()">인쇄</button>
	<button type="button" class="btn btn-default" onClick="document.location.href='/admin/ui/excel.do'">Excel</button>
	
	<h5 class="page-header"><span class="glyphicon glyphicon-th-large"></span> 폼체크 (jquery.mask : https://igorescobar.github.io/jQuery-Mask-Plugin/)</h5>
	
	<table style="width:400px">
	<colgroup>
		<col style="width:50%" />
		<col style="width:50%" />
	</colgroup>
	<tr>
		<td>
		  <div class="form-group">
		    <label for="date">Date</label>
		    <input type="text" class="form-control" id="dateCheck" >
		  </div>
		 </td>
		<td>
		 <div class="form-group">
		    <label for="number">Number</label>
		    <input type="text" class="form-control" id="number" >
		  </div>
		</td>
	</tr>
	<tr>
		<td>
		  <div class="form-group">
		    <label for="date">Money</label>
		    <input type="text" class="form-control" id="money">
		  </div>
		 </td>
		<td>
		 
		</td>
	</tr>
	</table>
	
</div>	

</div>