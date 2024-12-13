package com.university.university_management_system.repository;
import com.university.university_management_system.model.CLOModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface CLORepository extends JpaRepository<CLOModel, Integer> {

}
