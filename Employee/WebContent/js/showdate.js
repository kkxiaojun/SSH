
var MonthDNum=new Array(0,31,28,31,30,31,30,31,31,30,31,30,31);
var MonthText=new Array("","一月","二月","三月","四月","五月","六月","七月","八月","九月","十月","十一月","十二月");
var Calendar_obj,Calendar_obj2;
// var WriteHead=1;
document.write('<iframe style="position:absolute;width:206px;display:none;z-index:1000;" name="divCalendar" id="divCalendar" frameborder="0" scrolling="no"></iframe>')
/* 头部信息CSS及JS函数 */
var HeadMsg='<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">'+
'<html xmlns="http://www.w3.org/1999/xhtml">'+
'<meta http-equiv="Content-Type" content="text/html; charset=utf-8"><style type="text/css"><!--'+
'body,html{margin:0px;height:100%;background:#FFF;}a,li,input {font-family:"Verdana","Arial";font-size:12px;}'+
'a {height:18px;color:#000;padding-top:2px;text-decoration:none;display:block;}'+
'a:hover{height:17px;padding-top:1px;border:1px solid #000;background:#FFF;}'+
'.CurrentDate {height:17px;padding-top:1px;border:1px solid #000;background: #FFF;}'+
'ul{list-style:none;margin:0px;padding:0px;overflow:hidden;}'+
'ul li{float:left;margin-left:1px;padding-top:1px;display:inline;text-align:center;width:28px;height:20px;}'+
'#Tools {width:204px;background:#44b6ae;padding:0px;}'+
'#Tools li{padding-bottom:1px;}'+
'#Tools a{color:#FFF;}'+
'#Tools a:hover{border:1px solid #09fae9;background:#15f9e9;}'+
'#Title {width:204px;background:#56da9e;border-bottom:1px solid #000;}'+
'#Title li{height:16px;padding-top:3px;}'+
'#sYear,#sMonth {width:44px;height:16px;border:1px solid #88A9C9;border-right:0;padding-top:2px;}'+
'#SArr {width:19px;height:18px;background:#E2EBF4;font-size:10px;text-align:center;color:#44b6ae;border:1px solid #88A9C9;border-left:0;margin-right:3px;cursor:pointer;}'+
'#Select {width:63px;border:1px solid #8AC;background:#FFF;height:146px;}'+
'#Select a{height:16px;padding-left:3px;}'+
'#Select a:hover{color:#000;background:#E2EBF4;padding-top:2px;border:0;}'+
'#Select #SelectBn {background:#0defdf;font-size:8px;line-height:7px;height:7px;text-align:center;color:#44b6ae;}'+
'#Select #SelectBn:hover{background:#7682C1;color:#FFF;}#SArr,#sYear,#sMonth{float:left;}'+
'#SelectYear,#SelectMonth{position:absolute;top:21px;z-index:1;overflow:hidden;display:none;}'+
'--></style><scr'+
'ipt language="JavaScript">var mdown,sy,ey,sm,em,HideSelect=1,CurrentSelect,year,month,day;function Scroll(str,key)'+
'{var Html="",s,e,obj,d;'+
'if(key=="Y"){s=sy;e=ey;obj="SelectYearItem";d="年";}if(key=="M"){s=sm;e=em;obj="SelectMonthItem";d="";}'+
'if(str=="Up"){s--;e--;}if(str=="Next"){s++;e++;}'+
'if(key=="Y"){sy=s;ey=e;}if(key=="M"){if(s<1)s=1;if(s>6)s=6;if(e<7)e=7;if(e>12)e=12;sm=s;em=e;}'+
'for(i=s;i<=e;i++){Html+=\'<a href="javascript:;" onclick="parent.Calendar_Modif(\';Html+=(key=="M")?year+\',\'+i+\',\'+day+\');">\'+parent.MonthText[i]:i+\',\'+month+\',\'+day+\');">\'+i;Html+=d+"</a>";}'+
'document.getElementById(obj).innerHTML=Html;}'+
'function KeyDown(str){if(str==38){Scroll("Up",CurrentSelect);}if(str==40){Scroll("Next",CurrentSelect);}}'+
'function ShowSelect(str,str2){HideSelect=0;HSelect();Scroll(\'\',str2);document.getElementById(str).style.display="block";CurrentSelect=str2}'+
'function HSelect(){document.getElementById("SelectYear").style.display="none";document.getElementById("SelectMonth").style.display="none";}'+
'function Calendar_GetDate(y,m,d)'+
'{var objEvent=window.event||arguments.callee.caller.arguments[0];'+
'var srcElement=objEvent.srcElement;'+
'if(!srcElement){srcElement=objEvent.target;}'+
'if(srcElement.tagName=="A"){parent.Calendar_GetDate(y,m,srcElement.innerHTML);}}'+
'document.onclick=function(){if(HideSelect){HSelect();}HideSelect=1;}</scr'+
'ipt><body onkeydown="KeyDown(event.keyCode);">'+
'<div id="SelectYear" style="left:31px;" onclick="ShowSelect(\'SelectYear\',\'Y\');"><div id="Select"><a href="javascript:;" onmousedown="mdown=window.setInterval(\'Scroll(\\\'Up\\\',\\\'Y\\\')\',50);" onmouseup="window.clearInterval(mdown);" onmouseout="window.clearInterval(mdown);" id="SelectBn" style="border-bottom:1px solid #44b6ae;"><font face="Webdings">&#53;</font></a><div id="SelectYearItem">'+
'</div><a href="javascript:;" onmousedown="mdown=window.setInterval(\'Scroll(\\\'Next\\\',\\\'Y\\\')\',50);" onmouseup="window.clearInterval(mdown);" onmouseout="window.clearInterval(mdown);" id="SelectBn" style="border-top:1px solid #44b6ae;"><font face="Webdings">&#54;</font></a></div></div>'+
'<div id="SelectMonth" style="left:99px;" onclick="ShowSelect(\'SelectMonth\',\'M\');"><div id="Select"><a href="javascript:;" onmousedown="mdown=window.setInterval(\'Scroll(\\\'Up\\\',\\\'M\\\')\',50);" onmouseup="window.clearInterval(mdown);" onmouseout="window.clearInterval(mdown);" id="SelectBn" style="border-bottom:1px solid #44b6ae;"><font face="Webdings">&#53;</font></a><div id="SelectMonthItem">'+
'</div><a href="javascript:;" onmousedown="mdown=window.setInterval(\'Scroll(\\\'Next\\\',\\\'M\\\')\',50);" onmouseup="window.clearInterval(mdown);" onmouseout="window.clearInterval(mdown);" id="SelectBn" style="border-top:1px solid #44b6ae;"><font face="Webdings">&#54;</font></a></div></div>';
function Calendar_Show(year,month,day)
	{
	var content;
	var date=new Date();
	var DayNum=(IsLeapYear(year)&&month==2)?MonthDNum[month]+1:MonthDNum[month];
	var date2=new Date(year,month-1,1)
	var start=date2.getDay();
	var date2=null;
	var Trn=Math.ceil((DayNum+start)/7);
	var PrNum=1;
	content='<scr'+
	'ipt language="JavaScript">year='+year+',month='+month+',day='+day+',sy=year-3;ey=year+3;'+
	'sm=(month-3<1)?1:(+month-3>6)?6:month-3;'+
	'em=(month+3<7)?7:(month+3>12)?12:month+3;</scr'+
	'ipt><div style="border:1px solid #6A84C8;height:'+(64+21*Trn)+'px;"><ul><li style="background:#FFF;"></li>'+
	'<li style="width:144px;background:#FFF;padding-bottom:1px;" id="SelectArea"><div id="sYear" onclick="ShowSelect(\'SelectYear\',\'Y\');">'+year+'年</div><div id="SArr" onclick="ShowSelect(\'SelectYear\',\'Y\');"><font face="Webdings">&#54;</font></div>'+
	'<div id="sMonth" onclick="ShowSelect(\'SelectMonth\',\'M\');">'+MonthText[month]+'</div><div id="SArr" onclick="ShowSelect(\'SelectMonth\',\'M\');"><font face="Webdings">&#54;</font></div>';
	content+='</li>'+
	'<li><a href="javascript:parent.Calendar_hide();">×</a></li></ul>'+
	'<div id="Tools"><ul>'+
	'<li><a href="javascript:parent.Calendar_Modif('+(year-1)+','+month+','+day+');">&laquo;</a></li>'+
	'<li><a href="javascript:parent.Calendar_Modif('+year+','+(month-1)+','+day+')";>&#8249;</a></li>';
	if(Calendar_obj2){content+='<li style="width:42px;"><a href="javascript:parent.Calendar_GetDate('+year+','+month+',0);">本月</a></li>'+
	'<li style="width:43px;"><a href="javascript:parent.Calendar_GetDate('+date.getFullYear()+','+(date.getMonth()+1)+','+date.getDate()+');">本日</a></li>';}
	else{content+='<li style="width:86px;"><a href="javascript:parent.Calendar_GetDate('+date.getFullYear()+','+(date.getMonth()+1)+','+date.getDate()+');">选择本日</a></li>';}
	content+='<li><a href="javascript:parent.Calendar_Modif('+year+','+(month+1)+','+day+');">&#8250;</a></li>'+
	'<li><a href="javascript:parent.Calendar_Modif('+(year+1)+','+month+','+day+');">&raquo;</a></li>'+
	'</ul></div>'+
	'<div id="Title"><ul><li style="color:#F00;">日</li><li>一</li><li>二</li><li>三</li><li>四</li><li>五</li><li style="color:#F00;">六</li></ul></div>'+
	'<ul onClick="javascript:Calendar_GetDate('+year+','+month+',-1);">';
	var date=null;
	if(start>0){content+='<li style="width:'+(start*29-1)+'px;"></li>';}
	for(i=1;i<=DayNum;i++)
	{
	content+='<li><a href="#"'
	content+=(day==PrNum)?' class="CurrentDate"':'';
	content+=((i+start)%7<2)?' style="color:#F00;"':'';
	content+='>'+PrNum+'</a></li>';
	PrNum++;
	}
	content+='</ul></div>';
	// 层定位
	var Calendar=document.getElementById('divCalendar');
	Calendar.style.height=66+21*Trn+'px';		// 框架高度
	divCalendar.document.open()
	divCalendar.document.write(HeadMsg+content);
	divCalendar.document.close()
	var p=Calendar_obj;
	var eT=0,eL=0,eH=0,dH=0,sT=0,eP=p
	while(p&&p.tagName!="BODY"){
	eT+=p.offsetTop;		// 距窗口顶部距离
	eL+=p.offsetLeft;		// 距窗口左边距离
	p=p.offsetParent;}
	var eH=eP.offsetHeight;				// 输入框高度
	var eW=eP.offsetWidth;				// 输入框宽度
	var dH=Calendar.style.pixelHeight;	// 框架高度
	Calendar.style.top=(eT+dH>document.body.scrollHeight&&eT-dH>=0)?eT-dH+'px':eT+eH+'px';
	Calendar.style.left=(eL+206>document.body.scrollWidth&&eL-206+eW>=0)?eL-206+eW+'px':eL+'px';
	setTimeout("document.getElementById('divCalendar').style.display=''",1);
	}
