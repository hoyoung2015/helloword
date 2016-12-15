package net.hoyoung.helloword;

import akka.actor.ActorSystem;
import akka.actor.UntypedActor;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );

        ActorSystem system = ActorSystem.create("hello-akka");
//        system.actorOf(Props)
        system.shutdown();
    }
    public static class Greeter extends UntypedActor{

        @Override
        public void onReceive(Object o) throws Exception {
            if(o instanceof String){
                System.out.println(o);
            }
        }
    }
}
