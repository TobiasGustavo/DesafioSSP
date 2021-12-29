package org.desafio.desafioTobiasSSP.repository;

import org.desafio.desafioTobiasSSP.model.PostModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository <PostModel, Long>{

}
