package com.text.speak.translator;

import java.util.HashMap;

public class Message {

	// create map for collection of words both text speak and proper English
	private static HashMap<String,String> wordMapEng = new HashMap<String,String>();
	private static HashMap<String,String> wordMapTxt = new HashMap<String,String>();
	private static boolean createHashMap=false;


	public static boolean getCreateHashMap(){
		return createHashMap;
	}

	public static void setCreateHashMap(){
		createHashMap=true;
	}

	// translates from English to text
	public static String engToText(String text){
		//checks to see if the hashmaps have already been filled	
		if(getCreateHashMap()==false){
			fillMap();
			setCreateHashMap();
		}
		text=text.toLowerCase();
		String translated=" ";
		String regex=null;

		//breaks string into tokens using whitespace as delimiter
		String[] tokens = text.split("\\s+");//("\\W+")

		// checks for 4 word combination
		for(int i=0,a=1,b=2,c=3;c<tokens.length;i++,a++,b++,c++){
			regex = tokens[i]+" "+tokens[a]+" "+tokens[b]+" "+tokens[c];
			if(wordMapEng.containsKey(regex)){
				//if a match is found set 1st element to txt speak equivalent
				tokens[i]=wordMapEng.get(regex);
				tokens[a]=" ";
				tokens[b]=" ";
				tokens[c]=" ";
			}

		}

		// check for 3 word combination
		for(int i=0,a=1,b=2;b<tokens.length;i++,a++,b++){
			regex = tokens[i]+" "+tokens[a]+" "+tokens[b];
			if(wordMapEng.containsKey(regex)){
				//if a match is found set 1st element to txt speak equivalent
				tokens[i]=wordMapEng.get(regex);
				tokens[a]=" ";
				tokens[b]=" ";
			}

		}
		// check for 2 word combination
		for(int i=0,a=1;a<tokens.length;i++,a++){
			regex = tokens[i]+" "+tokens[a];
			if(wordMapEng.containsKey(regex)){
				//if a match is found set 1st element to txt speak equivalent
				tokens[i]=wordMapEng.get(regex);
				tokens[a]=" ";
			}

		}
		// check for single words				
		for(int x=0;x<tokens.length;x++){
			//test to see if element is whitespace
			if(tokens[x]==" "){
				continue;
			}
			if(wordMapEng.containsKey(tokens[x])){
				translated+=" "+wordMapEng.get(tokens[x]);
			}else{
				translated+=" "+tokens[x];//removed " "+
			}
		}
		
		
		//breaking string into tokens using non words as delimiter
		String[] tokens2 = translated.split("\\W+");
		translated=" ";
		// checks for 4 word combination
		for(int i=0,a=1,b=2,c=3;c<tokens2.length;i++,a++,b++,c++){
			regex = tokens2[i]+" "+tokens2[a]+" "+tokens2[b]+" "+tokens2[c];
			if(wordMapEng.containsKey(regex)){
				//if a match is found set 1st element to txt speak equivalent and remaining elements to whitespace
				tokens2[i]=wordMapEng.get(regex);
				tokens2[a]=" ";
				tokens2[b]=" ";
				tokens2[c]=" ";
			}

		}

		// check for 3 word combination
		for(int i=0,a=1,b=2;b<tokens2.length;i++,a++,b++){
			regex = tokens2[i]+" "+tokens2[a]+" "+tokens2[b];
			if(wordMapEng.containsKey(regex)){
				//if a match is found set 1st element to txt speak equivalent
				tokens2[i]=wordMapEng.get(regex);
				tokens2[a]=" ";
				tokens2[b]=" ";
			}

		}
		// check for 2 word combination
		for(int i=0,a=1;a<tokens2.length;i++,a++){
			regex = tokens2[i]+" "+tokens2[a];
			if(wordMapEng.containsKey(regex)){
				//if a match is found set 1st element to txt speak equivalent
				tokens2[i]=wordMapEng.get(regex);
				tokens2[a]=" ";
			}

		}
		// check for single words				
		for(int x=0;x<tokens2.length;x++){
			//test to see if element is whitespace
			if(tokens2[x]==" "){
				continue;
			}
			if(wordMapEng.containsKey(tokens2[x])){
				translated+=" "+wordMapEng.get(tokens2[x]);
			}else{
				translated+=" "+tokens2[x];//removed " "+
			}
		}
		

		return translated.trim();
	}

	// translates from text speak to English
	public static String textToEng(String text){
		//checks to see if the hashmaps have already been filled	
		if(getCreateHashMap()==false){
			fillMap();
			setCreateHashMap();
		}

		text=text.toLowerCase();
		String translated=" ";
		String[] tokens = text.split("\\W+");

		for(int x=0;x<tokens.length;x++){
			if(wordMapTxt.containsKey(tokens[x])){
				translated+=" "+wordMapTxt.get(tokens[x]);
			}else{
				translated+=" " + tokens[x];
			}
		}

		return translated.trim();
	}

