# buried-vtx-demo


### 1. 前言
本人学习Vert.x的初衷是为了找一个Springboot的平替方案。

Spring系列不能说不好，只是这么多年看着它从一个打败EJB的轻量级框架逐渐“发胖”，只感叹“屠龙少年终成恶龙”这并不是我等希望看到的。当然了，Spring团队也意识到这个问题了，后面来了个Springboot，但味儿终究还是变了。

虽然现公司还是用的Springboot，但随着业务扩张带来的“微服务”治理问题大大提升了投入成本，令我一度觉得回归水平扩展的SOA架构也不失为一个较理想的解决方案。“穷”则变变则通，本着“要比Springboot更轻、更快，占用资源更少”这个想法去选型并最终就选择了Vert.x（听上去不太靠谱，但是一开始没有什么方向的时候也只能先这样做了）。

至于Vert.x是什么？这个我就不再多说了，网上的各路大神和官网（[https://vertx-china.github.io/](https://vertx-china.github.io/)）都写得很清楚了。它给我的感受是一开始很惊艳（无论是启动速度上还是性能上）。但用着用着又觉得有点晦涩，毕竟十几年的Spring人很难摆脱Spring的编程风格。而且对于第三方的支持也比Spring少，不支持的第三方对接时还需额外开发。直到现在4.x版本推出后，就觉得很多轻量化的应用直接用Vert.x做，得益于体积小、资源占用少、启动快等优点，Vert.x可以为IoT设备加入一些边缘扩展，对于部分定制化IoT开发非常有帮助。

但话又说回来，企业想使用Vert.x全面替代Springboot也是不太现实的（除非公司的技术选型一开始就是Vert.x，而且招来的开发人员都是响应式开发出身），毕竟在以市场为主导的国内生态，Springboot的地位还是不可撼动的。与其使用较为小众的技术，还不如能快速开发，且社区强大的Springboot回报率更高吧。
### 2. 结构说明
言归正传，本次是“自我”假设以收集埋点数据为基础需求搭建的，其实就是公开一个对外RESTful接口，让外部调用一下。代码已经上传到Gitee：[https://gitee.com/yzh0623/buried-vtx-demo](https://gitee.com/yzh0623/buried-vtx-demo)
项目结构如下：

```bash
.
|-- pom.xml		# Maven的pom.xml文件
|-- src
|   |-- main
|   |   |-- java
|   |   |   `-- io
|   |   |       `-- kida
|   |   |           |-- App.java	# 启动类
|   |   |           |-- components
|   |   |           |   |-- callback
|   |   |           |   |   `-- BootstrapCallback.java	# 启动回调
|   |   |           |   |-- configs
|   |   |           |   |   |-- BootstrapConfig.java		# 启动配置
|   |   |           |   |   |-- RouterConfig.java				# 路由配置
|   |   |           |   |   `-- YamlConfig.java					# yaml文件工具配置
|   |   |           |   |-- constants
|   |   |           |   |   `-- CommonConstants.java		# 系统常量
|   |   |           |   |-- routers
|   |   |           |   |   `-- RouterSet.java					# 路由通用接口
|   |   |           |   `-- utils
|   |   |           |       |-- db
|   |   |           |       |   `-- JOOQUtil.java				# JOOQ工具
|   |   |           |       |-- http
|   |   |           |       |   |-- IPUtil.java					# IP工具
|   |   |           |       |   `-- RespMsg.java				# 接口返回对象
|   |   |           |       |-- redis			
|   |   |           |       |   `-- RedisUtil.java			# redis客户端
|   |   |           |       |-- ref
|   |   |           |       |   `-- ReflectUtil.java		# ASM映射工具
|   |   |           |       `-- yaml
|   |   |           |           |-- YamlUtil.java				# yaml工具类
|   |   |           |           |-- annotations
|   |   |           |           |   `-- PropLoader.java	# yaml配置注解
|   |   |           |           `-- constants
|   |   |           |               `-- YamlConstants.java	# yaml常量类
|   |   |           |-- model
|   |   |           |   |-- DefaultCatalog.java
|   |   |           |   |-- Indexes.java
|   |   |           |   |-- Keys.java
|   |   |           |   |-- Tables.java
|   |   |           |   |-- Tools.java
|   |   |           |   `-- tables
|   |   |           |       |-- SysUserBuried.java
|   |   |           |       |-- converters
|   |   |           |       |   |-- Bindings.java
|   |   |           |       |   `-- Converters.java
|   |   |           |       |-- daos
|   |   |           |       |   `-- SysUserBuriedDao.java
|   |   |           |       |-- pojos
|   |   |           |       |   `-- SysUserBuried.java
|   |   |           |       `-- records
|   |   |           |           `-- SysUserBuriedRecord.java
|   |   |           |-- router
|   |   |           |   `-- SysUserBuriedRouter.java
|   |   |           `-- service
|   |   |               `-- SysUserBuriedService.java
|   |   `-- resources
|   |       |-- configs																# 配置文件夹
|   |       |   |-- bootstrap.yml											# 启动配置
|   |       |   `-- master														# master分支配置（特意做成类似Springboot的配置模式）
|   |       |       |-- application-datasource.yml		# 数据库配置
|   |       |       `-- application-redis.yml					# redis配置
|   |       |-- db																		# 数据库脚本文件
|   |       |   `-- migrations
|   |       |       `-- V1.0.00001__v20230413.11.23_CREATE_SYS_USER_BURIED.sql
|   |       `-- log4j2.xml														# log4j配置文件
|   `-- test
|       |-- java
|       |   `-- io
|       |       `-- kida
|       |           `-- SysUserBuriedTest.java				# 单元测试类
|       `-- resources
`-- target
```
项目整体结构如上图所示，在结构上与Springboot极为相似（没办法用了这么多年了，太过于顺手）。Java代码的分层是在io.kida根目录下有一个名为App.java的启动类，分层结构也是io.kida.router独立一层用于真实路由访问也就是Springboot的RestController，io.kida.service独立一层用于逻辑处理。至于io.kida.model是JOOQ组件自己生成的，它将dao、pojo等内容都生成在里面了，不然的话我又会io.kida.dao一层的了...ε=(´ο｀*)))唉。其余的与业务无关的内容都放到io.kida.components一层。

