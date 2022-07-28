package com.ll.comu;

import com.ll.comu.util.Ut;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class ArticleRepository {
    private  static long latsId;
    private static List<ArticleDto> articleDtoList;
    static {
        articleDtoList=new ArrayList<>();
        latsId=0L;
        makeTestData();
    }
    public ArticleRepository(){

    }
    public static long write(String title,String body){
        long id=++latsId;
        ArticleDto articleDto=new ArticleDto(id,title,body);
        articleDtoList.add(articleDto);
        return id;
    }

    public List<ArticleDto> getList() {
        return articleDtoList;
    }

    public ArticleDto findById(long id) {
      for(ArticleDto articleDto : articleDtoList){
          if(articleDto.getId()==id){
              return articleDto;
          }
      }
      return null;
    }

    public void deleteById(long id) {
        for(ArticleDto articleDto:articleDtoList){
            if(articleDto.getId()==id){
                articleDtoList.remove(articleDto);
                return;
            }
        }
        return;
    }
    //테스트 데이터 자동생성 메소드
    private static void makeTestData(){
        IntStream.rangeClosed(1,10).forEach(id->{
            String title="제목%d".formatted(id);
            String body="내용%d".formatted(id);
            write(title,body);
        });
    }

    public void delete(long id) {
        ArticleDto articleDto=findById(id);
        if(articleDto==null){
            return;
        }
        articleDtoList.remove(articleDto);
    }

    public void modify(long id, String title, String body) {
        ArticleDto articleDto=findById(id);
        if(articleDto==null) return;
        articleDto.setTitle(title);
        articleDto.setBody(body);
    }

    public String showJson() {
        return Ut.json.toStr(articleDtoList,"");
    }

    public List<ArticleDto> findAll() {
        return articleDtoList;
    }
}
