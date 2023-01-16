//Life Game  
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

/*TODO:
 * Think of and add another weekly choice.
 * More jobs.
 * More Events.
 */

class Main {

	// Utility functions
	public static void clearScreen() {
		System.out.print("\033[H\033[2J");
		System.out.flush();
	}

	public static void wait(int ms) {
		try {
			Thread.sleep(ms);
		} catch (Exception e) {
			System.out.println("Error");
			e.printStackTrace();
		}
	}
	//Money functions
	//Updates money with jobHours * jobPay
	public static int moneyUpdate(int money, int[] jobChoices){
		return money += jobChoices[0] * jobChoices[1];
	}
	
	//Deducts your rent and groceries from your current money.
	public static int moneyDeducter(int money, int rent, int groceries){
		return money -= rent + groceries; 
	}

	//Health functions
	//Updates health using the various healthModifiers.
	public static int healthUpdate(int health, int groceriesHealthMod, int[] jobChoices){
		health = health + groceriesHealthMod + jobChoices[4] - 1;
		if (health >= 100){
			return health = 100;
		}
		else{
			return health;
		}
	}

	//Happiness functions
	//Updates happiness using the various happinessModifiers.
	public static int happinessUpdate(int happiness, int groceriesHappinessMod, int[] jobChoices){
		//System.out.println("gHM: " + groceriesHappinessMod + " | jC[3]: " + jobChoices[3]);
		//System.out.println("Total: " + (groceriesHappinessMod + jobChoices[3]));
		happiness += groceriesHappinessMod + jobChoices[3] - 1;
		if (happiness >= 100){
			return happiness = 100;
		}
		else{
			return happiness;
		}
	}
	
	//Stats
	//Prints out your current stats.
	public static void stats(int week, int money, int health, int happiness, String job) {
		System.out.println("Stats:");
		System.out.println("Week: " + week);
		System.out.println("Money: " + money);
		System.out.println("Health: " + health);
		System.out.println("Happiness: " + happiness);
		System.out.println("Job: " + job);
	}

	//Initializations for jobs
	//Initializes the names of all jobs into a HashMap and returns it.
	public static HashMap<Integer, String> initializationList(){
		jobs.cashier cashier = new jobs.cashier();
		jobs.cook cook = new jobs.cook();
		jobs.baker baker = new jobs.baker();
		jobs.waiter waiter = new jobs.waiter();
		jobs.fisherman fisherman = new jobs.fisherman();
		jobs.teacher teacher = new jobs.teacher();
		jobs.busDriver busDriver = new jobs.busDriver();
		jobs.engineer engineer = new jobs.engineer();
		jobs.computerScientist compSci = new jobs.computerScientist();
		jobs.doctor doctor = new jobs.doctor();
		jobs.nurse nurse = new jobs.nurse();
		jobs.surgeon surgeon = new jobs.surgeon();
		jobs.artist artist = new jobs.artist();
		jobs.musician musician = new jobs.musician();
		
		HashMap<Integer, String> jobList = new HashMap<Integer, String>();
		jobList.put(-1, "Unemployed");
		jobList.put(0, cashier.name);
		jobList.put(1, cook.name);
		jobList.put(2, baker.name);
		jobList.put(3, waiter.name);
		jobList.put(4, fisherman.name);
		jobList.put(5, teacher.name);
		jobList.put(6, busDriver.name);
		jobList.put(7, engineer.name);	
		jobList.put(8, compSci.name);
		jobList.put(9, doctor.name);
		jobList.put(10, nurse.name);
		jobList.put(11, surgeon.name);
		jobList.put(12, artist.name);
		jobList.put(13, musician.name);
		
		return jobList;
	}

	//Initializes the hours of all jobs into a HashMap and returns it.
	public static HashMap<String, Integer> initializationHours(){
		jobs.cashier cashier = new jobs.cashier();
		jobs.cook cook = new jobs.cook();
		jobs.baker baker = new jobs.baker();
		jobs.waiter waiter = new jobs.waiter();
		jobs.fisherman fisherman = new jobs.fisherman();
		jobs.teacher teacher = new jobs.teacher();
		jobs.busDriver busDriver = new jobs.busDriver();
		jobs.engineer engineer = new jobs.engineer();
		jobs.computerScientist compSci = new jobs.computerScientist();
		jobs.doctor doctor = new jobs.doctor();
		jobs.nurse nurse = new jobs.nurse();
		jobs.surgeon surgeon = new jobs.surgeon();
		jobs.artist artist = new jobs.artist();
		jobs.musician musician = new jobs.musician();
		
		HashMap<String, Integer> jobHours = new HashMap<String, Integer>();
    jobHours.put("Cashier", cashier.hours);
    jobHours.put("Cook", cook.hours);
    jobHours.put("Baker", baker.hours);
    jobHours.put("Waiter", waiter.hours);
    jobHours.put("Fisherman", fisherman.hours);
		jobHours.put("Teacher", teacher.hours);
		jobHours.put("Bus Driver", busDriver.hours);
		jobHours.put("Engineer", engineer.hours);
		jobHours.put("Computer Scientist", compSci.hours);
		jobHours.put("Doctor", doctor.hours);
		jobHours.put("Nurse", nurse.hours);
		jobHours.put("Surgeon", surgeon.hours);
		jobHours.put("Artist", artist.hours);
		jobHours.put("Musician", musician.hours);

		return jobHours;
	}

