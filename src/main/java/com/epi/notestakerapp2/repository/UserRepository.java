package com.epi.notestakerapp2.repository;

import com.epi.notestakerapp2.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    boolean existsByEmail(String email);


    /*
    boolean existsByEmail(String email); // This method declaration remains the same

    // Replace the following with the actual implementation

    @Override // Override the default implementation provided by JpaRepository
    default boolean existsByEmail(String email) {
        return findOneByEmail(email) != null; // More concise using Optional
    }
    */

    public User findByEmail(String email);

    /*abbreciation de :
    // Override the default implementation provided by Spring Data JPA
    @Override
    default User findByEmail(String email) {
        return findOneByEmail(email).orElse(null); // More concise using Optional
    }
    * */
}
