package com.sermon.mynote.web.controller;

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

import com.sermon.mynote.domain.Section;
import com.sermon.mynote.domain.StatusResponse;
import com.sermon.mynote.service.SectionService;

@RequestMapping("/section")
@Controller
public class SectionController {

	final Logger logger = LoggerFactory.getLogger(SectionController.class);

	@Autowired
	MessageSource messageSource;

	@Autowired
	private SectionService sectionService;

	@RequestMapping(value = "/addSection", method = RequestMethod.POST, headers = { "Content-type=application/json" })
	public @ResponseBody Section PostNote(@RequestBody Section section) {

		Section newSection = sectionService.save(section);

		return newSection;
	}

	/* update */
	@RequestMapping(value = "/updateSection/{id}", method = RequestMethod.PUT)
	@ResponseBody
	public void updateNote(@RequestBody Section section, @PathVariable Long id) {

		Section sectionTemp = new Section();
		sectionTemp = sectionService.findById(id.intValue());
		sectionTemp.setNoteId(section.getNoteId());
		sectionTemp.setSectionKeyWords(section.getSectionKeyWords());
		sectionTemp.setSectionText(section.getSectionText());
		sectionService.save(sectionTemp);

	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public StatusResponse delete(@PathVariable Long id) {
		logger.info("Deleting note with id: " + id);
		Section sectionTemp = sectionService.findById(id.intValue());
		int result = sectionService.delete(sectionTemp);
		logger.info("section deleted successfully");

		StatusResponse response = new StatusResponse();

		if (result == 0)
			response.setStatus(true);
		else
			response.setStatus(false);

		return response;
	}

	@RequestMapping(value = "/searchSection/{id}", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public Section getSectionById(@PathVariable int id) {
		logger.info("Listing section");

		Section section = sectionService.findById(id);
		return section;
	}

}