	//Initializes the pay of all jobs into a HashMap and returns it.
	public static HashMap<String, Integer> initializationPay(){
		jobs.cashier cashier = new jobs.cashier();
		jobs.cook cook = new jobs.cook();
		jobs.baker baker = new jobs.baker();
		jobs.waiter waiter = new jobs.waiter();
		jobs.fisherman fisherman = new jobs.fisherman();
		jobs.teacher teacher = new jobs.teacher();
		jobs.busDriver busDriver = new jobs.busDriver();
		jobs.engineer engineer = new jobs.engineer();
		jobs.computerScientist compSci = new jobs.computerScientist();
		jobs.doctor doctor = new jobs.doctor();
		jobs.nurse nurse = new jobs.nurse();
		jobs.surgeon surgeon = new jobs.surgeon();
		jobs.artist artist = new jobs.artist();
		jobs.musician musician = new jobs.musician();
		
		HashMap<String, Integer> jobPay = new HashMap<String, Integer>();
		jobPay.put("Cashier", cashier.pay);
    jobPay.put("Cook", cook.pay);
    jobPay.put("Baker", baker.pay);
    jobPay.put("Waiter", waiter.pay);
    jobPay.put("Fisherman", fisherman.pay);
		jobPay.put("Teacher", teacher.pay);
		jobPay.put("Bus Driver", busDriver.pay);
		jobPay.put("Engineer", engineer.pay);
		jobPay.put("Computer Scientist", compSci.pay);
		jobPay.put("Doctor", doctor.pay);
		jobPay.put("Nurse", nurse.pay);
		jobPay.put("Surgeon", surgeon.pay);
		jobPay.put("Artist", artist.pay);
		jobPay.put("Musician", musician.pay);

		return jobPay;
	}

	//Initializes the happiness modifiers of all jobs into a HashMap and returns it.
	public static HashMap<String, Integer> initializationJobHappinessMod(){
		jobs.cashier cashier = new jobs.cashier();
		jobs.cook cook = new jobs.cook();
		jobs.baker baker = new jobs.baker();
		jobs.waiter waiter = new jobs.waiter();
		jobs.fisherman fisherman = new jobs.fisherman();
		jobs.teacher teacher = new jobs.teacher();
		jobs.busDriver busDriver = new jobs.busDriver();
		jobs.engineer engineer = new jobs.engineer();
		jobs.computerScientist compSci = new jobs.computerScientist();
		jobs.doctor doctor = new jobs.doctor();
		jobs.nurse nurse = new jobs.nurse();
		jobs.surgeon surgeon = new jobs.surgeon();
		jobs.artist artist = new jobs.artist();
		jobs.musician musician = new jobs.musician();

		HashMap<String, Integer> jobHappinessMod = new HashMap<String, Integer>();
		jobHappinessMod.put("Cashier", cashier.happinessMod);
		jobHappinessMod.put("Cook", cook.happinessMod);
		jobHappinessMod.put("Baker", baker.happinessMod);
		jobHappinessMod.put("Waiter", waiter.happinessMod);
		jobHappinessMod.put("Fisherman", fisherman.happinessMod);
		jobHappinessMod.put("Teacher", teacher.happinessMod);
		jobHappinessMod.put("Bus Driver", busDriver.happinessMod);
		jobHappinessMod.put("Engineer", engineer.happinessMod);
		jobHappinessMod.put("Computer Scientist", compSci.happinessMod);
		jobHappinessMod.put("Doctor", doctor.happinessMod);
		jobHappinessMod.put("Nurse", nurse.happinessMod);
		jobHappinessMod.put("Surgeon", surgeon.happinessMod);
		jobHappinessMod.put("Artist", artist.happinessMod);
		jobHappinessMod.put("Musician", musician.happinessMod);
		
		return jobHappinessMod;
	}

	//Initializes the health modifiers of all jobs into a HashMap and returns it.
	//USUSED
	public static HashMap<String, Integer> initializationJobHealthMod(){
		jobs.cashier cashier = new jobs.cashier();
		jobs.cook cook = new jobs.cook();
		jobs.baker baker = new jobs.baker();
		jobs.waiter waiter = new jobs.waiter();
		jobs.fisherman fisherman = new jobs.fisherman();
		jobs.teacher teacher = new jobs.teacher();
		jobs.busDriver busDriver = new jobs.busDriver();
		jobs.engineer engineer = new jobs.engineer();
		jobs.computerScientist compSci = new jobs.computerScientist();
		jobs.doctor doctor = new jobs.doctor();
		jobs.nurse nurse = new jobs.nurse();
		jobs.surgeon surgeon = new jobs.surgeon();
		jobs.artist artist = new jobs.artist();
		jobs.musician musician = new jobs.musician();

		HashMap<String, Integer> jobHealthMod = new HashMap<String, Integer>();
		jobHealthMod.put("Cashier", cashier.healthMod);
		jobHealthMod.put("Cook", cook.healthMod);
		jobHealthMod.put("Baker", baker.healthMod);
		jobHealthMod.put("Waiter", waiter.healthMod);
		jobHealthMod.put("Fisherman", fisherman.healthMod);
		jobHealthMod.put("Teacher", teacher.healthMod);
		jobHealthMod.put("Bus Driver", busDriver.healthMod);
		jobHealthMod.put("Engineer", engineer.healthMod);
		jobHealthMod.put("Computer Scientist", compSci.healthMod);
		jobHealthMod.put("Doctor", doctor.healthMod);
		jobHealthMod.put("Nurse", nurse.healthMod);
		jobHealthMod.put("Surgeon", surgeon.healthMod);
		jobHealthMod.put("Artist", artist.healthMod);
		jobHealthMod.put("Musician", musician.healthMod);

		return jobHealthMod;
	}

