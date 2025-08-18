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

import java.util.List;

import com.fasterxml.jackson.annotation.JsonView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stuffies")
public class StuffiesController {

	private static final Logger logger = LoggerFactory.getLogger(StuffiesController.class);

	private final StuffieService stuffieService;

	StuffiesController(StuffieService stuffieService) {
		this.stuffieService = stuffieService;
	}

	@GetMapping({ "/", "" })
	@JsonView(Stuffie.MinimalView.class)
	public Iterable<Stuffie> all() {
		return this.stuffieService.list();
	}

	@GetMapping("/count")
	public long count() {
		logger.atInfo().log("Stuffies count");
		return this.stuffieService.count();
	}

	@GetMapping("/for/{owner}")
	@JsonView(Stuffie.MinimalView.class)
	public List<Stuffie> forOwner(@PathVariable String owner) {
		logger.atInfo().log("Stuffies for owner (minimal)");
		return this.stuffieService.listByOwner(owner);
	}

	@GetMapping("/by/{manufacturer}")
	@JsonView(Stuffie.MinimalView.class)
	public List<Stuffie> byManufacturer(@PathVariable String manufacturer) {
		logger.atInfo().log("Stuffies by manufacturer (minimal)");
		return this.stuffieService.listByManufacturer(manufacturer);
	}

	@GetMapping("/in/{country}")
	@JsonView(Stuffie.MinimalView.class)
	public List<Stuffie> inCountry(@PathVariable String country) {
		logger.atInfo().log("Stuffies in country '{}'", country);
		return this.stuffieService.listByCountry(country);
	}

}
