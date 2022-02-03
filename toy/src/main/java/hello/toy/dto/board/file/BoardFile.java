package hello.toy.dto.board.file;

import lombok.Data;

@Data
public class BoardFile {
    private Integer boardFileId;
    private String originalFileName;
    private String savedFileName;
    private Integer boardId;
}