	//Initializes the ids of all jobs into a HashMap and returns it.
	public static HashMap<String, Integer> initializationId(){
		jobs.cashier cashier = new jobs.cashier();
		jobs.cook cook = new jobs.cook();
		jobs.baker baker = new jobs.baker();
		jobs.waiter waiter = new jobs.waiter();
		jobs.fisherman fisherman = new jobs.fisherman();
		jobs.teacher teacher = new jobs.teacher();
		jobs.busDriver busDriver = new jobs.busDriver();
		jobs.engineer engineer = new jobs.engineer();
		jobs.computerScientist compSci = new jobs.computerScientist();
		jobs.doctor doctor = new jobs.doctor();
		jobs.nurse nurse = new jobs.nurse();
		jobs.surgeon surgeon = new jobs.surgeon();
		jobs.artist artist = new jobs.artist();
		jobs.musician musician = new jobs.musician();
		
		HashMap<String, Integer> jobId = new HashMap<String, Integer>();
		jobId.put("Cashier", cashier.id);
    jobId.put("Cook", cook.id);
    jobId.put("Baker", baker.id);
    jobId.put("Waiter", waiter.id);
    jobId.put("Fisherman", fisherman.id);
		jobId.put("Teacher", teacher.id);
		jobId.put("Bus Driver", busDriver.id);
		jobId.put("Engineer", engineer.id);
		jobId.put("Computer Scientist", compSci.id);
		jobId.put("Doctor", doctor.id);
		jobId.put("Nurse", nurse.id);
		jobId.put("Surgeon", surgeon.id);
		jobId.put("Artist", artist.id);
		jobId.put("Musician", musician.id);

		return jobId;
	}

	//Initializations for random events
	//Initializes the ids for all events into a HashMap and returns them.
	public static HashMap<Integer, Integer> initializationEventId(){
		events.hospitalArm hospitalArm = new events.hospitalArm();
		events.hospitalLeg hospitalLeg = new events.hospitalLeg();
		events.sickness sickness = new events.sickness();
		events.illness illness = new events.illness();
		events.gift gift = new events.gift();
		events.gift2 gift2 = new events.gift2();
		events.gift3 gift3 = new events.gift3();
		events.giftLose1 giftLose1 = new events.giftLose1();
		events.giftLose2 giftLose2 = new events.giftLose2();
		events.giftLose3 giftLose3 = new events.giftLose3();
		events.cut1 cut1 = new events.cut1();
		events.cut2 cut2 = new events.cut2();
		events.robbed1 robbed1 = new events.robbed1();
		events.robbed2 robbed2 = new events.robbed2();
		events.robbed3 robbed3 = new events.robbed3();
		events.robbed4 robbed4 = new events.robbed4();
		events.robbed5 robbed5 = new events.robbed5();

		HashMap<Integer, Integer> eventId = new HashMap<Integer, Integer>();
		eventId.put(0, hospitalArm.id);
		eventId.put(1, hospitalLeg.id);
		eventId.put(2, sickness.id);
		eventId.put(3, illness.id);
		eventId.put(4, gift.id);
		eventId.put(5, gift2.id);
		eventId.put(6, gift3.id);
		eventId.put(7, giftLose1.id);
		eventId.put(8, giftLose2.id);
		eventId.put(9, giftLose3.id);
		eventId.put(10, cut1.id);
		eventId.put(11, cut2.id);
		eventId.put(12, robbed1.id);
		eventId.put(13, robbed2.id);
		eventId.put(14, robbed3.id);
		eventId.put(15, robbed4.id);
		eventId.put(16, robbed5.id);

		return eventId;
	}

	//Initializes the happiness modifiers for all events into a HashMap and returns them.
	public static HashMap<Integer, Integer> initializationEventHappinessMod(){
		events.hospitalArm hospitalArm = new events.hospitalArm();
		events.hospitalLeg hospitalLeg = new events.hospitalLeg();
		events.sickness sickness = new events.sickness();
		events.illness illness = new events.illness();
		events.gift gift = new events.gift();
		events.gift2 gift2 = new events.gift2();
		events.gift3 gift3 = new events.gift3();
		events.giftLose1 giftLose1 = new events.giftLose1();
		events.giftLose2 giftLose2 = new events.giftLose2();
		events.giftLose3 giftLose3 = new events.giftLose3();
		events.cut1 cut1 = new events.cut1();
		events.cut2 cut2 = new events.cut2();
		events.robbed1 robbed1 = new events.robbed1();
		events.robbed2 robbed2 = new events.robbed2();
		events.robbed3 robbed3 = new events.robbed3();
		events.robbed4 robbed4 = new events.robbed4();
		events.robbed5 robbed5 = new events.robbed5();
		
		HashMap<Integer, Integer> eventHappinessMod = new HashMap<Integer, Integer>();
		eventHappinessMod.put(1, hospitalArm.happinessMod);
		eventHappinessMod.put(2, hospitalLeg.happinessMod);
		eventHappinessMod.put(3, sickness.happinessMod);
		eventHappinessMod.put(4, illness.happinessMod);
		eventHappinessMod.put(5, gift.happinessMod);
		eventHappinessMod.put(6, gift2.happinessMod);
		eventHappinessMod.put(7, gift3.happinessMod);
		eventHappinessMod.put(8, giftLose1.happinessMod);
		eventHappinessMod.put(9, giftLose2.happinessMod);
		eventHappinessMod.put(10, giftLose3.happinessMod);
		eventHappinessMod.put(11, cut1.happinessMod);
		eventHappinessMod.put(12, cut2.happinessMod);
		eventHappinessMod.put(13, robbed1.happinessMod);
		eventHappinessMod.put(14, robbed2.happinessMod);
		eventHappinessMod.put(15, robbed3.happinessMod);
		eventHappinessMod.put(16, robbed4.happinessMod);
		eventHappinessMod.put(17, robbed5.happinessMod);
		
		return eventHappinessMod;
	}

