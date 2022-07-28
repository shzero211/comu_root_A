package com.ll.comu;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/usr/*")
public class DispatchServlet extends HttpServlet{
    ArticleRepository articleRepository=new ArticleRepository();
    ArticleService articleService=new ArticleService(articleRepository);
    MemberController memberController=new MemberController();
    ArticleController articleController=new ArticleController(articleService);
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Rq rq=new Rq(req,resp);


        switch (rq.getMethod()){
            case "GET":
                switch(rq.getActionPath()){
                    case "/usr/article/detail":
                        articleController.showDetail(rq);
                        break;
                    case "/usr/article/list":
                        articleController.showList(rq);
                        break;
                    case "/usr/article/delete":
                        articleController.deleteWrite(rq);
                        break;
                    case "/usr/article/write":
                        articleController.showWrite(rq);
                        break;
                    case "/usr/article/modify":
                        articleController.showModify(rq);
                        break;
                    case  "/usr/member/login":
                        memberController.showLogin(rq);
                        break;

                }
                break;

            case "POST":
                switch (rq.getActionPath()){
                    case "/usr/article/write":
                        articleController.doWrite(rq);
                        break;
                    case "/usr/article/modify":
                        articleController.doModify(rq);
                        break;
                }
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       doGet(req,resp);
    }
}