在配置文件方面受Springboot设计影响较深。所有的配置文件都将放在src/main/resources/configs目录底下。其中bootstrap.yml文件为启动配置基础文件，如下图：

```yaml
server: # 服务器
   name: buried_vtx_demo # 当前服务名称
   active: master
   port: <<server_port>> # 开放端口
   context: vtx # 上下文
   timeout: 120 # eventbus超时时间
   cron: 30000
   http:
      header: # header获取到的变量
      - x-requested-with
      - Access-Control-Allow-Origin
      - Access-Control-Allow-Header
      - origin
      - Content-Type
      - accept
      - phSessionToken
   event-bus:
      timeout: 10000 # 毫秒
thread: # 线程配置
   deploy:
      init: 16 # 初始化部署线程数
      max-size: 64 # 最大部署线程数
      pool-name: vtx-thread-pool # 线程池名称
   worker: 64 # 程序工作线程数
   init-pool-size: 32 # 阻塞线程数量，默认20
   eventloop-pool-size: 128 # Event Loop线程的数量
```
里面包括server的名称，需要读取的配置文件夹名称，服务端口......至于各个分支不同的配置可以单独提取出来，放到各个以分支命名的文件夹下。如下图：
```yaml
datasource: # 数据库配置
   host: <<database_ip>> #数据库地址
   port: <<database_port>> #数据库端口
   database-name: tools #操作库名称
   use-unicode: true #是否使用unicode编码
   character-encoding: utf8 #文字编码
   ssl-enable: false # 是否使用安全连接
   server-timezone: UTC # 指定时区
   url-head: 'jdbc:mysql:' #jdbc连接头
   driver-class-name: com.mysql.cj.jdbc.Driver #jdbc驱动类型
   jooq-name: org.jooq.meta.mysql.MySQLDatabase #数据库方言
   package-path: io.kida.model # jooq映射路径
   username: <<username>> #数据库登录用户名
   password: <<password>> # 数据库登录密码
   hikari: # hikariCP线程池处理参数（略）
      is-auto-commit: true
      allow-pool-suspension: true
      connection-test-query: SELECT 1
      pool-name: vtx_hikari_pool
      minimum-idle: 20
      maximum-pool-size: 200
      idle-timeout: 180000
      connection-timeout: 60000
      cache-prep-stmts: true
      prep-stmt-cache-size: 128
      prep-stmt-cache-sql-limit: 256
      use-server-prep-stmts: true
      use-local-session-state: true
      use-local-transaction-state: true
      rewrite-batched-statements: true
      cache-result-set-metadata: true
      cache-server-configuration: true
      elide-set-auto-commits: true
      maintain-time-stats: false
      allow-public-key-retrieval: true
```
```yaml
redis: # redis配置
   max-pool-size: 6000 # 线程池最大线程数
   max-pool-waiting: -1 # 最大线程池等待时间
   connection-string: redis://<<redis_ip>>:<<redis_port>>/<<redis_db>> # redis连接地址
   pool-recycle-timeout: 5000 # 线程池回收超时
   batch-num: 5000 # 批次处理条数
   max-waiting-handlers: 7000 # 等待操作
```
样例里面的数据库配置和redis配置如上图所示。

