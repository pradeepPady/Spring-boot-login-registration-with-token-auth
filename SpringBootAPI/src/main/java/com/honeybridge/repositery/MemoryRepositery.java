package com.honeybridge.repositery;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.honeybridge.beans.Memory;
import com.honeybridge.beans.MemoryStatus;

@Repository
public interface MemoryRepositery extends MongoRepository<Memory, String> {
	List<Memory> findByMemoryId(String id);
	List<Memory> findByMemoryStatus(MemoryStatus memoryStatus);
	List<Memory> findByIsAbusedMemory(boolean isAbused);
}
