# 笔记

## 11月9号登录注册接口
    一、http://localhost/logins  (这是登录接口post请求,后面没东西了，不用跟参数)
    1、传一个body，包含username和password
    2、不用前端判断输入的值是否为空，后端判断好了
    3、在文本框或者密码框定理里面的文字初始值是“”，就两个符号，里面啥都没有
    4、然后就没有然后了，哦对了，一旦调用我的接口，一定要把我的msg反馈到页面
    5、后端返回一个flag与msg。如果登录成功，则flag=true，msg内容就是登录成功；
       如果登录失败，这分很多种原因。
       不同原因我都会以msg显示出来，但是flag一定是false

    二、http://localhost/enroll  (这是注册接口，post请求)
    1、跟上面一样
    

