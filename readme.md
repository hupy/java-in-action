
学习参考
![](https://github.com/xinghalo/JDK-Learning/blob/master/img/Jietu20180227-084502.jpg)

# io学习

io流是Java中最基本的数据读取和输出的工具方法，有字节流和字符流两种，即读取和写入的单位一个是字节，一个字符。
在程序中字符往往跟编码有关，有的字符对应的了几个字节不等，因此选择适合的方法要看操作的存储媒介内容是什么、属于什么编码。

除了各种各样的流之外，特别需要注意的是

- PipedInputStream可以用来在多线程之间交换数据；
- RandomAccessFile可以实现文件的随机读写；
- 尽量使用IOUils操作吧，原生的API不太友好

![](https://github.com/xinghalo/JDK-Learning/blob/master/img/IO流的关系图.png)

# nio学习

nio是新的io包 non-blocking IO，主要提供了channels和buffer，非阻塞模式，selector等。

目的：

- 基于Buffer缓存数据，更高效
- Channel去除了流的方向性，读写更随意
- Selector模式提供了单线程处理多个IO的能力，便于实现百万级并发的服务器程序
- 提供非阻塞模式，使得程序运行的更高效

![](https://github.com/xinghalo/JDK-Learning/blob/master/img/nio的selector.jpg)



- 参考《并发编程网》：http://ifeve.com/java-nio-all/

# 网络模型

- 聊聊同步、异步、阻塞与非阻塞：https://www.jianshu.com/p/aed6067eeac9
- 聊聊Linux 五种IO模型：https://www.jianshu.com/p/486b0965c296
- 5种网络IO模型（有图，很清楚）：https://www.cnblogs.com/findumars/p/6361627.html

# netty学习

![](https://github.com/xinghalo/JDK-Learning/blob/master/img/Jietu20180227-084552.jpg)

- 参考书籍：《netty实战》
- 参考应用：spark

