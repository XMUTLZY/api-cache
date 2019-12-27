package sch.xmut.jake.cache.apicache.service.aopRecord;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sch.xmut.jake.cache.apicache.Document.RedisLogDoc;
import sch.xmut.jake.cache.apicache.http.request.RecordRequest;

/**
 * Created by Jake.lin on 2019/12/25
 */
@Service
public class RecordService {
    @Autowired
    private MongoTemplate mongoTemplate;

    @Transactional
    public RedisLogDoc insert(RecordRequest recordRequest) {
        RedisLogDoc redisLogDoc = new RedisLogDoc();
        BeanUtils.copyProperties(recordRequest, redisLogDoc);
        return mongoTemplate.save(redisLogDoc);
    }

}
