package com.example.first;

import akka.actor.ActorSystem;
import akka.actor.ActorRef;

public class Main {

	private static final String ACTOR_SYSTEM_NAME = "MyActorSystem";
	private static final String ACTOR_NAME = "MyClassActor";
	private static final String MESSAGE = "Ping : %d";

	public static void main(String[] args) {
		//Initialize ActorSystem
		ActorSystem system = ActorSystem.create(ACTOR_SYSTEM_NAME);

		//Creating Instance of MyActor and accessing it via ActorRef
		ActorRef myActor = system.actorOf(MyActor.props(), ACTOR_NAME);

		for(int i = 1; i <= 10; i++) {
			//Sending message to MyActor
			myActor.tell(String.format(MESSAGE, i), ActorRef.noSender());
		}

		try {
			Thread.sleep(1100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("Terminating application");
		system.terminate();
	}
}