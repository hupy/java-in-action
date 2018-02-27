package cn.xingoo.learn.nio;

import java.io.IOException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class SelectorTest {
    public static void main(String[] args) throws IOException {
        Selector selector = Selector.open();

        SocketChannel socketChannel = null;
        socketChannel.configureBlocking(false);//selector时，channel需要时非阻塞的
        SelectionKey selectionKey = socketChannel.register(selector,SelectionKey.OP_READ);

        // connect, accept, read, write
        //int interestSet = SelectionKey.OP_READ | SelectionKey.OP_WRITE;

        // 检测感兴趣的操作
        int interestSet = selectionKey.interestOps();
        boolean isInterestedInAccept    = (interestSet & SelectionKey.OP_ACCEPT)  == SelectionKey.OP_ACCEPT;
        boolean isInterestedInConnect   = (interestSet & SelectionKey.OP_CONNECT) == SelectionKey.OP_CONNECT;
        boolean isInterestedInRead      = (interestSet & SelectionKey.OP_READ)    == SelectionKey.OP_READ;
        boolean isInterestedInWrite     = (interestSet & SelectionKey.OP_WRITE)   == SelectionKey.OP_WRITE;

        // 检测准备就绪的操作
        int readySet = selectionKey.readyOps();

        // 检测什么事件就绪
        selectionKey.isAcceptable();
        selectionKey.isConnectable();
        selectionKey.isReadable();
        selectionKey.isWritable();

        // 附加对象
        selectionKey.attach("a");
        String tag = (String) selectionKey.attachment();

        Set<SelectionKey> selectedKeys = selector.selectedKeys();
        Iterator keyIterator = selectedKeys.iterator();
        while(keyIterator.hasNext()){
            SelectionKey key = (SelectionKey) keyIterator.next();
            if(key.isAcceptable()){
                //
            }else if(key.isConnectable()){

            }else if(key.isReadable()){

            }else if(key.isWritable()){

            }
            keyIterator.remove();
        }

    }
}