/* 是否润年 */
function IsLeapYear(y){
	if(0==y%4&&((y%100!=0)||(y%400==0))){return true;}
	else{return false;}
	}
function Calendar_Modif(y,m,d)
	{
	if(m<1){m=12;y=y-1;}
	if(m>12){m=1;y=y+1;}
	var num=(IsLeapYear(y)&&m==2)?MonthDNum[m]+1:MonthDNum[m];
	if(d>num){d=num;}
	Calendar_Show(y,m,d)
	}
function Calendar(obj,obj2)
	{
	var p=Calendar_obj=document.getElementById(obj);
	Calendar_obj2=document.getElementById(obj2);
	var re=/\d{4}-\d{1,2}-\d{1,2}/;
	var arr,Sdate;
	arr=re.exec(Calendar_obj.value);
	if(arr!=null){Sdate=Calendar_obj.value;}
	else{var mydate=new Date();
	Sdate=mydate.getFullYear()+'-'+(mydate.getMonth()+1)+'-'+mydate.getDate();}
	Sdate=Sdate.split("-");
	Calendar_Show(parseInt(Sdate[0]),parseInt(Sdate[1]),parseInt(Sdate[2]));
	}
function Calendar_GetDate(y,m,d)
	{
	if(!Calendar_obj2||d!=0){
	if(d>0){Calendar_obj.value=y+'-'+m+'-'+d;}
	else{
	var objEvent=divCalendar.event||arguments.callee.caller.arguments[0];
	var srcElement=objEvent.srcElement;
	if(!srcElement){srcElement=objEvent.target;}
	Calendar_obj.value=y+'-'+m+'-'+srcElement.innerHTML;
	}
	}
	else{
	if(IsLeapYear(y)&&m==2){num=MonthDNum[m]+1;}
	else{num=MonthDNum[m];}
	Calendar_obj.value=y+'-'+m+'-1';
	Calendar_obj2.value=y+'-'+m+'-'+num;
	}
	Calendar_hide();}
function Calendar_hide()
	{document.getElementById("divCalendar").style.display="none";}
	document.onclick=Calendar_hide;