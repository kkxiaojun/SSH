	var xmlHttp;
    	function f_create(){
	    	try{
	    		xmlHttp = new XMLHttpRequest();
	    	}catch(e){
	    		try{
	    			xmlHttp = new ActiveXObject("Msxml2.XMLHTTP"); 
	    		}catch(e){
	    			try{
	    				xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
	    			}catch(e){
	    				alert("你的浏览器不支持Ajax");
	    				return;
	    			}
	    		}
	    	}
	    	xmlHttp.onreadystatechange = function (){
	    		if(xmlHttp.readyState == 4 && xmlHttp.status == 200){
	    			document.getElementById("i_code").innerHTML = xmlHttp.responseText;
	    		}
	    	}
	    }
	    function f_change(v){
	    	//使用这个对象打开对服务器的连接
	    	xmlHttp.open("get", "checkCode.jsp?code="+v , true);
	    	//对服务器发送请求
	    	xmlHttp.send(null);
		}
    	function f_put(){
    		document.getElementById("i_i").innerHTML = "<img src='Code'/>";
    		return false;
    	}
    	