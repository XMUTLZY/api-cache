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
