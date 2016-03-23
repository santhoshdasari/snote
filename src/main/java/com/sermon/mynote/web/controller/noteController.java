package com.sermon.mynote.web.controller;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sermon.mynote.domain.Note;
import com.sermon.mynote.domain.StatusResponse;
import com.sermon.mynote.service.NoteService;

@RequestMapping("/note")
@Controller
public class noteController {

	final Logger logger = LoggerFactory.getLogger(noteController.class);

	@Autowired
	MessageSource messageSource;

	@Autowired
	private NoteService noteService;

	@RequestMapping(value = "/addNote", method = RequestMethod.POST, headers = { "Content-type=application/json" })
	public @ResponseBody Note PostNote(@RequestBody Note note) {

		Note newNote = noteService.save(note);

		return newNote;
	}

	/* update */
	@RequestMapping(value = "/updateNote/{id}", method = RequestMethod.PUT)
	@ResponseBody
	public StatusResponse updateNote(@RequestBody Note note, @PathVariable Long id) {

		Note noteTemp = new Note();
		Date date = new Date();
		note.setEventDate(new Timestamp(date.getTime()));
		note.setEventTime(new Timestamp(date.getTime()));

		noteTemp = noteService.findById(id.intValue());

		noteTemp.setAuthorId(note.getAuthorId());
		noteTemp.setCategoryId(note.getCategoryId());
		noteTemp.setEventDate(note.getEventDate());
		noteTemp.setEventTime(note.getEventTime());
		noteTemp.setIntroduction(note.getIntroduction());
		noteTemp.setKeywords(note.getKeywords());
		noteTemp.setSubTitle(note.getSubTitle());
		noteTemp.setTitle(note.getTitle());
		noteTemp.setOrganizationId(note.getOrganizationId());

		Note noteResponse = noteService.save(noteTemp);

		StatusResponse response = new StatusResponse();

		if (noteResponse != null)
			response.setStatus(true);
		else
			response.setStatus(false);

		return response;
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public void delete(@PathVariable Long id) {
		logger.info("Deleting note with id: " + id);
		Note noteTemp = noteService.findById(id.intValue());
		noteService.delete(noteTemp);
		logger.info("Note deleted successfully");
	}

	@RequestMapping(value = "/searchNote/{id}", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public Note getNoteById(@PathVariable int id) {
		logger.info("Listing note");

		Note note = noteService.findById(id);
		return note;
	}

	@RequestMapping(value = "/getNoteDetails", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public Note getNoteDetails() {

		Note note = new Note();
		note.setAuthorId(1);
		note.setCategoryId(1);
		note.setIntroduction("intro test");
		note.setKeywords("test");
		Date date = new Date();
		note.setEventDate(new Timestamp(date.getTime()));
		note.setSubTitle("subtitle test");
		note.setTitle("test");
		return note;
	}

	@RequestMapping(value = "/getNotesListByAuthorId/{id}", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<Note> getChurchesByOrganization(@PathVariable int id) {
		logger.info("Listing getListOfNotesForGivenAuthorId");

		List<Note> noteList = noteService.findNotesByAuthorId(id);
		return noteList;
	}

}
