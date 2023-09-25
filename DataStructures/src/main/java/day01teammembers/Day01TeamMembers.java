package day01teammembers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * exceptions whose parents is RuntimeException is unchecked exception. Checked
 * exceptions must be handled, either throw either catch. ex.get.message() may
 * be store in the log but can't never be shown to client 4 cases that must
 * handle exceptions: file input/output, parsing, database input/output,
 * API/Network access
 *
 */
public class Day01TeamMembers {

    static HashMap<String, ArrayList<String>> playersByTeams = new HashMap<>();

    public static void main(String[] args) {

        String projectPath = System.getProperty("user.dir");
        String path = projectPath + "/src/day01teammembers/" + "teams.txt";
        File file = new File(path);
//        // print the file content as it is
//        try(Scanner inputFile = new Scanner(file)){
//
//            while (inputFile.hasNext())
//            {	
//                // split the line to team name and team members
//                String[] splitContent = inputFile.nextLine().split(":");
//                if (splitContent.length == 2) {
//                    
//                    // get the team name and team members as a string
//                    String teamName = splitContent[0].trim();
//                    String teamMember = splitContent[1].trim();
//                    
//                    // split team members string and store each element into a array list
//                    ArrayList<String> memberList = new ArrayList<>();
//                    String[] members = teamMember.split(",");
//                    for (String member : members) {
//                        memberList.add(member.trim());
//                    }
//                    // set team name as the key and memberlist as the value to a hashmap
//                    playersByTeams.put(teamName, memberList);
//                }             	    	
//            }
//            
//            // print the content from the file
//            for (HashMap.Entry<String, ArrayList<String>> entry : playersByTeams.entrySet()) {
//                System.out.println("Team: " + entry.getKey());
//                System.out.println("Members: " + entry.getValue());
//                System.out.println();
//            }          	    	
//        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
//        }
        
        // print froups by players like: A plays in group1, group2, group3
        try (Scanner inputFile = new Scanner(file)) {
            // hasNext() checks if the scanner has another token in its input,  returns true if it has another non-whitespace character
            // hasNextLine() method checks to see if there’s another line in the input of the Scanner object, no matter if the line is blank or not            
            while (inputFile.hasNextLine()) {
                String[] splitContent = inputFile.nextLine().split(":");
                // skip to next line if data is invalid
                if (splitContent.length != 2) {
                    System.out.println("Invalid data in line, skipping.");
                    continue;
                }

                String teamName = splitContent[0];
                String teamMember = splitContent[1];
                String[] members = teamMember.split(",");

                for (String memberName : members) {
                    String playerName = memberName;
                    ArrayList<String> teamsList;
                    // check if the playerName exsit as a key in the Hashmap
                    if (playersByTeams.containsKey(playerName)) {
                        // get the arraylist associated to this player 
                        teamsList = playersByTeams.get(playerName);
                        // add the team name to the list
                        teamsList.add(teamName);
                    } else { // playerName does not exsit as a key in the Hashmap
                        // create a new ArrayList<String> teamsList
                        teamsList = new ArrayList<>();
                        // add the team name to the list
                        teamsList.add(teamName);
                        playersByTeams.put(playerName, teamsList);
                    }
                }
            }
        } catch (IOException ex) {
            System.out.println("Fatal error: unable to read file, " + ex.getMessage());
        }

        // print the HashMap
//        for (HashMap.Entry<String, ArrayList<String>> entry
//                : playersByTeams.entrySet()) {
//            String playerName = entry.getKey();
//            ArrayList<String> teamsList = entry.getValue();
//            System.out.println(playerName + " plays in: " + String.join(", ", teamsList));
//        }
        for (String playerName : playersByTeams.keySet()) {
            ArrayList<String> teamsList = playersByTeams.get(playerName);
            System.out.printf("%s plays in : %s\n", playerName, String.join(", ", teamsList));
        }

    }
}
