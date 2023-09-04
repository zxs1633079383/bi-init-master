package com.yupi.springbootinit.manager;


import com.yupi.springbootinit.common.ErrorCode;
import com.yupi.springbootinit.exception.BusinessException;
import org.redisson.api.RRateLimiter;
import org.redisson.api.RateIntervalUnit;
import org.redisson.api.RateType;
import org.redisson.api.RedissonClient;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/***
 * redission 红锁进行限流
 */
@Service
public class RedisLimiterManger {

    @Resource
    private RedissonClient redissonClient;

    /***
     *  区分不同的限流,不同的用户id分别统计
     * @param key
     */
    public void doRateLimit(String key){
        RRateLimiter rateLimiter = redissonClient.getRateLimiter(key);
        // 每秒最多5次
        rateLimiter.trySetRate(RateType.OVERALL,2,1,RateIntervalUnit.SECONDS);
        // 拿取令牌
        boolean flag = rateLimiter.tryAcquire(1);
        if(!flag){
            throw new BusinessException(ErrorCode.TOO_MANY_REQUEST);
        }else{
            System.out.println("获取成功令牌: " + flag);
        }




    }


}
