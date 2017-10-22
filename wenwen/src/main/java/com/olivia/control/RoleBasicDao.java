package com.olivia.control;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.olivia.control.RolePlayer;
@Repository
public interface RoleBasicDao extends CrudRepository<RolePlayer, Integer> {
	public void delete(RolePlayer rolePlayer);

	@SuppressWarnings("unchecked")
	public RolePlayer save(RolePlayer rolePlayer);

	public List<RolePlayer> findAll();
	
	public RolePlayer findByUserName(String userName);
	
	@Query(value="select userName,money,id from RolePlayer r where r.money>?1 and r.money<?2")
    public List<RolePlayer>  findByMoney(int money1,int money2);
}
