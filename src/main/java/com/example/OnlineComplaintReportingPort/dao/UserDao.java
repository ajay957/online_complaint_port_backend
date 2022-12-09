package com.example.OnlineComplaintReportingPort.dao;

import com.example.OnlineComplaintReportingPort.model.Users;
import org.springframework.data.repository.CrudRepository;

public interface UserDao extends CrudRepository<Users,Integer> {
}
