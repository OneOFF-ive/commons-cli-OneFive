# commons-cli-OneFive
在[Apache Commons CLI](https://mvnrepository.com/artifact/commons-cli/commons-cli/1.5.0)的基础上进行封装，更加方便本人开发使用  

需要添加[Apache Commons CLI](https://mvnrepository.com/artifact/commons-cli/commons-cli/1.5.0)依赖  

```gradle
dependencies {
    implementation 'commons-cli:commons-cli:1.5.0'
    implementation 'com.github.OneOFF-ive:commons-cli-OneFive:v2.0.0'
}
```
最新的发布版本可以在[JitPack](https://jitpack.io/#OneOFF-ive/commons-cli-OneFive)查看  

使用说明：
建议在使用前首先阅读[Apache Commons CLI](https://mvnrepository.com/artifact/commons-cli/commons-cli/1.5.0)的官方使用说明，该项目只是在原工具的基础上优化使用方法。  

获取实例
```java
var myCli = MyCli.getInstance();
```  
使用addOption方法添加一个命令行选项,并且为其添加回调函数
```java
void addOption(Option option, Consumer<Object[]> callback)
```  
使用parseOptions方法处理所有命令行选项
```java
void parseAllOptions(String[] args)
```