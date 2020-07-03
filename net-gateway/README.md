
# Gateway 特性
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
 
 ###Filter
 > Filter 有三种策略：pre、proxy和post