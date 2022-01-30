package study.designpattern.composite;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class WaitressV2 {
    private MenuComponent allMenus;

    public void print(){
        allMenus.print();
    }
}
