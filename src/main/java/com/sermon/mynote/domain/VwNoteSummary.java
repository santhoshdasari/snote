package com.sermon.mynote.domain;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * VwNoteSummaryId generated by hbm2java
 */
@Entity

@NamedQuery(name = "VwNoteSummary.findNoteSummaryByNoteId", query = "SELECT o FROM VwNoteSummary o  WHERE o.noteId = (?1)")
@Table(name = "vw_NoteSummary")
public class VwNoteSummary implements java.io.Serializable {

	private int noteId;
	private String author;
	private String title;
	private String subtitle;
	private Date eventDate;
	//private Date eventTime;
	private String introduction;

	public VwNoteSummary() {
	}

	public VwNoteSummary(int noteId, String author, String title) {
		this.noteId = noteId;
		this.author = author;
		this.title = title;
	}

	public VwNoteSummary(int noteId, String author, String title,
			String subtitle, Date eventDate, Date eventTime, String introduction) {
		this.noteId = noteId;
		this.author = author;
		this.title = title;
		this.subtitle = subtitle;
		this.eventDate = eventDate;
		//this.eventTime = eventTime;
		this.introduction = introduction;
	}
   
	@Id
	@Column(name = "NoteId")
	public int getNoteId() {
		return this.noteId;
	}

	public void setNoteId(int noteId) {
		this.noteId = noteId;
	}

	public String getAuthor() {
		return this.author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSubtitle() {
		return this.subtitle;
	}

	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}

	public Date getEventDate() {
		return this.eventDate;
	}

	public void setEventDate(Date eventDate) {
		this.eventDate = eventDate;
	}
/*
	public Date getEventTime() {
		return this.eventTime;
	}

	public void setEventTime(Date eventTime) {
		this.eventTime = eventTime;
	}
*/
	public String getIntroduction() {
		return this.introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof VwNoteSummary))
			return false;
		VwNoteSummary castOther = (VwNoteSummary) other;

		return (this.getNoteId() == castOther.getNoteId())
				&& ((this.getAuthor() == castOther.getAuthor()) || (this
						.getAuthor() != null && castOther.getAuthor() != null && this
						.getAuthor().equals(castOther.getAuthor())))
				&& ((this.getTitle() == castOther.getTitle()) || (this
						.getTitle() != null && castOther.getTitle() != null && this
						.getTitle().equals(castOther.getTitle())))
				&& ((this.getSubtitle() == castOther.getSubtitle()) || (this
						.getSubtitle() != null
						&& castOther.getSubtitle() != null && this
						.getSubtitle().equals(castOther.getSubtitle())))
				&& ((this.getEventDate() == castOther.getEventDate()) || (this
						.getEventDate() != null
						&& castOther.getEventDate() != null && this
						.getEventDate().equals(castOther.getEventDate())))
			/*	&& ((this.getEventTime() == castOther.getEventTime()) || (this
						.getEventTime() != null
						&& castOther.getEventTime() != null && this
						.getEventTime().equals(castOther.getEventTime())))*/
				&& ((this.getIntroduction() == castOther.getIntroduction()) || (this
						.getIntroduction() != null
						&& castOther.getIntroduction() != null && this
						.getIntroduction().equals(castOther.getIntroduction())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getNoteId();
		result = 37 * result
				+ (getAuthor() == null ? 0 : this.getAuthor().hashCode());
		result = 37 * result
				+ (getTitle() == null ? 0 : this.getTitle().hashCode());
		result = 37 * result
				+ (getSubtitle() == null ? 0 : this.getSubtitle().hashCode());
		result = 37 * result
				+ (getEventDate() == null ? 0 : this.getEventDate().hashCode());
	/*	result = 37 * result
				+ (getEventTime() == null ? 0 : this.getEventTime().hashCode());*/
		result = 37
				* result
				+ (getIntroduction() == null ? 0 : this.getIntroduction()
						.hashCode());
		return result;
	}

}
