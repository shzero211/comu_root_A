import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.ll.comu.ArticleDto;
import com.ll.comu.util.Ut;
import org.junit.jupiter.api.Test;

import java.beans.Transient;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class AppTest {
    @Test
    void 실험_assertThat() {
        int rs = 10 + 20;
        assertThat(rs).isEqualTo(30);
    }

    @Test
    void ObjectMapper_object_toJson() throws JsonProcessingException {
        ArticleDto articleDto = new ArticleDto(1, "제목", "내용");

        String jsonStr = Ut.json.toStr(articleDto, "");
        assertThat(jsonStr).isNotBlank();
        assertThat(jsonStr).isEqualTo("""
                {"id":1,"title":"제목","body":"내용"}
                """.trim());
    }

    @Test
    void ObjectMapper__articleDtoListToJsonStr() {
        List<ArticleDto> articleDtos = new ArrayList<>();
        articleDtos.add(new ArticleDto(1, "제목1", "내용1"));
        articleDtos.add(new ArticleDto(2, "제목2", "내용2"));

        String jsonStr = Ut.json.toStr(articleDtos, "");
        assertThat(jsonStr).isEqualTo("""
                [{"id":1,"title":"제목1","body":"내용1"},{"id":2,"title":"제목2","body":"내용2"}]
                """.trim());
    }

    @Test
    void ObjectMapper__articleDtoMapToJsonStr() {
        Map<String, ArticleDto> articleDtoMap = new HashMap<>();
        articleDtoMap.put("가장오래된", new ArticleDto(1, "제목1", "내용1"));
        articleDtoMap.put("최신", new ArticleDto(2, "제목2", "내용2"));
        String jsonStr = Ut.json.toStr(articleDtoMap, "");
        assertThat(jsonStr).isEqualTo("""
                {"가장오래된":{"id":1,"title":"제목1","body":"내용1"},"최신":{"id":2,"title":"제목2","body":"내용2"}}
                """.trim());
    }
    @Test
    void ObjectMapper_json_toObj(){
        ArticleDto articleDtoOrigin=new ArticleDto(1,"제목","내용");
        String jsonStr=Ut.json.toStr(articleDtoOrigin,"");
        ArticleDto articleDto=Ut.json.toObj(jsonStr,ArticleDto.class,null);
        assertThat(articleDtoOrigin).isEqualTo(articleDto);
    }
    @Test
    void ObjectMapper_json_toArticleDtoMap(){
        Map<String,ArticleDto> mapOri=new HashMap<>();
        mapOri.put("가장오래된",new ArticleDto(1,"제목1","내용1"));
        mapOri.put("최신",new ArticleDto(2,"제목2","내용2"));
        String jsonStr=Ut.json.toStr(mapOri,"");
        Map<String,ArticleDto> map=Ut.json.toMap(jsonStr, new TypeReference<Map<String, ArticleDto>>() {
        },null);
        System.out.println(map.get("최신"));
    }
    @Test
    void ObjectMapper__jsonStrToArticleDtoList() {
        List<ArticleDto> articleDtos = new ArrayList<>();
        articleDtos.add(new ArticleDto(1, "제목1", "내용1"));
        articleDtos.add(new ArticleDto(2, "제목2", "내용2"));

        String jsonStr = Ut.json.toStr(articleDtos, "");

        List<ArticleDto> articleDtosFromJson = Ut.json.toObj(jsonStr, new TypeReference<>() {
        }, null);

        assertThat(articleDtosFromJson).isEqualTo(articleDtos);
    }
}