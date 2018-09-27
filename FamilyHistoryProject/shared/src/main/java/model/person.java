package model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.UUID;

/**
 * Created by Admin on 2/13/17.
 */

public class person {

    private String personID = UUID.randomUUID().toString();//: Unique identifier for this person
    private String descendant;//: User to which this person belongs
    private String firstName;//: Person’s first name (non-empty string)
    private String lastName;//: Person’s last name (non-empty string)
    private String gender;//: Person’s gender (Male or Female)
    private  String father = "";//: Person’s father (possibly null)
    private String mother= "";//: Person’s mother (possibly null)
    private String spouse = "";//: Person’s spouse (possibly null)
    private ArrayList<event> events;
    private ArrayList<person> ancestors = new ArrayList<person>();
    private location[] locals = null;
    private String[] mNames = null;
    private String[] wNames = null;
    private String[] sNames = null;
    private int eventTotals;
    private Random rand = null;


    public person(String personID, String descendant, String firstName, String lastName, String gender, String father, String mother, String spouse)
    {
        this.personID = personID;
        this.descendant = descendant;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.father = father;
        this.mother = mother;
        this.spouse = spouse;
    }

    public person(String firstName, String lastName, String gender, String descendant)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
    }

    public person(String personID, String firstName, String lastName, String gender, String descendant)
    {
        this.personID = personID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.descendant = descendant;
    }

    public int getEventTotals() {
        return eventTotals;
    }

    public void addToEventTotals(int eventNum) {
        this.eventTotals += eventNum;
    }

    public void setDescendant(String descendant) {
        this.descendant = descendant;
    }

    public void setmNames(String[] mNames) {
        this.mNames = mNames;
    }

    public void setwNames(String[] wNames) {
        this.wNames = wNames;
    }

    public void setsNames(String[] sNames) {
        this.sNames = sNames;
    }

    public void setLocals(location[] locals) {
        this.locals = locals;
    }

    public void setFather(String father) {
        this.father = father;
    }

    public void setMother(String mother) {
        this.mother = mother;
    }

    public void setSpouse(String spouse) {
        this.spouse = spouse;
    }

    public String getPersonID() {
        return personID;
    }

    public String getDescendant() {
        return descendant;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getGender() {
        return gender;
    }

    public String getFather() {
        return father;
    }

    public String getMother() {
        return mother;
    }

    public String getSpouse() {
        return spouse;
    }


    public ArrayList<event> getEvents() {
        return events;
    }

    public ArrayList<person> getAncestors() {
        return ancestors;
    }


    public String toString(){
        return firstName + " " + lastName;
    }

    /**
     * Calls create events function for an event function
     * Assigns event list to person
     */
    public void generateEvents(int birthYear, int marriageYear, event marriageEvent)
    {
        rand = new Random();
        String[] event_types = {"birth", "baptism", "christening", "marriage", "death"};

        events = new ArrayList<event>();
        int randomLoc;
        int baptismYear = 0;
        int cristYear = 0;
        int deathYear = 0;
        event evnt = null;

        if(marriageYear > 0)
        {
            birthYear = marriageYear-(int) (Math.random() * 40 + 20);
        }

        randomLoc = rand.nextInt(locals.length);
        evnt = new event(this.personID,
                this.descendant,
                locals[randomLoc].getLatitude(),
                locals[randomLoc].getLongitude(),
                locals[randomLoc].getCountry(),
                locals[randomLoc].getCity(),
                event_types[0],
                Integer.toString(birthYear));

        events.add(evnt);
        randomLoc = rand.nextInt(locals.length);
        baptismYear += birthYear + (int) (Math.random() * 14 + 1);
        if(baptismYear > 2017)
            return;


        evnt = new event(this.personID,
                this.descendant,
                locals[randomLoc].getLatitude(),
                locals[randomLoc].getLongitude(),
                locals[randomLoc].getCountry(),
                locals[randomLoc].getCity(),
                event_types[1],
                Integer.toString(baptismYear));
        events.add(evnt);

        randomLoc = rand.nextInt(locals.length);
        cristYear = baptismYear + (int) (Math.random() * 14 + 1);
        if(cristYear > 2017)
            return;

        evnt = new event(this.personID,
                this.descendant,
                locals[randomLoc].getLatitude(),
                locals[randomLoc].getLongitude(),
                locals[randomLoc].getCountry(),
                locals[randomLoc].getCity(),
                event_types[2],
                Integer.toString(cristYear));
        events.add(evnt);

        if(marriageEvent != null) {
            evnt = marriageEvent;
            evnt = new event(this.getPersonID(),
                    this.descendant,
                    evnt.getLatitude(),
                    evnt.getLongitude(),
                    evnt.getCountry(),
                    evnt.getCity(),
                    event_types[3],
                    evnt.getYear());
        }
        else
        {
            randomLoc = rand.nextInt(locals.length);
            marriageYear = cristYear + (int) (Math.random() * 35 + 10);
            if(marriageYear > 2017)
                return;

            evnt = new event(this.personID,
                    this.descendant,
                    locals[randomLoc].getLatitude(),
                    locals[randomLoc].getLongitude(),
                    locals[randomLoc].getCountry(),
                    locals[randomLoc].getCity(),
                    event_types[3],
                    Integer.toString(marriageYear));
        }
        events.add(evnt);

        randomLoc = rand.nextInt(locals.length);
        deathYear = marriageYear + (int) (Math.random() * 40 + 10);
        if(deathYear > 2017)
            return;

        evnt = new event(this.personID,
                this.descendant,
                locals[randomLoc].getLatitude(),
                locals[randomLoc].getLongitude(),
                locals[randomLoc].getCountry(),
                locals[randomLoc].getCity(),
                event_types[4],
                Integer.toString(deathYear));

        events.add(evnt);
        return;
    }

    /**
     * generates people for the amount of generations passed it
     *  to fill ancestor list
     * @param generations
     */
    public void generateAncestors(int generations)
    {
        generateAncestorsRecurse(this, generations, this.lastName);
        return;
    }


    private void generateAncestorsRecurse(person ogPerson, int generations, String paternalLastName) {

        rand = new Random();
        if(generations == 0)
        {
            return;
        }

        //Setting Variables
        String motherFirstName = wNames[rand.nextInt(wNames.length)];
        String motherLastName = sNames[rand.nextInt(sNames.length)];

        String fatherFirstName = mNames[rand.nextInt(mNames.length)];
        String fatherLastName = paternalLastName;

        String spouseFirstName;
        String spouseLastName = sNames[rand.nextInt(sNames.length)];

        int marriageYear = Integer.parseInt(this.events.get(0).getYear()) - rand.nextInt(15);


        //Make and initialize Mother and father
        person mother = new person(motherFirstName, motherLastName, "female", this.descendant);
        person father = new person(fatherFirstName, fatherLastName, "male", this.descendant);

        mother.setwNames(this.wNames);
        mother.setmNames(this.mNames);
        mother.setsNames(this.sNames);
        mother.setLocals(this.locals);

        father.setwNames(this.wNames);
        father.setmNames(this.mNames);
        father.setsNames(this.sNames);
        father.setLocals(this.locals);

        mother.setSpouse(father.getPersonID());
        father.setSpouse(mother.getPersonID());

        mother.setDescendant(ogPerson.getDescendant());
        father.setDescendant(ogPerson.getDescendant());

        mother.generateEvents(0, marriageYear, null);
        if( mother.getEvents().get(3) != null)
            father.generateEvents(0, marriageYear, mother.getEvents().get(3));
        else
            father.generateEvents(0, marriageYear, mother.getEvents().get(3));


        this.setMother(mother.getPersonID());
        this.setFather(father.getPersonID());

//        mother.setPersonID(this.getMother());
//        father.setPersonID(this.getFather());


        ogPerson.addAncestors(mother);
        ogPerson.addAncestors(father);

        ogPerson.addToEventTotals(mother.getEvents().size());
        ogPerson.addToEventTotals(father.getEvents().size());


        //Call recursion on mother and father to generate their mother and father
        mother.generateAncestorsRecurse(ogPerson, generations-1, motherLastName);
        father.generateAncestorsRecurse(ogPerson, generations-1, fatherLastName);


            return;
    }

    private void addAncestors(person prsn) {
        ancestors.add(prsn);
    }

    public void setPersonID(String personID) {
        this.personID = personID;
    }

    public void addEvent(event evnt) {
        events.add(evnt);
    }
}
