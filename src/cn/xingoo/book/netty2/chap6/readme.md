## 评判一个序列化框架的优劣：

- Java本身的序列化无法跨语言、支持的语言种类是否丰富
- 编码后流的大小
- 编解码的性能
- 类库是否小巧，api使用是否方便
- 使用者需要手工开发的工作量和难度

## Google ProtoBuf

- 结构化存储
- 高效编解码
- 语言无关、平台无关、扩展性好
- 官方支持Java、C++、Python

## Facebook Thrift

- IDL编译器
- TProtocol: RPC协议层
- TTransport: RPC传输层
- TProcessor: 调度接口
- TServer: 聚合

针对编码来说，有通用的二进制编码、压缩的二进制编码、优化的压缩编码

## JBOSS Marshalling
