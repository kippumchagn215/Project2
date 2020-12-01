//kjc190001 kippumchang
package project2;


import java.io.*;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {
	 
    public static int numberofplayers (String filename) throws IOException
    { // counting the number of player by reading each line of the inputfile
        int countplayer = 0;
        LineNumberReader L1= new LineNumberReader(new FileReader(filename));// reading the lines by using line reader
        while ((L1.readLine())!=null) {};	// reading the line while its not null
        countplayer = L1.getLineNumber(); // number of lines equals the number of player
        L1.close();
        return countplayer;
    }
  public static float[] Findingleader(boolean[] ineligible,float[] stat, int numberofplayer)
    {   // iterating through the array to find the highest value
        float first,second,third; // initializing to negative number, so even a zero can be the leader value
        first=second=third = -100;
        for (int a = 0; a<numberofplayer; a++) // loops till a is less than numofplayer
        {

            if ((first<stat[a]||first==stat[a])&& ineligible[a] != true)// if stat is higher or same as first, and the stat is not empty
            {	if(first==stat[a]) { // ignore the tie because the second value will be same as the first value
            	}
            	else {
                third = second; // previous second value becomes third 
                second = first; // previous fisrt value becomes second  now
                first = stat[a]; // replace the first value with stat[a]
            	}
            }
            else if((second<stat[a]||second==stat[a])&& ineligible[a] != true) { // if stat is higher than or equal to second value
            	if(second==stat[a]) { // ignoring the tie 
                	}
                	else {
            	third = second; // previous second value is now assigned to third
            	second = stat[a]; // second is replaced by the value of stat[a]
                	}
            }
            else if((third<stat[a]||third==stat[a])&& ineligible[a] != true) { // if stat is higher than or equal the third value
            	if(third==stat[a]) { // ignoring the tie value
                	}
                	else {
            	third = stat[a]; // third value is now replaced by the stat[a]
                	}
            }
        }
        float []top3value = {first,second,third}; // using array to return more than 1 value
        return top3value; // top3value array
    }
    public static float[] FindingKleader(boolean[] ineligible, float[] kstat, int numberofplayer)
    {   //iterating through the array to find the lowest value
        float first,second,third;
        first=second=third = Float.POSITIVE_INFINITY; // assigned positive infinity so any integer lower than infinity can be assigned to leader value
        for (int a = 0; a<numberofplayer; a++) // for number of players
        {

            if ((first>kstat[a]||first==kstat[a]) && ineligible[a] != true)// if stat exists and the stat is equal to or greater than first 
            {	if(first==kstat[a]) { // do nothing if the stat is same fisrt value
            	}
            	else { // if not tie
                third = second; // previous second value is assigned to third  
                second = first; // previous first value is now assigned to second
                first = kstat[a]; // value of the stat is now assigned to first
            	}
            }
            else if((second>kstat[a]||second==kstat[a]) && ineligible[a] != true) {
            	if(second==kstat[a]) {
                	}
                	else {
            	third = second;// previous second value is assigned to third
            	second = kstat[a]; // value of second is stat 
                	}
            	}
       	else if((third>kstat[a]||third==kstat[a]) && ineligible[a] != true) {
       		if(third==kstat[a]) {
            	}
            	else {
        	third = kstat[a]; // value of third is replace by the value of stat
            	}
        }
        }
        float[] top3kleader = {first,second,third};
        return top3kleader;
    }
    public static String[] displayleader(boolean[] ineligible, String[] name, float []top3, float[] stat, int numberofplayer)
    {   //iterating through the array to find the name that matches with the leader value

        String top1name,top2name,top3name;
        top1name = top2name = top3name = ""; // initialize null value of all names 
        int top1counter,top2counter,top3counter;
        top1counter = top2counter = top3counter = 0; // initialize 0 to all counters
        String top1namearray[] = new String[50]; // arrays to hold top3 names
        String top2namearray[] = new String[50];
        String top3namearray[] = new String[50];
        int a,b,c;
        a=b=c= 0;
        for (int i=0;i<numberofplayer;i++)
        {	
            if (top3[0]==stat[i] && ineligible[i] != true) { // if the value of top1 equals the stat of player
                if (top1counter < 1) { // if the first place is only one person
                	top1namearray[a]=name[i]; // putting in array to sort
                    top1name=name[i]; // assign name to top1name array
                    a++;
                } else {
                 top1namearray[a]=name[i]; // if there is more than one person with the top1 value
                 top1name = top1name + ", " + name[i];//if there is more than one leader, it prints out the names of the leader with comma between.
                 a++;
                }
                top1counter++;
            }
            if (top3[1]==stat[i] && ineligible[i] != true) { // if the value of top2 equals the stat of player
                if (top2counter < 1) {
                	top2namearray[b]=name[i];
                    top2name=name[i];
                    b++;
                } else {
                	top2namearray[b]=name[i];
                    top2name = top2name + ", " + name[i];//if there is more than one leader, it prints out the names of the leader with comma between.
                    b++;
                }
                top2counter++;
            }
            if (top3[2]==stat[i] && ineligible[i] != true) {// if the value of top1 equals the stat of player
                if (top3counter < 1) {
                	top3namearray[c]=name[i];
                    top3name=name[i];
                    c++;
                } else {
                	top3namearray[c]=name[i];
                    top3name = top3name + ", " + name[i];//if there is more than one leader, it prints out the names of the leader with comma between.
                    c++;
                }
                top3counter++;
            }
        }
        sortname(top1namearray);// sorting the names of top1players in alphabetical order
        sortname(top2namearray);// sorting the names of top2players in alphabetical order
        sortname(top3namearray);// sorting the names of top3players in alphabetical order
        int q =1;
       if(top1counter >1) { top1name = top1namearray[0];} // reassigning name of top 1 value in alphabetical order if there is more than one
        while (top1namearray[q]!=null&&top1counter!=1) { // while there is more than 1 player with top1value and while top1name is not null
        	top1name = top1name + ", " + top1namearray[q]; //inserting comma between names
        	q++;
        }
        q=1;
        if(top2counter >1) { top2name = top2namearray[0];}// reassigning name of top 1 value in alphabetical order if there is more than one
        while (top2namearray[q]!=null&&top2counter!=1) { // while there is more than 1 player with top2value and while top2name is not null
        	top2name = top2name + ", " + top2namearray[q]; //inserting comma between names
        	q++;
        }
        q=1;
        if(top3counter >1) { top3name = top3namearray[0];}// reassigning name of top 1 value in alphabetical order if there is more than one
        while (top3namearray[q]!=null&&top3counter!=1) { // while there is more than 1 player with top3value and while top3name is not null
        	top3name = top3name + ", " + top3namearray[q]; //inserting comma between names
        	q++;
        }
        if(numberofplayer ==1) {top2name = null; top3name = null;} // if there is only one player top2 and top3 does not exist
        else if (numberofplayer==2&&top1counter<2) {top3name =null;} // if there is only 2 players top3 is null
        else if(numberofplayer==2&&top1counter>1) {top2name =null;top3name=null;} // if there is 2 players but 2players have tie value then top2 and top3 is null
        else if(top1counter>2) {top2name=null;top3name=null;} // if there is more than 2 ties with top1value, top2 and top3 does not exist
        else if(top2counter>1||top1counter>1) {top3name=null;} // if there is more than one top1 or top2, then top3 does not exist
        String []top3names = {top1name,top2name,top3name};
        return top3names;
    }
    public static String [] sortname(String[] names) {
    	
		for(int i =0;i<names.length;i++) {// for size of array
		int j =0;
		while(j<names.length-1&&names[j+1]!=null) { // while less than size of array and the next of the array is not null
		if(names[j].compareTo(names[j+1])<0) { // if its already in alphabetical order do nothing
			//good
		}
		else { // if not in alphabetical order
			String temp = names[j]; // made temp to temporary hold the firstname
			names[j]= names[j+1]; // assign second names to first
			names[j+1] = temp; // assign temp that holding firstname to second name
		}
		j++;
		}
		}
    	return names;
    }


    public static void main(String[] args) {                        
        Scanner scan = new Scanner(System.in);
        String inputfilename = scan.nextLine();
        scan.close();
        String line;
        int i = 0;
        String []namearray = new String[50];
        float []battingaverage = new float[50];
        float []onbasepercentage = new float [50];
        float []hitarray = new float[50];
        float []walkarray = new float[50];
        float []strikeoutarray = new float[50];
        float []hitbypitcharray = new float[50];
        float []sacrificearray = new float[50];
        boolean []ineligible = new boolean[50]; 
        String [] strplayerstat;
        String [] strplayerstat1;
        char [] charplayerstat;
        DecimalFormat d1 = new DecimalFormat ();
        d1.setMinimumFractionDigits(3); // forcing it to printout 3 decimal places when needed
        LinkList l1 = new LinkList();
        BufferedReader br = null;
        BufferedReader br1 = null;
        try {
        	
        	File file1 = new File("organizedfile.txt"); // creating new file that contains trimed and organized version of inputfile
        	File file2 = new File("leaders.txt"); // output file
        	FileWriter f2 = new FileWriter(file1); // printwriter and filewriter to write on file organizedfile.txt
        	PrintWriter p2 = new PrintWriter(f2); 
        	FileWriter f3 = new FileWriter(file2); // printwriter and filewriter to write outputfile
    		PrintWriter p3 = new PrintWriter(f3);
    	   int numofplayer = numberofplayers(inputfilename); //determine the numofplayer by reading inputfile
    	   br = new BufferedReader (new FileReader(inputfilename)); // reading inputfile by bufferedreader
    	   br1 = new BufferedReader(new FileReader(file1)); // reading organizedfile by buffered reader
           String testnames[] = new String[50];
           String teststat[] = new String[50];
           int q=0;
           while ((line= br.readLine())!=null) { 
        	   strplayerstat1 = line.split(" ");// Splitting the line at the space between name and stat
        	   testnames[q] = strplayerstat1[0]; //  assign name to test names array
        	   teststat[q] = strplayerstat1[1];   // assigning stat to teststatarray
        		q++;
        	   
        	   }
           	for(int x =0;x<numofplayer-1;x++) { // for num of player
           		for(int y=1;y<numofplayer;y++) {
           		if((testnames[x].toUpperCase()).equals((testnames[y].toUpperCase()))&&x!=y) { // checking if there's a multiple entry for the same player
           			teststat[x]=teststat[x]+teststat[y]; // add stats together
           			testnames[y]=""; teststat[y]=""; // assign nothing to name and stat
           		}	
           		
           		}
           	}
           	int temp = numofplayer;
           	for(int x=0;x<temp;x++) { 
           		if(testnames[x].trim().equals("")||teststat[x].trim().equals("")) //trim the namearray and testarray and if the trimed result is nothing do below
           		{numofplayer--;} // -1 everytime there's a another entry for a sameplayer
           		else{p2.println(testnames[x]+" "+teststat[x]);} // print only the names and stat to organizedfile.txt, so that organizedfile does not contain multiple stat for same person
           	}

           	p2.close();
            while ((line= br1.readLine()) !=null) {		//reading the organized file line by line till there is nothing
                Player player = new Player();	//every time it reads line by line, create new player
                float H=0,O=0,K=0,W=0,P=0,S=0; // initialize every stat variable to 0
                float inv = 0;
                strplayerstat = line.split(" "); //split in to names and stat
               
                  if (strplayerstat.length < 2) { // if there is no stat for the player
                    onbasepercentage[i] = 0; // ob is 0 and prevents diving the stat by 0
                    ineligible[i] = true; //checking if the player actually has the data
                } else {
                    charplayerstat= strplayerstat[1].toCharArray(); // changing stat to char array
                    for (int x=0;x<strplayerstat[1].length();x++) {    //using loop to find the stat for eachplayer
                        if ( charplayerstat[x] == 'H') {H++;} // if the char is H H++
                        else if (charplayerstat[x] == 'O') {O++;} // if the char is O O++
                        else if ( charplayerstat[x] == 'K') {K++;} // if the char is K K++
                        else if ( charplayerstat[x] == 'W') {W++;} // if the char is W W++
                        else if ( charplayerstat[x] == 'P') {P++;} // if the char is P P++
                        else if	( charplayerstat[x] == 'S') {S++;}// if the char is S S++
                        else {inv++;} // if the char is non of above, it is considered invalid input, therefore inv ++
                    }
                    onbasepercentage[i] =((H+W+P)/(strplayerstat[1].length()-inv));// calculating onbase percentage, and the plate appearance is length = inv, so the invalid input is not included in plateappearace
                } 
                if (H+O+K > 0) {                 // if at bat value is higher than zero
                    battingaverage[i] = (H/(H+O+K)); // BA = hits / atbat
                } else {
                    battingaverage[i] = 0; // if at bat value is 0, the batting average is also zero
                }
                namearray[i]= strplayerstat[0]; // assigning all the player names into namearray
                hitarray[i]=H; // assigning all the hit values to hit array
                walkarray[i]=W; // assigning all the walk values to walkarray
                strikeoutarray[i]=K; // assigning all the Strikeout values to strike out array
                hitbypitcharray[i]=P;  // assign all the hbp to hbp array
                player.name = strplayerstat[0]; // assign names to player attribute
                player.atbat=(H+O+K); // assign at-bat attribute by adding hits,out,and strikeouts 
                player.hits=H; // assign this value to hit attribute
                player.walks=W; // assign walks value to player attribute
                player.so=K;// assign strikeout to player attribute
                player.hbp=P;// assign hbp value to player attribute
                player.sacrifice=S;// assign sacrifice value to player attribute
                player.plateappearance=strplayerstat[1].length()-inv;// input validation to prevent invalid input affecting the OB%
                Node node = new Node(player); // making new node each time it loop and takes difference player and player values everytime
                l1.insert(node); // adding node to the end of the linklist everytime it loops 
                i++;
            }
        Player p1 = new Player();  
         for (int aa=0;aa<numofplayer+1;aa++) { // for number of player +1  , sort the linked list data in alphabetical order
        	l1.sort();
        }
         i=0;
         Node n = new Node();n=l1.head; // temporary node variable to hold the head
         l1.print (p3,n); // printing all the data to output file
         float []top3valueBA = Findingleader(ineligible,battingaverage,numofplayer); //calculating top3 values of BA
         String []top3namesBA =displayleader(ineligible,namearray,top3valueBA,battingaverage,numofplayer); // calculating top 3 names of BA
        
         float []top3valueOB = Findingleader(ineligible,onbasepercentage,numofplayer);//calculating top3 values of OB
         String []top3namesOB =displayleader(ineligible,namearray,top3valueOB,onbasepercentage,numofplayer); // calculating top 3 names of OB

         float []top3valueH = Findingleader(ineligible,hitarray,numofplayer);//calculating top3 values of hits
         String []top3namesH =displayleader(ineligible,namearray,top3valueH,hitarray,numofplayer); // calculating top 3 names of hits
         
         float []top3valueW = Findingleader(ineligible,walkarray,numofplayer);//calculating top3 values of walks
         String []top3namesW =displayleader(ineligible,namearray,top3valueW,walkarray,numofplayer); // calculating top 3 names of walks
         
         float []top3valueSO = FindingKleader(ineligible,strikeoutarray,numofplayer);//calculating top3 values of strikeout
         String []top3namesSO =displayleader(ineligible,namearray,top3valueSO,strikeoutarray,numofplayer); // calculating top 3 names of strikeout

         float []top3valueHBP = Findingleader(ineligible,hitbypitcharray,numofplayer);//calculating top3 values of hbp
         String []top3namesHBP =displayleader(ineligible,namearray,top3valueHBP,hitbypitcharray,numofplayer); // calculating top 3 names of hbp
         p3.println("LEAGUE LEADERS"); // printing to outputfile
         p3.println("BATTING AVERAGE");// printing to outputfile
         while( i<3 && displayleader(ineligible,namearray,top3valueBA,battingaverage,numofplayer)[i]!=null) { // while the value is not null and its less than 3 
   		 p3.println(d1.format(top3valueBA[i])+"\t"+top3namesBA[i]); // printout top 3 leaders
   		 i++;
   		 }
         p3.println();
         i=0;
         p3.println("ON-BASE PERCENTAGE");// printing to outputfile
         while( i<3 && displayleader(ineligible,namearray,top3valueOB,onbasepercentage,numofplayer)[i]!=null) { // while the value is not null and its less than 3 
       		 p3.println(d1.format(top3valueOB[i])+"\t"+top3namesOB[i]);// printout top 3 leaders
       		 i++;
       		 }
         p3.println();
         i=0;
         p3.println("HITS");// printing to outputfile
         while( i<3 && displayleader(ineligible,namearray,top3valueH,hitarray,numofplayer)[i]!=null) {// while the value is not null and its less than 3 
       		 p3.println((int)top3valueH[i]+"\t"+top3namesH[i]);// printout top 3 leaders
       		 i++;
       		 }
         p3.println();
         i=0;
         p3.println("WALKS");// printing to outputfile
         while( i<3 && displayleader(ineligible,namearray,top3valueW,walkarray,numofplayer)[i]!=null) {// while the value is not null and its less than 3 
       		 p3.println((int)top3valueW[i]+"\t"+top3namesW[i]);// printout top 3 leaders
       		 i++;
       		 }
        p3.println();
         i=0;
         p3.println("STRIKEOUTS");// printing to outputfile
         while( i<3 && displayleader(ineligible,namearray,top3valueSO,strikeoutarray,numofplayer)[i]!=null) {// while the value is not null and its less than 3 
       		 p3.println((int)top3valueSO[i]+"\t"+top3namesSO[i]);// printout top 3 leaders
       		 i++;
       		 }
         p3.println();
         i=0;
         p3.println("HIT BY PITCH");// printing to outputfile
         while( i<3 && displayleader(ineligible,namearray,top3valueHBP,hitbypitcharray,numofplayer)[i]!=null) {// while the value is not null and its less than 3 
       		 p3.println((int)top3valueHBP[i]+"\t"+top3namesHBP[i]);// printout top 3 leaders
       		 i++;
       		 }
         p3.println();
         p3.close(); // closing the printwriter
         i=0;

        } catch (IOException e) { 
            e.printStackTrace();
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
