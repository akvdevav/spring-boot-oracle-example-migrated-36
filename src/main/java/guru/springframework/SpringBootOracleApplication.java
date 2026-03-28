package guru.springframework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

@SpringBootApplication
public class SpringBootOracleApplication {

	public static void main(String[] args) {
		// Override the default physical naming strategy to avoid class‑loading issues with
		// org.springframework.boot.orm.jpa.hibernate.SpringPhysicalNamingStrategy which is not
		// present in the current Spring Boot version.
		System.setProperty(
				"spring.jpa.hibernate.naming.physical-strategy",
				"org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl"
		);
		SpringApplication.run(SpringBootOracleApplication.class, args);
	}

	/**
	 * Explicitly configure the PostgreSQL DataSource.
	 * This overrides any auto‑configuration that might attempt to use a legacy Oracle driver.
	 */
	@Bean
	public DataSource dataSource() {
		return DataSourceBuilder.create()
				.driverClassName("org.postgresql.Driver")
				.url("jdbc:postgresql://localhost:5432/postgres")
				.username("postgres")
				.password("postgres")
				.build();
	}
}