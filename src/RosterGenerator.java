import java.util.*;

public class RosterGenerator {
	public ArrayList<Player> roster = new ArrayList<Player>();
	
	public RosterGenerator(){
		Forward crosby = new Forward("Crosby",41,40,230,24);
		Forward backstrom = new Forward("Backstrom",22,56,142,36);
		Forward granlund = new Forward("Granlund",25,41,164,12);
		Forward paajarvi = new Forward("Paajarvi",6,3,35,4);
		Forward roussel = new Forward("Roussel",12,15,82,115);
		Forward jokinen = new Forward("Jokinen",11,16,109,35);
		Forward burrows = new Forward("Burrows",13,14,128,53);
		Forward versteeg = new Forward("Versteeg",13,16,116,44);
		Forward landeskog = new Forward("Landeskog",15,14,138,58);
		Forward smith = new Forward("Smith",16,16,131,61);
		
		Defensemen karlsson = new Defensemen("Karlsson",14,52,201,22);
		Defensemen krug = new Defensemen("Krug",7,41,194,33);
		Defensemen barrie = new Defensemen("Barrie",6,28,157,16);
		Defensemen green = new Defensemen("Green",11,21,106,38);
		Defensemen phaneuf = new Defensemen("Phaneuf",9,21,143,94); 
		Defensemen mcquaid = new Defensemen("Mcquaid",2,7,59,69);
		
		Goalie bobrovsky = new Goalie("Bobrovsky",1515, 39);
		Goalie jones = new Goalie("Jones",1523, 32);
		Goalie condon = new Goalie("Condon",951, 18);
		Goalie miller = new Goalie("Miller",1396,18);
		
		roster.add(crosby);
		roster.add(backstrom);
		roster.add(granlund);
		roster.add(paajarvi);
		roster.add(roussel);
		roster.add(jokinen);
		roster.add(burrows);
		roster.add(versteeg);
		roster.add(landeskog);
		roster.add(smith);
		roster.add(karlsson);
		roster.add(krug);
		roster.add(barrie);
		roster.add(green);
		roster.add(phaneuf);
		roster.add(mcquaid);
		roster.add(bobrovsky);
		roster.add(jones);
		roster.add(condon);
		roster.add(miller);
	}

	public ArrayList<Player> getRoster() {
		return roster;
	}
	public Player getPlayer(String name){
		for(Player p : roster){
			if(p.getName().equals(name)){
				return p;
			}
		}
		return null;
	}

}
