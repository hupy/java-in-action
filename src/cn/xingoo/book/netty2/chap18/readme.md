
单线程的Reactor模型：
单个线程效率不高、有风险

多线程模型：
专门的Acceptor线程，网络IO操作由线程池完成

主从模型：
Acceptor线程接收请求，然后一个线程池完成SocketChannel的读写和编解码的工作，后续的线程池负责真正的连接。

