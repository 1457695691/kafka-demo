package com.lh.kafka.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 数据库基本配置
 * 走配置中心，无需走文件
 *
 * @PropertySource(value={"classpath:jdbc.properties"})
 */

@Configuration
public class DiySourceConfig {

    @Value("${config.jdbc.driver}")
    private String driver;
    @Value("${config.jdbc.url}")
    private String url;
    @Value("${config.jdbc.username}")
    private String username;
    @Value("${config.jdbc.password}")
    private String password;

    @Value("${config.jdbc.druid.initialSize}")
    private int initialSize;
    @Value("${config.jdbc.druid.maxActive}")
    private int maxActive;
    @Value("${config.jdbc.druid.minIdle}")
    private int minIdle;

    @Bean(name = "dataSource")
    public DruidDataSource dataSource() {
        DruidDataSource dataSource = DruidDataSourceBuilder.create().build();
        dataSource.setDriverClassName(driver);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        dataSource.setInitialSize(initialSize);
        dataSource.setMaxActive(maxActive);
        dataSource.setMinIdle(minIdle);
        dataSource.setTimeBetweenEvictionRunsMillis(100000L);
        try {
            dataSource.init();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dataSource;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getInitialSize() {
        return initialSize;
    }

    public void setInitialSize(int initialSize) {
        this.initialSize = initialSize;
    }

    public int getMaxActive() {
        return maxActive;
    }

    public void setMaxActive(int maxActive) {
        this.maxActive = maxActive;
    }

    public int getMinIdle() {
        return minIdle;
    }

    public void setMinIdle(int minIdle) {
        this.minIdle = minIdle;
    }
}