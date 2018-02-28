##java interface design
* 1 根据业务定义接口
* 2 根据设计图，看去哪张表里面查询，查询结果是个list，还是一个对象
* 3 通过什么条件，查询哪个表，需要什么样的json数据结构

## 步骤
* 业务推导出表
* 产品设计--业务推到出表
* 根据业务去设计接口
* 有的接口直接可以返回数据，有的需要拼装json

## 例子
```javascript
    构建消息类型，实体类
    DjTeacher
    TeacherInfo
    两个vo类，DjTeacher的字段多于TeacherInfo的字段
    查询DjTeacher，封装TeacherInfo来接收这个消息对象
```
