import com.fasterxml.jackson.core.JsonProcessingException;
import com.ll.comu.ArticleDto;
import com.ll.comu.util.Ut;
import org.junit.jupiter.api.Test;

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
    void ObjectMapper_json_toObject(){
        ArticleDto articleDtoOrigin=new ArticleDto(1,"제목","내용");
        String jsonStr=Ut.json.toStr(articleDtoOrigin,"");
        ArticleDto articleDto=Ut.json.toObject(jsonStr,ArticleDto.class,null);
        assertThat(articleDtoOrigin).isEqualTo(articleDto);
    }
}