	//Initializes the health modifiers for all events into a HashMap and returns them.
	public static HashMap<Integer, Integer> initializationEventHealthMod(){
		events.hospitalArm hospitalArm = new events.hospitalArm();
		events.hospitalLeg hospitalLeg = new events.hospitalLeg();
		events.sickness sickness = new events.sickness();
		events.illness illness = new events.illness();
		events.gift gift = new events.gift();
		events.gift2 gift2 = new events.gift2();
		events.gift3 gift3 = new events.gift3();
		events.giftLose1 giftLose1 = new events.giftLose1();
		events.giftLose2 giftLose2 = new events.giftLose2();
		events.giftLose3 giftLose3 = new events.giftLose3();
		events.cut1 cut1 = new events.cut1();
		events.cut2 cut2 = new events.cut2();
		events.robbed1 robbed1 = new events.robbed1();
		events.robbed2 robbed2 = new events.robbed2();
		events.robbed3 robbed3 = new events.robbed3();
		events.robbed4 robbed4 = new events.robbed4();
		events.robbed5 robbed5 = new events.robbed5();
		
		HashMap<Integer, Integer> eventHealthMod = new HashMap<Integer, Integer>();
		eventHealthMod.put(1, hospitalArm.healthMod);
		eventHealthMod.put(2, hospitalLeg.healthMod);
		eventHealthMod.put(3, sickness.healthMod);
		eventHealthMod.put(4, illness.healthMod);
		eventHealthMod.put(5, gift.healthMod);	
		eventHealthMod.put(6, gift2.healthMod);
		eventHealthMod.put(7, gift3.healthMod);
		eventHealthMod.put(8, giftLose1.healthMod);
		eventHealthMod.put(9, giftLose2.healthMod);
		eventHealthMod.put(10, giftLose3.healthMod);
		eventHealthMod.put(11, cut1.healthMod);
		eventHealthMod.put(12, cut2.healthMod);
		eventHealthMod.put(13, robbed1.healthMod);
		eventHealthMod.put(14, robbed2.healthMod);
		eventHealthMod.put(15, robbed3.healthMod);
		eventHealthMod.put(16, robbed4.healthMod);
		eventHealthMod.put(17, robbed5.healthMod);
		
		return eventHealthMod;
	}

	//Initializes the money modifiers for all events into a HashMap and returns them.
	public static HashMap<Integer, Integer> initializationEventMoneyMod(){
		events.hospitalArm hospitalArm = new events.hospitalArm();
		events.hospitalLeg hospitalLeg = new events.hospitalLeg();
		events.sickness sickness = new events.sickness();
		events.illness illness = new events.illness();
		events.gift gift = new events.gift();
		events.gift2 gift2 = new events.gift2();
		events.gift3 gift3 = new events.gift3();
		events.giftLose1 giftLose1 = new events.giftLose1();
		events.giftLose2 giftLose2 = new events.giftLose2();
		events.giftLose3 giftLose3 = new events.giftLose3();
		events.cut1 cut1 = new events.cut1();
		events.cut2 cut2 = new events.cut2();
		events.robbed1 robbed1 = new events.robbed1();
		events.robbed2 robbed2 = new events.robbed2();
		events.robbed3 robbed3 = new events.robbed3();
		events.robbed4 robbed4 = new events.robbed4();
		events.robbed5 robbed5 = new events.robbed5();
		
		HashMap<Integer, Integer> eventMoneyMod = new HashMap<Integer, Integer>();
		eventMoneyMod.put(1, hospitalArm.moneyMod);
		eventMoneyMod.put(2, hospitalLeg.moneyMod);
		eventMoneyMod.put(3, sickness.moneyMod);
		eventMoneyMod.put(4, illness.moneyMod);
		eventMoneyMod.put(5, gift.moneyMod);
		eventMoneyMod.put(6, gift2.moneyMod);
		eventMoneyMod.put(7, gift3.moneyMod);
		eventMoneyMod.put(8, giftLose1.moneyMod);
		eventMoneyMod.put(9, giftLose2.moneyMod);
		eventMoneyMod.put(10, giftLose3.moneyMod);
		eventMoneyMod.put(11, cut1.moneyMod);
		eventMoneyMod.put(12, cut2.moneyMod);
		eventMoneyMod.put(13, robbed1.moneyMod);
		eventMoneyMod.put(14, robbed2.moneyMod);
		eventMoneyMod.put(15, robbed3.moneyMod);
		eventMoneyMod.put(16, robbed4.moneyMod);
		eventMoneyMod.put(17, robbed5.moneyMod);

		return eventMoneyMod;
	}
	
