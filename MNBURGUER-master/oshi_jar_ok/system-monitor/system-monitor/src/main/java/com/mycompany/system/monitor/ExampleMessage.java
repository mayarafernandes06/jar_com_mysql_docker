package com.mycompany.system.monitor;

public class ExampleMessage {

    public static void main(String[] args) {
        Integer teste = 2;
        
       if(teste == 1){
           Message slackMessage = Message
                .builder()
                .text("Testando valor 1")
                .build();

        SendMessage.sendMessage(slackMessage);

       }
       if(teste == 2){
           Message slackMessage = Message
                .builder()
                .text("Testando valor 2")
                .build();

        SendMessage.sendMessage(slackMessage);

       }

    }

}
    