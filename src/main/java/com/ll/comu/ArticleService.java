package com.ll.comu;

import java.util.List;

public class ArticleService {
    private ArticleRepository articleRepository;
    public ArticleService (ArticleRepository articleRepository){
      this.articleRepository=articleRepository;
    }
    public long write(String title,String body){
        return articleRepository.write(title,body);
    }
    public List<ArticleDto> getList(){
        return articleRepository.getList();
    }

    public ArticleDto findById(long id) {
        return articleRepository.findById(id);
    }

    public void delete(long id) {
        articleRepository.delete(id);
    }

    public void modify(long id, String title, String body) {
        articleRepository.modify(id,title,body);
    }
}
