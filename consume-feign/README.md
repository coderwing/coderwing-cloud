# feign 服务使用说明

> Feign服务内部继承了Ribbon，拥有ribbon的负载能力 ；增加了注解定义；
>

## 断路器使用
> 这里断路器分成两部分：断路器使用和断路器的Dashboard
>
> 断路器的使用，直接参考源码，源码定义很直接；
>
> Dashboard 按照pom.xml中的引入，然后启动类上增加对应的注解：
```yaml
# 开启HystrixDashboard
@EnableHystrixDashboard
# 内部使用了 EnableCircuitBreakerImportSelector 加载相关的断路器配置类；熔断超时机制
@EnableCircuitBreaker
```
> 访问：http://localhost:9004/hystrix