	//fill map with English->text speak
	public static void fillMap(){
		wordMapEng.put("ate","8");
		wordMapTxt.put("8","ate");

		wordMapEng.put("all my love","aml");
		wordMapTxt.put("aml","all my love");

		wordMapEng.put("annoying","anoyn");
		wordMapTxt.put("anoyn","annoying");
		wordMapTxt.put("annoyin","annoying");

		wordMapEng.put("about to ","abt2");
		wordMapTxt.put("abt2","about to");

		wordMapEng.put("at","@");
		wordMapTxt.put("@","at");

		wordMapEng.put("answer","ans");
		wordMapTxt.put("ans","answer");

		wordMapEng.put("attitude","ata2ud");
		wordMapTxt.put("ata2ud","attitude");

		wordMapEng.put("await","aw8");
		wordMapTxt.put("aw8","await");

		wordMapEng.put("average","avg");
		wordMapTxt.put("avg","average");

		wordMapEng.put("attention","attn");
		wordMapTxt.put("attn","attention");

		wordMapEng.put("another","notha");
		wordMapTxt.put("notha","another");

		wordMapEng.put("are you ok","ruok");
		wordMapTxt.put("ruok","are you ok");

		wordMapEng.put("as far as i know","afaik");
		wordMapTxt.put("afaik","as far as i know");

		wordMapEng.put("as soon as possible","asap");
		wordMapTxt.put("asap","as soon as possible");

		wordMapEng.put("at the moment","atm");
		wordMapTxt.put("atm","at the moment");

		wordMapEng.put("away from keyboard","afk");
		wordMapTxt.put("afk","away from keyboard");

		wordMapEng.put("anything","nethng");
		wordMapTxt.put("nethng","anything");
		wordMapTxt.put("anythin","anything");

		wordMapEng.put("are","r");
		wordMapTxt.put("r","are");

		wordMapEng.put("as far as im concerned","afaik");
		wordMapTxt.put("afaic","as far as im concerned");

		wordMapEng.put("as far as i can tell","afaict");
		wordMapTxt.put("afaict","as far as I can tell");

		wordMapEng.put("all fucked up","afu");
		wordMapTxt.put("afu","all f**ked up");

		wordMapEng.put("also known as","aka");
		wordMapTxt.put("aka","also known as");

		wordMapEng.put("as i see it","aisi");
		wordMapTxt.put("aisi","as i see it");


		wordMapTxt.put("asl","age,sex,location");

		wordMapEng.put("austrailia","oz");
		wordMapTxt.put("oz","austrailia");

		wordMapEng.put("address","adr");
		wordMapTxt.put("adr","address");

		wordMapEng.put("absent without leave","awol");
		wordMapTxt.put("awol","absent without leave");

		wordMapEng.put("as you know","ayk");
		wordMapTxt.put("ayk","as you know");

		wordMapEng.put("anyone","any1");
		wordMapTxt.put("any1","anyone");
		wordMapTxt.put("ne1", "anyone");

		wordMapEng.put("better","betr");
		wordMapTxt.put("betr","better");

		wordMapEng.put("bye for now","bfn");
		wordMapTxt.put("bfn","by for now");

		wordMapEng.put("brother","bro");
		wordMapTxt.put("bro","brother");

		wordMapEng.put("breeze","brez");
		wordMapTxt.put("brez","breeze");

		wordMapEng.put("batter","b@r");
		wordMapTxt.put("b@r","batter");

		wordMapEng.put("been there done that","btdt");
		wordMapTxt.put("btdt","been there done that");

		wordMapEng.put("bottle","btl");
		wordMapTxt.put("btl","btl");

		wordMapEng.put("bored to tears","btt");
		wordMapEng.put("bored to tear's","btt");
		wordMapTxt.put("btt","bored to tears");

		wordMapEng.put("bizarre","bzar");
		wordMapTxt.put("bzar","bizarre");

		wordMapEng.put("busy","bzy");
		wordMapTxt.put("bzy","busy");

		wordMapEng.put("battery","b@tre");
		wordMapTxt.put("b@tre","battery");

		wordMapEng.put("basics","ba6");
		wordMapTxt.put("ba6","basics");

		wordMapEng.put("balance","balns");
		wordMapTxt.put("balns","balance");

		wordMapEng.put("barbecue","bbq");
		wordMapTxt.put("bbq","barbecue");		

		wordMapEng.put("back","bak");
		wordMapTxt.put("bak","back");

		wordMapEng.put("be right back","brb");
		wordMapTxt.put("brb","be right back");

		wordMapEng.put("be right there","brt");
		wordMapTxt.put("brt","be right there");

		wordMapEng.put("by the way","btw");
		wordMapTxt.put("btw","by the way");

		wordMapEng.put("bye for now","bfn");
		wordMapTxt.put("bfn","by for now");

		wordMapEng.put("be","b");
		wordMapTxt.put("b","be");	

		wordMapEng.put("because","coz");
		wordMapTxt.put("coz","because");
		wordMapTxt.put("cuz","because");
		wordMapTxt.put("bc","because");
		wordMapTxt.put("bcoz","because");

		wordMapEng.put("boyfriend","bf");
		wordMapTxt.put("bf","boyfriend");

		wordMapEng.put("ben","bongjamen");
		wordMapTxt.put("ben","bongjamen");

		wordMapEng.put("before","b4");
		wordMapTxt.put("b4","before");

		wordMapTxt.put("biffo","big ignorant fucker from offaly");

		wordMapEng.put("gordon","stud muffin extraodinare");
		wordMapTxt.put("gordon","stud muffin extraodinare");

		wordMapEng.put("butt ugly","bugly");
		wordMapTxt.put("bugly","butt ugly");

		wordMapEng.put("before you","b4u");
		wordMapTxt.put("b4u","before you");

		wordMapEng.put("before","b4");
		wordMapTxt.put("b4","before");

		wordMapEng.put("best friend forever","nethng");
		wordMapTxt.put("bff","best friend forever");

		wordMapEng.put("better known as","bka");
		wordMapTxt.put("bka","better known as");

		wordMapEng.put("best wishes","bw");
		wordMapTxt.put("bw","best wishes");

		wordMapEng.put("but you knew that","bykt");
		wordMapTxt.put("bykt","but you knew that");

		wordMapEng.put("come and","com&");
		wordMapTxt.put("com&","come and");

		wordMapEng.put("combat","comb@");
		wordMapTxt.put("comb@","combat");

		wordMapEng.put("communicate","communic8");
		wordMapTxt.put("communic8","communicate");

		wordMapEng.put("complicate","complic8");
		wordMapTxt.put("complic8","complicate");

		wordMapEng.put("complex","complx");
		wordMapTxt.put("complx","complex");

		wordMapEng.put("company","compne");
		wordMapTxt.put("compne","company");

		wordMapEng.put("confuse","confuz");
		wordMapTxt.put("confuz","confuse");

		wordMapEng.put("congratulate","congrats");
		wordMapTxt.put("congrats","congratulate");

		wordMapEng.put("crazy","craZ");
		wordMapTxt.put("craz","crazy");

		wordMapEng.put("cant wait to see you","cw2cu");
		wordMapTxt.put("cw2cu","cant wait to see you");


		wordMapEng.put("centre","centr");
		wordMapTxt.put("centr","centre");

		wordMapEng.put("cant", "cnt");
		wordMapTxt.put("cnt","cant");

		wordMapEng.put("chocolate","chocl@");
		wordMapTxt.put("chocl@","chocolate");

		wordMapEng.put("chess","ch$");
		wordMapTxt.put("ch$","chess");

		wordMapEng.put("click", "clik");
		wordMapTxt.put("clik","click");

		wordMapEng.put("calm", "clm");
		wordMapTxt.put("clm","calm");

		wordMapEng.put("computer", "cmputa");
		wordMapTxt.put("cmputa","computer");

		wordMapEng.put("cathal", "cathal the legend");
		wordMapTxt.put("cathal","cathal the legend");

		wordMapEng.put("see you","cu");
		wordMapTxt.put("cu","see you");

		wordMapEng.put("come", "cum");
		wordMapTxt.put("cum", "come");

		wordMapTxt.put("cya","see you");

		wordMapEng.put("see you later","cul8r");
		wordMapTxt.put("cul8r","see you later");

		wordMapTxt.put("ciao","goodbye");

		wordMapEng.put("cool", "kewl");
		wordMapTxt.put("kewl","cool");

		wordMapEng.put("see you later", "cyl");
		wordMapTxt.put("cyl","see you later");

		wordMapEng.put("cutie","qt");
		wordMapTxt.put("qt","cutie");

		wordMapEng.put("demand","dm&");
		wordMapTxt.put("dm&","demand");

		wordMapEng.put("decks","dx");
		wordMapTxt.put("dx","decks");

		wordMapEng.put("did you know","dyk");
		wordMapTxt.put("dyk","did you know");

		wordMapEng.put("design","dzine");
		wordMapTxt.put("dzine","design");

		wordMapEng.put("dog","k9");
		wordMapTxt.put("k9","dog");

		wordMapEng.put("dogs","k9s");
		wordMapEng.put("dog's","k9s");
		wordMapTxt.put("k9s","dog");

		wordMapEng.put("date", "d8");
		wordMapTxt.put("d8","date");

		wordMapEng.put("decide", "dcide");
		wordMapTxt.put("dcide","decide");

		wordMapEng.put("debate", "db8");
		wordMapTxt.put("db8","debate");

		wordMapEng.put("degree", "dgre");
		wordMapTxt.put("dgre","degree");

		wordMapEng.put("diamond", "dimnd");
		wordMapTxt.put("dimnd","diamond");

		wordMapEng.put("do it yourself","diy");
		wordMapTxt.put("diy","do it yourself");

		wordMapEng.put("dying with laughter","dwl");
		wordMapTxt.put("dwl","dying with laughter");

		wordMapEng.put("do not disturb","dnd");
		wordMapTxt.put("dnd","do not disturb");

		wordMapEng.put("dylan","dylan the little boss");
		wordMapTxt.put("dylan","dylan the little boss");



		wordMapEng.put("effort", "ef4t");
		wordMapTxt.put("ef4t","effort");

		wordMapEng.put("enough", "enuf");
		wordMapTxt.put("enuf","enough");
		wordMapTxt.put("nuf","enough");

		wordMapEng.put("estimated time of arrival", "eta");
		wordMapTxt.put("eta","estimated time of arrival");

		wordMapEng.put("everywhere", "evrywhr");
		wordMapTxt.put("evrywhr","everywhere");

		wordMapEng.put("experience", "experens");
		wordMapTxt.put("experens","experience");

		wordMapEng.put("entertain", "ntrtain");
		wordMapTxt.put("ntrtain","entertain");

		wordMapEng.put("excite", "xcite");
		wordMapTxt.put("xcite","excite");

		wordMapEng.put("exciting", "xcitn");
		wordMapTxt.put("xcitin","exciting");

		wordMapEng.put("exit", "Xit");
		wordMapTxt.put("xit","exit");

		wordMapEng.put("expect", "xpect");
		wordMapTxt.put("xpect","expect");

		wordMapEng.put("expecting", "xpectn");
		wordMapTxt.put("xpectn","expecting");

		wordMapEng.put("experts", "xperts");
		wordMapEng.put("expert's", "xperts");
		wordMapTxt.put("xperts","experts");

		wordMapEng.put("explosive", "xplosive");
		wordMapTxt.put("xplosive","explosive");

		wordMapEng.put("expensive", "xpnsiv");
		wordMapTxt.put("xpnsiv","expensive");

		wordMapEng.put("express", "xprs");
		wordMapTxt.put("xprs","express");

		wordMapEng.put("extra small", "xs");
		wordMapTxt.put("xs","extra small");

		wordMapEng.put("easy","ez");
		wordMapTxt.put("ez","easy");

		wordMapEng.put("energy","nrg");
		wordMapTxt.put("nrg","energy");

		wordMapTxt.put("l33t","elite");
		wordMapEng.put("elite","l33t");

		wordMapEng.put("fate","f8");
		wordMapTxt.put("f8","fate");

		wordMapEng.put("food","fud");
		wordMapTxt.put("fud","food");

		wordMapEng.put("flat","fl@");
		wordMapTxt.put("fl@","flat");

		wordMapEng.put("forgive", "4give");
		wordMapTxt.put("4give","forgive");

		wordMapEng.put("forgotten", "4got10");

		wordMapEng.put("foreplay", "4pla");
		wordMapTxt.put("4pla","foreplay");

		wordMapEng.put("fortunate", "4tun8");
		wordMapTxt.put("4tun8","fortunate");

		wordMapEng.put("fortnight", "4tnite");
		wordMapTxt.put("4tnite","fortnight");

		wordMapEng.put("fuck off and die","foad");
		wordMapTxt.put("foad","f**k off and die");

		wordMapEng.put("for","4");
		wordMapTxt.put("4","for");

		wordMapEng.put("for what its worth","fwiw");
		wordMapEng.put("for what it's worth","fwiw");
		wordMapTxt.put("fwiw","for what its worth");

		wordMapEng.put("for your information","fyi");
		wordMapTxt.put("fyi","for your information");

		wordMapEng.put("forget","4get");
		wordMapTxt.put("4get","forget");

		wordMapEng.put("forever","4evr");
		wordMapTxt.put("4evr","forever");

		wordMapEng.put("from","frm");
		wordMapTxt.put("frm","from");

		wordMapEng.put("fuck off","fo");
		wordMapTxt.put("fo","f**k off");

		wordMapTxt.put("fubar","f**ked up beyond recognition");

		wordMapEng.put("fuck","fk");
		wordMapTxt.put("fk","f**k");

		wordMapEng.put("fucking","fkin");
		wordMapTxt.put("fkin","f**king");

		wordMapEng.put("forever and ever","4frnfr");
		wordMapTxt.put("4frnfr", "forever and ever");

		wordMapEng.put("friends forever","ff");
		wordMapEng.put("friend's forever","ff");
		wordMapTxt.put("ff", "friends forever");

		wordMapEng.put("forward","fwd");
		wordMapTxt.put("fwd","forward");

		wordMapEng.put("for the win","ftw");
		wordMapTxt.put("ftw","for the win");

		wordMapEng.put("fall on floor laughing","fofl");
		wordMapTxt.put("fofl","fall on floor laughing");

		wordMapEng.put("greatly","gr8ly");
		wordMapTxt.put("gr8ly","greatly");

		wordMapEng.put("go to hell ","gth");
		wordMapTxt.put("gth","go to hell");

		wordMapEng.put("good night","gudnite");
		wordMapTxt.put("gordon","stud muffin extraodinare");

		wordMapEng.put("good good","gg");
		wordMapTxt.put("gg","good good");

		wordMapEng.put("good","gud");
		wordMapTxt.put("gud","good");

		wordMapEng.put("got to go","g2g");
		wordMapTxt.put("g2g","got to go");

		wordMapEng.put("girlfriend","gf");
		wordMapTxt.put("gf","girlfriend");

		wordMapEng.put("good sense of humour","gsoh");
		wordMapTxt.put("gsoh","good sense of humour");

		wordMapEng.put("good luck ","gl");
		wordMapTxt.put("gl","good luck");

		wordMapEng.put("great","gr8");
		wordMapTxt.put("gr8","great");

		wordMapEng.put("goodnight","gudnite");
		wordMapTxt.put("gudnite","goodnight");

		wordMapEng.put("have a good one","hago");
		wordMapTxt.put("hago","have a good one");

		wordMapEng.put("happy birthday to you","hbtu");
		wordMapTxt.put("hbtu","happy birthday to you");

		wordMapEng.put("heavy","heve");
		wordMapTxt.put("heve","heavy");

		wordMapEng.put("have","hav");
		wordMapTxt.put("hav","have");

		wordMapEng.put("ha ha only kidding","hhok");
		wordMapTxt.put("hhok","ha ha only kidding");

		wordMapEng.put("happened","hapnd");
		wordMapTxt.put("hapnd","happened");

		wordMapEng.put("hope im right","hir");
		wordMapEng.put("hope i'm right","hir");
		wordMapTxt.put("hir","hope im right");

		wordMapEng.put("how you doin","hud");
		wordMapTxt.put("hud", "how you doin");

		wordMapEng.put("hot for you","hot4u");
		wordMapTxt.put("hot4u", "hot for you");

		wordMapEng.put("how are you","hru");
		wordMapTxt.put("hru","how are you");

		wordMapEng.put("how are you today","hru2d");
		wordMapTxt.put("hru2d","how are you today");

		wordMapTxt.put("woot","hurray");

		wordMapTxt.put("hbtu", "happy birthday to you");

		wordMapEng.put("hate", "h8");
		wordMapTxt.put("h8", "hate");

		wordMapTxt.put("hak","hugs and kisses");
		wordMapTxt.put("xoxo","hugs and kisses");

		wordMapEng.put("hates", "h8s");
		wordMapEng.put("hat'es", "h8s");
		wordMapTxt.put("h8s","hates");

		wordMapEng.put("hello", "elo");
		wordMapTxt.put("elo","hello");

		wordMapEng.put("i dont know","idk");
		wordMapTxt.put("idk","i dont know");

		wordMapEng.put("i could be wrong","icbw");
		wordMapTxt.put("icbw","i could be wrong");


		wordMapEng.put("into","in2");
		wordMapTxt.put("in2","in2");

		wordMapEng.put("its","itz");
		wordMapEng.put("it's","itz");
		wordMapTxt.put("itz","its");

		wordMapEng.put("inside","nside");
		wordMapTxt.put("nside","inside");

		wordMapEng.put("i dont care", "idc");
		wordMapTxt.put("idc", "i dont care");

		wordMapEng.put("i love you","ilu");
		wordMapTxt.put("ilu", "i love you");

		wordMapEng.put("in real life","irl");
		wordMapTxt.put("irl", "in real life");

		wordMapEng.put("i owe you","iou");
		wordMapTxt.put("iou", "i owe you");

		wordMapEng.put("if i remember correctly","iirc");
		wordMapTxt.put("iirc", "if i remember correctly");

		wordMapEng.put("i see","ic");
		wordMapTxt.put("ic","i see");

		wordMapEng.put("ideal","idl");
		wordMapTxt.put("idl","ideal");

		wordMapEng.put("joke","jk");
		wordMapTxt.put("jk","joke");

		wordMapEng.put("joking","jkn");
		wordMapTxt.put("jkn","joking");

		wordMapEng.put("ok","k");
		wordMapTxt.put("k","ok");

		wordMapEng.put("okay","k");

		wordMapEng.put("laugh","laff");
		wordMapTxt.put("laff","laugh");

		wordMapEng.put("laugh out loud","lol");
		wordMapTxt.put("lol","Laugh out loud");

		wordMapEng.put("later","l8r");
		wordMapTxt.put("l8r","later");

		wordMapEng.put("late","l8");
		wordMapTxt.put("l8","Late");

		wordMapEng.put("love","luv");
		wordMapTxt.put("luv","Love");

		wordMapEng.put("like","lyk");
		wordMapTxt.put("lyk","like");

		wordMapEng.put("lucky","lcke");
		wordMapTxt.put("lcke","lucky");

		wordMapEng.put("leave","leav");
		wordMapTxt.put("leav","leave");

		wordMapEng.put("learn","lern");
		wordMapTxt.put("lern","learn");

		wordMapEng.put("let me know","lmk");
		wordMapTxt.put("lmk","let me know");

		wordMapEng.put("locate","loc8");
		wordMapTxt.put("loc8","locate");

		wordMapEng.put("mate","m8");
		wordMapTxt.put("m8","mate");

		wordMapEng.put("mates","m8s");
		wordMapEng.put("mate's","m8s");
		wordMapTxt.put("m8s","mates");

		wordMapEng.put("message","msg");
		wordMapEng.put("message's","msg's");
		wordMapTxt.put("msg","message");

		wordMapEng.put("moment","mo");
		wordMapTxt.put("mo","moment");

		wordMapEng.put("motherfucker","mofo");
		wordMapTxt.put("mofo","motherf**ker");

		wordMapEng.put("might","mite");
		wordMapTxt.put("mite","might");

		wordMapEng.put("movie","mov");
		wordMapTxt.put("mov","movie");

		wordMapEng.put("mine","myn");
		wordMapTxt.put("myn","miss");

		wordMapEng.put("mind your own business","myob");
		wordMapTxt.put("myob","mind your own business");

		wordMapEng.put("mark","unrepentant flange mauler");
		wordMapTxt.put("mark","unrepentant flange mauler");

		wordMapEng.put("noise","noyz");
		wordMapTxt.put("noyz","noise");

		wordMapEng.put("next","nxt");
		wordMapTxt.put("nxt","next");

		wordMapEng.put("nevermind","nm");
		wordMapTxt.put("nm","nevermind");

		wordMapEng.put("no one","no1");
		wordMapTxt.put("no1","no one");

		wordMapEng.put("no problem","np");
		wordMapTxt.put("np","no problem");

		wordMapEng.put("nice one","n1");
		wordMapTxt.put("n1","nice one");

		wordMapEng.put("not to mention","n2m");
		wordMapTxt.put("n2m","not to mention");

		wordMapEng.put("not my problem","nmp");
		wordMapTxt.put("nmp","not my problem");

		wordMapEng.put("newbie","noob");
		wordMapTxt.put("noob","newbie");

		wordMapEng.put("oh my god","omg");
		wordMapTxt.put("omg","oh my god");

		wordMapEng.put("once", "1ce");
		wordMapTxt.put("1ce","once");

		wordMapEng.put("oh my fucking god","omfg");
		wordMapTxt.put("omfg","oh my f**king god");

		wordMapEng.put("owned", "pawned");
		wordMapTxt.put("pawned","owned");

		wordMapEng.put("off topic","ot");
		wordMapTxt.put("ot","off topic");

		wordMapEng.put("over the top","ott");
		wordMapTxt.put("ott","over the top");

		wordMapEng.put("oh i see","oic");
		wordMapTxt.put("oic","oh i see");

		wordMapEng.put("on my way","omw");
		wordMapTxt.put("omw","on my way");

		wordMapEng.put("overrated","ovr8d");
		wordMapTxt.put("ovr8d","overrated");


		wordMapTxt.put("zomg","oh my god");

		wordMapEng.put("pain in the ass","pita");
		wordMapTxt.put("pita","pain in the ass");

		wordMapEng.put("parents are watching","prw");
		wordMapTxt.put("prw","parents are watching");

		wordMapEng.put("people","ppl");
		wordMapTxt.put("ppl","people");

		wordMapEng.put("please text back","ptb");
		wordMapTxt.put("ptb","please text back");

		wordMapEng.put("please", "pls");
		wordMapTxt.put("pls","please");

		wordMapEng.put("piss off","po");
		wordMapEng.put("po", "p**s off");

		wordMapEng.put("point of view","pov");
		wordMapEng.put("pov", "point of view");

		wordMapEng.put("private message","pm");
		wordMapEng.put("pm", "private message");

		wordMapEng.put("photo","foto");
		wordMapTxt.put("foto","photo");

		wordMapEng.put("picture","pix");
		wordMapEng.put("pictures","pix");
		wordMapEng.put("picture's","pix");
		wordMapTxt.put("pix","picture");

		wordMapEng.put("player","playa");
		wordMapTxt.put("playa","player");

		wordMapEng.put("earlier", "rlr");
		wordMapTxt.put("rlr","earlier");

		wordMapEng.put("are", "r");
		wordMapTxt.put("r","are");

		wordMapEng.put("read the fucking manual","rtfm");
		wordMapTxt.put("rtfm","read the f**king manual");

		wordMapEng.put("are you","ru");
		wordMapTxt.put("ru","are you");

		wordMapTxt.put("roflol","rolling on floor laughing out loud");

		wordMapEng.put("real life","rl");
		wordMapTxt.put("rl","real life");

		wordMapEng.put("right on the money","rotm");
		wordMapTxt.put("rotm","right on the money");

		wordMapEng.put("remember","rembr");
		wordMapTxt.put("rembr","remember");

		wordMapEng.put("respect","respx");
		wordMapTxt.put("respx","respect");

		wordMapEng.put("rules","rulz");
		wordMapEng.put("rule's","rulz");
		wordMapTxt.put("rulz","rules");

		wordMapEng.put("really","rly");
		wordMapTxt.put("rly","really");

		wordMapEng.put("see you","cu");
		wordMapTxt.put("cu","see you");

		wordMapTxt.put("cya","see you");

		wordMapEng.put("school","skool");
		wordMapTxt.put("skool","school");

		wordMapEng.put("small","sml");
		wordMapTxt.put("sml","small");

		wordMapEng.put("send","snd");
		wordMapTxt.put("snd","send");

		wordMapEng.put("shut the fuck up","stfu");
		wordMapTxt.put("stfu","shut the f**k up");

		wordMapEng.put("sucks","sux");
		wordMapEng.put("suck's","sux");
		wordMapTxt.put("sux","sucks");

		wordMapEng.put("says","sez");
		wordMapEng.put("say's","sez");
		wordMapTxt.put("sez","says");

		wordMapEng.put("skate", "sk8");
		wordMapTxt.put("sk8","skate");

		wordMapEng.put("see", "c");
		wordMapTxt.put("c","see");

		wordMapEng.put("sorry", "soz");
		wordMapTxt.put("soz","sorry");

		wordMapEng.put("someone", "sum1");
		wordMapTxt.put("sum1","someone");

		wordMapEng.put("sent with a loving kiss", "swalk");
		wordMapTxt.put("swalk","sent with a loving kiss");

		wordMapEng.put("see you later", "cul8tr");
		wordMapTxt.put("cul8tr","see you later");

		wordMapEng.put("straight", "str8");
		wordMapTxt.put("str8","straight");

		wordMapEng.put("safe for work", "sfw");
		wordMapTxt.put("sfw","safe for work");

		wordMapEng.put("speak", "spk");
		wordMapTxt.put("spk", "speak");

		wordMapEng.put("stand","st&");
		wordMapTxt.put("st&","stand");

		wordMapEng.put("statue","statu");
		wordMapTxt.put("statu","statue");

		wordMapEng.put("sticks","stix");
		wordMapEng.put("stick's","stix");
		wordMapTxt.put("stix","sticks");

		wordMapEng.put("stress","str$");
		wordMapTxt.put("str$","stress");

		wordMapEng.put("the", "de");
		wordMapTxt.put("de", "the");

		wordMapEng.put("talk to you later", "ttyl");
		wordMapTxt.put("ttyl","talk to you later");

		wordMapEng.put("text me back", "tmb");
		wordMapTxt.put("tmb","text me back");

		wordMapEng.put("thanks", "thx");
		wordMapEng.put("thank's", "thx");
		wordMapTxt.put("thx","thanks");

		wordMapEng.put("thank you", "thanq");
		wordMapTxt.put("thanq","thank you");
		wordMapTxt.put("ty","thank you");

		wordMapEng.put("today", "2day");
		wordMapTxt.put("2day","today");

		wordMapEng.put("tomorrow", "2morro");
		wordMapTxt.put("2morro","tomorrow");
		wordMapTxt.put("2morrow","tomorrow");

		wordMapEng.put("tonight", "2nite");
		wordMapTxt.put("2nite","tonight");
		wordMapTxt.put("2night","tonight");

		wordMapEng.put("twat", "twt");
		wordMapTxt.put("twt","twat");

		wordMapEng.put("to you too", "2u2");
		wordMapTxt.put("2u2","to you too");

		wordMapEng.put("to be advised", "tba");
		wordMapTxt.put("tba","to be advised");

		wordMapEng.put("to be honest", "tbh");
		wordMapTxt.put("tbh","to be honest");


		wordMapEng.put("text", "txt");
		wordMapTxt.put("txt", "text");

		wordMapEng.put("to late","2l8");
		wordMapTxt.put("2l8","to late");

		wordMapEng.put("to you","2u");
		wordMapTxt.put("2u","to you");

		wordMapEng.put("toilet","jacks");
		wordMapTxt.put("jacks","toilet");

		wordMapEng.put("talking","talkin");
		wordMapTxt.put("talkin","talking");

		wordMapEng.put("tattoo","tat2");
		wordMapTxt.put("tat2","tattoo");

		wordMapEng.put("tattoos","tats");
		wordMapEng.put("tattoo's","tats");
		wordMapTxt.put("tats","tattoos");

		wordMapEng.put("talk","tlk");
		wordMapTxt.put("tlk","talk");

		wordMapEng.put("translate","transl8");
		wordMapTxt.put("transl8","translate");

		wordMapEng.put("text me","txtme");
		wordMapTxt.put("txtme","text me");
		
		wordMapEng.put("that","dat");
		wordMapTxt.put("dat","that");

		wordMapEng.put("thank you very much","tyvm");
		wordMapTxt.put("tyvm","thank you very much");

		wordMapEng.put("there","der");
		wordMapTxt.put("der","there");

		wordMapEng.put("you", "u");
		wordMapTxt.put("u", "you");

		wordMapEng.put("you idiot", "ui");
		wordMapTxt.put("ui", "you idiot");

		wordMapEng.put("you too", "u2");
		wordMapTxt.put("u2", "you too");

		wordMapEng.put("yours forever", "u4e");
		wordMapTxt.put("u4e", "yours forever");

		wordMapEng.put("your", "ur");
		wordMapTxt.put("ur", "your");

		wordMapEng.put("you are", "ur");

		wordMapEng.put("unforgetable","un4gtebl");
		wordMapTxt.put("un4gtebl","unforgetable");

		wordMapEng.put("understand","underst&");
		wordMapTxt.put("underst&","understand");

		wordMapEng.put("up to you","up2u");
		wordMapTxt.put("up2u","up to you");

		wordMapEng.put("up to","up2");
		wordMapTxt.put("up2","up to");

		wordMapEng.put("update","upd8");
		wordMapTxt.put("upd8","update");

		wordMapEng.put("voicemail", "vm");
		wordMapTxt.put("vm", "voicemail");

		wordMapEng.put("vibrator","vbr8r");
		wordMapTxt.put("vbr8r","vibrator");

		wordMapEng.put("very hot","vh");
		wordMapTxt.put("vh","very hot");

		wordMapEng.put("way to go", "wtg");
		wordMapTxt.put("wtg", "way to go");

		wordMapEng.put("what the hell", "wth");
		wordMapTxt.put("wth", "what the hell");

		wordMapEng.put("want to", "wan2");
		wordMapTxt.put("wan2", "want to");

		wordMapEng.put("wait","w8");
		wordMapTxt.put("w8","wait");

		wordMapEng.put("with", "wit");
		wordMapTxt.put("wit", "with");

		wordMapEng.put("without", "wo");
		wordMapTxt.put("wo", "without");

		wordMapEng.put("whatever", "WE");

		wordMapEng.put("weekend", "wknd");
		wordMapTxt.put("wknd", "weekend");

		wordMapEng.put("why", "y");
		wordMapTxt.put("y", "why");

		wordMapEng.put("why are", "yr");
		wordMapTxt.put("yr", "why are");

		wordMapEng.put("work", "wrk");
		wordMapTxt.put("wrk", "work");

		wordMapEng.put("what", "wat");
		wordMapTxt.put("wat", "what");

		wordMapEng.put("when","wen");
		wordMapTxt.put("wen","when");

		wordMapEng.put("what the fuck","wtf");
		wordMapTxt.put("wtf","what the f**k");

		wordMapEng.put("want to buy", "wtb");
		wordMapTxt.put("wtb", "want to by");

		wordMapEng.put("water","h2o");
		wordMapTxt.put("h2o","water");

		wordMapEng.put("walk","wlk");
		wordMapTxt.put("wlk","walk");

		wordMapEng.put("worry","wori");
		wordMapTxt.put("wori","worry");

		wordMapEng.put("where are you","wru");
		wordMapTxt.put("wru","where are you");

		wordMapEng.put("was","ws");
		wordMapTxt.put("ws","was");

		wordMapEng.put("would","wud");
		wordMapTxt.put("wud","would");

		wordMapEng.put("wouldnt","wudnt");
		wordMapEng.put("wouldn't","wudnt");
		wordMapTxt.put("wudnt","wouldn't");

		wordMapEng.put("excellent", "xlnt");
		wordMapTxt.put("xlnt", "excellent");

		wordMapEng.put("excuse me", "xme");
		wordMapTxt.put("xme", "excuse me");

		wordMapEng.put("you're welcome", "urw");
		wordMapEng.put("youre welcome","urw");
		wordMapTxt.put("urw", "you are welcome");

		wordMapEng.put("you never know", "ynk");
		wordMapTxt.put("ynk", "you never know");

		wordMapEng.put("you will", "ul");
		wordMapTxt.put("ul", "you will");

		wordMapEng.put("you know what", "ykw");
		wordMapTxt.put("ykw", "you know what");

		wordMapEng.put("you ok","uok");
		wordMapTxt.put("uok","you ok");

		wordMapEng.put("year","yr");
		wordMapTxt.put("yr","year");



		wordMapEng.put("boring", "zzzz");


	}

	public HashMap<String,String> getWordMapEng(){
		return wordMapEng;
	}

	public HashMap<String,String> getWordMaptxt(){
		return wordMapTxt;
	}
}
