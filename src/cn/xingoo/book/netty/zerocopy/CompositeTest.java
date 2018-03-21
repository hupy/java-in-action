package cn.xingoo.book.netty.zerocopy;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.CompositeByteBuf;
import io.netty.buffer.Unpooled;

public class CompositeTest {
    public static void main(String[] args) {
        //组合缓冲区
        CompositeByteBuf compBuf = Unpooled.compositeBuffer();

        ByteBuf header = Unpooled.buffer(8);
        header.writeBytes("aaaabbbb".getBytes());

        ByteBuf body = Unpooled.buffer(8);
        body.writeBytes("11112222".getBytes());

        //添加ByteBuf到CompositeByteBuf
        compBuf.addComponents(header, body);

        System.out.println(compBuf.toString());
    }
}
