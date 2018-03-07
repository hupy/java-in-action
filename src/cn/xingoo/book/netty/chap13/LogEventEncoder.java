package cn.xingoo.book.netty.chap13;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.socket.DatagramPacket;
import io.netty.handler.codec.MessageToMessageEncoder;
import io.netty.util.CharsetUtil;

import java.net.InetSocketAddress;
import java.util.List;

public class LogEventEncoder extends MessageToMessageEncoder<LogEvent> {

    private final InetSocketAddress address;

    public LogEventEncoder(InetSocketAddress address){
        this.address = address;
    }

    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, LogEvent logEvent, List<Object> list) throws Exception {
        byte[] file = logEvent.getLogfile().getBytes(CharsetUtil.UTF_8);
        byte[] msg  = logEvent.getMsg().getBytes(CharsetUtil.UTF_8);

        ByteBuf buf = channelHandlerContext.alloc().buffer(file.length+msg.length+1);
        buf.writeBytes(file);
        buf.writeByte(LogEvent.SEPARATOR);
        buf.writeBytes(msg);

        list.add(new DatagramPacket(buf,address));
    }
}
