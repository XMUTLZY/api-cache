# Read Me
#### String
    /cache/string/add   PUT   添加缓存数据 @Params:member、key、value
    /cache/string/get   POST    获取缓存数据 @Params:member、key
    /cache/string/delete   POST   删除缓存数据 @Params:member、key

#### List
    /cache/list/add   PUT   添加一个List或插入元素（左or右） @Params:member、key、value_list、operate_type
    /cache/list/get-range   POST    获取对应区间的元素 @Params:member、key、start(起始)、end(终止)
    /cache/list/get-one   POST    出栈元素(左or右) @Params:member、key、operate_type
    /cache/list/update-by-index   POST    修改key对应list指定下标index的元素 @Params:member、key、index、instead_value(替代的元素)
    /cache/list/get-by-index    POST    获取key对应list指定下标index的元素 @Params:member、key、index
    
#### Set
    /cache/set/add    PUT   添加一个set @Params:member、key、value_list
    /cache/set/get    POST    获取key对应的所有元素 @Params:member、key
    
#### Hash
    /cache/hash/add    PUT   添加一个hash  @Params:member、key、value_map
    /cache/hash/add-one    PUT    往Hash插入一个元素(key, value) @Params:member、key、new_key、new_value 
    /cache/hash/get     POST    获取Hash所有的元素  @Params:member、key
    
#### ZSort
    /cache/zsort/add    PUT   添加一个有序集  @Params:member、key、zsort_map
    /cache/zsort/add-one    PUT    插入一个元素 @Params:member、key、score、value
    
#### Key
    /key/is-exist    POST   判断key值是否存在  @Params:member、key
    /key/set-time    POST   设置键的生存时间(s) @Params:member、key、life_time
    /key/get-time    POST   获取键剩余的生存时间(s) @Params:member、key
    
#### tips: 只支持string数据类型，在需要使用对象时，需进行json转换
    demo: jedis.set("KEY",JSON.toJSONString(new User()));
          String str = jedis.get("key");
          User result = JSON.parseObject(str, User.class);
         
#### 管道技术，在批量添加和获取数据时提高效率
    /cache/batch/add    PUT   批量添加缓存数据  @Params:member、key_value_map
    /cache/batch/get   POST    批量获取缓存数据  @Params:member、key_list
      
#### 最新添加了mongo记录
     需要请自行在application.properites中配置
