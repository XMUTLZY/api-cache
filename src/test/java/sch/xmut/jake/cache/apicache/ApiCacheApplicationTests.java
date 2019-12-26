package sch.xmut.jake.cache.apicache;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import sch.xmut.jake.cache.apicache.web.utils.SystemUtils;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

class ApiCacheApplicationTests {
    public static void main(String[] args) {
        MongoClient mongoClient = new MongoClient("106.15.207.108", 27017);//连接mongo服务器
        MongoDatabase mongoDatabase = mongoClient.getDatabase("redis_logs");//获取数据库
        mongoDatabase.createCollection("test_collect");//创建集合
        MongoCollection<Document> mongoCollection = mongoDatabase.getCollection("test_collect");//获取集合

        /** 插入文档 */
        Document document = new Document("project", "Image")
                .append("params", "{\"key:\":123}")
                .append("url", "/string/cache/put")
                .append("contentType", "application/json")
                .append("method", "POST")
                .append("create_time", SystemUtils.dateToFormat(new Date()));
        List<Document> documentList = Arrays.asList(document);
        mongoCollection.insertMany(documentList);
        System.out.println("文档插入成功");

        /** 更新文档 */
        mongoCollection.updateMany(Filters.eq("url", "/string/cache/put"), new Document("$set",new Document("url", "/string/cache/get")));

        /** 查询文档 */
        FindIterable<Document> findIterable = mongoCollection.find(); //获取迭代器
        MongoCursor<Document> mongoCursor = findIterable.iterator(); //通过迭代器获取游标
        while (mongoCursor.hasNext()) {
            System.out.println(mongoCursor.next());
        }
    }
}
