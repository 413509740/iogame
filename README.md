<h1 align="center" style="text-align:center;">
  ioGame
</h1>
<p align="center">
	<strong>国内首个基于蚂蚁金服 SOFABolt 的 java 网络游戏服务器框架；无锁异步化、事件驱动的架构设计；</strong>
	<br>
	<strong>通过 ioGame 可以很容易的搭建出一个集群无中心节点、有状态的分步式网络游戏服务器 </strong>
	<br>
	<strong>轻量级的、启动快、更节约、简单、好用、开箱即用、无配置文件、超高性能；</strong>
	<br>
	<strong>代码即文档、JSR380、断言 + 异常机制 = 更少的维护与开发成本</strong>
	<br>
	<strong>业务框架平均每秒可以执行 1152 万次业务逻辑；</strong>
    <br>
	<strong>对webMVC开发者友好</strong>
</p>
<p align="center">
	<a href="https://www.yuque.com/iohao/game">https://www.yuque.com/iohao/game</a>
</p>



<p align="center">
	<a target="_blank" href="https://www.oracle.com/java/technologies/downloads/#java17">
		<img src="https://img.shields.io/badge/JDK-17-green.svg" alt="JDK 17" />
	</a>
	<br>
	<a target="_blank" href="https://license.coscl.org.cn/Apache2/">
		<img src="https://img.shields.io/:license-Apache2-blue.svg" alt="Apache 2" />
	</a>
	<br />
	<a target="_blank" href='https://gitee.com/iohao/iogame'>
		<img src='https://gitee.com/iohao/iogame/badge/star.svg' alt='gitee star'/>
	</a>
	<a target="_blank" href='https://github.com/iohao/iogame'>
		<img src="https://img.shields.io/github/stars/iohao/iogame.svg?logo=github" alt="github star"/>
	</a>
</p>
<hr />

<br/>

过去、现在、将来都不会有商业版本，所有功能全部开源！

只做真的完全式开源，拒绝虚假开源，售卖商业版，不搞短暂维护！

承诺项目的维护周期是十年起步， 2022-03-01起，至少十年维护期！

提供高质量的使用文档！

如果您觉得还不错，帮忙给个 start 关注

<br>

