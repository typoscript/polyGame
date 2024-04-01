package main;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import stage.Stage;
import stage.StageBattle;
import stage.StageLobby;
import stage.StageName;

public class GameManager {
	public static Scanner sc = new Scanner(System.in);
	public static boolean isRunning = true;
	private int stageLevel = 1;
	private Map<StageName, Stage> stages = new HashMap<StageName, Stage>();
	private StageName currentStage;
	
	public GameManager() {
		stages.put(StageName.LOBBY, new StageLobby());
		stages.put(StageName.BATTLE, new StageBattle());
		
		currentStage = StageName.LOBBY;
	}

	public void run() {
		while (isRunning) {
			Stage stage = stages.get(currentStage);
			
			stage.run();
			
			switch (currentStage) {
				case LOBBY:
					currentStage = StageName.BATTLE;
					break;
				case BATTLE:
					currentStage = StageName.LOBBY;
					stageLevel++;
					break;
			}
		}
		
		System.out.println("게임 종료");
	}
}
