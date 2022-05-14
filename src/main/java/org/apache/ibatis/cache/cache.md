~~~~
# mybatis自带两级缓存，这两级缓存与mybatis及整个应用在同一块堆内存中，
需要缓存大量数据时，应该使用redis

二级缓存：
    TransactionalCache
    TransactionalCacheManager
~~~~