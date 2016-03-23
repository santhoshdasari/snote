package com.sermon.mynote.service;

import java.util.List;

import com.sermon.mynote.domain.Note;

public interface NoteService {

	// public List<Note> findAll();

	public Note findById(Integer id);

	public Note save(Note note);

	public void delete(Note note);

	public List<Note> findNotesByAuthorId(int id);

	/*
	 * public void createNote(Integer authorId,String title,String
	 * subTitle,String introduction, Date eventDate,Time eventTime,Integer
	 * noteCategoryId,String keywords,Integer organizationId);
	 */
	// public Page<Note> findAllByPage(Pageable pageable);

}
