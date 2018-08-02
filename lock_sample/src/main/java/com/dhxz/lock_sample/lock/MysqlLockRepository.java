package com.dhxz.lock_sample.lock;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface MysqlLockRepository extends CrudRepository<MysqlLock,String> {
    Optional<MysqlLock> findByLock(String lock);
}