数据库脚本方面，由于之前是使用了Flyway做数据库版本控制的，但后来因为某些原因没用了。虽然组件没用了，但是脚本存放路径还是保留了src/main/resources/db/migrations。
最后还有log4j2的配置，这里请不要纠结为什么要用log4j，因为当初在学习的时候log4j还没有出事儿呢...只是个Demo还是保留它吧。
```xml
<?xml version="1.0" encoding="UTF-8"?>
<Configuration status="DEBUG">
  <Properties>
    <Property name="log.level.console">info</Property>
    <Property name="log.path"><<log_path>></Property>
    <Property name="project.name">buried_vtx_demo</Property>
  </Properties>
  <Appenders>
    <Console name="CONSOLE" target="SYSTEM_OUT">
      <ThresholdFilter level="${log.level.console}"
        onMatch="ACCEPT" onMismatch="DENY" />
      <PatternLayout
        pattern="%d{yyyy-MM-dd HH:mm:ss,SSS}:%4p %t (%F:%L) - %m%n" />
    </Console>
    <RollingFile name="ROLLING_FILE" ignoreExceptions="false"
      fileName="${log.path}/${project.name}.log"
      filePattern="${log.path}/$${date:yyyy-MM}/${project.name}-%d{yyyy-MM-dd}-%i.log.gz">
      <PatternLayout
        pattern="%d{yyyy-MM-dd HH:mm:ss,SSS}:%4p %t (%F:%L) - %m%n" />
      <Policies>
        <SizeBasedTriggeringPolicy size="300MB" />
      </Policies>
      <DefaultRolloverStrategy max="100" />
    </RollingFile>
  </Appenders>
  <Loggers>
    <Root level="${log.level.console}">
      <AppenderRef ref="CONSOLE" />
      <AppenderRef ref="ROLLING_FILE" />
    </Root>
  </Loggers>
</Configuration>
```
整套项目都是Maven项目，怎么能够不提一下pom.xml呢？
```xml
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
	<modelVersion>4.0.0</modelVersion>
	<groupId>io.kida</groupId>
	<artifactId>buried-vtx-demo</artifactId>
	<version>1.0.0</version>
	<name>buried-vtx-demo</name>
	<description>数据埋点vtx演示</description>

	<properties>
		<encoding.code>UTF-8</encoding.code>
		<project.build.sourceEncoding>${encoding.code}
		</project.build.sourceEncoding>
		<project.reporting.outputEncoding>${encoding.code}
		</project.reporting.outputEncoding>

		<vertx.version>3.9.0</vertx.version>
		<junit.version>4.13</junit.version>
		<jooq.version>3.13.2</jooq.version>
		<jooq.rx.version>5.1.1</jooq.rx.version>
		<mysql.version>8.0.19</mysql.version>
		<yaml.version>1.1.3</yaml.version>
		<log4j2.version>2.13.2</log4j2.version>
		<disruptor.version>3.4.2</disruptor.version>
		<jackson.version>4.7.0</jackson.version>
		<reflectasm.version>1.09</reflectasm.version>
		<hikari.version>3.4.5</hikari.version>

		<jdk.version>8</jdk.version>
		<maven.shade.version>2.4.2</maven.shade.version>
		<compiler.version>3.3</compiler.version>

		<main.class>io.kida.App</main.class>
	</properties>


	<dependencies>
		<!-- vertx核心代码包 -->
		<dependency>
			<groupId>io.vertx</groupId>
			<artifactId>vertx-core</artifactId>
			<version>${vertx.version}</version>
		</dependency>
		<!-- vertx web -->
		<dependency>
			<groupId>io.vertx</groupId>
			<artifactId>vertx-web</artifactId>
			<version>${vertx.version}</version>
		</dependency>
		<!-- vertx junit -->
		<dependency>
			<groupId>io.vertx</groupId>
			<artifactId>vertx-unit</artifactId>
			<version>${vertx.version}</version>
			<scope>test</scope>
		</dependency>
		<dependency>
			<groupId>junit</groupId>
			<artifactId>junit</artifactId>
			<version>${junit.version}</version>
			<scope>test</scope>
		</dependency>
		<!-- vertx redis -->
		<dependency>
			<groupId>io.vertx</groupId>
			<artifactId>vertx-redis-client</artifactId>
			<version>${vertx.version}</version>
		</dependency>
		<!-- vertx jdbc -->
		<dependency>
			<groupId>io.vertx</groupId>
			<artifactId>vertx-jdbc-client</artifactId>
			<version>${vertx.version}</version>
		</dependency>
		<!-- HikariCP -->
		<dependency>
			<groupId>com.zaxxer</groupId>
			<artifactId>HikariCP</artifactId>
			<version>${hikari.version}</version>
		</dependency>
		<!-- yaml配置读取 -->
		<dependency>
			<groupId>io.vertx</groupId>
			<artifactId>vertx-config-yaml</artifactId>
			<version>${vertx.version}</version>
		</dependency>
		<dependency>
			<groupId>io.vertx</groupId>
			<artifactId>vertx-config</artifactId>
			<version>${vertx.version}</version>
		</dependency>
		<!-- log4j2 -->
		<dependency>
			<groupId>org.apache.logging.log4j</groupId>
			<artifactId>log4j-api</artifactId>
			<version>${log4j2.version}</version>
		</dependency>
		<dependency>
			<groupId>org.apache.logging.log4j</groupId>
			<artifactId>log4j-core</artifactId>
			<version>${log4j2.version}</version>
		</dependency>
		<dependency>
			<groupId>org.apache.logging.log4j</groupId>
			<artifactId>log4j-slf4j-impl</artifactId>
			<version>${log4j2.version}</version>
		</dependency>
		<dependency>
			<groupId>org.apache.logging.log4j</groupId>
			<artifactId>log4j-jcl</artifactId>
			<version>${log4j2.version}</version>
		</dependency>
		<dependency>
			<groupId>org.apache.logging.log4j</groupId>
			<artifactId>log4j-jul</artifactId>
			<version>${log4j2.version}</version>
		</dependency>
		<dependency>
			<groupId>com.lmax</groupId>
			<artifactId>disruptor</artifactId>
			<version>${disruptor.version}</version>
		</dependency>
		<!-- jooq -->
		<dependency>
			<groupId>org.jooq</groupId>
			<artifactId>jooq</artifactId>
			<version>${jooq.version}</version>
		</dependency>
		<dependency>
			<groupId>io.github.jklingsporn</groupId>
			<artifactId>vertx-jooq-completablefuture-jdbc</artifactId>
			<version>${jooq.rx.version}</version>
		</dependency>
		<!-- mysql8 连接驱动 -->
		<dependency>
			<groupId>mysql</groupId>
			<artifactId>mysql-connector-java</artifactId>
			<version>${mysql.version}</version>
		</dependency>
		<!-- jackson -->
		<dependency>
			<groupId>com.englishtown.vertx</groupId>
			<artifactId>vertx-jersey-jackson</artifactId>
			<version>${jackson.version}</version>
		</dependency>
		<!-- reflectasm -->
		<dependency>
			<groupId>com.esotericsoftware.reflectasm</groupId>
			<artifactId>reflectasm</artifactId>
			<version>${reflectasm.version}</version>
		</dependency>
	</dependencies>

	<build>
		<plugins>
			<!-- maven compiler -->
			<plugin>
				<artifactId>maven-compiler-plugin</artifactId>
				<version>${compiler.version}</version>
				<configuration>
					<source>${jdk.version}</source>
					<target>${jdk.version}</target>
				</configuration>
			</plugin>

			<!-- yaml properties maven -->
			<plugin>
				<groupId>it.ozimov</groupId>
				<artifactId>yaml-properties-maven-plugin</artifactId>
				<version>${yaml.version}</version>
				<executions>
					<execution>
						<phase>initialize</phase>
						<goals>
							<goal>read-project-properties</goal>
						</goals>
						<configuration>
							<files>
								<file>src/main/resources/configs/master/application-datasource.yml</file>
							</files>
						</configuration>
					</execution>
				</executions>
			</plugin>

			<!-- jooq codegen -->
			<plugin>
				<groupId>org.jooq</groupId>
				<artifactId>jooq-codegen-maven</artifactId>
				<version>${jooq.version}</version>
				<executions>
					<execution>
						<goals>
							<goal>generate</goal>
						</goals>
					</execution>
				</executions>
				<dependencies>
					<dependency>
						<groupId>io.github.jklingsporn</groupId>
						<artifactId>vertx-jooq-generate</artifactId>
						<version>${jooq.rx.version}</version>
					</dependency>
				</dependencies>
				<configuration>
					<jdbc>
						<driver>${datasource.driver-class-name}</driver>
						<url>${datasource.url-head}//${datasource.host}:${datasource.port}/${datasource.database-name}?useUnicode=${datasource.use-unicode}%26characterEncoding=${datasource.character-encoding}%26useSSL=${datasource.ssl-enable}%26serverTimezone=${datasource.server-timezone}</url>
						<user>${datasource.username}</user>
						<password>${datasource.password}</password>
					</jdbc>
					<generator>
						<name>io.github.jklingsporn.vertx.jooq.generate.completablefuture.CompletableFutureJDBCVertxGenerator
						</name>
						<database>
							<name>${datasource.jooq-name}</name>
							<includes>.*</includes>
							<excludes>flyway_schema_history</excludes>
							<inputSchema>${datasource.database-name}</inputSchema>
						</database>
						<generate>
							<pojos>true</pojos>
							<javaTimeTypes>true</javaTimeTypes>
							<daos>true</daos>
							<fluentSetters>true</fluentSetters>
						</generate>
						<target>
							<packageName>${datasource.package-path}</packageName>
							<directory>src/main/java</directory>
						</target>
						<strategy>
							<name>io.github.jklingsporn.vertx.jooq.generate.VertxGeneratorStrategy
							</name>
						</strategy>
					</generator>
				</configuration>
			</plugin>

			<!-- maven shade -->
			<plugin>
				<groupId>org.apache.maven.plugins</groupId>
				<artifactId>maven-shade-plugin</artifactId>
				<version>${maven.shade.version}</version>
				<executions>
					<execution>
						<phase>package</phase>
						<goals>
							<goal>shade</goal>
						</goals>
						<configuration>
							<transformers>
								<transformer implementation="org.apache.maven.plugins.shade.resource.ManifestResourceTransformer">
									<manifestEntries>
										<Main-Class>${main.class}</Main-Class>
									</manifestEntries>
								</transformer>
								<transformer implementation="org.apache.maven.plugins.shade.resource.AppendingTransformer">
									<resource>META-INF/services/io.vertx.core.spi.VerticleFactory
									</resource>
								</transformer>
							</transformers>
							<outputFile>${project.build.directory}/${project.artifactId}-${project.version}-prod.jar
							</outputFile>
						</configuration>
					</execution>
				</executions>
			</plugin>
		</plugins>
	</build>
</project>
```
pom文件中用的三个插件需要提一下的，他们分别是yaml-properties-maven-plugin、jooq-codegen-maven和maven-shade-plugin。

