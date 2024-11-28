package com.example.alumni.Repository;

import com.example.alumni.Entity.Organisations;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrganisationsRepo extends JpaRepository<Organisations,Long> {
}
