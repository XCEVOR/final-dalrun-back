package com.dalrun.dto;

import com.dalrun.domain.DotMap;
import com.dalrun.domain.User;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

public class DotMapDto implements Serializable {

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class Request {
        private Long id;
        private User user;
        private String dotId;
        private LocalDateTime createdDate;
        private String description;
        private String color;
        private String txHash;

        /* DTO -> Entity */
//        public DotMap toEntity() {
//            DotMap dotmap = DotMap.builder().id(id).user(user).dotId(dotId).description(description).color(color).txHash(txHash).build();
//            return dotmap;
//        }
    }

    @Getter
    public static class Response {
        private Long id;
        private String userName;
        private String dotId;
        private LocalDateTime createdDate;
        private String description;
        private String color;
        private String txHash;
        private String picture;

//        /* Entity -> DTO */
//        public Response(DotMap dotmap) {
//            this.id = dotmap.getId();
//            this.userName = dotmap.getUser().getName();
//            this.dotId = dotmap.getDotId();
//            this.createdDate = dotmap.getCreatedDate();
//            this.description  = dotmap.getDescription();
//            this.color = dotmap.getColor();
//            this.txHash = dotmap.getTxHash();
//            this.picture = dotmap.getUser().getPicture();
//        }
    }
}
