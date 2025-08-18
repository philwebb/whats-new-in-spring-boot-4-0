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
import java.util.Optional;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.Repository;

public interface StuffieRepository extends Repository<Stuffie, Integer> {

	long count();

	Iterable<Stuffie> findAll();

	Optional<Stuffie> findById(int id);

	@Query("SELECT * FROM stuffie JOIN stuffie_owner ON stuffie.id = stuffie_owner.stuffie WHERE stuffie_owner.owner = :ownerId")
	List<Stuffie> findByOwner(int ownerId);

	List<Stuffie> findByManufacturer(int manufacturerId);

	List<Stuffie> findByCountry(int countryId);

}
