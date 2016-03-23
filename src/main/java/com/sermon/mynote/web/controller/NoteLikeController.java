package com.sermon.mynote.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sermon.mynote.domain.NoteLike;
import com.sermon.mynote.domain.StatusResponse;
import com.sermon.mynote.service.NoteLikeService;

@RequestMapping("/noteLike")
@Controller
public class NoteLikeController {

	final Logger logger = LoggerFactory.getLogger(noteController.class);

	@Autowired
	private NoteLikeService noteLikeService;

	@RequestMapping(value = "/like", method = RequestMethod.POST, headers = { "Content-type=application/json" })
	public @ResponseBody StatusResponse PostNoteDownload(@RequestBody NoteLike noteLike) {

		NoteLike like = noteLikeService.save(noteLike);

		StatusResponse response = new StatusResponse();

		if (like != null)
			response.setStatus(true);
		else
			response.setStatus(false);

		return response;
	}

}
