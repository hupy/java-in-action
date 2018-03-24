
Channel类似Nio的Channel，Unsafe是内部的网络接口实现。

# Channel相关内容

为什么要自己写Channel：

- SocketChannel和ServerSocketChannel没有统一的操作接口
- SPI类接口实现难度大
- 需要与Netty框架融合，支持各种参数定义

因此，自己实现了Channel：

- 采用Facade模式，统一封装
- 抽象公共类
- 具体实现采用聚合方式

源码学习：

- AbstractChannel：聚合各种组件，如parent、id、unsafe、pipeline
- AbstractNioChannel：消息的各种事件，selectableChannel、selectionKey
- AbstractNioByteChannel：flushTask消息发送
- AbstractNioMessageChannel：消息发送，只不过发送的是POJO对象
- NioServerSocketChannel：消息接收，doReadMessages，创建NioSocketChannel进行连接
- NioSocketChannel：消息读写

# Unsafe相关内容

是Channel的辅助接口，不想暴露给用户的，真正负责IO操作。

源码学习：

- AbstractUnsafe：负责把channel注册到EventLoop的多路复用器上，跟线程有关。如果是当前线程，则直接注册；如果不是，则放入队列中。（这块不太明白）
bind()负责绑定端口；disconnect()；close()；write()；flush()
- AbstractNioUnsafe：connect()
- NioByteUnsafe：read()

