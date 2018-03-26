package com.example.first;
import akka.actor.AbstractActor;
import akka.actor.Props;
import akka.japi.pf.ReceiveBuilder;

public class MyActor extends AbstractActor {

	private static final String MESSAGE_RECEIVED = "Message received : %s by actor : %s";

	public static Props props() {
		return Props.create(MyActor.class, ()-> new MyActor());
	}

	public Receive createReceive() {
		return ReceiveBuilder.create().match(String.class, message-> {
			System.out.println(String.format(MESSAGE_RECEIVED, message, getSelf()));
			Thread.sleep(100);
		}).build();
	}
}
