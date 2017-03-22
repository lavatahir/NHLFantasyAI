import java.util.*;

public class RosterGenerator {
	public ArrayList<Player> roster;
	
	public RosterGenerator(){
		Forward crosby = new Forward(41,40,230,24);
		Forward backstrom = new Forward(22,56,142,36);
		Forward granlund = new Forward(25,41,164,12);
		Forward paajarvi = new Forward(6,3,35,4);
		Forward roussel = new Forward(12,15,82,115);
		Forward jokinen = new Forward(11,16,109,35);
		Forward burrows = new Forward(13,14,128,53);
		Forward versteeg = new Forward(13,16,116,44);
		Forward landeskog = new Forward(15,14,138,58);
		Forward smith = new Forward(16,16,131,61);
		
		Defensemen karlsson = new Defensemen(14,52,201,22);
		Defensemen krug = new Defensemen(7,41,194,33);
		Defensemen barrie = new Defensemen(6,28,157,16);
		Defensemen green = new Defensemen(11,21,106,38);
		Defensemen phaneuf = new Defensemen(9,21,143,94); 
		Defensemen mcquaid = new Defensemen(2,7,59,69);
		
		Goalie bobrovsky = new Goalie(1515, 39);
		Goalie jones = new Goalie(1523, 32);
		Goalie condon = new Goalie(951, 18);
		Goalie miller = new Goalie(1396,18);
	}

}