在线文档:：[ioGame 网络游戏框架-文档](https://www.yuque.com/iohao/game)

|                                    | gitee                                                      | github                                                      |
| ---------------------------------- | ---------------------------------------------------------- | ----------------------------------------------------------- |
| 源码地址                           | [ioGame 网络游戏框架-源码](https://gitee.com/iohao/iogame) | [ioGame 网络游戏框架-源码](https://github.com/iohao/iogame) |
| 示例地址                           | [ioGame 示例集合](https://gitee.com/iohao/example-iogame)  | [ioGame 示例集合](https://github.com/iohao/example-iogame)  |

<br>

------

<br>

|   热心市民提供的游戏前端连接示例代码    | 连接方式 |
| ------------------------------------------------------------ | ------------------------------------------------------------ |
| [u3d 连接示例](https://www.yuque.com/iohao/game/syv5mm) | websocket |
| [cocoscreator 连接示例](https://www.yuque.com/iohao/game/ua4afq) | websocket |




> **推荐大家看在线文档，排版好一些，README 上看有点乱！**

<br>

---

<br>

## 愿景

**让网络游戏服务器的编程变得轻松简单！**  



## 网络游戏服务器框架简介

ioGame 是一个由 **java** 语言编写的**网络游戏服务器框架**。支持 websocket、tcp ，适用于**全球同服**、回合制游戏、策略游戏、即时战斗等游戏服务器的开发。具有高性能、稳定、易用易扩展、超好编程体验等特点。可做为 H5、手游、端游的 java 游戏服务器。



ioGame 是轻量级的网络游戏服务器框架，在使用 ioGame 时，无需安装其他服务，如： Nginx、Redis、MQ、Mysql、ZooKeeper、Protobuf协议编译工具 ... ...等。简单点说，就是无需安装其他产品就能使用；这意味着在使用上简单了，在部署上也为企业节约了成本。



通过 ioGame 你可以很容易的搭建出一个稳定、高性能、集群无中心节点、分步式、自带负载均衡、跨进程通信、避免类爆炸设计的网络游戏服务器。游戏框架借助于蚂蚁金服 [sofa-bolt](https://www.sofastack.tech/projects/sofa-bolt/overview/) 通信框架来提供通信方面的稳定与高性能。



在 ioGame 中能让你遗忘 Netty，你几乎没有机会能直接的接触到 Netty 的**复杂**，但却能享受 Netty 带来的**高性能**。对开发者要求极低，为开发者节约开发时间。



即使之前没有游戏编程的经验，也能参与到游戏编程中。如果你之前具备一些游戏开发或者 webMVC 相关的知识，则会更容易上手游戏服务器的开发。



ioGame 可以很方便的与 spring 集成（5 行代码）。在部署上支持多服单进程的方式部署（类似单体应用）、也支持多服多进程多机器的方式部署。在部署方式上可以随意切换，而不需要更改代码；日常中按照单体思维开发，在生产上可以使用多进程的方式部署；当然，也可以使用单进程的方式部署。



ioGame 框架职责清晰、业务开发几乎零学习成本、源码有高质量注释、示例多、使用文档多，开发体验最佳、对接文档自动生成、逻辑服之间可跨进程跨机器通信、业务代码定位--神级特性、异常机制。提供了丰富的在线高质量使用文档，为你的团队助力，带上你们的小伙伴一起，这样就不用手把手的教了。



------

ioGame 是国内首个基于蚂蚁金服 [sofa-bolt](https://www.sofastack.tech/projects/sofa-bolt/overview/) 的网络游戏框架，游戏框架由 [**网络通信框架**] 和 [**业务框架**] 组成。

- 网络通信框架：职责是各服务器之间的网络通信
- 业务框架：职责是业务逻辑的处理方式和编写方式



### 网络通信框架 - SOFABolt

[SOFABolt](https://www.sofastack.tech/projects/sofa-bolt/overview/) 是蚂蚁金融服务集团开发的一套基于 Netty 实现的网络通信框架。

- 为了让 Java 程序员能将更多的精力放在基于网络通信的业务逻辑实现上，而不是过多的纠结于网络底层 NIO 的实现以及处理难以调试的网络问题，Netty 应运而生。
- 为了让中间件开发者能将更多的精力放在产品功能特性实现上，而不是重复地一遍遍制造通信框架的轮子，SOFABolt 应运而生。

Bolt 名字取自迪士尼动画-闪电狗，是一个基于 Netty 最佳实践的轻量、易用、高性能、易扩展的通信框架。



### 业务框架

如果说  [sofa-bolt](https://www.sofastack.tech/projects/sofa-bolt/overview/) 是为了让 Java 程序员能将更多的精力放在基于网络通信的业务逻辑实现上。而业务框架正是解决业务逻辑如何方便实现这一问题上。业务框架是游戏框架的一部份，职责是简化程序员的业务逻辑实现，业务框架使程序员能够快速的开始编写游戏业务。



业务框架对于每个 action （即业务的处理类） 都是通过 [asm](https://www.oschina.net/p/reflectasm) 与 Singleton、Flyweight 、Command 等设计模式结合，对 action 的获取上通过 array 来得到，是一种近原生的方式。



业务框架平均每秒可以执行 1152 万次业务逻辑。

<details>
<summary>业务框架性能报告JMH--点我展开</summary>

```text
Iteration   1: 11439916.980 ops/s
Iteration   2: 11521457.838 ops/s
Iteration   3: 11560843.725 ops/s
Iteration   4: 11535277.025 ops/s
Iteration   5: 11564838.596 ops/s
Result "com.iohao.game.example.benchmark.BarSkeletonBenchmark.handle1":
  11524466.833 ±(99.9%) 194712.309 ops/s [Average]
  (min, avg, max) = (11439916.980, 11524466.833, 11564838.596), stdev = 50566.168
  CI (99.9%): [11329754.524, 11719179.141] (assumes normal distribution)

# Run complete. Total time: 00:01:20

```
----------------------------------------
上面是在单线程中的测试数据，业务框架平均每秒执行 1152 万次。

</details>

------

## 架构简图

![img](https://oscimg.oschina.net/oscnet/up-2a383c8fd7b13161b4e5bf210bdf9980771.png)

<p align="center" style="color:red">
通过 ioGame 你可以很容易的搭建出一个集群无中心节点、分步式的网络游戏服务器！
</p>



无锁异步化、事件驱动的架构设计、集群无中心节点、自带负载均衡、分布式支持、可动态增减机器、避免类爆炸的设计；



图中的每个对外服、每个游戏逻辑服、每个 broker （游戏网关）都可以在单独的进程中部署，逻辑服之间可以跨进程通信（对外服也是逻辑服的一种）。



**游戏网关集群**

broker （游戏网关）可以**集群**的方式部署，集群无中心节点、自带负载均衡。ioGame 本身就包含服务注册，你不需要外接一个服务注册中心，如 Eureka，ZooKeeper 等（变相的节约服务器成本）。



通过 broker （游戏网关） 的介入，之前非常复杂的负载均衡设计，如服务注册、健康度检查（后续版本提供）、到服务端的连接维护等这些问题，在 ioGame 中都不需要了，结构也简单了很多。实际上单台 broker （游戏网关） 性能已经能够满足了，因为游戏网关只做了转发。



**逻辑服**

逻辑服通常说的是游戏对外服和游戏逻辑服。逻辑服可以有很多个，逻辑服扩展数量的理论上限是 netty 的连接上限。



**游戏对外服**

对外服保持与用户（玩家）的长连接。先来个假设，假如我们的一台硬件支持我们建立用户连接的上限是 5000 人，当用户量达到 7000 人时，我们可以多加一个对外服务器来进行分流减压。由于游戏对外服扩展的简单性，意味着支持同时在线玩家可以轻松的达到百万、千万甚至更多。



参考：[构架简图中：对外服、游戏网关、游戏逻辑服各自的职责](https://www.yuque.com/iohao/game/dqf0he)



## ioGame 支持的通讯方式
![img](https://oscimg.oschina.net/oscnet/up-7cc466fa3c1f88b6e7fcff7120b82e27ee7.png)

ioGame 支持 3 种类型的通讯方式，分别是**单次请求处理、推送、逻辑服间**的相互通信；下面分别对这 3 种类型的通讯方式相关的应用场景举几个例子。



框架对这 3 种类型的通讯方式提供了代码调用点的日志，简单点说就是框架可以让开发者知道，是在哪一行代码中触发的业务逻辑。



我们可以想象一下，假如框架没有提供代码调用点的日志会是什么样的；比如，游戏前端发送一个业务请求到游戏服务器中，但是处理这个请求的业务方法，会触发多个响应（通常是推送、广播）给游戏前端。一但时间久了，开发者是很难知道分别响应了哪些业务数据给游戏前端，特别是一些二手项目；所以这将是一个灾难性的问题，因为这会耗费大量的时间来寻找这些相关的业务代码。



<details>
<summary>3 种类型的通讯方式的详细内容--点我展开</summary>

**1.单次请求处理**

**1.1 请求、无响应**

当请求端发起请求后，逻辑服不会发送任何响应给请求端。可以用在在网络通讯中，存在着不需要接收方回执确认的调用模型，如数据采集的场景: 打点采集、日志传输、metrics上报等。  



在写 [action](https://www.yuque.com/iohao/game/sqcevl) 时，将方法返回值声名为 void 就表示处理 请求、无响应的。  



<br>

**1.2 请求、响应**

请求、响应是在游戏开发中常见的通讯模式，也就是通讯的一方发出请求，而远程通讯的对方做出响应，也就是常说的请求/响应模式。  



比如：装备的升级、人物的升级、玩家的移动、抽奖、游戏前端到某一个场景时需要从游戏服务端获取一些对应的场景配置等；  



在写 [action](https://www.yuque.com/iohao/game/sqcevl) 时，方法有返回值的就表示处理 请求、响应的，框架会将这个返回值给到请求端。  



<br>

**2.推送**

**2.1 指定单个或多个用户广播（推送）**

向一个或多个指定的用户（玩家）主动发送一些数据。比如：

- 给指定的在线玩家发送一些奖励。
- 给在同一个房间内的玩家广播一些数据，如某一个玩家射击子弹，把这子弹的数据广播给房间内的其他玩家。如几个玩家在同一个房间内打牌，某个玩家出牌后，把这张牌的数据广播给房间内的其他玩家。  



<br>

**2.2 全服广播（推送）**

给全服的所有在线玩家广播消息，如广播公告、即将停服维护等。

详细示例可参考：[广播示例](https://www.yuque.com/iohao/game/qv4qfo)



<br>

**3.逻辑服间的相互通信**

**3.1 单个逻辑服与单个逻辑服通信请求 - 有返回值（可跨进程）**

逻辑服与逻辑服之间的相互请求通信，有返回值



比如：我们有两个游戏逻辑服，分别是：a.天气预报逻辑服、b.战斗逻辑服。现在我们设想一个回合制游戏的战斗场景，需要配合天气，根据天气来增强或者减弱某个英雄的能力。那么在战斗开始前，战斗逻辑服只需要向游戏网关发起一个获取当前天气的请求，就可以得到当前的天气信息了，在根据当前的天气数据来增强或减弱该英雄的能力。



又比如：a.大厅逻辑服、b.奖励发放逻辑服。大厅记录着一些数据（房间总数），奖励发放逻辑服根据当前的房间数量，来生成不同奖品，随机发放给在线用户。

详细示例可参考：[逻辑服与逻辑服之间的交互示例](https://www.yuque.com/iohao/game/anguu6)



<br>

**3.2 单个逻辑服与单个逻辑服通信请求 - 无返回值（可跨进程）**

逻辑服与逻辑服之间的相互请求通信，无返回值



比如：我们有两个游戏逻辑服，分别是：a.匹配逻辑服、b.房间逻辑服。



业务场景如下，多个玩家在开始游戏前需要匹配。这里假设有两个玩家，当匹配完成后，给这两个玩家返回所匹配到的房间信息。



具体实现如下，两个玩家分别向匹配逻辑服发送匹配请求，匹配逻辑服收到玩家的请求后进行逻辑处理，并成功的把这两个玩家匹配到一起，此时我们把两个匹配到一起的玩家先称为匹配结果。匹配逻辑服只负责匹配相关的算法逻辑，所以在匹配逻辑服中，我们可以把匹配结果给到房间逻辑服，因为与匹配相关的工作已经完成了。



在匹配逻辑服中，我们可以向房间逻辑服发起一个（单个逻辑服与单个逻辑服通信请求 - 无返回值）的请求，当房间逻辑服拿到匹配结果，根据匹配结果来创建房间。房间创建完成后把结果用推送（广播）给这两名玩家。

为什么要用无返回值的通信请求呢，因为匹配逻辑服并不关心房间的创建。

详细说明可参考：[逻辑服与逻辑服之间的交互-无返回值](https://www.yuque.com/iohao/game/anguu6#cZfdx)



<br>

**3.3 单个逻辑服与同类型多个逻辑服通信请求（可跨进程）**

如： 【象棋逻辑服】有 3 台，分别是：《象棋逻辑服-1》、《象棋逻辑服-2》、《象棋逻辑服-3》，这些逻辑服可以在不同有进程中。



我们可以在大厅逻辑服中向【同类型】的多个游戏逻辑服请求，意思是大厅发起一个向这 3 台象棋逻辑服的请求，框架会收集这 3 个结果集（假设结果是：当前服务器房间数）。



当大厅得到这个结果集，可以统计房间的总数，又或者说根据这些信息做一些其他的业务逻辑；这里只是举个例子。实际当中可以发挥大伙的想象力。



详细示例可参考：[请求同类型多个逻辑服通信结果](https://www.yuque.com/iohao/game/rf9rb9)

其中配合[动态绑定逻辑服节点；可以实现LOL、王者荣耀匹配后动态分配房间](https://www.yuque.com/iohao/game/idl1wm)



<br>

**最后，发挥你的想象力，把这 3 类通讯方式用活，可以满足很多业务。**

</details>


## 快速入门

### 业务交互

![img](https://oscimg.oschina.net/oscnet/up-cf1326ae1f3752897a403095218b4660008.jpg)

抽象的说，游戏前端与游戏服务器的的交互由上图组成。游戏前端与游戏服务器可以自由的双向交互，交互的业务数据由 .proto 作为载体。协议文件是对业务数据的描述载体，用于游戏前端与游戏服务器的数据交互。



当游戏前端和游戏服务端建立了连接后，就可以开始相互传递业务数据，处理各自的业务了。好了，看完业务交互介绍后，开始编写一个游戏业务处理示例吧，接下来我们先定一个业务数据协议。



### 协议文件

协议文件是对业务数据的描述载体，用于游戏前端与游戏服务器的数据交互。Protocol Buffers 是Google公司开发的一种数据描述语言，也简称 [PB](https://www.oschina.net/p/protocol+buffers) 。当然协议文件描述还可以是 json、xml或者任意自定义的，因为最后传输时会转换为二进制，但游戏开发中 PB 是目前的最佳。



### 游戏前端

游戏前端的展现可以是 [Unity](https://unity.cn/) 、 [UE(虚幻)](https://www.unrealengine.com/zh-CN/) 、 [Cocos](https://www.cocos.com/) 或者其他的游戏引擎。这些游戏引擎只是展现游戏画面的一种形式，数据交互则由通信来完成（TCP、UDP 等）。

- [u3d 连接示例](https://www.yuque.com/iohao/game/syv5mm)
- [cocosCreator 连接示例](https://www.yuque.com/iohao/game/ua4afq)



### 快速入门代码示例

这里主要介绍游戏服务器相关的，下面这个示例介绍了服务器编程可以变得如此简单。



<br>

#### Proto 协议文件定义

首先我们自定义一个协议文件，这个协议文件作为我们的业务载体描述。这个协议是纯java代码编写的，使用的是 jprotobuf，jprotobuf 是对 [google protobuf](https://www.oschina.net/p/protocol+buffers) 的简化使用，性能同等。



可以把这理解成DTO、POJO、业务数据载体等，其主要目的是用于业务数据的传输；

```java
/** 请求 */
@ProtobufClass
@FieldDefaults(level = AccessLevel.PUBLIC)
public class HelloReq {
    String name;
}
```



<br>

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

一个方法在业务框架中表示一个 Action（即一个业务动作）。



方法声名的参数是用于接收前端传入的业务数据，在方法 return 时，数据就可以被游戏前端接收到。程序员可以不需要关心业务框架的内部细节。



从上面的示例可以看出，这和普通的 java 类并无区别，同时这种设计方式**避免了类爆炸**。如果只负责编写游戏业务，那么对于业务框架的学习可以到此为止了。



游戏编程就是如此简单！



<br>

**问：我可以开始游戏服务器的编程了吗？**

是的，你已经可以开始游戏服务器的编程了。



<br>

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
> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[路由](https://www.yuque.com/iohao/game/soxp4u) 是唯一的访问地址。



有了以上信息，游戏开发者可以很快的定位问题。如果没有可视化的信息，开发中会浪费很多时间在前后端的沟通上。问题包括：

- 是否传参问题 （游戏前端说传了）
- 是否响应问题（游戏后端说返回了）
- 业务执行时长问题 （游戏前端说没收到响应， 游戏后端说早就响应了）



其中代码导航可以让开发者快速的跳转到业务类对应代码中，在多人合作的项目中，可以快速的知道业务经过了哪些方法的执行，使得我们可以快速的进行阅读或修改；



<br>

## 适合人群？

1. 长期从事 web 内部系统开发人员， 想了解游戏的
2. 刚从事游戏开发的
3. 未从事过游戏开发，但却对其感兴趣的
4. 对设计模式在实践中的应用和 sofa-bolt 有兴趣的学习者
5. 可以接受新鲜事物的
6. 想放弃祖传代码的



推荐实际编程经验一年以上的人员



<br>

## 框架内置功能

**内置多种可选模块，可按需选择，以方便应用开发：**

<details>
<summary>游戏服务器框架内置功能详细--点我展开</summary>

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
- [业务参数自动装箱、拆箱基础类型](https://www.yuque.com/iohao/game/ieimzn) （解决协议碎片）

**集成相关：**

- [spring 集成 ](https://www.yuque.com/iohao/game/evkgnz) （业务框架可以方便的与 spring 进行集成，5 行代码）

**后续计划：**

- 抽象通用的游戏逻辑 （进一步减少开发实践过程中的工作量）
- 步骤表
- 帧同步
- 状态同步
- 框架自带监控

</details>



<br>


## ioGame 关注的多个方面

当然每个框架都会给自身打上高性能、使用简单、易学易用、可扩展等各种有调调的标签。这里将从这么几个方面给出一些相关的解释，同是也是开发中接触最多的几个方面，如：

- 性能方面
- 对接方面
- 通讯方式方面
- 开发方面

- - 开发体验方面
  - 参数方面
  - 参数的数据验证方面
  - 异常机制方面
  - 调试方面



### 性能方面

ioGame游戏框架由 [网络通信框架] 和 [业务框架] 组成。所以我们只需要关注使用最频繁的两个点，1. 网络传输的性能，2.调用开发者编写的业务代码（action）。

<br>

**1. 网络传输的性能**

网络传输方面的性能上限取决于网络通信框架 [sofa-bolt](https://www.sofastack.tech/projects/sofa-bolt/overview/) 。

<br>

**2.调用开发者编写的业务代码（action）**

业务框架对于每个 action （即业务的处理类） 都是通过 [asm](https://www.oschina.net/p/reflectasm) 与 Singleton、Flyweight 、Command 等设计模式结合，对 action 的获取上通过 array 来得到，是一种近原生的方式。

<br>

业务框架平均每秒可以执行 1152 万次业务逻辑。

<details>
<summary>业务框架性能报告JMH--点我展开</summary>

![img](https://oscimg.oschina.net/oscnet/up-ad008557d2ed7f1f0ba6aeab41780446866.png)

</details>


<br>

### 对接方面

日常中，我们编写完成业务需求后，就会与游戏前端的同学进行联调对接的环节。在对接前需要提供相应的对接文档，如：如何访问该需求的业务方法、访问该业务方法需要什么参数、会得的响应是什么、对于该业务方法的描述等等。



对于这方面 ioGame 也提供了一些辅助 [游戏文档生成](https://www.yuque.com/iohao/game/irth38) ，通过该辅助可以做到代码即文档，就是说当你的业务编写完成后，不需要额外的编写业务对接文档了，框架会自动的生成最新的文档。



如果没有游戏文档生成，那么你将要抽出一些时间来维护文档的工作，而且当团队人数多了，就会很乱（文档不同步、不是最新的、或是忘记更新等等情况就会出现）。



<details>
<summary markdown="span">框架生成的对接文档预览--点我展开</summary>

```
==================== DemoEndPointRoomAction 动态绑定逻辑服节点-房间相关 ====================
路由: 10 - 0  --- 【统计房间数】 --- 【DemoEndPointRoomAction:44】【countRoom】
    方法返回值: com.iohao.game.example.common.msg.RoomNumMsg

路由: 10 - 1  --- 【房间内的操作】 --- 【DemoEndPointRoomAction:64】【operation】
    方法参数: com.iohao.game.example.common.msg.DemoOperation
    方法返回值: com.iohao.game.example.common.msg.DemoOperation

==================== DemoMatchAction 动态绑定逻辑服节点-匹配相关 ====================
路由: 11 - 0  --- 【开始匹配】 --- 【DemoMatchAction:83】【matching】
    方法返回值: com.iohao.game.example.common.msg.MatchResponse

路由: 11 - 1  --- 【登录】 --- 【DemoMatchAction:56】【loginVerify】
    方法参数: com.iohao.game.example.common.msg.login.DemoLoginVerify
    方法返回值: com.iohao.game.example.common.msg.login.DemoUserInfo

==================== 错误码 ====================
 -1005 : class 不存在 
 -1004 : 请先登录 
 -1003 : 心跳超时相关 
 -1002 : 路由错误 
 -1001 : 参数验错误 
 -1000 : 系统其它错误 

```

</details>



<br>


### 通讯方式方面

框架提供了 3 类通讯方式：**单次请求处理、推送、逻辑服间的相互通信**。**发挥你的想象力，把这 3 类通讯方式用活，可以满足很多业务。**

<details>
<summary>通讯方式方面--点我展开</summary>

**1.单次请求处理**

- 请求、无响应
- 请求、响应



<br>

**2.推送**

- 指定单个或多个用户广播（推送）
- 全服广播（推送）

参考：[广播（推送）相关示例与文档](https://www.yuque.com/iohao/game/qv4qfo)



<br>

**3.逻辑服间的相互通信**

- 单个逻辑服与单个逻辑服通信请求-有返回值（可跨进程）
- 单个逻辑服与单个逻辑服通信请求-无返回值（可跨进程）
- 单个逻辑服与同类型多个逻辑服通信请求（可跨进程）



参考：[逻辑服与逻辑服之间的交互示例](https://www.yuque.com/iohao/game/anguu6)

其中配合[动态绑定逻辑服节点；可以实现LOL、王者荣耀匹配后动态分配房间](https://www.yuque.com/iohao/game/idl1wm)

[3类通讯方式文档](https://www.yuque.com/iohao/game/nelwuz)
</details>



<br>

### 开发方面

ioGame 非常注重开发者的开发体验，学习零成本。在开发方面又包括这几个小方面：**开发体验方面、参数方面、参数的数据验证方面、异常机制方面、调试方面**。



<br>

#### **开发体验方面**

1.零学习成本，一个普通的 java 方法就是一个 action。

2.方法参数就是请求端给的请求参数。

3.方法返回值（响应结果）会给到请求端。



可以看到，框架屏蔽了通信细节，从而使得开发变得很简单，可以说是学习零成本（因为这是一个普通的 java 方法），同时这种设计方式**避免了类爆炸**。



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

action 有这么几个组成部分：方法名、方法参数、方法体、方法返回值、方法的异常、方法的调用。业务框架关注的有这么几个点

1. 方法的调用
2. 方法参数的验证
3. 方法的异常处理机制
4. 方法的返回值



<br>

#### 参数

框架对 [jprotobuf通信协议的友好支持](https://www.yuque.com/iohao/game/mbr9in) ，通信协议这里指游戏端与游戏服务端之间的业务数据传递。例如：登录业务的登录请求（游戏端请求游戏服务端）与登录响应（游戏服务端返回数据给游戏端）。jprotobuf 是对 google protobuf 的简化使用，性能同等。



<br>

#### 参数的数据验证方面（方法参数的验证）

框架支持 JSR303+ 相关验证规范，业务参数的验证不在需要写在业务代码里面，可以使得业务代码更干净。若不使用验证框架，常规的做法是不断的在业务代码中疯狂使用 if else 输出，使得业务代码混乱。

参考：[开启JSR303+验证规范](https://www.yuque.com/iohao/game/ghng6g)



<br>

#### 异常机制方面

断言 + 异常机制 = 清晰简洁的代码



业务框架支持异常机制，有了异常机制可以使得业务代码更加的清晰。也正是有了异常机制，才能做到零学习成本（普通的 java 方法成为一个业务动作 [action](https://www.yuque.com/iohao/game/sqcevl) ）。



如果有业务上的异常，请直接抛出去，不需要开发者做过多的处理，业务框架会知道如何处理这个业务异常，这些抛出去的业务异常总是能给到游戏的请求端的。

参考：[异常机制](https://www.yuque.com/iohao/game/avlo99)



<br>

#### 调试方面 （方法的调用）

在项目开发阶段，框架提供了对于请求访问的一些日志打印和业务代码定位--神级特性 （可以让你知道哪些业务方法被调用了，并能快速的跳转到对应的业务代码中）。



其中代码导航可以让开发者快速的跳转到业务类对应代码中，在多人合作的项目中，可以快速的知道业务经过了哪些方法的执行，使得我们可以快速的进行阅读或修改；



对于这块更详细的说明在 [业务日志](https://www.yuque.com/iohao/game/pf3sx0) 中有介绍



<br>

### 小结-业务框架的关注点

开发方面：1.开发体验、2.参数 、3.[参数的数据验证方面（方法参数的验证）](https://www.yuque.com/iohao/game/ghng6g) 、4.[异常机制](https://www.yuque.com/iohao/game/avlo99) 、5.[调试日志（业务日志）](https://www.yuque.com/iohao/game/pf3sx0) 



对接方面：1.[游戏文档生成](https://www.yuque.com/iohao/game/irth38)



这几个方面是我们开发中最常用的，也是用得最为频繁的。如果满足不了上面最为基础的几个方面，谈不上是一个好用的框架。



<br>

## 源码目录介绍

<details>
<summary>源码目录详细</summary>
<pre>
├── common
│   ├── common-core (业务框架)
│   └── common-kit (工具相关)
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
</pre>
</details>


<br>

## 快速从零编写服务器完整示例

如果觉得 ioGame 适合你，可以看一下 [快速从零编写服务器完整示例](https://www.yuque.com/iohao/game/zm6qg2) 。在这个示例中，你可以用很少的代码实现一个完整的、可运行的、高性能的、稳定的服务器。



<br>

## 坦克游戏示例

ioGame 源码内提供了一个基于 [FXGL](https://www.oschina.net/p/fxgl) 游戏引擎的游戏示例 （[坦克射击](https://www.yuque.com/iohao/game/gqossg) 启动文档），FXGL 是纯 java 开发的一个游戏引擎，可以在项目中直接运行。通过示例，可以快速的掌握网络游戏编程！



运行 TankApp.java 文件就可以启动游戏了。原计划用 U3D 来做游戏示例的，但想到大伙还得安装 [u3d](https://unity.cn/) 的环境，就用  [FXGL](https://www.oschina.net/p/fxgl) 来做游戏示例了。

![img](https://oscimg.oschina.net/oscnet/up-5ae3d9516142c4e3aecd73c62d495104bed.png)

**如果您觉得还不错，帮忙给个 start 关注**



<br>

## 参考

什么是 [Action](https://www.yuque.com/iohao/game/sqcevl) 。

[快速从零编写服务器完整示例](https://www.yuque.com/iohao/game/zm6qg2)

[坦克示例](https://www.yuque.com/iohao/game/gqossg) （游戏前端） 

[广播（推送）相关示例与文档](https://www.yuque.com/iohao/game/qv4qfo)

[逻辑服与逻辑服之间的交互示例](https://www.yuque.com/iohao/game/anguu6)

[构架简图中：对外服、游戏网关、游戏逻辑服各自的职责](https://www.yuque.com/iohao/game/dqf0he)



[u3d 连接示例](https://www.yuque.com/iohao/game/syv5mm)

[cocosCreator 连接示例](https://www.yuque.com/iohao/game/ua4afq)



## 安装与使用ioGame

参考 https://www.yuque.com/iohao/game/wsgmba





