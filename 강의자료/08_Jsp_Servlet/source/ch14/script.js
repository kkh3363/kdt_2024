function inputCheck(){
	if(document.regFrm.id.value==""){
		alert("아이디를 입력해 주세요.");
		document.regFrm.id.focus();
		return;
	}
	if(document.regFrm.pwd.value==""){
		alert("비밀번호를 입력해 주세요.");
		document.regFrm.pwd.focus();
		return;
	}
	if(document.regFrm.repwd.value==""){
		alert("비밀번호를 확인해 주세요");
		document.regFrm.repwd.focus();
		return;
	}
	if(document.regFrm.pwd.value != document.regFrm.repwd.value){
		alert("비밀번호가 일치하지 않습니다.");
		document.regFrm.repwd.value="";
		document.regFrm.repwd.focus();
		return;
	}
	if(document.regFrm.name.value==""){
		alert("이름을 입력해 주세요.");
		document.regFrm.name.focus();
		return;
	}
	if(document.regFrm.birthday.value==""){
		alert("생년월일을 입력해 주세요.");
		document.regFrm.birthday.focus();
		return;
	}
	if(document.regFrm.email.value==""){
		alert("이메일을 입력해 주세요.");
		document.regFrm.email.focus();
		return;
	}
    var str=document.regFrm.email.value;	   
    var atPos = str.indexOf('@');
    var atLastPos = str.lastIndexOf('@');
    var dotPos = str.indexOf('.'); 
    var spacePos = str.indexOf(' ');
    var commaPos = str.indexOf(',');
    var eMailSize = str.length;
    if (atPos > 1 && atPos == atLastPos && 
	   dotPos > 3 && spacePos == -1 && commaPos == -1 
	   && atPos + 1 < dotPos && dotPos + 1 < eMailSize);
    else {
          alert('E-mail주소 형식이 잘못되었습니다.\n\r다시 입력해 주세요!');
	      document.regFrm.email.focus();
		  return;
    }
    if(document.regFrm.zipcode.value==""){
		alert("우편번호를 검색해 주세요.");
		return;
	}
	if(document.regFrm.job.value=="0"){
		alert("직업을 선택해 주세요.");
		document.regFrm.job.focus();
		return;
	}
	document.regFrm.submit();
}

function win_close(){
	self.close();
}