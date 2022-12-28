package ao.it.chandsoft.vagaemprego.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.orm.jpa.EntityManagerFactoryInfo;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Slf4j
@Component
public class DataBaseConfig {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    @EventListener(ApplicationReadyEvent.class)
    public void loadScriptSQL() {
        log.info("Executing script DDL + DML");
        EntityManagerFactoryInfo info = (EntityManagerFactoryInfo) entityManager.getEntityManagerFactory();
        ResourceDatabasePopulator resourceDatabasePopulator = new ResourceDatabasePopulator(
                true,
                false,
                "UTF-8",
                new ClassPathResource("ddl.sql"),
                new ClassPathResource("dml.sql")
        );
        resourceDatabasePopulator.execute(info.getDataSource());
        log.info("Script DDL + DML executed successefuly");
    }
}
