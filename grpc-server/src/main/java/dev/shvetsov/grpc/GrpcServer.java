package dev.shvetsov.grpc;

import dev.shvetsov.grpc.service.UserService;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import java.io.IOException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GrpcServer {

  public static void main(String[] args) throws IOException, InterruptedException {
    Server server = ServerBuilder.forPort(9090).addService(new UserService()).build();
    server.start();
    log.info("Server started at: {}", server.getPort());
    server.awaitTermination();
  }
}
