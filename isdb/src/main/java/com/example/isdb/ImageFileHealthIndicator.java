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

package com.example.isdb;

import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

@Component
public class ImageFileHealthIndicator extends AbstractHealthIndicator {

	private final ResourcePatternResolver resourceLoader;

	ImageFileHealthIndicator(ResourcePatternResolver resourceLoader) {
		this.resourceLoader = resourceLoader;
	}

	@Override
	protected void doHealthCheck(Health.Builder builder) throws Exception {
		Resource[] resources = this.resourceLoader.getResources("classpath*:/images/*.jpg");
		if (ObjectUtils.isEmpty(resources)) {
			builder.down();
		}
		else {
			builder.up().withDetail("resources", resources.length);
		}
	}

}
