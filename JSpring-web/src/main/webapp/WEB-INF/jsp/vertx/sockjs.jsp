 <%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
 
  <script src="/js/sockjs.min.js"></script>
  
  <script>
  var sock = new SockJS("http://localhost:8888/springvertx/vertx");
  sock.onopen = function(){
	  //alert("open");
  };
  sock.onmessage = function(e){
	 //alert("" + e.data)
	  $("#receive").append("<p>" + e.data + "</p>");
  };
  sock.onclose = function(){
	  alert("close")
  }
  
  function send(msg){
	  if(sock.readyState = SockJS.OPEN){
		  sock.send(msg)
	  }else{
		  alert("error")
	  }
  }
  
  </script>
 
 <div class="row">

	 <div class="col-lg-12">
	     <h3 class="page-header">Blank</h3>
	 </div>
	 
	 <div id="receive"></div>
	 <input type="button" value="가가가가" onClick="send('가가가가가가')">

	

</div>