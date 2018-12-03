package com.honeybridge.controller;

import com.honeybridge.beans.Memory;

@org.springframework.stereotype.Service
public class Service {

	public Memory updating(Memory memory1) {
		Memory memory=new Memory();
		memory.setOwnerUserName(memory1.getOwnerUserName());
		memory.setAbusedMemory(memory1.isAbusedMemory());
		memory.setContributions(memory1.getContributions());
		memory.setDelete(memory1.isDelete());
		memory.setDescription(memory1.getDescription());
		return memory;
		
	}

	
	
	

}
