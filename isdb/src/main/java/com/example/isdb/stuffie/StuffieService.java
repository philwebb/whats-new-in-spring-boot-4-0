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

import com.example.isdb.country.Country;
import com.example.isdb.country.CountryRepository;
import com.example.isdb.manufacturer.Manufacturer;
import com.example.isdb.manufacturer.ManufacturerRepository;
import com.example.isdb.owner.Owner;
import com.example.isdb.owner.OwnerRepository;

import org.springframework.stereotype.Service;

@Service
public class StuffieService {

	private final StuffieRepository stuffieRepository;

	private final OwnerRepository ownerRepository;

	private final ManufacturerRepository manufacturerRepository;

	private final CountryRepository countryRepository;

	StuffieService(StuffieRepository stuffieRepository, OwnerRepository ownerRepository,
			ManufacturerRepository manufacturerRepository, CountryRepository countryRepository) {
		this.stuffieRepository = stuffieRepository;
		this.ownerRepository = ownerRepository;
		this.manufacturerRepository = manufacturerRepository;
		this.countryRepository = countryRepository;
	}

	public long count() {
		return this.stuffieRepository.count();
	}

	public Iterable<Stuffie> list() {
		return this.stuffieRepository.findAll();
	}

	public Stuffie get(int id) {
		return this.stuffieRepository.findById(id).orElseThrow(() -> new UnknownIdException("stuffie", id));
	}

	public List<String> getOwners(int id) {
		return get(id).owners().stream().map(this::getOwnerName).toList();
	}

	private String getOwnerName(StuffieOwner stuffieOwner) {
		int id = stuffieOwner.owner();
		return this.ownerRepository.findById(id).orElseThrow(() -> new UnknownIdException("owner", id)).name();
	}

	public List<Stuffie> listByOwner(String name) {
		Owner owner = this.ownerRepository.findByNameIgnoringCase(name)
			.orElseThrow(() -> new UnknownNameException("owner", name));
		return this.stuffieRepository.findByOwner(owner.id());
	}

	public List<Stuffie> listByManufacturer(String name) {
		Manufacturer manufacturer = this.manufacturerRepository.findByNameIgnoringCase(name)
			.orElseThrow(() -> new UnknownNameException("manufacturer", name));
		return this.stuffieRepository.findByManufacturer(manufacturer.id());
	}

	public List<Stuffie> listByCountry(String name) {
		Country country = this.countryRepository.findByNameIgnoringCase(name)
			.orElseThrow(() -> new UnknownNameException("country", name));
		return this.stuffieRepository.findByCountry(country.id());
	}

}
