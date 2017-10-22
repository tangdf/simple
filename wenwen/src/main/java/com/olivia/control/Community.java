package com.olivia.control;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.olivia.control.demo.PartyDao;
import com.olivia.control.entity.Party;

@Service
public class Community {
@Resource
private  PartyDao partyDao;
private Logger logger= LoggerFactory.getLogger(Community.class);
    public Party build(Party party){
    	logger.info("start build party");
    	return partyDao.save(party);
    }
    public Party query(Integer id){
    	logger.info("selecting....from");
    	return partyDao.findOne(id);
    }
    public Party myQuery(String name){
    	return partyDao.findByPartyName(name);
    }
}
