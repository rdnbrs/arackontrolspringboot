package com.bariserden.arackontroldemo.repo;

import com.bariserden.arackontroldemo.entity.Arac;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AracRepository extends JpaRepository <Arac, Long> {
}
