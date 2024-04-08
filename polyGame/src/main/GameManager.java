package main;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import stage.Stage;
import stage.StageBattle;
import stage.StageLobby;
import stage.StageMarket;
import stage.StageName;

public class GameManager {
	public static boolean isRunning = true;
	private Map<StageName, Stage> stages = new HashMap<StageName, Stage>();
	private StageName currentStage;
	
	public GameManager() {
		stages.put(StageName.LOBBY, new StageLobby());
		stages.put(StageName.MARKET, new StageMarket());
		stages.put(StageName.BATTLE, new StageBattle());
		
		currentStage = StageName.LOBBY;
	}
	
	public void run() {
		while (isRunning) {
			Stage stage = stages.get(currentStage);

			currentStage = stage.run();
		}
		
		System.out.println("게임 종료");
	}
}
