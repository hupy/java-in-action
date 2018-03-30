package cn.xingoo.book.zook.chap5;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

public class ZooKeeper_Contructor_Usage implements Watcher {

    private static CountDownLatch connectedSemaphore = new CountDownLatch(1);

    public static void main(String[] args) throws IOException {
        ZooKeeper zookeeper = new ZooKeeper("localhost:2181",5000,new ZooKeeper_Contructor_Usage());
    }

    @Override
    public void process(WatchedEvent watchedEvent) {

    }
}
