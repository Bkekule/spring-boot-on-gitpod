package bobo_master_spring.gitpod_version.demo.datasource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
public class PostgresDataSource {
    @Bean
    @ConfigurationProperties("app.datasource")
    public HikariDataSource hikariDataSource(){
        return DataSourceBuilder
        .create()
        .type(HikariDataSource.class)
        .build();
    }

    @Bean
    @Qualifier("hikari")
    public JdbcTemplate jdbcTemplate(HikariDataSource hikariDataSource){
        return new JdbcTemplate(hikariDataSource);
    }
}
