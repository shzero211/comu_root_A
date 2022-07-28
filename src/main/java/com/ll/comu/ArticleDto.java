package com.ll.comu;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleDto {

    private long id;
    private String title;
    private String body;

}
