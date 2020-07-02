

### http请求地址和资源文件映射如下:
  
      /{application}/{profile}[/{label}]
      /{application}-{profile}.yml
      /{label}/{application}-{profile}.yml
      /{application}-{profile}.properties
      /{label}/{application}-{profile}.properties
      
## 参数解释
> application: 应用名称，如配置文件 user-dev.properties,这里指的就是 "user"
> profile: 环境变量，如配置文件 user-dev.properties,这里指的就是 "dev"
> label: Git仓库分支名称，如master、test等

## http访问示例
> http://localhost:9006/address/dev/master
>
> 还原后的意思就是，访问 master 分支的配置文件 address-dev.properties 
> 其他的雷同；