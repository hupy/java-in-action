
单线程的Reactor模型：
单个线程效率不高、有风险

多线程模型：
专门的Acceptor线程，网络IO操作由线程池完成

主从模型：
Acceptor线程接收请求，然后一个线程池完成SocketChannel的读写和编解码的工作，后续的线程池负责真正的连接。

NioEventLoop处理两类任务：
1 系统Task
2 定时任务

NioEventLoop中定义了启动和Selector的代码，并包含有Selector空轮训重建的过程。
貌似使用cancelKey>256判断，不过什么时机触发canelkey自增，还没完全理解。