先说yaml-properties-maven-plugin，这个插件能让pom中的变量读取配置文件配置，如下图：
```xml
<plugin>
  <groupId>it.ozimov</groupId>
  <artifactId>yaml-properties-maven-plugin</artifactId>
  <version>${yaml.version}</version>
  <executions>
    <execution>
      <phase>initialize</phase>
      <goals>
        <goal>read-project-properties</goal>
      </goals>
      <configuration>
        <files>
          <file>src/main/resources/configs/master/application-datasource.yml</file>
        </files>
      </configuration>
    </execution>
  </executions>
</plugin>
```
如上图所示，execution -> goal中配置了read-project-properties（读取项目配置）参数，在下方就能够通过configuration -> files -> file去指定被读取的文件，这里是“src/main/resources/configs/master/application-datasource.yml”，至于有小伙伴可能会问，这里能不能做成动态的呢？毕竟启动环境不一样路径也不一样。可以的，但是就需要借助一下其他手段了，方法多的是。

配置了yaml-properties-maven-plugin之后，我们怎样将配置文件内容读取到pom里面呢？这时，我们就可以看看jooq-codegen-maven的展示
```xml
<!-- jooq -->
<dependency>
  <groupId>org.jooq</groupId>
  <artifactId>jooq</artifactId>
  <version>${jooq.version}</version>
</dependency>
<dependency>
  <groupId>io.github.jklingsporn</groupId>
  <artifactId>vertx-jooq-completablefuture-jdbc</artifactId>
  <version>${jooq.rx.version}</version>
</dependency>

......

<!-- jooq codegen -->
<plugin>
  <groupId>org.jooq</groupId>
  <artifactId>jooq-codegen-maven</artifactId>
  <version>${jooq.version}</version>
  <executions>
    <execution>
      <goals>
        <goal>generate</goal>
      </goals>
    </execution>
  </executions>
  <dependencies>
    <dependency>
      <groupId>io.github.jklingsporn</groupId>
      <artifactId>vertx-jooq-generate</artifactId>
      <version>${jooq.rx.version}</version>
    </dependency>
  </dependencies>
  <configuration>
    <jdbc>
      <driver>${datasource.driver-class-name}</driver>
      <url>${datasource.url-head}//${datasource.host}:${datasource.port}/${datasource.database-name}?useUnicode=${datasource.use-unicode}%26characterEncoding=${datasource.character-encoding}%26useSSL=${datasource.ssl-enable}%26serverTimezone=${datasource.server-timezone}</url>
      <user>${datasource.username}</user>
      <password>${datasource.password}</password>
    </jdbc>
    <generator>
      <name>io.github.jklingsporn.vertx.jooq.generate.completablefuture.CompletableFutureJDBCVertxGenerator
      </name>
      <database>
        <name>${datasource.jooq-name}</name>
        <includes>.*</includes>
        <excludes>flyway_schema_history</excludes>
        <inputSchema>${datasource.database-name}</inputSchema>
      </database>
      <generate>
        <pojos>true</pojos>
        <javaTimeTypes>true</javaTimeTypes>
        <daos>true</daos>
        <fluentSetters>true</fluentSetters>
      </generate>
      <target>
        <packageName>${datasource.package-path}</packageName>
        <directory>src/main/java</directory>
      </target>
      <strategy>
        <name>io.github.jklingsporn.vertx.jooq.generate.VertxGeneratorStrategy
        </name>
      </strategy>
    </generator>
  </configuration>
</plugin>
```
JOOQ是一个比较优秀的ORM组件，它也能够提供代码生成功能，如上图所示。executions -> execution -> goals -> goal配置成generate表示用于生成代码，在这个基础上加入vertx-jooq-generate依赖。在下方配置jdbc信息。
```xml
<configuration>
  <jdbc>
    <driver>${datasource.driver-class-name}</driver>
    <url>${datasource.url-head}//${datasource.host}:${datasource.port}/${datasource.database-name}?useUnicode=${datasource.use-unicode}%26characterEncoding=${datasource.character-encoding}%26useSSL=${datasource.ssl-enable}%26serverTimezone=${datasource.server-timezone}</url>
    <user>${datasource.username}</user>
    <password>${datasource.password}</password>
  </jdbc>
  <generator>
    <name>io.github.jklingsporn.vertx.jooq.generate.completablefuture.CompletableFutureJDBCVertxGenerator
    </name>
    <database>
      <name>${datasource.jooq-name}</name>
      <includes>.*</includes>
      <excludes>flyway_schema_history</excludes>
      <inputSchema>${datasource.database-name}</inputSchema>
    </database>
    <generate>
      <pojos>true</pojos>
      <javaTimeTypes>true</javaTimeTypes>
      <daos>true</daos>
      <fluentSetters>true</fluentSetters>
    </generate>
    <target>
      <packageName>${datasource.package-path}</packageName>
      <directory>src/main/java</directory>
    </target>
    <strategy>
      <name>io.github.jklingsporn.vertx.jooq.generate.VertxGeneratorStrategy
      </name>
    </strategy>
  </generator>
</configuration>
```
在这里面的${datasource.driver-class-name}就是读取配置文件的内容，是不是非常方便呢。在下面只需要配置生成内容和目标路径即可完成自动代码生成配置。如下图；
```xml
<generate>
  <pojos>true</pojos>
  <javaTimeTypes>true</javaTimeTypes>
  <daos>true</daos>
  <fluentSetters>true</fluentSetters>
</generate>
<target>
  <packageName>${datasource.package-path}</packageName>
  <directory>src/main/java</directory>
</target>
```
最后，我们再说一下Vert.x的打包，这里我选用的是maven-shade-plugin插件进行maven打包。通过transformers -> transformer -> manifestEntries -> Main-Class指定启动类，通过outputFile指定宝输出目录和命名。至于META-INF/services/io.vertx.core.spi.VerticleFactory是固定的配置，我这边是没有改的。
### 3. 开源软件声明
通过上面对pom.xml的介绍大伙儿多多少少都能够看到使用了那些开源组件了

