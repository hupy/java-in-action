package cn.xingoo.book.zook.chap5;

import org.apache.zookeeper.*;

import java.io.IOException;

public class AuthSample_Get {
    final static String PATH = "/zk-book-auth-test";

    public static void main(String[] args) throws IOException, KeeperException, InterruptedException {
        ZooKeeper zooKeeper1 = new ZooKeeper("localhost:2181",5000,null);
        zooKeeper1.addAuthInfo("digest","foo:true".getBytes());
        zooKeeper1.create(PATH, "init".getBytes(), ZooDefs.Ids.CREATOR_ALL_ACL, CreateMode.EPHEMERAL);

        // 有权限
        ZooKeeper zooKeeper3 = new ZooKeeper("localhost:2181",5000,null);
        zooKeeper3.addAuthInfo("digest","foo:true".getBytes());
        zooKeeper3.getData(PATH, false, null);

        // 没权限
        ZooKeeper zooKeeper2 = new ZooKeeper("localhost:2181",5000,null);
        zooKeeper2.getData(PATH, false, null);
    }
}
