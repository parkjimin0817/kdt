package com.kh.jpa.repository;

import com.kh.jpa.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepositoryV2 extends JpaRepository<Board,Long> {
}
