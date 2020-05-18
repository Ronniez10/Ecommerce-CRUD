package com.neelav.EcommerceCRUD.repository;

import com.neelav.EcommerceCRUD.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users,String> {
}
