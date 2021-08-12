package com.mechanicservice.repository;

import com.mechanicservice.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Long, Message> {
}
