/*
 * Copyright 2025 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.isdbweb;

import java.io.InputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WebController {

	private static Logger logger = LoggerFactory.getLogger(WebController.class);

	private final StuffieHttpClient stuffieHttpClient;

	private final StuffieDetailsService stuffieDetailsService;

	public WebController(StuffieHttpClient stuffieHttpClient, StuffieDetailsService stuffieDetailsService) {
		this.stuffieHttpClient = stuffieHttpClient;
		this.stuffieDetailsService = stuffieDetailsService;
	}

	@GetMapping({ "", "/" })
	public ModelAndView index() {
		logger.atInfo().log("Index");
		return new ModelAndView("index").addObject("stuffies", this.stuffieHttpClient.all());
	}

	@GetMapping("/stuffie/{id}")
	public ModelAndView stuffie(@PathVariable int id) {
		logger.atInfo().log("Stuffie {}", id);
		return new ModelAndView("stuffie").addObject("details", this.stuffieDetailsService.getStuffieDetails(id));
	}

	@GetMapping(path = "/images/stuffie/{id}", produces = MediaType.IMAGE_JPEG_VALUE)
	@ResponseBody
	public InputStreamResource picture(@PathVariable int id) {
		logger.atInfo().log("Picture {}", id);
		InputStream picture = this.stuffieHttpClient.picture(id);
		return new InputStreamResource(picture);
	}

}
