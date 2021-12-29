package org.desafio.desafioTobiasSSP.model;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostForm {
	
	@NotBlank
	@Length(max = 300)
	private String text;
	
	@NotBlank 
	@Length(max = 25)
	private String author;
}


