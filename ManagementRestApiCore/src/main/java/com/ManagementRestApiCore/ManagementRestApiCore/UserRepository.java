package com.ManagementRestApiCore.ManagementRestApiCore;

import org.graalvm.compiler.lir.LIRInstruction.Use;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends MongoRepository<Use, Long>{

}