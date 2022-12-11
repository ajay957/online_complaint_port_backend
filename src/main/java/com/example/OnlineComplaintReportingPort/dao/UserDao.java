package com.example.OnlineComplaintReportingPort.dao;

import com.example.OnlineComplaintReportingPort.model.Users;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserDao extends CrudRepository<Users,Integer> {

    @Query(value = "SELECT `id`, `address`, `confirm_password`, `email`, `name`, `password`, `phno`, `username` FROM `complaint` WHERE `username`=:username AND password =:password",nativeQuery = true)
    List<Users> UserLogin(@Param("username") String username,@Param("password") String password);
//
//    @Query(value = "SELECT `id`, `address`, `confirm_password`, `email`, `name`, `password`, `phno`, `username` FROM `complaint` WHERE `username`=:username",nativeQuery = true)
//    List<Users> UserFind(@Param("username") String username);
}
