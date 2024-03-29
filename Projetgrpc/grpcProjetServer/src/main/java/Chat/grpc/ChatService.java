package Chat.grpc;

import Project.grpc.ChatServiceGrpc.ChatServiceImplBase;
import Project.grpc.ChatServiceOuterClass.Message;
import Project.grpc.ChatServiceOuterClass.MessageList;
import Project.grpc.ChatServiceOuterClass.MessageRequest;
import Project.grpc.ChatServiceOuterClass.MessageResponse;
import Project.grpc.ChatServiceOuterClass.UserRequest;
import io.grpc.stub.StreamObserver;

public class ChatService extends ChatServiceImplBase{

	@Override
    public void sendMessage(MessageRequest request, StreamObserver<MessageResponse> responseObserver) {
        // Logique pour envoyer le message au destinataire
        // Ici, vous pouvez implémenter le code pour envoyer un message à l'utilisateur spécifié
        String status = "Message sent successfully";
        MessageResponse response = MessageResponse.newBuilder().setStatus(status).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void getMessagesForUser(UserRequest request, StreamObserver<MessageList> responseObserver) {
        // Logique pour récupérer les messages pour un utilisateur donné
        // Ici, vous pouvez implémenter le code pour récupérer les messages destinés à un utilisateur spécifié
        MessageList messageList = MessageList.newBuilder()
                                .addMessages(Message.newBuilder().setSender("Sender").setMessage("Hello").build())
                                .build();
        responseObserver.onNext(messageList);
        responseObserver.onCompleted();
    }
}
