
# config client使用说明
> 启动eureka-server、启动config-server之后，再启动config-client
>
> config-client启动的端口使用的是git远端的server:port: 8889
> 
> git端更新了配置文件之后，使用Bus总线消息接口通知对应的client端：http://localhost:8889/actuator/bus-refresh
> 
> /actuator/bus-refresh接口可以指定服务，即使用"destination"参数，比如 “/actuator/bus-refresh?destination=customers:**” 即刷新服务名为customers的所有服务。
