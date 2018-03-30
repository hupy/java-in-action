package cn.xingoo.jdk.nio;

import java.io.IOException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class SelectorTest2 {
    public static void main(String[] args) throws IOException {
        Selector selector = Selector.open();
        SocketChannel channel = SocketChannel.open();
        channel.configureBlocking(false);
        //SelectionKey key = channel.register(selector, SelectionKey.OP_READ);
        while(true){
            int readyChannels = selector.select();
            if(readyChannels == 0) {
                continue;
            }

            Set<SelectionKey> selectedKeys = selector.selectedKeys();
            Iterator keyIterator = selectedKeys.iterator();
            while(keyIterator.hasNext()){
                SelectionKey key = (SelectionKey) keyIterator.next();
                if(key.isAcceptable()){
                    //
                } else if (key.isConnectable()){

                } else if (key.isReadable()){

                } else if (key.isWritable()){

                }
                keyIterator.remove();
            }
        }
    }
}
