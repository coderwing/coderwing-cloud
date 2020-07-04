
# Gateway 

## 特性
> 可以匹配人已请求属性的路由
>
> 可以根据路由使用匹配策略和过滤器
>
> 可以很好地集成Hystrix断路器
> 
> 集成服务注册（同样支持Eureka）
>
> 易于写断言+过滤器
>
> 请求限流
>
> 重写path
>
  总结起来就是三大特性：Route、Predicate和Filter
### 为什么使用网关
在微服务架构中有很多服务，比如user、goods、sales等，在这些服务的业务中都需要做鉴权、限流、日志输出等，
如果都放在每个单独的服务中去做，无疑都是重复工作，修改的话都需要修改，显然很麻烦，因此网关的作用就是统
一对共同的请求处理做公共抽取拦截；
 ***
 ## Predicate
> 参考：https://cloud.spring.io/spring-cloud-static/spring-cloud-gateway/2.2.1.RELEASE/reference/html/#gateway-request-predicates-factories
> 
> 有After or Before 指定在某时间后/前路由到某url的、Header过滤、Cookie过滤、HOST主机名匹配、Path路径匹配的，以及Query查询参数过滤等
***
## Filter 
> 过滤器有三、2种模式：pre 和 post
>
> 但是按照作用范围，Gateway有2类：一类是对单个路由的GatewayFilter（目前31种），另一类是对所有/全局路由的GlobalFilter（目前10种）；
>
> 作用于单个路由参考：https://cloud.spring.io/spring-cloud-static/spring-cloud-gateway/2.2.1.RELEASE/reference/html/#gatewayfilter-factories <br>
> 作用于全局路由参考：https://cloud.spring.io/spring-cloud-static/spring-cloud-gateway/2.2.1.RELEASE/reference/html/#global-filters <br>
#### - pre模式
参数校验<br>
权限拦截<br>
流量监控<br>
日志输出<br>
协议转换<br>
等

#### -post
响应内容修改<br>
响应头修改<br>
日志输出<br>
流量监控<br>
等


### 自定义过滤器
> 可以通过实现 GatewayFilter, Ordered 接口完成自定义过滤器，全局过滤器需要实现GlobalFilter接口；

> 我们还可以通过继承AbstractGatewayFilterFactory或AbstractNameValueGatewayFilterFactory （这两个抽象类都是GatewayFilterFactory接口的实现类）来自定义过滤器工厂；

注意：自定义的工程和Filter都需要手动@Bean注入
***
### 限流
常用限流算法<br>
> 计数器算法<br>漏桶算法<br>令牌桶算法<br>

> 【计数器算法】：简单粗暴，比如1s内qps最大100，超过一千则请求不到；缺点很明显，如果前10ms超过了100，那么后990ms就只能是请求失败，称为“突刺现象”；
<br>
> 【漏桶算法】：上游请求速度不限制，在处理请求的时候，将上游请求放到一个队列中，每10ms处理一次请求，可以解决突刺现象；缺点是，因为是匀速的，所以不适合正常的突发请求；
<br>
> 【令牌桶】算法：使用一个队列存放令牌，令牌可以预先生成好，等请求到达后，给每一个请求配对一个令牌，如果令牌使用完毕，则请求等待令牌生成；生成令牌可以使用线程池每隔一段时间或向队列桶中放入新的令牌；

<br>
Gateway的Filter使用 pre 类型的方式自行实现限流；Gateway提供了 RequestRateLimiterGatewayFilterFactory，适用于Redis和lua脚本实现了令牌桶的方式，在Spring对应的包目录中提供了lua脚本；
<br>
限流过滤器name: RequestRateLimiter；具体查看代码
