package com.Book.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Book.server.pojo.BookDB;

@Repository
public interface BookRespository extends JpaRepository<BookDB, Integer> {

}
