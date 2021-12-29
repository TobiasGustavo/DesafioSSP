package org.desafio.desafioTobiasSSP.controller;

import java.net.URI;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.desafio.desafioTobiasSSP.model.PostForm;
import org.desafio.desafioTobiasSSP.model.PostModel;
import org.desafio.desafioTobiasSSP.service.postService.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/post")

public class PostController {

	@Autowired
	private PostService postService;

	@PostMapping
	public ResponseEntity<PostModel> insert(@RequestBody @Valid PostForm form, HttpServletResponse response) {
		PostModel post = postService.insert(form);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
				.path("/{id}").buildAndExpand(post.getClass())
				.toUri();
		response.setHeader("Location", uri.toASCIIString());
		return ResponseEntity.status(HttpStatus.CREATED).body(post);
	}

	@GetMapping
	public ResponseEntity<List<PostModel>> findAll(Pageable pageable) {
		List<PostModel> postModel = PostService.findAll(pageable);
		return ResponseEntity.ok(post);
	}

	@PutMapping("/{idPost}/upvote")
	public ResponseEntity<PostModel> addUpvote(@PathVariable("idPost") Long idPost) {
		PostModel post = postService.addUpvote(idPost);
		return ResponseEntity.ok(post);
	}
}


