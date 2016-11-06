package cn.xingoo.es;

import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.sort.FieldSortBuilder;
import org.elasticsearch.search.sort.SortOrder;
import org.elasticsearch.transport.client.PreBuiltTransportClient;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.elasticsearch.index.query.QueryBuilders.*;

/**
 * Created by xxh on 2016/11/6.
 */
public class ESAgg {
    private static TransportClient client;
    static{
        Settings settings = Settings.builder().put("cluster.name", "es-5.0-test").build();

        client = new PreBuiltTransportClient(settings);
        try {
//            client = new TransportClient(settings);
            client.addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("10.10.3.101"), 9300));
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try{
            testIndex();
        }finally {
            client.close();
        }
    }

    public static void testScroll(){
        QueryBuilder qb = QueryBuilders.termQuery("multi", "test");
/*
        SearchResponse scrollResp = client.prepareSearch(test)
                .addSort(FieldSortBuilder.DOC_FIELD_NAME, SortOrder.ASC)
                .setScroll(new TimeValue(60000))
                .setQuery(qb)
                .setSize(100).execute().actionGet(); //max of 100 hits will be returned for each scroll
        do {
            for (SearchHit hit : scrollResp.getHits().getHits()) {
                //Handle the hit...
            }

            scrollResp = client.prepareSearchScroll(scrollResp.getScrollId()).setScroll(new TimeValue(60000)).execute().actionGet();
        } while(scrollResp.getHits().getHits().length != 0);*/
    }

    public static void testIndex() {
        for(int i=0;i<10;i++){
            Map<String, Object> json = new HashMap<String, Object>();
            json.put("user","test_"+i);
            json.put("age",new Random(47).nextInt(100));

            client.prepareIndex("test", "test", new Integer(i).toString())
                .setSource(json)
                .get();
        }
    }

}
