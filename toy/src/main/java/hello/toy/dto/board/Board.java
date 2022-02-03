package hello.toy.dto.board;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Board {
    private Integer boardId;
    private String title;
    private String content;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Integer userId;
}
