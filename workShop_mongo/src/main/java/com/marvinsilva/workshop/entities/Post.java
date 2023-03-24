package com.marvinsilva.workshop.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.marvinsilva.workshop.dto.AuthorDTO;
import com.marvinsilva.workshop.dto.CommentDTO;

@Document
public class Post implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;
	private Date date;
	private String title;
	private String boddy;
	private AuthorDTO author;

	private List<CommentDTO> comment = new ArrayList<>();

	public Post(String id, Date date, String title, String boddy, AuthorDTO author) {
		super();
		this.id = id;
		this.date = date;
		this.title = title;
		this.boddy = boddy;
		this.author = author;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBoddy() {
		return boddy;
	}

	public void setBoddy(String boddy) {
		this.boddy = boddy;
	}

	public AuthorDTO getAuthor() {
		return author;
	}

	public void setAthor(AuthorDTO author) {
		this.author = author;
	}

	public List<CommentDTO> getComment() {
		return comment;
	}

	public void setComment(List<CommentDTO> comment) {
		this.comment = comment;
	}

	public Post() {
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Post other = (Post) obj;
		return Objects.equals(id, other.id);
	}

}
