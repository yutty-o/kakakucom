package kakakucom;


import kakakucom.component.exception.ExceptionProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableCaching
public class AppConfig {
    @Autowired
    DataSourceProperties dataSourceProperties;
    DataSource dataSource;

    @Bean
    DataSource dataSource() {
        DataSourceBuilder factory = DataSourceBuilder
            .create(this.dataSourceProperties.getClassLoader())
            .url(this.dataSourceProperties.getUrl())
            .username(this.dataSourceProperties.getUsername())
            .password(this.dataSourceProperties.getPassword());
        this.dataSource = factory.build();
        return this.dataSource;
    }

    @Bean
    ExceptionProvider exceptionProvider() {
        return new ExceptionProvider();
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
}
