package study.designpattern;

import study.designpattern.templatemethod.Coffee;
import study.designpattern.templatemethod.Tea;

public class App {
    public static void main(String[] args) {
        Tea tea = new Tea();
        System.out.println("차 준비 중...");
        tea.prepareRecipe();

        Coffee coffee = new Coffee();
        System.out.println("커피 준비 중...");
        coffee.prepareRecipe();
    }
}
