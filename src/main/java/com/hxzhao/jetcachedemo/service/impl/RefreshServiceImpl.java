package com.hxzhao.jetcachedemo.service.impl;

import com.alicp.jetcache.anno.CacheRefresh;
import com.alicp.jetcache.anno.CacheType;
import com.alicp.jetcache.anno.Cached;
import com.hxzhao.jetcachedemo.service.IRefreshService;
import org.springframework.stereotype.Service;


@Service
public class RefreshServiceImpl implements IRefreshService {

    @Override
    @Cached(name = "refreshCache", key = "'randomContent'", cacheType = CacheType.BOTH)
    @CacheRefresh(refresh = 60, stopRefreshAfterLastAccess = 300)
    public String getContent() {
        return String.valueOf(System.currentTimeMillis());
    }
}
