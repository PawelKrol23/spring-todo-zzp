package com.ttpsc.springtodo.repository;

import com.ttpsc.springtodo.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StatusRepository extends JpaRepository<Status,Long> {

   @Query("SELECT s FROM statuses s WHERE s.owner.id = :userId")
   List<Status> getUsersStatuses(Long userId);


   @Query("SELECT s FROM statuses s WHERE s.name = :name AND s.owner.id=:userId")
   Status getStatusByName(String name,Long userId);
}