	//Game functions
	//Finds a set of three jobs and asks user to choose one. Returns an array of the job's properites.
	public static int[] jobFinder(Scanner scan, Random rand, HashMap<Integer, String> jobList, HashMap<String, Integer> jobHours, HashMap<String, Integer> jobPay, HashMap<String, Integer> jobId, HashMap<String, Integer> jobHappinessMod, HashMap<String, Integer> jobHealthMod) {
		ArrayList<String> jobs = new ArrayList<String>();

		int randNum = rand.nextInt(14);
    String job1 = jobList.get(randNum);
    jobs.add(job1);
    while (true){
        randNum = rand.nextInt(14);
        if (jobs.contains(jobList.get(randNum))){
            continue;
        }
        else{
            String job2 = jobList.get(randNum);
	          jobs.add(job2);
            break;
        }
    }
        
    while (true){
        randNum = rand.nextInt(14);
        if (jobs.contains(jobList.get(randNum))){
            continue;
        }
        else{
            String job3 = jobList.get(randNum);
            jobs.add(job3);
            break;
        }
    }

		System.out.println("Available jobs: ");

    for (int i = 0; i < jobs.size();i++){
			System.out.println(jobs.get(i));
	  }
      
   System.out.println("_____________");
//Hours
		System.out.println(jobs.get(0) + " Hours: " + jobHours.get(jobs.get(0)));
    System.out.println(jobs.get(1) + " Hours: " + jobHours.get(jobs.get(1)));
    System.out.println(jobs.get(2) + " Hours: " + jobHours.get(jobs.get(2)));

		System.out.println("_____________");
		
//Pay
		System.out.println(jobs.get(0) + " Pay: " + jobPay.get(jobs.get(0)));
    System.out.println(jobs.get(1) + " Pay: " + jobPay.get(jobs.get(1)));
    System.out.println(jobs.get(2) + " Pay: " + jobPay.get(jobs.get(2)));

    System.out.println("_____________");

		int choice = 0;
		while (true){
			System.out.println("Which job do you want?: 1. " + jobs.get(0) + " 2. " + jobs.get(1) + " 3. " + jobs.get(2) + " 4. None");
			try{
				choice = scan.nextInt();
			}
			catch(Exception e){
				System.out.println("Error: Not an int.");
				e.printStackTrace();
			}
			break;
		}

		//Final Choice
		String job = null;
		if (choice == 1){
			job = jobs.get(0);
			System.out.println("\nYou got the " + job + " job\n");

			int[] jobChoice = {jobHours.get(jobs.get(0)), jobPay.get(jobs.get(0)), jobId.get(jobs.get(0)), jobHappinessMod.get(jobs.get(0)), jobHealthMod.get(jobs.get(0))};
			//jobHappinessMod.get()
			//System.out.println(jobChoice[0]);
			//System.out.println(jobChoice[1]);
			//System.out.println(jobChoice[2]);
			//System.out.println(jobChoice[3]);
			return jobChoice;
		}
		else if (choice == 2){
			job = jobs.get(1);
			System.out.println("You got the " + job + " job\n");

			int[] jobChoice = {jobHours.get(jobs.get(1)), jobPay.get(jobs.get(1)), jobId.get(jobs.get(1)), jobHappinessMod.get(jobs.get(1)), jobHealthMod.get(jobs.get(1))};
			//System.out.println(jobChoice[0]);
			//System.out.println(jobChoice[1]);
			//System.out.println(jobChoice[2]);
			//System.out.println(jobChoice[3]);
			return jobChoice;
		}
		else if (choice == 3){
			job = jobs.get(2);
			System.out.println("You got the " + job + " job\n");

			int[] jobChoice = {jobHours.get(jobs.get(2)), jobPay.get(jobs.get(2)), jobId.get(jobs.get(2)), jobHappinessMod.get(jobs.get(2)), jobHealthMod.get(jobs.get(2))};
			//System.out.println(jobChoice[0]);
			//System.out.println(jobChoice[1]);
			//System.out.println(jobChoice[2]);
			//System.out.println(jobChoice[3]);
			return jobChoice;
		}
		else{
			System.out.println("You didn't apply for any of the jobs.");
			int[] jobChoice = {0, 0, -1, 0, 0};
			return jobChoice;
		}
	}

	//Finds a random event with a 0.125 / 1/8 chance of it happening. Returns an array the events modifiers.
	public static int[] randomEventFinder(Random rand, HashMap<Integer, Integer> eventId, HashMap<Integer, Integer> eventHappinessMod, HashMap<Integer, Integer> eventHealthMod, HashMap<Integer, Integer> eventMoneyMod){
		//rand.nextInt(6) gives 0-6. eventId has 0-6. all other event HashMaps are 1-7. take the result of the eventId.get(randomNum) and add 1 to it before using the returned value with other things.
		int randomNum = rand.nextInt(18);
		boolean chance = rand.nextInt(7)==0;

		if (chance == true){
			int[] eventMods = new int[4];
			eventMods[0] = eventId.get(randomNum);
			//eventMods[0] += 1;
			System.out.println(eventMods[0]);
			//Occasionally errors because of a null value at eventMods[0]
			//^Should be fixed.
			//Or not*2
			//^Should be fixed.
			eventMods[1] = eventHappinessMod.get(eventMods[0]);
			eventMods[2] = eventHealthMod.get(eventMods[0]);
			eventMods[3] = eventMoneyMod.get(eventMods[0]);

			//for(int i = 0; i < eventMods.length; i++){
			//	System.out.println(eventMods[i]);
			//}

			return eventMods;
		}
		else{
			int[] emptyArray = new int[4];
			return emptyArray;
		}
	}

