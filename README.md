1.更改数据库连接更改用户名密码kafka-dal/dalgen/config/config.xml
      <database name="test" class="com.mysql.cj.jdbc.Driver" type="mysql">
          <property name="url" value="jdbc:mysql://localhost:3306/test?characterEncoding=utf-8"/>
          <property name="userid" value="root"/>
          <property name="password" value="test123456"/>
      </database>

2.更改testTables文件下.xml后，进入终端
  cd kafka-dal
  mvn mybatis:gen
  输入表名 回车
  自动生成dao、mapper等文件，在service里直接用@Autowired引入对应DAO即可。

3.记得先启动Kafka服务！
