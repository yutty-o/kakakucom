package kakakucom;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@Configuration
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
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
