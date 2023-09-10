# 在线考试管理系统

## 系统运行环境配置

Java版本：1.8

MySQL版本：MySQL8（也可以用MySQL5，这个看个人，但如果要使用MySQL5请记得在application.properites文件中更改驱动名称，更改为com.mysql.jdbc.Driver）

![image-20230910172645223](https://md-pictures-1320770511.cos.ap-guangzhou.myqcloud.com/image-20230910172645223.png)

Maven版本：Maven3.5或者Maven3.6（其他版本可能会出现版本不兼容的情况导致项目运行出错）

## 项目运行前的一些注意事项

1. 记得在application.properties文件中将数据库的用户名和密码更改为自己数据库的用户名和密码；
2. 先将sql文件夹中的examdb.sql文件在本地数据库运行完后再启动项目；
3. 请先确保项目所需要的依赖都加载完后再启动项目。

## 系统演示

后台登录界面（请求地址：http://localhost:9000，账号：admin，密码：123456）

![image-20230910163839881](https://md-pictures-1320770511.cos.ap-guangzhou.myqcloud.com/image-20230910163839881.png)

项目前台登录界面（请求地址：http://localhost:9000/front/login，账号：test01，密码：123456）

![image-20230910170653197](https://md-pictures-1320770511.cos.ap-guangzhou.myqcloud.com/image-20230910170653197.png)

前台部分页面展示：

![image-20230910170946218](https://md-pictures-1320770511.cos.ap-guangzhou.myqcloud.com/image-20230910170946218.png)

![image-20230910171031111](https://md-pictures-1320770511.cos.ap-guangzhou.myqcloud.com/image-20230910171031111.png)

![image-20230910171046579](https://md-pictures-1320770511.cos.ap-guangzhou.myqcloud.com/image-20230910171046579.png)

![image-20230910171108969](https://md-pictures-1320770511.cos.ap-guangzhou.myqcloud.com/image-20230910171108969.png)

后台部分页面展示：

![image-20230910165652952](https://md-pictures-1320770511.cos.ap-guangzhou.myqcloud.com/image-20230910165652952.png)

![image-20230910171129484](https://md-pictures-1320770511.cos.ap-guangzhou.myqcloud.com/image-20230910171129484.png)

![image-20230910171146994](https://md-pictures-1320770511.cos.ap-guangzhou.myqcloud.com/image-20230910171146994.png)

![image-20230910171202615](https://md-pictures-1320770511.cos.ap-guangzhou.myqcloud.com/image-20230910171202615.png)

![image-20230910171218365](https://md-pictures-1320770511.cos.ap-guangzhou.myqcloud.com/image-20230910171218365.png)

![image-20230910171233395](https://md-pictures-1320770511.cos.ap-guangzhou.myqcloud.com/image-20230910171233395.png)

![image-20230910171250526](https://md-pictures-1320770511.cos.ap-guangzhou.myqcloud.com/image-20230910171250526.png)

![image-20230910171310362](https://md-pictures-1320770511.cos.ap-guangzhou.myqcloud.com/image-20230910171310362.png)

![image-20230910171324485](https://md-pictures-1320770511.cos.ap-guangzhou.myqcloud.com/image-20230910171324485.png)