	//Returns an array of the event's modifiers to stats. Returns a blank array if there is no event. 
	public static int[] randomEventStatUpdater(int[] eventMods,int money, int health, int happiness){
		int[] statArray = new int[3];
		switch(eventMods[0]){
			case 0:
				statArray[0] = happiness;
				statArray[1] = health;
				statArray[2] = money;
				break;
			case 1:
				System.out.println("You broke your arm! -500$.\n");
				System.out.println("Happiness: " + eventMods[1] + "\nHealth: " + eventMods[2]);
				if (eventMods[3] * -1 > 0){
					System.out.println("Money: " + eventMods[3] + "\n");
				}
				else{
					System.out.println("Money: -" + eventMods[3] + "\n");
				}
				statArray[0] = happiness += eventMods[1];
				statArray[1] = health += eventMods[2];
				statArray[2] = money -= eventMods[3];
				break;
			case 2:
				System.out.println("You broke your leg! -500$.\n");
				System.out.println("Happiness: " + eventMods[1] + "\nHealth: " + eventMods[2]);
				if (eventMods[3] * -1 > 0){
					System.out.println("Money: " + eventMods[3] + "\n");
				}
				else{
					System.out.println("Money: -" + eventMods[3] + "\n");
				}
				statArray[0] = happiness += eventMods[1];
				statArray[1] = health += eventMods[2];
				statArray[2] = money -= eventMods[3];
				break;
			case 3:
				System.out.println("You caught a bad cold.\n");
				System.out.println("Happiness: " + eventMods[1] + "\nHealth: " + eventMods[2]);
				if (eventMods[3] * -1 > 0){
					System.out.println("Money: " + eventMods[3] + "\n");
				}
				else{
					System.out.println("Money: -" + eventMods[3] + "\n");
				}
				statArray[0] = happiness += eventMods[1];
				statArray[1] = health += eventMods[2];
				statArray[2] = money -= eventMods[3];
				break;
			case 4:
				System.out.println("You got badly ill.\n");
				System.out.println("Happiness: " + eventMods[1] + "\nHealth: " + eventMods[2]);
				if (eventMods[3] * -1 > 0){
					System.out.println("Money: " + eventMods[3] + "\n");
				}
				else{
					System.out.println("Money: -" + eventMods[3] + "\n");
				}
				statArray[0] = happiness += eventMods[1];
				statArray[1] = health += eventMods[2];
				statArray[2] = money -= eventMods[3];
				break;
			case 5:
				System.out.println("You recieved a gift from a friend.\n");
				System.out.println("Happiness: " + eventMods[1] + "\nHealth: " + eventMods[2]);
				if (eventMods[3] * -1 > 0){
					System.out.println("Money: " + eventMods[3] + "\n");
				}
				else{
					System.out.println("Money: -" + eventMods[3] + "\n");
				}
				statArray[0] = happiness += eventMods[1];
				statArray[1] = health += eventMods[2];
				statArray[2] = money -= eventMods[3];
				break;
			case 6:
				System.out.println("You recieved some money from a friend.\n");
				System.out.println("Happiness: " + eventMods[1] + "\nHealth: " + eventMods[2]);
				if (eventMods[3] * -1 > 0){
					System.out.println("Money: " + eventMods[3] + "\n");
				}
				else{
					System.out.println("Money: -" + eventMods[3] + "\n");
				}
				statArray[0] = happiness += eventMods[1];
				statArray[1] = health += eventMods[2];
				statArray[2] = money -= eventMods[3];
				break;
			case 7:
				System.out.println("You recieved a lot of money from a friend.\n");
				System.out.println("Happiness: " + eventMods[1] + "\nHealth: " + eventMods[2]);
				if (eventMods[3] * -1 > 0){
					System.out.println("Money: " + eventMods[3] + "\n");
				}
				else{
					System.out.println("Money: -" + eventMods[3] + "\n");
				}
				statArray[0] = happiness += eventMods[1];
				statArray[1] = health += eventMods[2];
				statArray[2] = money -= eventMods[3];
				break;
			case 8:
				System.out.println("You gave a gift to a friend.\n");
				System.out.println("Happiness: " + eventMods[1] + "\nHealth: " + eventMods[2]);
				if (eventMods[3] * -1 > 0){
					System.out.println("Money: " + eventMods[3] + "\n");
				}
				else{
					System.out.println("Money: -" + eventMods[3] + "\n");
				}
				statArray[0] = happiness += eventMods[1];
				statArray[1] = health += eventMods[2];
				statArray[2] = money -= eventMods[3];
				break;
			case 9:
				System.out.println("You gave some money to a friend.\n");
				System.out.println("Happiness: " + eventMods[1] + "\nHealth: " + eventMods[2]);
				if (eventMods[3] * -1 > 0){
					System.out.println("Money: " + eventMods[3] + "\n");
				}
				else{
					System.out.println("Money: -" + eventMods[3] + "\n");
				}
				statArray[0] = happiness += eventMods[1];
				statArray[1] = health += eventMods[2];
				statArray[2] = money -= eventMods[3];
				break;
			case 10:
				System.out.println("You gave a lot of money to a friend.\n");
				System.out.println("Happiness: " + eventMods[1] + "\nHealth: " + eventMods[2]);
				if (eventMods[3] * -1 > 0){
					System.out.println("Money: " + eventMods[3] + "\n");
				}
				else{
					System.out.println("Money: -" + eventMods[3] + "\n");
				}
				statArray[0] = happiness += eventMods[1];
				statArray[1] = health += eventMods[2];
				statArray[2] = money -= eventMods[3];
				break;
			case 11:
				System.out.println("You accidentally cut yourself.\n");
				System.out.println("Happiness: " + eventMods[1] + "\nHealth: " + eventMods[2]);
				if (eventMods[3] * -1 > 0){
					System.out.println("Money: " + eventMods[3] + "\n");
				}
				else{
					System.out.println("Money: -" + eventMods[3] + "\n");
				}
				statArray[0] = happiness += eventMods[1];
				statArray[1] = health += eventMods[2];
				statArray[2] = money -= eventMods[3];
				break;
			case 12:
				System.out.println("You accidentally badly cut yourself.\n");
				System.out.println("Happiness: " + eventMods[1] + "\nHealth: " + eventMods[2]);
				if (eventMods[3] * -1 > 0){
					System.out.println("Money: " + eventMods[3] + "\n");
				}
				else{
					System.out.println("Money: -" + eventMods[3] + "\n");
				}
				statArray[0] = happiness += eventMods[1];
				statArray[1] = health += eventMods[2];
				statArray[2] = money -= eventMods[3];
				break;
			case 13:
				System.out.println("Your house got robbed!.\n");
				System.out.println("Happiness: " + eventMods[1] + "\nHealth: " + eventMods[2]);
				if (eventMods[3] * -1 > 0){
					System.out.println("Money: " + eventMods[3] + "\n");
				}
				else{
					System.out.println("Money: -" + eventMods[3] + "\n");
				}
				statArray[0] = happiness += eventMods[1];
				statArray[1] = health += eventMods[2];
				statArray[2] = money -= eventMods[3];
				break;	
			case 14:
				System.out.println("You got pickpocketed and lost your wallet!.\n");
				System.out.println("Happiness: " + eventMods[1] + "\nHealth: " + eventMods[2]);
				if (eventMods[3] * -1 > 0){
					System.out.println("Money: " + eventMods[3] + "\n");
				}
				else{
					System.out.println("Money: -" + eventMods[3] + "\n");
				}
				statArray[0] = happiness += eventMods[1];
				statArray[1] = health += eventMods[2];
				statArray[2] = money -= eventMods[3];
				break;	
			case 15:
				System.out.println("You caught a theif trying to rob your house, but he attacked you and got away.\n");
				System.out.println("Happiness: " + eventMods[1] + "\nHealth: " + eventMods[2]);
				if (eventMods[3] * -1 > 0){
					System.out.println("Money: " + eventMods[3] + "\n");
				}
				else{
					System.out.println("Money: -" + eventMods[3] + "\n");
				}
				statArray[0] = happiness += eventMods[1];
				statArray[1] = health += eventMods[2];
				statArray[2] = money -= eventMods[3];
				break;
			case 16:
				System.out.println("You caught a theif trying to rob your house, but he badly attacked you and got away.\n");
				System.out.println("Happiness: " + eventMods[1] + "\nHealth: " + eventMods[2]);
				if (eventMods[3] * -1 > 0){
					System.out.println("Money: " + eventMods[3] + "\n");
				}
				else{
					System.out.println("Money: -" + eventMods[3] + "\n");
				}
				statArray[0] = happiness += eventMods[1];
				statArray[1] = health += eventMods[2];
				statArray[2] = money -= eventMods[3];
				break;
			case 17:
				System.out.println("You caught a theif trying to rob your house and scared him away.\n");
				System.out.println("Happiness: " + eventMods[1] + "\nHealth: " + eventMods[2]);
				if (eventMods[3] * -1 > 0){
					System.out.println("Money: " + eventMods[3] + "\n");
				}
				else{
					System.out.println("Money: -" + eventMods[3] + "\n");
				}
				statArray[0] = happiness += eventMods[1];
				statArray[1] = health += eventMods[2];
				statArray[2] = money -= eventMods[3];
				break;
			default:
				statArray[0] = happiness;
				statArray[1] = health;
				statArray[2] = money;
				break;
		}
		return statArray;
	}

