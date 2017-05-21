// JavaScript Document


function login_validate() {
	if (document.loginForm.username.value == "") {
		alert("用户名不能为空");
		return false;
	}
	if (document.loginForm.password.value == "") {
		alert("密码不能为空");
		return false;
	}
	if (document.loginForm.randcode.value == "") {
		alert("验证码不能为空");
		return false;
	}
}
function emploe_validate() {
	
	var patn = /\.jpg$|\.bmp$|\.jpeg$|\.gif$|\.png$/i;
	var allowString ="jpg,jpeg,gif,png,bmp";

	if (document.emploeForm.name.value == "") {
		alert("输入不合法，员工姓名不能为空！");
		return false;
	}
	if (document.emploeForm.sex.value == "") {
		alert("输入不合法，员工性别不能为空！");
		return false;
	}
	if (document.emploeForm.birthday.value == "") {
		alert("输入不合法，员工生日不能为空！");
		return false;
	}
	if (document.emploeForm.flay.value == "") {
		alert("输入不合法，员工婚否不能为空！");
		return false;
	}
	if (document.emploeForm.xl.value == "") {
		alert("输入不合法，员工学历不能为空！");
		return false;
	}
	if (document.emploeForm.orgid.value == "") {
		alert("输入不合法，员工部门不能为空！");
		return false;
	}
	if (document.emploeForm.zwid.value == "") {
		alert("输入不合法，员工职位不能为空！");
		return false;
	}
	if (document.emploeForm.mobile.value == "") {
		alert("输入不合法，员工电话不能为空！");
		return false;
	}
	if (document.emploeForm.address.value == "") {
		alert("输入不合法，员工地址不能为空！");
		return false;
	}
	
	var photo = document.emploeForm.photo.value;
	if (photo != "") {
		if(!patn.test(photo)){
			 alert("图片格式不正确，只能上传以下图片格式："+allowString);
			 return false;
		}
	}
}