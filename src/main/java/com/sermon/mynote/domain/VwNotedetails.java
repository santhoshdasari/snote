package com.sermon.mynote.domain;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

/**
 * VwNotedetails generated by hbm2java
 */
@Entity

@NamedQuery(name = "VwNotedetails.findNoteDetailsByNoteId", query = "SELECT o FROM VwNotedetails o  WHERE o.noteId = (?1)")
@Table(name = "vw_notedetails")
public class VwNotedetails implements java.io.Serializable {

	private int noteKey;
	private int noteId;
	private String author;
	private String title;
	private String subtitle;
	private Date eventDate;
	private Date eventTime;
	private String introduction;
	private int sectionId;
	private String sectionText;
	private String sectionKeywords;
	private int subSectionId;
	private String subSectionText;
	private String subSectionKeywords;

	public VwNotedetails() {
	}

	public VwNotedetails(int noteKey, int noteId, String author,
			String title, int sectionId, int subSectionId) {
		this.noteKey = noteKey;
		this.noteId = noteId;
		this.author = author;
		this.title = title;
		this.sectionId = sectionId;
		this.subSectionId = subSectionId;
	}

	public VwNotedetails(int noteKey, int noteId, String author,
			String title, String subtitle, Date eventDate, Date eventTime,
			String introduction, int sectionId, String sectionText,
			String sectionKeywords, int subSectionId, String subSectionText,
			String subSectionKeywords) {
		this.noteKey = noteKey;
		this.noteId = noteId;
		this.author = author;
		this.title = title;
		this.subtitle = subtitle;
		this.eventDate = eventDate;
		//this.eventTime = eventTime;
		this.introduction = introduction;
		this.sectionId = sectionId;
		this.sectionText = sectionText;
		this.sectionKeywords = sectionKeywords;
		this.subSectionId = subSectionId;
		this.subSectionText = subSectionText;
		this.subSectionKeywords = subSectionKeywords;
	}

	@Id
	@Column(name = "NoteKey")
	public int getNoteKey() {
		return this.noteKey;
	}

	public void setNoteKey(int noteKey) {
		this.noteKey = noteKey;
	}

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
	@Type(type="org.joda.time.contrib.hibernate.PersistentDateTime")
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

	public int getSectionId() {
		return this.sectionId;
	}

	public void setSectionId(int sectionId) {
		this.sectionId = sectionId;
	}

	public String getSectionText() {
		return this.sectionText;
	}

	public void setSectionText(String sectionText) {
		this.sectionText = sectionText;
	}

	public String getSectionKeywords() {
		return this.sectionKeywords;
	}

	public void setSectionKeywords(String sectionKeywords) {
		this.sectionKeywords = sectionKeywords;
	}

	public int getSubSectionId() {
		return this.subSectionId;
	}

	public void setSubSectionId(int subSectionId) {
		this.subSectionId = subSectionId;
	}

	public String getSubSectionText() {
		return this.subSectionText;
	}

	public void setSubSectionText(String subSectionText) {
		this.subSectionText = subSectionText;
	}

	public String getSubSectionKeywords() {
		return this.subSectionKeywords;
	}

	public void setSubSectionKeywords(String subSectionKeywords) {
		this.subSectionKeywords = subSectionKeywords;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof VwNotedetails))
			return false;
		VwNotedetails castOther = (VwNotedetails) other;

		return (this.getNoteKey() == castOther.getNoteKey())
				&& (this.getNoteId() == castOther.getNoteId())
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
				/**&& ((this.getEventTime() == castOther.getEventTime()) || (this
						.getEventTime() != null
						&& castOther.getEventTime() != null && this
						.getEventTime().equals(castOther.getEventTime())))*/
				&& ((this.getIntroduction() == castOther.getIntroduction()) || (this
						.getIntroduction() != null
						&& castOther.getIntroduction() != null && this
						.getIntroduction().equals(castOther.getIntroduction())))
				&& (this.getSectionId() == castOther.getSectionId())
				&& ((this.getSectionText() == castOther.getSectionText()) || (this
						.getSectionText() != null
						&& castOther.getSectionText() != null && this
						.getSectionText().equals(castOther.getSectionText())))
				&& ((this.getSectionKeywords() == castOther
						.getSectionKeywords()) || (this.getSectionKeywords() != null
						&& castOther.getSectionKeywords() != null && this
						.getSectionKeywords().equals(
								castOther.getSectionKeywords())))
				&& (this.getSubSectionId() == castOther.getSubSectionId())
				&& ((this.getSubSectionText() == castOther.getSubSectionText()) || (this
						.getSubSectionText() != null
						&& castOther.getSubSectionText() != null && this
						.getSubSectionText().equals(
								castOther.getSubSectionText())))
				&& ((this.getSubSectionKeywords() == castOther
						.getSubSectionKeywords()) || (this
						.getSubSectionKeywords() != null
						&& castOther.getSubSectionKeywords() != null && this
						.getSubSectionKeywords().equals(
								castOther.getSubSectionKeywords())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getNoteKey();
		result = 37 * result + this.getNoteId();
		result = 37 * result
				+ (getAuthor() == null ? 0 : this.getAuthor().hashCode());
		result = 37 * result
				+ (getTitle() == null ? 0 : this.getTitle().hashCode());
		result = 37 * result
				+ (getSubtitle() == null ? 0 : this.getSubtitle().hashCode());
		result = 37 * result
				+ (getEventDate() == null ? 0 : this.getEventDate().hashCode());
		/*result = 37 * result
				+ (getEventTime() == null ? 0 : this.getEventTime().hashCode());*/
		result = 37
				* result
				+ (getIntroduction() == null ? 0 : this.getIntroduction()
						.hashCode());
		result = 37 * result + this.getSectionId();
		result = 37
				* result
				+ (getSectionText() == null ? 0 : this.getSectionText()
						.hashCode());
		result = 37
				* result
				+ (getSectionKeywords() == null ? 0 : this.getSectionKeywords()
						.hashCode());
		result = 37 * result + this.getSubSectionId();
		result = 37
				* result
				+ (getSubSectionText() == null ? 0 : this.getSubSectionText()
						.hashCode());
		result = 37
				* result
				+ (getSubSectionKeywords() == null ? 0 : this
						.getSubSectionKeywords().hashCode());
		return result;
	}

}