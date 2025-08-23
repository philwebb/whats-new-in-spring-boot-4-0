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

package com.example.isdb.stuffie;

import java.time.Duration;
import java.util.List;

import com.example.isdb.stuffie.Stuffie.DetailView;
import com.fasterxml.jackson.annotation.JsonView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stuffie")
public class StuffieController {

	private static final Logger logger = LoggerFactory.getLogger(StuffieController.class);

	private volatile int sleepCount;

	private final StuffieService stuffieService;

	StuffieController(StuffieService stuffieService) {
		this.stuffieService = stuffieService;
	}

	@GetMapping(path = "/{id}/for", version = "1.0")
	public String forOwner(@PathVariable int id) {
		logger.atInfo().log("Stuffie for owner {}", id);
		return this.stuffieService.getOwners(id).get(0);
	}

	@GetMapping(path = "/{id}/for", version = "2.0")
	public List<String> forOwners(@PathVariable int id) {
		logger.atInfo().log("Stuffie for owner {}", id);
		napNowAndAgain();
		return this.stuffieService.getOwners(id);
	}

	@GetMapping(path = "/{id}/detail")
	@JsonView(DetailView.class)
	Stuffie detail(@PathVariable int id) {
		return this.stuffieService.get(id);
	}

	@GetMapping(path = "/{id}/pic", produces = MediaType.IMAGE_JPEG_VALUE)
	Resource picture(@PathVariable int id) {
		Stuffie stuffie = this.stuffieService.get(id);
		return new ClassPathResource("images/" + stuffie.imagefile());
	}

	void napNowAndAgain() {
		this.sleepCount += 1;
		if (this.sleepCount > 3) {
			this.sleepCount = 0;
			logger.atInfo().log("Having a nap");
			try {
				Thread.sleep(Duration.ofSeconds(4).toMillis());
			}
			catch (InterruptedException ex) {
				Thread.currentThread().interrupt();
			}
		}
	}

}
