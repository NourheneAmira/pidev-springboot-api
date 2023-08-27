package com.esprit.tn.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;


import com.esprit.tn.entities.Notification;

@Repository
public interface NotificationRepository extends  JpaRepository<Notification,Long>{
	List<Notification> findByParentsId(Long id);
}
