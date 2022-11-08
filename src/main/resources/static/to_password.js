var img = document.getElementById("eyes");
var pwd = document.getElementById("password");

var flag = 0;
img.onclick = function () {
  
  if (flag == 0) {
    img.src = "./image/睁眼.png";
    pwd.type = "text";
    flag = 1;
  } else {
    img.src = "./image/闭眼.png";
    pwd.type = "password";
    flag = 0;
  }
};
