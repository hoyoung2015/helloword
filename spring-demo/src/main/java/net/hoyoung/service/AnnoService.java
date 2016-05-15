package net.hoyoung.service;

import org.springframework.stereotype.Service;

/**
 * Created by hoyoung on 16-5-1.
 */
@Service
public class AnnoService {
    public void doService(){
        System.out.println(this.getClass().getName()+" doService");
    }
}