| 组件名称 | 版本 | 作用 |
| --- | --- | --- |
| Vert.x | 3.9.0 | Vert.x是一个基于JVM的响应式应用程序框架，它允许您轻松地编写高性能、高可扩展性和易于维护的应用程序。Vert.x的核心是一个事件循环，它提供了异步I/O、事件驱动和非阻塞的API，可以用于构建各种类型的应用程序，包括Web应用程序、RESTful服务、消息系统、流处理和微服务等。它还提供了多种编程语言的支持，包括Java、Kotlin、Scala、Groovy和JavaScript等。Vert.x的目标是为开发者提供一个易于使用、高性能、灵活且可扩展的框架，使开发者能够快速地构建现代化的应用程序。 |
| JUnit | 4.13 | JUnit是一个用于Java编程语言的测试框架，它提供了注解和断言等工具，用于编写和运行单元测试。JUnit是由Erich Gamma和Kent Beck创建的，并在Apache许可证下发布。JUnit主要用于单元测试，它可以自动化地执行测试，并将测试结果以报告的形式呈现。JUnit可以帮助开发人员提高代码质量、减少错误和缺陷，并简化代码的维护和重构。除了Java之外，JUnit还可以用于其他编程语言，如C#和Python等。 |
| JOOQ | 3.13.2（由于我们用的是MySQL数据库，因此用免费版就可以了） | JOOQ是一种Java对象关系映射（ORM）框架，它允许使用Java编程语言进行类型安全的SQL查询。JOOQ（Java对象查询语言）提供了一种类型安全的方式来编写SQL查询，它不仅提供了ORM框架的一些好处，如编写简单、易于维护的代码，而且还提供了一些更强大的功能，如支持复杂的SQL查询、查询结果的类型安全和流式查询等。JOOQ使用Java代码表示SQL查询，这样可以在编译时就检查语法错误，而不是在运行时出现错误。此外，JOOQ还提供了一些工具和API来支持数据库架构演化和版本控制，使得应用程序可以更轻松地适应数据库结构的变化。 |
| MySQL | 8.0.19 | 使用对应的MySQL Community Server版本即可 |
| Yaml-Properties-Maven-Plugin | 1.1.3 | 这是一个Maven插件，用于将YAML文件转换为Java Properties文件。它可以方便地将YAML格式的配置文件转换为Java Properties格式，以便在Java应用程序中使用。它支持将一个或多个YAML文件转换为一个或多个Properties文件，并且可以通过Maven命令行或在Maven项目的pom.xml文件中进行配置。这个插件通常被用于将YAML格式的配置文件转换为Spring Boot应用程序所需的application.properties文件。 |
| Log4j2 | 2.13.2（实际使用时可能要考虑漏洞问题） | Log4j2是一个开源的Java日志框架，是Log4j框架的升级版。它提供了更好的性能和灵活性，并且支持更多的应用场景。 |
| Disruptor | 3.4.2 | Disruptor是一个高性能的无锁并发框架，主要用于解决高并发、低延迟的业务场景。 |
| Jackson | 4.7.0 | Jackson是一个用于Java平台的流行JSON解析器和生成器库。它提供了一组API来读取和写入JSON格式数据，包括支持JSON数据和Java对象之间的转换。Jackson可以通过多种方式使用，包括注解和XML配置。它是一个高性能的库，可在大规模应用程序中使用。Jackson还提供了对XML和YAML格式的支持。 |
| ReflectASM | 1.09 | ReflectASM是一个基于ASM库的Java库，用于快速反射Java对象。它提供了一个高性能的替代Java反射的方案。相比Java反射，ReflectASM使用ASM在编译期生成的字节码来访问Java对象的方法和字段，从而提高了性能。使用ReflectASM，可以显着提高访问Java对象的性能，特别是在需要反射访问大量对象的情况下。ReflectASM还支持访问非公共的Java对象方法和字段。 |
| HikariCP | 3.4.5 | HikariCP是一个开源的高性能轻量级连接池，适用于Java应用程序，它提供了比其他连接池更快速和更可靠的数据库连接管理。HikariCP的设计目标是最小化数据库连接等待时间，最大化应用程序吞吐量。它是目前市场上使用最广泛的连接池之一，因为它比其他连接池拥有更好的性能和更低的资源消耗。 |