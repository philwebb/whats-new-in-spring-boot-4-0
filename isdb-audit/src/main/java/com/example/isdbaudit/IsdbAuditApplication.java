package com.example.isdbaudit;

import java.util.Iterator;
import java.util.Random;

import com.example.isdbaudit.proto.GetStuffiesByOwnerRequest;
import com.example.isdbaudit.proto.GetStuffiesByOwnerResponse;
import com.example.isdbaudit.proto.IsdbGrpc.IsdbBlockingStub;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.grpc.client.ImportGrpcClients;
import org.springframework.util.StringUtils;

@SpringBootApplication
@ImportGrpcClients(types = IsdbBlockingStub.class)
public class IsdbAuditApplication {

	private static final String[] OWNERS = { "Alex", "Sophie", "Adam" };

	private static final Random random = new Random();

	@Bean
	ApplicationRunner runner(IsdbBlockingStub isdb) {
		return (args) -> {
			String owner = OWNERS[random.nextInt(OWNERS.length)];
			audit(isdb, owner);
		};
	}

	private void audit(IsdbBlockingStub isdb, String owner) {
		System.out.println("\n\n");
		System.out.println("Please audit '%s' for the following:\n".formatted(owner));
		GetStuffiesByOwnerRequest request = GetStuffiesByOwnerRequest.newBuilder().setOwner(owner).build();
		for (Iterator<GetStuffiesByOwnerResponse> iterator = isdb.getStuffiesByOwner(request); iterator.hasNext();) {
			GetStuffiesByOwnerResponse response = iterator.next();
			String name = response.getName();
			String type = response.getType();
			System.out.println("  [ ] %s (%s)".formatted(name, StringUtils.hasText(type) ? type : "Unknown Species"));
		}
	}

	public static void main(String[] args) {
		SpringApplication.run(IsdbAuditApplication.class, args);
	}

}
