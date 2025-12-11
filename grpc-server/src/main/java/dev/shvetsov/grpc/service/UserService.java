package dev.shvetsov.grpc.service;

import dev.shvetsov.grpc.generated.User.APIResponse;
import dev.shvetsov.grpc.generated.User.LoginRequest;
import dev.shvetsov.grpc.generated.User.LogoutRequest;
import dev.shvetsov.grpc.generated.userGrpc.userImplBase;
import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UserService extends userImplBase {

  @Override
  public void login(LoginRequest request, StreamObserver<APIResponse> responseObserver) {
    log.info("Processing the request: {}", request);
    String username = request.getUsername();
    String password = request.getPassword();
    APIResponse.Builder response = APIResponse.newBuilder();
    if(username.equals(password)) {
      response.setResponseCode(0).setResponseMessage("SUCCESS");
    }
    else {
      response.setResponseCode(100).setResponseMessage("INVALID PASSWORD");
    }
    responseObserver.onNext(response.build());
    responseObserver.onCompleted();
    log.info("The response status: {}", response.getResponseMessage());
  }
  
  
  

  @Override
  public void logout(LogoutRequest request, StreamObserver<APIResponse> responseObserver) {

  }
}
