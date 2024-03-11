package com.chat.websocket.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

public class ChatRoom {
    @Id
    private String id;
    private String chatId;
    private String senderId;
    private String recipientId;

    public ChatRoom() {
    }

    public ChatRoom(String id, String chatId, String senderId, String recipientId) {
        this.id = id;
        this.chatId = chatId;
        this.senderId = senderId;
        this.recipientId = recipientId;
    }

    public static ChatRoomBuilder builder() {
        return new ChatRoomBuilder();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getChatId() {
        return chatId;
    }

    public void setChatId(String chatId) {
        this.chatId = chatId;
    }

    public String getSenderId() {
        return senderId;
    }

    public void setSenderId(String senderId) {
        this.senderId = senderId;
    }

    public String getRecipientId() {
        return recipientId;
    }

    public void setRecipientId(String recipientId) {
        this.recipientId = recipientId;
    }

    @Override
    public String toString() {
        return "ChatRoom{" +
                "id='" + id + '\'' +
                ", chatId='" + chatId + '\'' +
                ", senderId='" + senderId + '\'' +
                ", recipientId='" + recipientId + '\'' +
                '}';
    }

    public static class ChatRoomBuilder {
        private String id;
        private String chatId;
        private String senderId;
        private String recipientId;

        ChatRoomBuilder() {
        }

        public ChatRoomBuilder id(String id) {
            this.id = id;
            return this;
        }

        public ChatRoomBuilder chatId(String chatId) {
            this.chatId = chatId;
            return this;
        }

        public ChatRoomBuilder senderId(String senderId) {
            this.senderId = senderId;
            return this;
        }

        public ChatRoomBuilder recipientId(String recipientId) {
            this.recipientId = recipientId;
            return this;
        }

        public ChatRoom build() {
            return new ChatRoom(id, chatId, senderId, recipientId);
        }
    }
}
