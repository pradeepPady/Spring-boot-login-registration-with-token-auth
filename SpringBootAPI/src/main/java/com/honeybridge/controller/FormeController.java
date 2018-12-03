package com.honeybridge.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.honeybridge.beans.FormeProfile;
import com.honeybridge.beans.Memory;
import com.honeybridge.beans.MemoryStatus;
import com.honeybridge.repositery.FormeRepositery;
import com.honeybridge.repositery.MemoryRepositery;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api
public class FormeController {
	
	@Autowired
	FormeRepositery formeRepositery;
	@Autowired
	MemoryRepositery memoryRepositery;
	@Autowired
	Service service;
	@RequestMapping("/")
	public void test() {
		int c=39;
		System.out.println("fst-c:"+""+c);
		Page<Memory>page=memoryRepositery.findAll(new PageRequest(0, 39));
		System.out.println("fst-c:"+""+c);
		while(c>0) { 
			System.out.println(c);
			System.out.println(page.getContent()+" "+c--);
		}
	}
	@PostMapping("/forme/create")
	public void create(@RequestBody FormeProfile formeProfile) {
		formeRepositery.save(formeProfile);
	}
	@RequestMapping("/forme/profile/{id}")
	public Optional<FormeProfile> getFormeProfile(@PathVariable String id) {
		return formeRepositery.findById(id);
		
	}
	@RequestMapping("/forme/memory")
	@ApiOperation(value="Get All Memories")
	public List<Memory> getAllMemory(){
		return memoryRepositery.findAll();
	}

	@RequestMapping(value="/forme/memory",method=RequestMethod.POST)
	@ApiOperation(value="Memory  to db")
	public void post(@RequestBody Memory entity) {
		memoryRepositery.save(entity);
	}
	@RequestMapping("/memory/status/{status}")
	@ApiOperation(value="Get Memories by memory status")
	public List<Memory> getMemoryBySatus(@PathVariable("status")MemoryStatus memoryStatus){
		return memoryRepositery.findByMemoryStatus(memoryStatus);
		
	}
	@RequestMapping("/memory/isAbused/{isAbused}")
	@ApiOperation(value="Get Memories by memory status")
	public List<Memory> getMemoryByisAbused(@PathVariable("isAbused")Boolean isAbused){
		return memoryRepositery.findByIsAbusedMemory(isAbused);
		
	}
	@RequestMapping("/memory/{memoryId}")
	@ApiOperation(value="Edit a Memory")
	@ResponseBody
	public Memory editMemory(@PathVariable("memoryId")String memoryId ,@RequestBody Memory memory1) {
		boolean isExsits=memoryRepositery.existsById(memoryId);
		if(isExsits)
		{
			Memory mem=service.updating(memory1);
		}
		return null;
	}
}
