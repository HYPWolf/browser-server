# Alaya 区块链浏览器服务端
> 提供对alaya链的浏览功能，包括区块、交易、验证节点、治理参数、令牌等功能

## 软件架构

- [架构文档](docs/arch_doc/overall_structure.md)
- [接口文档](https://platonnetwork.github.io/browser-server/)

## 使用技术

- gradle
- junit
- mockito
- spring,springboot
- mybatis
- logback
- client-sdk(web3j)

## 项目结构

- browser-agent：区块同步服务，将特殊节点数据同步到区块链浏览器的数据库中。
- browser-api：浏览器api服务，对web页面提供api接口。
- browser-common：通用模块
- browser-export：用于报表导出的令行客户端
- browser-generator：mybatis骨架生成
- browser-press：用于生成压测数据
- browser-service：通用服务模块
- browser-sync：将区块交易同步到redis的工具
- browser-test：测试类，用于创建合约
- docs：接口文档

## 打包
### browser-agent的打包

```bash
gradlew clean buildTar -x test -b browser-agent/build.gradle
```

### browser-api的打包

```bash
gradlew clean buildTar -x test -b browser-api/build.gradle
```