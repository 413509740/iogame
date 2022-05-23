[![JDK 17](https://img.shields.io/badge/JDK-17-green.svg "JDK 17")]()

**过去、现在、将来都不会有商业版本，所有功能全部开源！**

**只做真的完全式开源，拒绝虚假开源，售卖商业版，不搞短暂维护！**

**承诺项目的维护周期是十年起步， 2022-03-01起，至少十年维护期！**

**提供高质量的使用文档！**

**如果您觉得还不错，帮忙给个 start 关注**

.

开源地址: [基于 sofa-bolt 的网络游戏框架-源码地址](https://gitee.com/iohao/iogame)

在线文档: [基于 sofa-bolt 的网络游戏框架-在线文档](https://www.yuque.com/iohao/game/wwvg7z)

> **推荐大家看在线文档，排版好一些，README 上看有点乱！**



## 愿景

**让网络游戏服务器的编程变得轻松简单！**



## 网络游戏框架简介

ioGame 是国内首个基于蚂蚁金服 [sofa-bolt](https://www.sofastack.tech/projects/sofa-bolt/overview/) 的网络游戏框架，游戏框架由 [**网络通信框架**] 和 [**业务框架]** 组成。

- **网络通信框架**：负责服务器之间的网络通信
- **业务框架**：负责业务逻辑的处理方式和编写方式



​	通过 ioGame 可以快速的搭建一个稳定的、**集群无中心节点、自带负载均衡**、高性能的、分步式的网络游戏服务器。

​	游戏框架借助于蚂蚁金服 [sofa-bolt](https://www.sofastack.tech/projects/sofa-bolt/overview/) 通信框架来提供稳定、高性能。

​	即使之前没有游戏编程的经验，也能参与到游戏编程中。如果你之前具备一些游戏开发或者 web MVC 相关的知识，则会更容易上手游戏服务器的开发。



>  源码内置了一个坦克射击游戏的示例，可直接运行。
>  坦克射击游戏是基于FXGL引擎（纯java的游戏引擎）开发的。
>  通过示例，可以快速的掌握网络游戏编程！
>
>  [游戏示例在线文档](https://www.yuque.com/iohao/game/gqossg)



### 网络通信框架 - SOFABolt

[SOFABolt](https://www.sofastack.tech/projects/sofa-bolt/overview/) 是蚂蚁金融服务集团开发的一套基于 Netty 实现的网络通信框架。

- 为了让 Java 程序员能将更多的精力放在基于网络通信的业务逻辑实现上，而不是过多的纠结于网络底层 NIO 的实现以及处理难以调试的网络问题，Netty 应运而生。
- 为了让中间件开发者能将更多的精力放在产品功能特性实现上，而不是重复地一遍遍制造通信框架的轮子，SOFABolt 应运而生。

Bolt 名字取自迪士尼动画-闪电狗，是一个**基于 Netty 最佳实践**的轻量、易用、高性能、易扩展的通信框架。



### 业务框架

​	如果说  [sofa-bolt](https://www.sofastack.tech/projects/sofa-bolt/overview/) 为了让 Java 程序员能**将更多的精力放在**基于网络通信的**业务逻辑实现上**。而业务框架正是**解决**业务逻辑**如何方便的实现**这一问题上。

业务框架是游戏框架的一部份，职责是简化程序员的业务逻辑实现。业务框架使程序员能够快速的开始编写游戏业务。



## 架构简图

![img](https://gitee.com/iohao/xmindpic/raw/master/game/ioGame.jpg)

<p align="center">
通过 ioGame 你可以很容易的搭建出一个集群、分步式的网络游戏服务器！
</p>


​    ioGame 是一个由 **java** 语言编写的**网络游戏服务器框架**。支持 websocket、tcp ，适用于回合制游戏、策略游戏、即时战斗游戏，等游戏服务器的开发。具有高性能、稳定、易用易扩展、超好编程体验等特点。可做为 H5（HTML5）、手游、端游的游戏服务器。

​	在 ioGame 中能让你遗忘 Netty，你几乎没有机会能直接的接触到 Netty 的**复杂**，但却能享受 Netty 带来的**高性能**。对开发者要求低，为开发者节约开发时间。

​	ioGame 可以很方便的与 spring 集成。**支持多服多进程的方式部署，也支持多服单进程的方式部署**。图中的每个**对外服**、每个**游戏逻辑服**、每个 **broker** （**游戏网关**）都可以在**单独的进程中部署**，逻辑服之间**可以跨进程**通信（对外服也是逻辑服的一种）。



**游戏网关集群**

​	broker （游戏网关）可以**集群**的方式部署，集群无中心节点、自带负载均衡。ioGame 本身就包含服务注册，你不需要外接一个服务注册中心，如 Eureka，ZooKeeper 等（变相的节约服务器成本）。

​	通过 broker （游戏网关） 的介入，之前非常复杂的负载均衡设计，如服务注册、健康度检查（后续版本提供）、到服务端的连接维护等这些问题，在 ioGame 中都不需要了，结构也简单了很多。

实际上单台 broker （游戏网关） 性能已经能够满足了，因为游戏网关只做了转发。



**逻辑服**

​	对外服和游戏逻辑服可以有很多个，逻辑服数量的理论上限是 netty 的连接上限。


参考：[构架简图中：对外服、游戏网关、游戏逻辑服各自的职责](https://www.yuque.com/iohao/game/dqf0he)





## 快速入门

### 业务交互

![img](https://gitee.com/iohao/xmindpic/raw/master/game/interaction.jpeg)

抽象的说，游戏前端与游戏服务器的的交互由上图组成。游戏前端与游戏服务器可以自由的双向交互，交互的业务数据由 .proto 作为载体。

### 协议文件

协议文件是对业务数据的描述载体，用于游戏前端与游戏服务的数据交互。Protocol Buffers (ProtocolBuffer/ protobuf )
是Google公司开发的一种数据描述语言。也简称 [PB](https://www.oschina.net/p/protocol+buffers)。当然协议文件描述还可以是
json、xml或者任意自定义的，因为最后传输时会转换为二进制。但游戏开发中 PB 是目前的最佳。

### 游戏前端

游戏前端可以是 [Unity](https://unity.cn/)、 [UE(虚幻)](https://www.unrealengine.com/zh-CN/)、 [Cocos](https://www.cocos.com/)或者其他的游戏引擎。游戏前端与用户的接触最为直接。

### 游戏服务器

游戏服务器处理实际的用户等其他的业务数据。

### 快速入门代码示例

这里主要介绍游戏服务器，毕竟是游戏服务器的框架。下面这个示例介绍了服务器编程可以变得如此简单。

#### Proto 协议文件定义

首先我们自定义一个协议文件，这个协议文件作为我们的业务载体描述。这个协议是纯java代码编写的，使用的是 jprotobuf, jprotobuf
是对 [google protobuf](https://www.oschina.net/p/protocol+buffers) 的简化使用，性能同等。

```java
/** 请求 */
@ProtobufClass
@FieldDefaults(level = AccessLevel.PUBLIC)
public class HelloReq {
    String name;
}
```

#### Action

游戏服务器的编程，游戏服务器接收业务数据后，对业务数据进行处理；

```java
@ActionController(1)
public class DemoAction {
    @ActionMethod(0)
    public HelloReq here(HelloReq helloReq) {
        HelloReq newHelloReq = new HelloReq();
        newHelloReq.name = helloReq.name + ", I'm here ";
        return newHelloReq;
    }
}
```

​	一个方法在业务框架中表示一个 Action（既一个业务动作）。

​	方法声名的参数是用于接收前端传入的业务数据，在方法 return 时，数据就可以被游戏前端接收到。程序员可以不需要关心业务框架的内部细节。

​	从上面的示例可以看出，**这和普通的 java 类并无区别**。如果只负责编写游戏业务，那么对于业务框架的**学习可以到此为止了**。

游戏编程就是如此简单！



问：我可以开始游戏服务器的编程了吗？

​	是的，你已经可以开始游戏服务器的编程了。



#### 访问示例（控制台）

当我们访问 here 方法时（通常由游戏前端来请求），控制台将会打印

```basic
┏━━━━━ Debug. [(DemoAction.java:4).here] ━━━ [cmd:1 - subCmd:0 - cmdMerge:65536]
┣ userId: 888
┣ 参数: helloReq : HelloReq(name=塔姆)
┣ 响应: HelloReq(name=塔姆, I'm here )
┣ 时间: 0 ms (业务方法总耗时)
┗━━━━━ Debug [DemoAction.java] ━━━
```

> Debug. [(DemoAction.java:4).here]：
> 表示执行业务的是 DemoAction 类下的 here 方法，4 表示业务方法所在的代码行数。在工具中点击控制台的 DemoAction.java:4 这条信息，就可以跳转到对应的代码中（快速导航到对应的代码）。
>
> userId :  
> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;当前发起请求的 用户 id。
>
> 参数 :  
> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;通常是游戏前端传入的值。
>
> 响应 :  
> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;通常是业务方法返回的值 ，业务框架会把这个返回值推送到游戏前端。
>
> 时间 :  
> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;执行业务方法总耗时，我们可根据业务方法总耗时的时长来优化业务。
>
> 路由信息 :  
> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[路由](https://www.yuque.com/iohao/game/soxp4u)是唯一的访问地址。

有了以上信息，游戏开发者可以很快的定位问题。

如果没有可视化的信息，开发中会浪费很多时间在前后端的沟通上。

问题包括：

- 是否传参问题 （游戏前端说传了）

- 是否响应问题（游戏后端说返回了）

- 业务执行时长问题 （游戏前端说没收到响应， 游戏后端说早就响应了）

其中代码导航可以让开发者快速的跳转到业务类对应代码中，在多人合作的项目中，可以快速的知道业务经过了哪些方法的执行，使得我们可以快速的进行阅读或修改；

## 适合人群？

1. 长期从事 web 内部系统开发人员， 想了解游戏的
2. 刚从事游戏开发的
3. 未从事过游戏开发但却对其感兴趣的
4. 对设计模式在实践中的应用和 sofa-bolt 有兴趣的学习者

推荐实际编程经验一年以上的人员



## 业务框架内置功能

**内置多种可选模块，可按需选择，以方便应用开发：**

- [领域事件](https://www.yuque.com/iohao/game/gmfy1k) （[disruptor](https://www.yuque.com/iohao/game/gmfy1k) 实现类似Spring事件驱动模型 ApplicationEvent）
- [任务延时器](https://www.yuque.com/iohao/game/niflk0) （将来某个时间可对任务进行执行、暂停、取消等操作，并不是类似 Quartz 的任务调度）
- [多环境切换](https://www.yuque.com/iohao/game/ekx6ve) （不同运行环境下的配置支持）
- [light-jprotobuf ](https://www.yuque.com/iohao/game/vpe2t6) （补足 jprotobuf 不能让多个对象在单个 .proto 源文件中生成的需求，并简化jprotobuf对源文件的注释）
- [分步式锁](https://www.yuque.com/iohao/game/wz7af5) (基于Redisson的简单实现)



**内置的其他功能：**

- [心跳相关](https://www.yuque.com/iohao/game/uueq3i)
- [用户上线、离线相关的钩子方法](https://www.yuque.com/iohao/game/hv5qqh)
- [UserSessions](https://www.yuque.com/iohao/game/wg6lk7) （对所有用户UserSession的管理，统计在线用户等）
- [UserSession](https://www.yuque.com/iohao/game/wg6lk7) (与 channel 是 1:1 的关系，可取到对应的 userId、channel 等信息。)
- [登录相关](https://www.yuque.com/iohao/game/tywkqv)



**集成相关：**

- [spring 集成 ](https://www.yuque.com/iohao/game/evkgnz)（业务框架可以方便的与 spring 进行集成，5 行代码）



**已完成的示例：**

示例代码在源码 **example/** 目录下

- [多服单进程示例](https://www.yuque.com/iohao/game/zm6qg2) - DemoApplication.java
- [spring集成示例](https://www.yuque.com/iohao/game/evkgnz) - DemoSpringBootApplication
- [多个逻辑服之间相互调用示例](https://www.yuque.com/iohao/game/anguu6) - DemoInteractionApplication



**后续计划：**

- 抽象通用的游戏逻辑 （进一步减少开发实践过程中的工作量）
- 步骤表
- 帧同步
- 状态同步



## ioGame 关注的多个方面

​	当然每个框架都会给自身打上高性能，使用简单、易学易用、可扩展等各种有调调的标签。这里将从这么几个方面给出一些相关的解释，如：性能方面、对接方面、通讯方式方面、开发方面（开发体验方面、参数方面、参数的数据验证方面、异常机制方面、调试方面）。



### 性能方面

ioGame游戏框架由 [**网络通信框架**] 和 [业务框架] 组成。所以我们只需要关注使用最频繁的两个点：1. 网络传输的性能，2.调用开发者编写的业务代码（action）。

**1. 网络传输的性能**

​	网络传输方面的性能上限取决于网络通信框架 [sofa-bolt](https://www.sofastack.tech/projects/sofa-bolt/overview/)。

**2.调用开发者编写的业务代码（action）**

​	业务框架对于每个 action （既业务的处理类） 都是通过 asm、singleton 等结合，对 action 的获取上通过 array 来得到，是一种近原生的方式。



### 对接方面

日常中，我们编写完成业务需求后，就会与游戏前端的同学进行联调对接的环节。在对接前需要提供相应的对接文档，如：如何访问该需求的业务方法、访问该业务方法需要什么参数、会得的响应是什么、对于该业务方法的描述等等。

对于这方面 ioGame 也提供了一些辅助 [游戏文档生成](https://www.yuque.com/iohao/game/irth38)，通过该辅助可以做到代码既文档，就是说当你的业务编写完成后，不需要额外的编写业务对接文档了，框架会自动的生成最新的文档。

如果没有游戏文档生成，那么你将要抽出一些时间来维护文档的工作，而且当团队人数多了，就会很乱（文档不同步、不是最新的、或是忘记更新等等情况就会出现）。



### 通讯方式方面

框架提供了 3 类通讯方式：**单次请求处理、推送、逻辑服间的相互通信**。**发挥你的想象力，把这 3 类通讯方式用活，可以满足很多业务。**

**1.单次请求处理**

​	a. 请求、无响应、b. 请求、响应

**2.推送**

​	a. 指定单个或多个用户广播（推送）、b. 全服广播（推送）

**3.逻辑服间的相互通信**

​	a. 单个逻辑服与单个逻辑服通信请求（**可跨进程**）、b. 单个逻辑服与同类型多个逻辑服通信请求（**可跨进程**）(后续版本提供)



[3类通讯方式文档](https://www.yuque.com/iohao/game/nelwuz)



### 开发方面

​	ioGame 非常注重开发者的开发体验，学习零成本。在开发方面又包括这几个小方面：**开发体验方面、参数方面、参数的数据验证方面、异常机制方面、调试方面**。



#### **开发体验方面**

​	1.零学习成本，一个普通的 java 方法就是一个 action。

​	2.方法参数就是请求端给的请求参数。

​	3.方法返回值（响应结果）会给到请求端。

可以看到，框架屏蔽了通信细节，从而使得开发变得很简单，可以说是学习零成本（因为这是一个普通的 java 方法）。

参考：[快速入门样例](https://www.yuque.com/iohao/game/wotnhl)

```java
@ActionController(1)
public class DemoAction {
    
    @ActionMethod(1)
    public HelloReq jackson(HelloReq helloReq) throws MsgException {
        String jacksonName = "jackson";
        
        if (jacksonName.equals(helloReq.name) == false) {
            throw new MsgException(101, "名字不正确！");
        }
        
        helloReq.name = helloReq.name + ", hello, jackson !";
        
        return helloReq;
    }
}
```

​	action 有这么几个组成部分：方法名、方法参数、方法体、方法返回值、方法的异常、方法的调用。业务框架关注有这么几个点：1.方法的调用、2.方法参数的验证、3.方法的异常处理机制、4.方法的返回值。



#### 参数

​	框架对 [jprotobuf通信协议的友好支持](https://www.yuque.com/iohao/game/mbr9in)，通信协议这里指游戏端与游戏服务端之间的业务数据传递。例如：登录业务的登录请求（游戏端请求游戏服务端）与登录响应（游戏服务端返回数据给游戏端）。jprotobuf 是对 google protobuf 的简化使用，性能同等。



#### 参数的数据验证方面（方法参数的验证）

​	框架支持 JSR303+ 相关验证规范，业务参数的验证不在需要写在业务代码里面，可以使得业务代码更干净。若不使用验证框架，常规的做法是不断的在业务代码中疯狂使用 if else 输出，使得业务代码混乱。

参考：[开启JSR303+验证规范](https://www.yuque.com/iohao/game/ghng6g)



#### 异常机制方面

​	业务框架支持异常机制，有了异常机制可以使得业务代码更加的清晰。也正是有了异常机制，才能做到零学习成本（普通的 java 方法成为一个业务动作 [action](https://www.yuque.com/iohao/game/sqcevl) ）。

​	如果有业务上的异常，请直接抛出去，不需要开发者做过多的处理，业务框架会知道如何处理这个业务异常，这些抛出去的业务异常总是能给到游戏的请求端的。

参考：[异常机制](https://www.yuque.com/iohao/game/avlo99)



#### 调试方面 （方法的调用）

在项目开发阶段，框架提供了对于请求访问的一些日志打印和业务代码定位--神级特性 （可以让你知道哪些业务方法被调用了，并能快速的跳转到对应的业务代码中）。

其中代码导航可以让开发者快速的跳转到业务类对应代码中，在多人合作的项目中，可以快速的知道业务经过了哪些方法的执行，使得我们可以快速的进行阅读或修改；

对于这块更详细的说明在[业务日志](https://www.yuque.com/iohao/game/pf3sx0)中有介绍



### 小结

业务框架的关注点：

开发方面：1.开发体验、2.参数 、3.[参数的数据验证方面（方法参数的验证）](https://www.yuque.com/iohao/game/ghng6g)、4.[异常机制](https://www.yuque.com/iohao/game/avlo99)、5.[调试日志（业务日志）](https://www.yuque.com/iohao/game/pf3sx0)

对接方面：1.[游戏文档生成](https://www.yuque.com/iohao/game/irth38)



**这几个方面是我们开发中最常用的，也是用得最为频繁的。如果满足不了上面最为基础的几个方面，谈不上是一个好用的框架。**



## 源码目录介绍

```tex
.
├── common
│   ├── common-core (业务框架)
│   └── common-kit (工具相关)
├── example （示例）
│   ├── example-broadcast （广播示例）
│   ├── example-cluster-run-one （集群示例）
│   ├── example-for-spring （spring集成示例）
│   ├── example-for-tcp-socket （对外服使用tcp协议示例）
│   ├── example-interaction （逻辑服与逻辑服之间的交互，可跨进程通信）
│   ├── example-parent
│   ├── example-redisson-lock （分步式锁）
│   ├── example-redisson-lock-spring-boot-starter （分步式锁 for springBootStarter）
│   └── example-run-one （快速启动示例）
├── example-game-collect （实战示例、坦克）
│   ├── fxgl-tank （游戏引擎-坦克游戏启动端）
│   ├── game-common （一些通用的功能）
│   ├── game-common-proto （示例 pb ）
│   ├── game-external （对外服）
│   ├── game-logic-hall （登录逻辑服）
│   ├── game-logic-tank （坦克逻辑服）
│   └── game-one （一键启动 游戏网关、游戏逻辑服（登录和坦克）、对外服）
├── net-bolt （网络通信框架相关的：对外服、游戏网关、游戏逻辑服）
│   ├── bolt-broker-server （游戏网关）
│   ├── bolt-client （逻辑服）
│   ├── bolt-core （游戏网关和逻辑服 ，bolt 相关 core 包）
│   ├── bolt-external （对外服， 也是逻辑服的一种）
│   └── bolt-run-one （单体启动辅助，一个进程内可以启动 ： 对外服、游戏网关、游戏逻辑服）
└── widget （内置多种可选模块）
    ├── light-domain-event （领域事件）
    ├── light-jprotobuf （生成 .proto 源文件）
    ├── light-profile （多环境切换）
    ├── light-redis-lock （分步式锁 ，基于Redisson的简单实现）
    ├── light-redis-lock-spring-boot-starter （分步式锁 ，基于Redisson的简单实现）
    └── light-timer-task （任务延时器）
```



## 快速从零编写服务器完整示例

​	如果觉得 ioGame 适合你，可以看一下 [快速从零编写服务器完整示例](https://www.yuque.com/iohao/game/zm6qg2) 。在这个示例中，你可以**用很少的代码**
实现一个完整的、可运行的、高性能的、稳定的服务器。



## 坦克游戏示例

​	ioGame 内提供了一个基于 [FXGL](https://www.oschina.net/p/fxgl) 游戏引擎的游戏示例（[坦克射击](https://www.yuque.com/iohao/game/gqossg)启动文档），FXGL 是纯 java 开发的一个游戏引擎，可以在项目中直接运行。

运行 TankApp.java 文件就可以启动游戏了。

原计划用 [U3D](https://unity.cn/) 来做游戏示例的，但想到大伙还得安装 [u3d](https://unity.cn/) 的环境，就用  [FXGL](https://www.oschina.net/p/fxgl)
来做游戏示例了。

![img](https://gitee.com/iohao/xmindpic/raw/master/game/tank.png)


**如果您觉得还不错，帮忙给个 start 关注**



## 参考

什么是 [Action](https://www.yuque.com/iohao/game/sqcevl)。

[快速从零编写服务器完整示例](https://www.yuque.com/iohao/game/zm6qg2)

[坦克示例](https://www.yuque.com/iohao/game/gqossg)（坦克游戏前端）。
