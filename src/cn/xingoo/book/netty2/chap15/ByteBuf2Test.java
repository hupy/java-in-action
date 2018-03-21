package cn.xingoo.book.netty2.chap15;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

public class ByteBuf2Test {
    public static void main(String[] args) {
        ByteBuf buf = Unpooled.buffer(5);
        Unpooled.directBuffer(5);

        System.out.println(buf);

        buf.writeBytes("123".getBytes());
        System.out.println(buf);

        buf.writeBytes("aaaaaaaaaaaaaaaaa".getBytes());
        System.out.println(buf);

    }
}
