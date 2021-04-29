package com.example.restservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MemberService {
	@Autowired
	MemberDao memberDao;
	public void addMember(MemberAccount memberAccount){
		memberDao.addMember(memberAccount);
	}
	public void addAccount(UserData Data){
		memberDao.addAccount(Data);
	}
}