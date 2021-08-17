package com.example.emaillist.dao;

import com.example.emaillist.vo.UserVO;

public interface UserDAO {
	public UserVO getUserbyEmailAndPassword(String email, String password);
	public int insert(UserVO vo);
}
