package study.designpattern.templatemethod;

import java.util.Scanner;

public class Tea extends CaffeineBeverage {

    @Override
    void brew() {
        System.out.println("찻잎을 우려내는 중");
    }

    @Override
    boolean customerWantsCondiments() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("레몬즙을 넣으시겠습니까? (y/n)");
        String answer = scanner.nextLine();
        // scanner.close();
        if(answer.equalsIgnoreCase("Y")) return true;
        else return false;
    }

    @Override
    void addCondiments() {
        System.out.println("레몬을 추가한다.");
    }
}
