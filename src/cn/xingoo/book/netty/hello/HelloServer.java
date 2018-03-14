package cn.xingoo.book.netty.hello;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import java.nio.charset.Charset;

public class HelloServer {
    public static void main(String[] args) throws InterruptedException {
        final ByteBuf buffer = Unpooled.unreleasableBuffer(Unpooled.copiedBuffer("I'm ok!\r\n", Charset.forName("UTF-8")));

        NioEventLoopGroup bossGroup = new NioEventLoopGroup(1);
        NioEventLoopGroup workerGroup = new NioEventLoopGroup();

        ServerBootstrap bootstrap = new ServerBootstrap();

        try{
            bootstrap.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ChannelPipeline pipeline = ch.pipeline();
                            pipeline.addLast(new ChannelInboundHandlerAdapter(){
                                @Override
                                public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
                                    System.out.println("Server 接收信息");
                                    ByteBuf result = (ByteBuf)msg;
                                    System.out.println(ctx.channel().remoteAddress()+" said:"+result.toString(Charset.forName("UTF-8")));
                                    result.release();

                                    ctx.writeAndFlush(buffer);
                                }

                            });
                        }
                    });
            ChannelFuture f = bootstrap.bind(5555).sync();
            f.channel().closeFuture().sync();
        }finally {
            bossGroup.shutdownGracefully().sync();
            workerGroup.shutdownGracefully().sync();
        }
    }
}
