package com.company;

import java.util.Stack;

/**
 * @program: 备忘录模式
 * @description:
 * @author: Mr.Huang
 * @create: 2020-10-18 20:29
 **/
public class DraftsBox {
   private final Stack<ArticleMemento> STACK = new Stack<ArticleMemento>();

    public ArticleMemento getMemento(){
        ArticleMemento articleMemento = STACK.pop();
        return articleMemento;
    }

    public void addMemento(ArticleMemento articleMemento){
        STACK.push(articleMemento);
    }

}
