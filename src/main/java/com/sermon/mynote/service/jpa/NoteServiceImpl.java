package com.sermon.mynote.service.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Lists;
import com.sermon.mynote.domain.Note;
import com.sermon.mynote.repository.NoteRepository;
import com.sermon.mynote.service.NoteService;

@Service("noteService")
@Repository
@Transactional
public class NoteServiceImpl implements NoteService {

	final Logger logger = LoggerFactory.getLogger(NoteServiceImpl.class);

	@PersistenceContext
	private EntityManager em;

	@Autowired
	private NoteRepository noteRepository;

	public Note findById(Integer id) {
		return noteRepository.findOne(id.intValue());
	}

	public Note save(Note note) {

		return noteRepository.save(note);
	}

	/*
	 * 
	 * public void createNote(Integer authorId,String title,String
	 * subTitle,String introduction, Date eventDate,Time eventTime,Integer
	 * noteCategoryId,String keywords,Integer organizationId);
	 */
	@Override
	public void delete(Note note) {
		Note mergedNote = em.merge(note);
		em.remove(mergedNote);
		logger.info("Note with id: " + note.getNoteId() + " deleted successfully");
	}

	@Transactional(readOnly = true)
	public List<Note> findNotesByAuthorId(int authorId) {

		return Lists.newArrayList(noteRepository.findNotesByAuthorId(authorId));
	}

}
