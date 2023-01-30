package com.example.provider.repository;

import com.example.provider.pojo.provider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProviderRepository extends JpaRepository<provider, Long> {
}
