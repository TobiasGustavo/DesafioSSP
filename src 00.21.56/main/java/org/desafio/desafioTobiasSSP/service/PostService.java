package org.desafio.desafioTobiasSSP.service;

import java.util.List;

import org.desafio.desafioTobiasSSP.model.PostForm;
import org.desafio.desafioTobiasSSP.model.PostModel;
import org.desafio.desafioTobiasSSP.model.PostUpvote;
import org.desafio.desafioTobiasSSP.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

	@Service
	public class PostService {
		
		@Autowired
		private PostRepository postRep;
		
		public PostModel insert(PostForm form) {
			PostModel post = new PostUpvote();
			post.setText(form.getText());
			post.setAuthor(form.getAuthor());
			post = postRep.save(post);
			return new PostModel(post);
	}
		public List<PostModel> findAll(Pageable pageable) {
			pageable = PageRequest.of(pageable.getPageNumber(), 
					pageable.getPageSize(), Sort.by("dtPersist").descending());
			Page<PostUpvote> post = postRep.findAll(pageable);
			return post.map((post) -> new PostModel(post)).getContent();
		}
		public PostModel addUpvote(Long idPost) {
			PostModel post = postRep.findById(idPost).orElseThrow(() -> new EmptyResultDataAccessException(1));		 
			post.addUpvote();
			post = postRep.save(post);
			return new PostModel(post);
		}
	}