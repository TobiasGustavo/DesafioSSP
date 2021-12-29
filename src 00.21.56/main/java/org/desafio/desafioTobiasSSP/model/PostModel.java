package org.desafio.desafioTobiasSSP.model;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class PostModel {

	private Long idPost;
	private String text;
	private String author;
	private int upvotes;
	private LocalDateTime dtPersist;
	
	public PostModel() {
	}
	
	public PostModel(Long idPost, String text, String author) {
		this.idPost = idPost;
		this.text = text;
		this.author = author;
	}
	
	public PostModel(String text, String author) {
		this.text = text;
		this.author = author;
	}
	
	public  PostModel(PostUpvote post ){
		this.idPost = post.getIdPost();
		this.text = post.getText();
		this.author = post.getAuthor();		
		this.upvotes = post.getUpvotes() != null ? post.getUpvotes().intValue() : 0;
		this.dtPersist = post.getDtPersist();
	}
	
}



