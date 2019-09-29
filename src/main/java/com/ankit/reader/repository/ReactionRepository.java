package com.ankit.reader.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ankit.reader.model.Reaction;

@Repository
public interface ReactionRepository extends JpaRepository<Reaction,Long>{
	
	
	
	boolean existsById(Long reactionId);
	Optional<Reaction> findById(Long reactionId);

}
