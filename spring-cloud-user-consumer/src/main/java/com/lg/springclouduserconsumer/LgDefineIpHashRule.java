package com.lg.springclouduserconsumer;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.List;

public class LgDefineIpHashRule extends AbstractLoadBalancerRule {
    private static Logger log = LoggerFactory.getLogger(LgDefineIpHashRule.class);

    public Server choose(ILoadBalancer lb,Object key){
        if(lb==null){
            return null;
        }else {
            Server server = null;
            while (server == null) {
                //获取可用的服务实例列表
                List<Server> upList = lb.getReachableServers();
                //获取所有的服务实例列表
                List<Server> allList = lb.getAllServers();
                int serverCount = allList.size();
                if (serverCount == 0) {
                    return null;
                }
                int index=ipAddressHash(serverCount);
                server = upList.get(index);
            }
            return server;
        }
    }
    private int ipAddressHash(int serverCount){
        ServletRequestAttributes requestAttributes=(ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        String remoteAddr=requestAttributes.getRequest().getRemoteAddr();
        int code=Math.abs(remoteAddr.hashCode());
        return code%serverCount;
    }

    @Override
    public Server choose(Object key) {
        return choose(getLoadBalancer(),key);
    }

    @Override
    public void initWithNiwsConfig(IClientConfig iClientConfig) {

    }
}
