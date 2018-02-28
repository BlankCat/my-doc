##单页面应用
* webpack配置，单应用，通过配置信息应用信息，统一把信息渲染到index.html模板

##  RxJS
* [使用 RxJS 实现 JavaScript 的 Reactive 编程](http://www.oschina.net/translate/rxjs-streams)
* RxJS `观察者模式 ` 和 `函数式编程 ` 的相结合的最佳实践
* 任何应用最重要的一个目标之一就是在所有`时刻保持响应`。

## 应用AJAX请求过程
* 处理用户输入 或 凭借AJAX 从服务器接受一些额外的数据时停止
    * 服务端：IO（输入/输出）运行（从磁盘或者网络读取）比CPU执行指令慢太多
    * 客户端: 在JavaScript中,充分利用`浏览器的多重连接`,用`回调函数`来产生一个独立的用来照顾一些长期运行的处理
       这是一种`反转控制`形式
       
##知识扩展
* cpu指令比io运行网络读取速度快的多
* 后端异步调用，响应式。例如node

##  RxJS 特性
* 理解流（ Streams）
    * 联系redux的快照数据
    * 观察流Stream式数据的变化情况
    * 流是一种无状态的数据结构
* 可观察数据类型
    * RxJS库包装一个数据片段（按钮事件，键盘事件，鼠标事件，数字，字符串或者队列）就有了流式数据类型的优点；
    * 流变量是不可变的数据类型
    * 流是一个时间节点上的数据（流只是一个在时间轴上的事件传输序列）
* 创建可观察序列对象方法
    * of()
    * from()
    * fromPromise()
    * fromEvent()
* 流式编程的另一个`不同点触发机制`.
    * 可观察序列类型对象是后触发的(lazy data types),订阅者订阅的时候什么也不执行,订阅机制是被观察者(Observer)触发的
* 观察者（Observer）
    * 观察者==`模型的消费者`， (负责对`被可观察序列对象`发送过来的值进行处理和反馈)
    * 观察者的API简单，基于`迭代者模式`,定义了next方法。事件执行结果推向到可观察对象的时候，这个方法next就会被调用；
    * 观察者也定义了`处理异常的API`,异常发出信号通知，所有的观察者对象里的方法都是可选择的，订阅一下就可以(调用subscribe方法)
        * subscribe订阅通知
        
```javascript
const observer = Rx.Observer.create(
    function next(val) {  
        console.log(val);
	处理业务逻辑
    },
    function error(err) { 
        ; // 事件异常情况执行
    },

    function complete() {
        ; // 事件完成后执行
    }
);

```

* 订阅
    * 订阅一个Observable对象就会返回一个订阅对象observer
    * unsubscribe方法释放掉对象流，（清理和释放事件和句柄（指针）对象资源）
    
* 流式序列化    
    * rxJS框架的核心思想供一个统一的数据处理的编程模型，不考虑数据类型
    * map(fn)  重新构建observable序列对象为新的形式
    * filter(predicate)	通过给定的predicate函数，过滤掉匹配的observable序列对象
    * reduce(accumulator, [seed]) 通过`收集器函数accumulator`返回一个单一结果。seed是收集器的初始化数据
    
* 处理时间
    * RxJS 如何有效处理时间以及通过基于时间的延迟可以做运算符
    * Rx.Observable.interval(period)   在每一个时期返回一个可观测序列产生值
    * Rx.Observable.timer(dueTime)     在dueTime运行后产生一个值,然后在每一个时期返回一个可观测序列
    
* 处理用户输入,用户事件
    * Observable对象与DOM事件进行交互
    * Rx.Observable.fromEvent
    
* 处理异步调用
    * RxJS框架也优雅地整合了ES6 Promise API
    * 假如要从Github上获取用户并且提取用户名。RxJS框架的强大，让我们处理这些逻辑只用5行代码就够了
    
* Map与FlatMap对比
    * Map映射方法
    Observable对象的map方法是对`自身对象的数据值`进行映射处理，`返回`是一个包含映射结果的`新Observale对象`。调用的方法能返回任意类型对象，甚至另外的Observable类型对象。
    * FlatMap
    映射方法把Observalbe对象里数据结果进行映射产生一个新Observable对象。(在函数式编程里这种方式很普遍)我们要做的就是处理映射关系并把结果存放到一个Observalbe对象里，这有点像给洋葱剥皮。这正是flatMap方法的优点。上面的方法返回结果是Rx.Observable.fromPromise(...),所以需要处理promise对象。从一般经验来看，当你从其他类型对象中构建Observalbe对象时，需要使用flatMap方法。
* 释放可观察序列
    * RxJS框架的好处之一是`对JavaScript事件进行了统一抽象`，这样可以更好的释放和销毁事件。
    * ubscription.unsubcribe()
* 合并流,合并多个流
    * merge方法负责执行合并操作，合成多个Observalble序列变成一个Observalble对象；
    * 另一种流的合并方式是可以通过concat()和concatAll()方法进行。
    * merge()
    * concat()
    * concatAll()
    
* 缓存
  * 流是一种无状态的数据结构，这就意味着其状态从未滞留其中而是立即从生产者流向消费者
  * 它能够临时存储一些数据;
  
* 缓冲一段时间
  暂时保存一定数量的数据到内部数组,一旦满足条件，它将作为一个整体得到释放
  
* 错误处理
    * observer.onError(error)
    * onErrorResumeNext
    
* 捕捉异常（Catch ）
    * 操作符 operator
    * catch 且 throw  错误
    
* 重试
  在可监控的范围内，你可以重试上一行操作确定的次数，之前的失败将会被解除。
   
   
   
##Angular工程总结
```javascript
 import { NgModule }      from '@angular/core';
 import { BrowserModule } from '@angular/platform-browser';
 import { AppComponent }  from './app.component';
 
 @NgModule({
   imports:      [ BrowserModule ],
   declarations: [ AppComponent ],
   bootstrap:    [ AppComponent ]
 })
 export class AppModule { }
 
```
* @NgModule
    * @NgModule装饰器修饰的类。
    * @NgModule装饰器将AppModule标记为Angular模块类，
    * @NgModule接受一个元数据对象，告诉Angular如何编译和启动应用
* import数组： BrowseModule，每个在浏览器运行应用都需要他。
    * Angular模块把`特性合并成` `离散单元`的一种方式
    * Angular自身许多特性也是通过Angular模块组织的(`HTTP服务在HTTPModule里` `路由器在RouterModule中` )
    * 你需要模块的特性时，将其添加到imports数组中
    * 不要将Angular模块的`imports数组`与`文件顶部的import语句`混淆
        * `imports数组` :告诉Angular特定Angular模块的信息
        * `文件顶部的import语句`:访问其他文件
* declarations数组： 应用唯一组件 
    * 每个组件必须在且在一个NgModule类中声明，通过将其将其列到AppModule模块的declaration数组中，`告诉Angular哪个组件属于AppModule`。
    * boostrap数组：根组件，Angular创建他并插入index.html 
    * 引导根AppModule来`启动应用`，在启动过程中，其中一部是创建列在列在bootstrap数组的组件，并将他们每一个都插入浏览器DOM中。 
      每个`被引导的组件`都是`自己组件树的根`，`插入一个被引导的组件`通常`触发一系列组件的创建`并形成`组件树`
      
* 四、在main.ts中引导

```javascript
import { platformBrowserDynamic } from '@angular/platform-browser-dynamic';
import { AppModule }              from './app.module';

platformBrowserDynamic().bootstrapModule(AppModule);
```

上面的代码为动态（JiT）`编译器动态编译应用`编译创建浏览器平台，并`引导上面提到的AppModule`。 
引导过程中搭建运行环境，从模块中的`bootstrap数组中提到根AppComponent`，`创建该组件的实例`，并将其`插入到组件selector标示的元素标签`中。 
AppComponent选择器-在这里大部分例子是my-app，所以Angular在index.html中查找像这样的my-app的标签，然后在那里显示AppComponen

```
<1>package.json中主要引入‘@angular／router’模块
<2>webpack.config.js或者systemjs.config.js新引入的模块添加识别路径
<3>routing的配置信息，路由配置信息
   创建reuting文件export出去
   将路由引入AppModule中
	
<4>入口（App Component）
<router-outlet></router-outlet>
router-outlet是个指令，当你点击不同的router link，router-outlet标签就会切换相应不同的component啦。

创建组件
@Component({
		selector:'my-find',//文件标签的id
		templateUrl:'./find.template.html',
		styleUrls:['./find.style.css']
})
export class FindComponent {
	title = 'find...'
}
```

##指令链接
[Angular2 Directive ](http://blog.csdn.net/shenlei19911210/article/details/53218074)
  

  
  

    
    





