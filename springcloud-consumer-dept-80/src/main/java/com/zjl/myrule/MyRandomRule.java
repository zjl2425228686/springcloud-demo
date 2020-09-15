package com.zjl.myrule;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class MyRandomRule extends AbstractLoadBalancerRule {

    //每个服务，访问3次，换下一个服务
    private int total = 0;
    private int curr = 0;

    public Server choose(ILoadBalancer lb, Object key) {
        if (lb == null) {
            return null;
        }
        Server server = null;

        while (server == null) {
            if (Thread.interrupted()) {
                return null;
            }
            List<Server> upList = lb.getReachableServers();//获得活着的服务
            List<Server> allList = lb.getAllServers();//获得全部服务

            int serverCount = allList.size();
            if (serverCount == 0) {
                return null;
            }
            if (total >= 3) {
                total = 0;
                curr++;
                if (curr > upList.size() - 1) {
                    curr = 0;
                }
            }
            total++;
            server = upList.get(curr);
//            int index = chooseRandomInt(serverCount);//生成区间随机数
//            server = upList.get(index);//从活着的服务中，随机获取一个

            if (server == null) {
                Thread.yield();
                continue;
            }

            if (server.isAlive()) {
                return (server);
            }

            server = null;
            Thread.yield();
        }
        return server;
    }

    protected int chooseRandomInt(int serverCount) {
        return ThreadLocalRandom.current().nextInt(serverCount);
    }

    @Override
    public Server choose(Object key) {
        return choose(getLoadBalancer(), key);
    }

    @Override
    public void initWithNiwsConfig(IClientConfig clientConfig) {
    }
}
