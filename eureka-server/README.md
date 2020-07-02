# Eureka server使用说明

> eureka server目前是经过改造后的，支持负载的集群模式
>
> 并且使用虚拟本地域名 peer和peer2，当然你也可以定义其他的名字；
>
## 初版
> 初版的Eureka是个单节点服务，核心就是配置文件的修改，原来只有一个application.yml文件，内容如下：
```yaml

server:
  port: 8761

spring:
  application:
    name: eureka-server

eureka:
  instance:
    hostname: localhost
  client:
    serviceUrl:
      defaultZone: http://localhost:8761/eureka/

```

> 为了更加健壮稳定的支持服务注册与发现，进行改造；
>
## 改造
> 增加两个新的配置文件application-peer1.yml和application-peer2.yml，内容可直接查看对应文件；
>
> 将原来的application.yml内容修改成只有激活环境的配置：
```yaml

spring:
  profiles:
    active: peer1

```

> 这里解释一下peer1和peer2，这两个名称就是模拟的域名，在本地随便起一个可用的名字用来测试即可，既然是域名就需要修改本地的hosts文件，增加：
```yaml
127.0.0.1 peer1
127.0.0.1 peer2
```
> 映射和配置文件准备完毕之后既可以启动项目了

## 项目启动
### 方式一：
> 直接在idea中启动，在idea中默认是不支持对一个项目同时启动两个实例的，但是可以通过修改配置（很简单）支持，修改配置参考：https://www.notion.so/coderwing/IDEA-aeff3bfe028e4f35ae0d53e99a89e0ac
>
> 启动了第一个之后，修改applicatoin.yml中的active ，改成peer2 或者peer1，另一个值；

### 方式二：
> 不实用application.yml配置文件，先把项目打成jar包，然后通过命令方式启动：
```yaml
# 实例1
java -jar eureka-server-0.0.1-SNAPSHOT.jar - -spring.profiles.active=peer1

# 实例2
java -jar eureka-server-0.0.1-SNAPSHOT.jar - -spring.profiles.active=peer2

```

## 注意
> 第一个启动的服务启动后控制台会报错，这是正常的，因为在配置文件中依赖了第二个服务实例，但是这时候第二个服务实例还没有启动，所以在eureka刚启动后，探测不到服务实例2，当启动第二个的时候不会报错，然后再看第一个启动的服务控制台信息就正常了，因为这时候可以探测到服务实例2了；
