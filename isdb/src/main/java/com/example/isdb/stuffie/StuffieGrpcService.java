/*
 * Copyright 2026 the original author or authors.
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

import com.example.isdb.proto.GetStuffiesByOwnerRequest;
import com.example.isdb.proto.GetStuffiesByOwnerResponse;
import com.example.isdb.proto.GetStuffiesByOwnerResponse.Builder;
import com.example.isdb.proto.IsdbGrpc;
import io.grpc.stub.StreamObserver;

import org.springframework.boot.context.properties.PropertyMapper;
import org.springframework.grpc.server.service.GrpcService;

@GrpcService
public class StuffieGrpcService extends IsdbGrpc.IsdbImplBase {

	private final StuffieService stuffieService;

	public StuffieGrpcService(StuffieService stuffieService) {
		this.stuffieService = stuffieService;
	}

	@Override
	public void getStuffiesByOwner(GetStuffiesByOwnerRequest request,
			StreamObserver<GetStuffiesByOwnerResponse> responseObserver) {
		this.stuffieService.listByOwner(request.getOwner())
			.stream()
			.map(this::asResponse)
			.forEach(responseObserver::onNext);
		responseObserver.onCompleted();
	}

	private GetStuffiesByOwnerResponse asResponse(Stuffie stuffie) {
		PropertyMapper map = PropertyMapper.get();
		Builder builder = GetStuffiesByOwnerResponse.newBuilder();
		map.from(stuffie::name).to(builder::setName);
		map.from(stuffie::type).to(builder::setType);
		return builder.build();
	}

}
