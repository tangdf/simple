package com.olivia.control.demo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.olivia.control.entity.Party;
@Repository
public interface PartyDao extends CrudRepository<Party, Integer> {

	@SuppressWarnings("unchecked")
	public Party save(Party party);
	public Party findOne(Integer id);
	public Party findByPartyName(String partyName);
}
