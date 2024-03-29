package com.rish.spring.database.repository;

import com.rish.spring.bpp.Auditing;
import com.rish.spring.bpp.Transaction;
import com.rish.spring.database.entity.Company;
import com.rish.spring.database.pool.ConnectionPool;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

//import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Optional;

@Slf4j
@Repository
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
@Transaction
@Auditing
@RequiredArgsConstructor
public class CompanyRepository implements CrudRepository<Integer, Company>{

//    @Resource(name = "pool1")
//    @Autowired
//    @Qualifier("pool1")
    private final ConnectionPool pool1;

    private final List<ConnectionPool> pools;

    @Value("${db.pool.size}")
    private final Integer poolSize;


    @PostConstruct
    private void init(){
        log.warn("init company repository");
    }


    @Override
    public Optional<Company> findById(Integer id) {
        System.out.println("findById method...");
        return Optional.of(new Company(id));
    }

    @Override
    public void delete(Company entity) {
        System.out.println("delete method...");
    }
}