	//Random chance to fire you from your job. 
public static int[] fired(Random rand, int[] jobChoices){
	if (jobChoices[2] == -1){
		return jobChoices;
	}
	else{
		boolean chance = rand.nextInt(15)==0;
		if (chance == true){
			System.out.println("You got fired from your job!\n");	
			int[] jobChoicesFired = {0, 0, -1, 0, 0};
			return jobChoicesFired;
		}
		else{
			return jobChoices;
		}
	}
}
	
	//Main function
	public static void main(String[] args) {
		Random rand = new Random();
		Scanner scan = new Scanner(System.in);
		Main returnv = new Main();
		HashMap<Integer, String> jobList = returnv.initializationList();
		HashMap<String, Integer> jobHours = returnv.initializationHours();
		HashMap<String, Integer> jobHappinessMod = returnv.initializationJobHappinessMod();
		HashMap<String, Integer> jobHealthMod = returnv.initializationJobHealthMod();
		HashMap<String, Integer> jobPay = returnv.initializationPay();
		HashMap<String, Integer> jobId = returnv.initializationId();

		HashMap<Integer, Integer> eventId = returnv.initializationEventId();
		HashMap<Integer, Integer> eventHappinessMod = returnv.initializationEventHappinessMod();
		HashMap<Integer, Integer> eventHealthMod = returnv.initializationEventHealthMod();
		HashMap<Integer, Integer> eventMoneyMod = returnv.initializationEventMoneyMod();
		
		int min = 5;
		int max = 95;
		int week = 0;
		int money = 200;
		int rent = 150;
		int groceries = 50;

		int groceriesHealthMod = 0;
		int groceriesHappinessMod = 0;
		
		int health = (int) Math.floor(Math.random() * (max - min + 1) + min);
		int happiness = (int) Math.floor(Math.random() * (max - min + 1) + min);
		
		String job = "Unemployeed";
		int[] jobChoices = {0, 0, -1, 0, 0};
		
		boolean active = true;
		while (active == true) {

			int[] eventMods = new int[4];
			eventMods = returnv.randomEventFinder(rand, eventId, eventHappinessMod, eventHealthMod, eventMoneyMod);
			int[] statArray = new int[3];
			statArray = returnv.randomEventStatUpdater(eventMods, money, health, happiness);

			happiness = statArray[0];
			health = statArray[1];
			money = statArray[2];

			int[] tempFired = new int[5];
			tempFired = returnv.fired(rand, jobChoices);
			if (tempFired[2] == -1){
				jobChoices = tempFired;
				job = "Unemployed";
			}
			
			stats(week, money, health, happiness, job);
			for (int i = 0; i < 3; i++) {
				System.out.println("1. Continue 2. Job 3. Groceries 4. Recreation 5. Visit a Doctor");
				int choice = scan.nextInt();
				if (choice == 1) {
					break;
				}
					
					//Job
				else if (choice == 2) {
					System.out.println("\n1. View Job 2. Find jobs 3. Quit Job.");
					choice = scan.nextInt();
					if (choice == 1) {
						if (jobChoices[2] == -1){
							System.out.println("You don't have a job.");
						}
						else{
							System.out.println("Job: " + job);
						}
					} else if (choice == 2) {
						jobChoices = returnv.jobFinder(scan, rand, jobList, jobHours, jobPay, jobId, jobHappinessMod, jobHealthMod);
						job = jobList.get(jobChoices[2]);
						//System.out.println(job);
					} else if (choice == 3) {
						if (jobChoices[2] == -1){
							System.out.println("You don't have a job.");
						}
						else{
							System.out.println("You quit your job.");
							jobChoices[0] = 0;
							jobChoices[1] = 0;
							jobChoices[2] = -1;
							jobChoices[3] = 0;
							jobChoices[4] = 0;
							job = "Unemployed";
						}
					}
				}
					//Groceries
				else if (choice == 3){
					System.out.println("Choose how many groceries you want to buy every week.");
					System.out.println("*This will affect your health and happiness.");
					System.out.println("1. Light (25$) 2. Normal (50$) 3. Heavy (75$) 4. Very Heavy (100$)");
					choice = scan.nextInt();
					if (choice == 1){
						System.out.println("You will buy a light amount of groceries.");
						groceries = 25;
						groceriesHealthMod = -1;
						groceriesHappinessMod = -1;
					}
					else if (choice == 2){
						System.out.println("You will buy a normal amount of groceries.");
						groceries = 50;
						groceriesHealthMod = 0;
						groceriesHappinessMod = 0;
					}
					else if (choice == 3){
						System.out.println("You will buy a heavy amount of groceries.");
						groceries = 75;
						groceriesHealthMod = 0;
						groceriesHappinessMod = 1;
					}
					else if (choice == 4){
						System.out.println("You will buy a very heavy amount of groceries.");
						groceries = 100;
						groceriesHealthMod = -1;
						groceriesHappinessMod = 2;
					}
				}

				else if (choice == 4){
					System.out.println("What do you do?");
					System.out.println("1. Theater 2. Park 3. See friends 4. Go to a restaraunt");
					choice = scan.nextInt();
					if (choice == 1){
						System.out.println("You see a movie.");
						int randHappiness = rand.nextInt(4) ;
						System.out.println("Happiness: " + randHappiness);
						System.out.println("Money: -" + 50);
						happiness += randHappiness;
						money -= 50;
						if (happiness > 100){
							happiness = 100;
						}
					}
					else if (choice == 2){
						System.out.println("You go to the park.");
						int randHappiness = rand.nextInt(2);
						System.out.println("Happiness: " + randHappiness);
						happiness += randHappiness;
						if (happiness > 100){
							happiness = 100;
						}
					}
					else if (choice == 3){
						System.out.println("You hang out with some friends.");
						int randHappiness = rand.nextInt(7);
						int randMoney = rand.nextInt(5);
						randMoney *= 10;
						System.out.println("Happiness: " + randHappiness);
						System.out.println("Money: -" + randMoney);
						happiness += randHappiness;
						money -= randMoney;
						if (happiness > 100){
							happiness = 100;
						}
					}
					else if (choice == 4){
						System.out.println("You go to a restaraunt.");
						max = 100;
						min = 50;
						int randMoney = (int) Math.floor(Math.random() * (max - min + 1) + min);
						int randHappiness = rand.nextInt(6);
						System.out.println("Happiness: " + randHappiness);
						System.out.println("Money: -" + randMoney);
						money -= randMoney;
						happiness += randHappiness;
						if (happiness > 100){
							happiness = 100;
						}
					}
				}
				
				else if (choice == 5){
					System.out.println("You go to the doctor.");
					min = 100;
					max = 250;
					int randMoney = (int) Math.floor(Math.random() * (max - min + 1) + min);
					min = 0;
					max = 10;
					int randHealth = (int) Math.floor(Math.random() * (max - min + 1) + min);
					System.out.println("Health: " + randHealth);
					System.out.println("Money: -" + randMoney);
					health += randHealth;
					money -= randMoney;
					if (health > 100){
						health = 100;
					}
				}
			}

			if (money * -1 >= 500 || health < 5 || happiness < 5) {
				System.out.println("Game over.");
				scan.close();
				System.exit(0);
			}
			
			week++;

			money = returnv.moneyUpdate(money, jobChoices);
			money = returnv.moneyDeducter(money, rent, groceries);
			health = returnv.healthUpdate(health, groceriesHealthMod, jobChoices);
			happiness = returnv.happinessUpdate(happiness, groceriesHappinessMod, jobChoices);
			wait(1000);
			clearScreen();
			//System.out.println("\n");
		}
	}
}