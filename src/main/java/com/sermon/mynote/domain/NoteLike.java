package com.sermon.mynote.domain;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

@Entity
@Table(name = "NoteLike")
public class NoteLike implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int noteLikeId;
	private int noteId;
	private int userId;
	private DateTime likeDate;
	private int likeCount;

	public NoteLike() {

	}

	public NoteLike(int noteLikeId, int noteId, int userId, DateTime likeDate, int likeCount) {
		this.noteLikeId = noteLikeId;
		this.noteId = noteId;
		this.userId = userId;
		this.likeDate = likeDate;
		this.likeCount = likeCount;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "NoteLikeId")
	public int getNoteLikeId() {
		return noteLikeId;
	}

	public void setNoteLikeId(int noteLikeId) {
		this.noteLikeId = noteLikeId;
	}

	public int getNoteId() {
		return noteId;
	}

	public void setNoteId(int noteId) {
		this.noteId = noteId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	public DateTime getLikeDate() {
		return likeDate;
	}

	public void setLikeDate(DateTime likeDate) {
		this.likeDate = likeDate;
	}

	public int getLikeCount() {
		return likeCount;
	}

	public void setLikeCount(int likeCount) {
		this.likeCount = likeCount;
	}

}
