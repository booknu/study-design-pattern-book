package study.designpattern.templatemethod;

import java.util.Scanner;

public class Coffee extends CaffeineBeverage {

    @Override
    void brew() {
        System.out.println("커피를 우려내는 중");
    }

    @Override
    boolean customerWantsCondiments() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("카페모카로 드시겠습니까? (y/n)");
        String answer = scanner.nextLine();
        // scanner.close();
        if(answer.equalsIgnoreCase("Y")) {
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    void addCondiments() {
        System.out.println("초코시럽 첨가하기");
    }
}
