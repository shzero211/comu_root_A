<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ include file="../common/head.jspf"%>
<script src="https://cdn.tailwindcss.com"></script>
<script>
function Article__loadMore(){
        $('.articles').append(`
        <li>하하</li>
        `
);
}
</script>
<!-- 보통 구획은 섹션으로 나눈다. -->
<section>
    <!-- container(max-width) : 너비가 너무 넓게 퍼지는 것을 막는다 + 반응형은 잃지 않는다. -->
    <!-- mx-auto : margin-left:auto; margin-right:auto; -->
    <div class="container px-3 mx-auto articles">
        <h1 class="font-bold text-lg">게시물 리스트(auto)</h1>
        <button class="btn btn-sm" onclick="Article__loadMore()">버튼</button>
    </div>
</section>
<section class="mt-5">
    <div class="container px-3 mx-auto">
        <h1 class="font-bold text-lg">테스트</h1>
         <script>
         function Article__loadLatest(){
         fetch('/usr/article/getArticles/free')
         .then(data=>data.json())
         .then(data=>{
        const articleList=data.data;
        const latestArticle=articleList[articleList.length-1];
        const content=new Date()+ " : "+latestArticle.title+"<br />";
        $('.place-1').prepend(content);
         });

         }
         </script>
        <button onclick="Article__loadLatest()"class="btn btn-xs">최신글 가져오기</button>

        <div class="border-2 border-[red] min-h-[500px] place-1">
        </div>
    </div>
</section>
<%@ include file="../common/footer.jspf"%>