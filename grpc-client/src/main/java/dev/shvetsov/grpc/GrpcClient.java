package dev.shvetsov.grpc;

import dev.shvetsov.grpc.generated.User.APIResponse;
import dev.shvetsov.grpc.generated.User.LoginRequest;
import dev.shvetsov.grpc.generated.userGrpc;
import dev.shvetsov.grpc.generated.userGrpc.userBlockingStub;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GrpcClient {

  public static void main(String[] args) {
    ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9090).usePlaintext().build();
    userBlockingStub userStub = userGrpc.newBlockingStub(channel);
    LoginRequest loginRequestSuccess = LoginRequest.newBuilder().setUsername("User").setPassword("Password").build();
    LoginRequest loginRequestInvalid = LoginRequest.newBuilder().setUsername("User").setPassword("User").build();
    APIResponse responseSuccess = userStub.login(loginRequestSuccess);
    APIResponse responseInvalid = userStub.login(loginRequestInvalid);
    log.info("The request status: {}", responseSuccess.getResponseMessage());
    log.info("The request status: {}", responseInvalid.getResponseMessage());
  }
}
