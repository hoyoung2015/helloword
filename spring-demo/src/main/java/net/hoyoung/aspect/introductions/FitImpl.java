package net.hoyoung.aspect.introductions;

/**
 * Created by hoyoung on 16-5-1.
 */
public class FitImpl implements IFit {
    public void filter() {
        System.out.println(this.getClass().getName()+" filter");
    }
}
