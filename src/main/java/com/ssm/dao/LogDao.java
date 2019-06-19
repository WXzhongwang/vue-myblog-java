package com.ssm.dao;


import org.springframework.stereotype.Repository;

import com.ssm.domain.Log;

@Repository
public interface LogDao {
  public void insert(Log log);
}
