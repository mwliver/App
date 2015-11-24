package pl.edu.agh.careSystemService.persistance.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Copyright (C) Coderion sp. z o.o
 */
@Configuration
@EnableJpaRepositories("pl.edu.agh.careSystemService.persistance.service")
public class ClientDaoConfiguration {
}
